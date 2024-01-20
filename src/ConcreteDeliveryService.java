/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

class ConcreteDeliveryService implements DeliveryService {
    private MappingService mappingService; // Assume a MappingService interface or class

    public ConcreteDeliveryService(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @Override
    public boolean isDeliveryAvailable() {
        // Placeholder logic to check if delivery is available
        // This can depend on factors like distance, location, etc.
        // For illustration purposes, always return true.
        return true;
    }

    @Override
    public void processDelivery(Order order) {

        if (isDeliveryAvailable()) {
            int estimatedDeliveryTime = mappingService.estimateDeliveryTime(order.getDeliveryAddress());
            System.out.println("Estimated delivery time: " + estimatedDeliveryTime + " minutes");

            order.setStatus("Out for Delivery");
            order.notifyObservers();

            System.out.println("Processing delivery for order: " + order.getDescription());
        } else {
            System.out.println("Delivery is not available for this order.");
        }
    }
}