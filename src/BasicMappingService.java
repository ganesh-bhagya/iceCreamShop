/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
// BasicMappingService implementing MappingService
public class BasicMappingService implements MappingService {
    @Override
    public int estimateDeliveryTime(String destination) {
        int distanceToDestination = calculateDistanceToDestination(destination);

        // the delivery time estimate based on the distance
        if (distanceToDestination < 5) {
            return 20; // 20 minutes delivery time for short distances
        } else if (distanceToDestination < 10) {
            return 30; // 30 minutes delivery time for medium distances
        } else {
            return 45; // 45 minutes delivery time for longer distances
        }
    }

    private int calculateDistanceToDestination(String destination) {
        return 8;
    }
}
