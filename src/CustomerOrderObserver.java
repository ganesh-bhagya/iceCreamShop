/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete observer
class CustomerOrderObserver implements OrderObserver {
    private String customerName;

    public CustomerOrderObserver(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(Order order) {
        System.out.println("Dear " + customerName + ", your order status is now: " + order.getStatus());
    }
}