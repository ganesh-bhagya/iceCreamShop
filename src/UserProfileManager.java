/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.HashMap;
import java.util.Map;

public class UserProfileManager {
    private Map<String, UserProfile> userProfiles;

    public UserProfileManager() {
        this.userProfiles = new HashMap<>();
    }

    public UserProfile registerUser(String username) {
        UserProfile userProfile = new UserProfile(username);
        userProfiles.put(username, userProfile);
        return userProfile;
    }

    public UserProfile getUserProfile(String username) {
        return userProfiles.get(username);
    }

    // Additional methods for user authentication, profile updates, etc.
}
