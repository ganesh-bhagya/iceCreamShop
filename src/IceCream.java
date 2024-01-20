
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
// Ice cream interface
interface IceCream {

    String getDescription();

    double cost();

    Flavor getFlavor();

    Topping getTopping();

    Syrup getSyrup();

    void setFlavor(Flavor flavor);

    void setTopping(Topping topping);

    void setSyrup(Syrup syrup);
  

    String getCustomName(); // Add custom name method

    void setCustomName(String customName); // Add set custom name method

}
