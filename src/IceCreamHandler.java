/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
interface IceCreamHandler {

    void setNext(IceCreamHandler next);

    void handleRequest(IceCream iceCream);
}
