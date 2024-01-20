/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Syrup interface with price and ID
interface Syrup {
    String getSyrupDescription();

    double getPrice();

    int getId();

    String getName();

    @Override
    String toString();
}
