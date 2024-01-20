/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// ConcretePickupService implementing PickupService
public class ConcretePickupService implements PickupService {
    @Override
    public boolean isPickupAvailable() {
        
        return true; // Placeholder implementation
    }

    @Override
    public void processPickup(Order order) {
      
        System.out.println("Processing pickup for order: " + order.getDescription());
      
    }
}
