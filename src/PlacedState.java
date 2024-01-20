/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete states
class PlacedState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order placed.");
        order.setStatus("Placed");
    }
}