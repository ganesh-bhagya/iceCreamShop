/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

class ChocolateFlavor implements Flavor {
    private static final double PRICE = 3.0;
    private static final int ID = 2;
    private static final String FLAVOR_NAME = "Chocolate";

    @Override
    public String getFlavorDescription() {
        return FLAVOR_NAME;
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
        return FLAVOR_NAME;
    }
}

