
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Updated GiftWrappingDecorator class
class GiftWrappingDecorator extends OrderDecorator {
    private String giftWrapOption;

    public GiftWrappingDecorator(Order decoratedOrder, String giftWrapOption) {
        super(decoratedOrder);
        this.giftWrapOption = giftWrapOption;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Gift Wrapping: " + giftWrapOption;
    }

    @Override
    public double calculateTotal() {
        // Additional cost for gift wrapping options
        double additionalCost = 0.0;
        switch (giftWrapOption.toLowerCase()) {
            case "birthday":
                additionalCost = 2.0;
                break;
            case "valentine":
                additionalCost = 3.0;
                break;
            case "anniversary":
                additionalCost = 4.0;
                break;
            default:
                System.out.println("Invalid gift wrapping option. No additional cost will be added.");
        }

        return super.calculateTotal() + additionalCost;
    }
}
