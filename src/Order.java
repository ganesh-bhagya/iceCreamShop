
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
// Context class
class Order {

    private List<IceCream> items = new ArrayList<>();
    private String status;
    private List<OrderObserver> observers = new ArrayList<>();
    private String description;
    private boolean forDelivery;
    private boolean isFavorite;
    private UserProfile userProfile;
    private PaymentStrategy paymentStrategy;
    private List<Promotion> promotions = new ArrayList<>();
    private String feedback;
    private int rating;

    public List<IceCream> getItems() {
        return items;
    }

    public void setForDelivery(boolean forDelivery) {
        this.forDelivery = forDelivery;
    }

    public boolean isForDelivery() {
        return forDelivery;
    }

    public void addItem(IceCream item) {
        items.add(item);
    }

    public void removeItem(IceCream item) {
        items.remove(item);
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public void removePromotion(Promotion promotion) {
        promotions.remove(promotion);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(IceCream::cost).sum();
    }

    public double discountedTotal(double currentTotal) {
        double discountedPrice = currentTotal;
        for (Promotion promotion : promotions) {
            discountedPrice = promotion.applyDiscount(discountedPrice);
        }
        return discountedPrice;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryMethod() {
        return forDelivery ? "Delivery" : "Pickup";
    }

    public String getDeliveryAddress() {
        return isForDelivery() ? "123 Main St, City" : "Pickup at store";
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
    
     public void submitFeedback(String feedback) {
        this.feedback = feedback;
        System.out.println("Feedback submitted: " + feedback);
    }

    public void submitRating(int rating) {
        this.rating = rating;
        System.out.println("Rating submitted: " + rating);
    }

}
