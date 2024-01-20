
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IceCreamShop {

    public static void main(String[] args) {
        // Create an order using the Builder pattern
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order = orderBuilder
                .addItem(new BasicIceCream())
                .addObserver(new CustomerOrderObserver("Alice"))
                .build();

        // Select flavors
        Scanner scanner = new Scanner(System.in);

        // Chain of Responsibility pattern
        IceCreamHandler flavorHandler = new FlavorHandler(new SimpleFlavorFactory());
        IceCreamHandler toppingHandler = new ToppingHandler(new SimpleToppingFactory());
        IceCreamHandler syrupHandler = new SyrupHandler(new SimpleSyrupFactory());

        // Set up the chain
        flavorHandler.setNext(toppingHandler);
        toppingHandler.setNext(syrupHandler);

        // Validate ice cream customization
        validateIceCreamCustomization(order.getItems().get(0), flavorHandler);

        System.out.println("Enter a name for your custom ice cream combination:");
        String customIceCreamName = scanner.nextLine();
        order.getItems().get(0).setCustomName(customIceCreamName);

        UserProfileManager userProfileManager = new UserProfileManager();
        UserProfile userProfile = userProfileManager.registerUser("Alice");

        // Add the current order to user's favorites
        userProfile.addFavoriteCombination(order);

        // Prompt the user to reorder a favorite combination
        System.out.println("Do you want to reorder a favorite combination? (Y/N)");
        String reorderChoice = scanner.next();
        if ("Y".equalsIgnoreCase(reorderChoice)) {
            List<Order> favoriteCombinations = userProfile.getFavoriteCombinations();
            if (!favoriteCombinations.isEmpty()) {
                System.out.println("Select a favorite combination to reorder:");
                for (int i = 0; i < favoriteCombinations.size(); i++) {
                    System.out.println((i + 1) + ". " + favoriteCombinations.get(i).getDescription());
                }
                int selectedFavorite = scanner.nextInt();
                Order selectedOrder = favoriteCombinations.get(selectedFavorite - 1);

                // Reorder the selected favorite
                OrderBuilder reorderBuilder = new OrderBuilder();
                // Manually copy the items from the selected order to the new order
                for (IceCream item : selectedOrder.getItems()) {
                    reorderBuilder.addItem(item); // Assuming OrderBuilder has an addItem method
                }

                Order reorderedOrder = reorderBuilder.build();
                // Set the delivery status directly on the reordered order
                reorderedOrder.setForDelivery(selectedOrder.isForDelivery());
                // Process the reordered order (similar to existing order processing logic)
                // ...
                System.out.println("Reordered favorite combination successfully!");
            } else {
                System.out.println("No favorite combinations available for reorder.");
            }
        }

        // Add gift wrapping using the decorator pattern
        System.out.println("Select a gift wrapping option: (1. Birthday / 2. Valentine / 3. Anniversary / 4. None)");
        int giftWrapOptionChoice = scanner.nextInt();

        String giftWrapOption = null;
        switch (giftWrapOptionChoice) {
            case 1:
                giftWrapOption = "Birthday";
                break;
            case 2:
                giftWrapOption = "Valentine";
                break;
            case 3:
                giftWrapOption = "Anniversary";
                break;
            case 4:
                // No gift wrapping
                break;
            default:
                System.out.println("Invalid option. No gift wrapping will be added.");
        }

        // Decorate the order based on the user's choice
        Order decoratedOrder;
        if (giftWrapOption != null) {
            decoratedOrder = new GiftWrappingDecorator(order, giftWrapOption);
        } else {
            decoratedOrder = order;
        }

        System.out.println("Select an option:");
        System.out.println("1. Pickup");
        System.out.println("2. Delivery");
        int option = scanner.nextInt();

        order.setForDelivery(option == 2);

        // Process the order based on the selected option
        if (order.isForDelivery()) {
            MappingService mappingService = new BasicMappingService();

            DeliveryService deliveryService = new ConcreteDeliveryService(mappingService);

            if (deliveryService.isDeliveryAvailable()) {
                // Get the delivery time estimate using the mapping service
                int deliveryTimeEstimate = mappingService.estimateDeliveryTime(order.getDeliveryAddress());
                System.out.println("Estimated Delivery Time: " + deliveryTimeEstimate + " minutes");

                deliveryService.processDelivery(order);
            } else {
                System.out.println("Sorry, delivery is not available for this order.");
            }
        } else {
            PickupService pickupService = new ConcretePickupService();
            if (pickupService.isPickupAvailable()) {
                pickupService.processPickup(order);
            } else {
                System.out.println("Sorry, pickup is not available for this order.");
            }
        }

        PromotionManager promotionManager = new PromotionManager();
        promotionManager.addPromotion(new ChristmasPromotion());

// Get active promotions for the current date
        List<Promotion> activePromotions = promotionManager.getActivePromotions();

// Check if there are active promotions
        if (!activePromotions.isEmpty()) {
            // Display available promotions to the user
            System.out.println("Available Promotions:");
            for (int i = 0; i < activePromotions.size(); i++) {
                System.out.println((i + 1) + ". " + activePromotions.get(i).getDescription());
            }

            // Prompt the user to choose a promotion
            System.out.println("Select a promotion to apply (1-" + activePromotions.size() + "), or enter 0 to skip:");
            int promotionChoice = scanner.nextInt();

            if (promotionChoice > 0 && promotionChoice <= activePromotions.size()) {
                // User selected a promotion, apply it to the order
                Promotion selectedPromotion = activePromotions.get(promotionChoice - 1);
                order.addPromotion(selectedPromotion);

                // Calculate the total, considering promotions
                double originalPrice = order.calculateTotal();
                double discountedTotal = order.discountedTotal(originalPrice);

                System.out.println("Total Price (Before Discount): $" + originalPrice);
                System.out.println("Total Price (After Discount): $" + discountedTotal);
            } else {
                // User chose to skip the promotion, calculate the total without discounts
                double totalWithoutDiscount = order.calculateTotal();
                System.out.println("Total Price: $" + totalWithoutDiscount);
            }
        } else {
            // No active promotions, calculate the total without discounts
            double totalWithoutDiscount = order.calculateTotal();
            System.out.println("Total Price: $" + totalWithoutDiscount);
        }
        System.out.println("Select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");

        int paymentOption = scanner.nextInt();

        PaymentStrategy paymentStrategy;
        switch (paymentOption) {
            case 1:
                paymentStrategy = new CreditCardPaymentStrategy();
                break;
            case 2:
                paymentStrategy = new CashPaymentStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment option");
        }

// Set the payment strategy for the order
        order.setPaymentStrategy(paymentStrategy);

        // Execute the order using a command
        Command placeOrderCommand = new PlaceOrderCommand(order);
        placeOrderCommand.execute();

        // Print the order status
        System.out.println("Order Status: " + order.getStatus());

        System.out.println("Order with Gift Wrapping: " + decoratedOrder.getDescription());
        System.out.println("Total Cost: $" + decoratedOrder.calculateTotal());

        // Change the order state using the state pattern
        OrderState preparationState = new PreparationState();
        preparationState.processOrder(order);
        System.out.println("Updated Order Status: " + order.getStatus());

        // Display order details
        System.out.println("\nOrder Details:");
        System.out.println("Delivery Method: " + order.getDeliveryMethod());
        System.out.println("Items:");
        for (IceCream item : order.getItems()) {
            System.out.println("- " + item.getDescription());
            System.out.println("  Flavor: " + item.getFlavor().getFlavorDescription());
            System.out.println(
                    "  Toppings: " + item.getTopping().getToppingDescription());
            System.out.println(
                    "  Syrups: " + item.getSyrup().getSyrupDescription());
        }

        // Display gift wrapping information
        String giftWrapInfo = (giftWrapOption != null) ? "Gift Wrapping: " + giftWrapOption : "No Gift Wrapping";
        double giftWrapCost = (giftWrapOption != null) ? calculateGiftWrapCost(giftWrapOption) : 0.0;
        System.out.println(giftWrapInfo);
        System.out.println("Gift Wrapping Cost: $" + giftWrapCost);

// Display order cost
        double orderCost = decoratedOrder.calculateTotal();
        System.out.println("Order Cost: $" + orderCost);

        preparationState.processOrder(order);
        System.out.println("Updated Order Status: " + order.getStatus());

// Calculate and display the grand total
        double grandTotal = orderCost + giftWrapCost;
        System.out.println("Grand Total: $" + grandTotal);
        

        System.out.println("Provide feedback for the order:");
        String feedback = scanner.nextLine();

        System.out.println("Provide a rating for the order (1-5):");
        int rating = scanner.nextInt();

        // Create command objects
        Command feedbackCommand = new SubmitFeedbackCommand(order, feedback);
        Command ratingCommand = new SubmitRatingCommand(order, rating);

        // Create command invoker
        FeedbackCommandInvoker commandInvoker = new FeedbackCommandInvoker();
        commandInvoker.addCommand(feedbackCommand);
        commandInvoker.addCommand(ratingCommand);

        // Execute feedback and rating commands
        commandInvoker.executeCommands();

    }

    private static double calculateGiftWrapCost(String giftWrapOption) {
        switch (giftWrapOption.toLowerCase()) {
            case "birthday":
                return 2.0;
            case "valentine":
                return 3.0;
            case "anniversary":
                return 4.0;
            default:
                System.out.println("Invalid gift wrapping option. No additional cost will be added.");
                return 0.0;
        }
    }

    private static void validateIceCreamCustomization(IceCream iceCream, IceCreamHandler handler) {
        handler.handleRequest(iceCream);
    }

}
