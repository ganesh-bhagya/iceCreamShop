/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Concrete decorator for adding special packaging
class SpecialPackagingDecorator extends OrderDecorator {
    public SpecialPackagingDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Special Packaging";
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal() + 1.5; // Additional cost for special packaging
    }
}