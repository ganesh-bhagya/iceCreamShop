/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete toppings with different prices and IDs
class SprinklesTopping implements Topping {
    private static final double PRICE = 0.5;
    private static final int ID = 1;
     private static final String TOPPING_NAME = "Sprinkles";

    @Override
    public String getToppingDescription() {
        return "Sprinkles";
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
         return TOPPING_NAME;
    }

    @Override
    public String toString() {
        return getToppingDescription();
    }
}