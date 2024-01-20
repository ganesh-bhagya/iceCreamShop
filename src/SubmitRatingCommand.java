/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
// Concrete command for submitting ratings
class SubmitRatingCommand implements Command {
    private Order order;
    private int rating;

    public SubmitRatingCommand(Order order, int rating) {
        this.order = order;
        this.rating = rating;
    }

    @Override
    public void execute() {
        order.submitRating(rating);
    }
}