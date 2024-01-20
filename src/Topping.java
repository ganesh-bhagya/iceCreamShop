/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Topping interface with price and ID
interface Topping {
    String getToppingDescription();

    double getPrice();

    int getId();

    String getName();

    @Override
    String toString();
}
