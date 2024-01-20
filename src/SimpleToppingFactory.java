/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete ToppingFactory implementation
class SimpleToppingFactory implements ToppingFactory {
    @Override
    public Topping createTopping(int toppingId) {
        switch (toppingId) {
            case 1:
                return new SprinklesTopping();
            case 2:
                return new NutsTopping();
            // Add more cases for additional toppings
            default:
                throw new IllegalArgumentException("Invalid topping ID");
        }
    }
}