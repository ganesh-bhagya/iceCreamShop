/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// FlavorFactory interface
interface FlavorFactory {
    Flavor createFlavor(int flavorId);
}

// Concrete FlavorFactory implementation
class SimpleFlavorFactory implements FlavorFactory {
    @Override
    public Flavor createFlavor(int flavorId) {
        switch (flavorId) {
            case 1:
                return new VanillaFlavor();
            case 2:
                return new ChocolateFlavor();
            default:
                throw new IllegalArgumentException("Invalid flavor ID");
        }
    }
}