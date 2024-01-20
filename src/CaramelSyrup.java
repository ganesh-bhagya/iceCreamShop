/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */


class CaramelSyrup implements Syrup {
    private static final double PRICE = 0.8;
    private static final int ID = 2;

    @Override
    public String getSyrupDescription() {
        return "Caramel Syrup";
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
        return "Caramel";
    }

    @Override
    public String toString() {
        return getSyrupDescription();
    }
}
