/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String username;
    private List<Order> favoriteCombinations;

    public UserProfile(String username) {
        this.username = username;
        this.favoriteCombinations = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

      public List<Order> getFavoriteCombinations() {
        return favoriteCombinations;
    }

    public void addFavoriteCombination(Order order) {
        favoriteCombinations.add(order);
    }

    public void removeFavoriteCombination(Order order) {
        favoriteCombinations.remove(order);
    }

}
