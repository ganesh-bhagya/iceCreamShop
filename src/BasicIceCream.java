
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

class BasicIceCream implements IceCream {
    private Flavor flavor;
    private Topping topping;
   private Syrup syrup;
  
    private String customName;
 
    
    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }
    
     public void setTopping(Topping topping) {
        this.topping = topping;
    }
     
      public void setSyrup(Syrup syrup) {
        this.syrup = syrup;
    }
    
    @Override
    public String getCustomName() {
        return customName;
    }

    @Override
    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public String getDescription() {
        if (customName != null && !customName.isEmpty()) {
            return customName + " Ice Cream";
        } else {
            return "Basic Ice Cream";
        }
    }

    @Override
    public double cost() {
         return flavor.getPrice() + topping.getPrice() + syrup.getPrice();
    }

    @Override
    public Flavor getFlavor() {
        return flavor;
    }

    @Override 
    public Topping getTopping() {
        return topping;
    }
 

    @Override 
    public Syrup getSyrup() {
        return syrup;
    }

  
  
}