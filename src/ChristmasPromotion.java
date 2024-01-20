/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class ChristmasPromotion implements Promotion {
    @Override
    public double applyDiscount(double originalPrice) {
        // Apply Christmas-specific discount logic
        return 0.9 * originalPrice; // 10% off
    }

    @Override
    public String getDescription() {
        return "Christmas Promotion: 10% off on all flavors!";
    }
}

