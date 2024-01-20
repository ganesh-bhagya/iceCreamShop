
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
class FlavorHandler implements IceCreamHandler {
private final FlavorFactory flavorFactory;
    private IceCreamHandler next;
    
  public FlavorHandler(FlavorFactory flavorFactory) {
        this.flavorFactory = flavorFactory;
    }

    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getFlavor() == null) {
            System.out.println("Please select a flavor.");

            // Let's simulate user input for flavor selection
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a flavor (1 for Vanilla, 2 for Chocolate):");
            int selectedFlavorId = scanner.nextInt();

            // Create Flavor using FlavorFactory and set it to ice cream
            Flavor selectedFlavor = flavorFactory.createFlavor(selectedFlavorId);
            iceCream.setFlavor(selectedFlavor);
        }

        if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}