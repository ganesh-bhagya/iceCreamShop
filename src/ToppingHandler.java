
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
class ToppingHandler implements IceCreamHandler {
   private final ToppingFactory toppingFactory;
    private IceCreamHandler next;

    public ToppingHandler(ToppingFactory toppingFactory) {
        this.toppingFactory = toppingFactory;
    }

    
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getTopping()== null) {
            System.out.println("Please select a topping.");

            // Let's simulate user input for flavor selection
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a topping (1 for Sprinkles, 2 for Nuts):");
            int selectedToppingId = scanner.nextInt();

            // Create Flavor using FlavorFactory and set it to ice cream
            Topping selectedTopping = toppingFactory.createTopping(selectedToppingId);
            iceCream.setTopping(selectedTopping);
        }

        if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}