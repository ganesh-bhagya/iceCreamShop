/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete syrups with different prices and IDs
class ChocolateSyrup implements Syrup {
    private static final double PRICE = 1.0;
    private static final int ID = 1;

    @Override
    public String getSyrupDescription() {
        return "Chocolate Syrup";
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
        return "Chocolate";
    }

    @Override
    public String toString() {
        return getSyrupDescription();
    }
}