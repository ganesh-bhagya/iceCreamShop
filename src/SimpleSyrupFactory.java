/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete SyrupFactory implementation
class SimpleSyrupFactory implements SyrupFactory {
    @Override
    public Syrup createSyrup(int syrupId) {
        switch (syrupId) {
            case 1:
                return new ChocolateSyrup();
            case 2:
                return new CaramelSyrup();
            // Add more cases for additional syrups
            default:
                throw new IllegalArgumentException("Invalid syrup ID");
        }
    }
}