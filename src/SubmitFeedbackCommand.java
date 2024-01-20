/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
// Concrete command for submitting feedback
class SubmitFeedbackCommand implements Command {
     private Order order;
    private String feedback;

    public SubmitFeedbackCommand(Order order, String feedback) {
        this.order = order;
        this.feedback = feedback;
    }

    @Override
     public void execute() {
        order.submitFeedback(feedback);
    }
}
