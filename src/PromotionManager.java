
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
public class PromotionManager {
    private List<Promotion> activePromotions = new ArrayList<>();

    public void addPromotion(Promotion promotion) {
        activePromotions.add(promotion);
    }

    public void removePromotion(Promotion promotion) {
        activePromotions.remove(promotion);
    }

    public List<Promotion> getActivePromotions() {
       
        return activePromotions;
    }
}
