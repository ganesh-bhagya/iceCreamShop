/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

class NutsTopping implements Topping {
    private static final double PRICE = 0.8;
    private static final int ID = 2;
    private static final String TOPPING_NAME = "Nuts";

    @Override
    public String getToppingDescription() {
        return "Nuts";
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
    public String toString() {
        return getToppingDescription();
    }

      @Override
    public String getName() {
         return TOPPING_NAME;
    }
}
