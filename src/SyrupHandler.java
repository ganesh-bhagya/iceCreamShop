
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
class SyrupHandler implements IceCreamHandler {
      private final SyrupFactory syrupFactory;
    private IceCreamHandler next;

     public SyrupHandler(SyrupFactory syrupFactory) {
        this.syrupFactory = syrupFactory;
    }

     
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getSyrup()== null) {
            System.out.println("Please select a syrup.");

            // Let's simulate user input for syrup selection
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a syrup (1 for Sprinkles, 2 for Nuts):");
            int selectedSyrupId = scanner.nextInt();

            // Create Flavor using syrupFactory and set it to ice cream
            Syrup selectedSyrup = syrupFactory.createSyrup(selectedSyrupId);
            iceCream.setSyrup(selectedSyrup);
        }

        if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}