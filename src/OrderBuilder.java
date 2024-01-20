/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

// Builder pattern
class OrderBuilder {
    private Order order = new Order();

    public OrderBuilder addItem(IceCream item) {
        order.addItem(item);
        return this;
    }

    public OrderBuilder addObserver(OrderObserver observer) {
        order.addObserver(observer);
        return this;
    }

    public Order build() {
        return order;
    }
}
