package src.models;

import java.util.ArrayList;

/**
 * Represents a user in the system.
 */
public class User {
    private String userID;
    private String name;
    private Wardrobe wardrobe;
    private ArrayList<Outfit> savedOutfits;

    /**
     * Constructor for User.
     *
     * @param userID Unique identifier for the user.
     * @param name   Name of the user.
     */
    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
        this.wardrobe = new Wardrobe(userID + "_wardrobe");
        this.savedOutfits = new ArrayList<>();
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }

    /**
     * Saves an outfit to the user's saved outfits.
     *
     * @param outfit The outfit to save.
     */
    public void saveOutfit(Outfit outfit) {
        savedOutfits.add(outfit);
    }

    /**
     * Retrieves the user's saved outfits.
     *
     * @return List of saved outfits.
     */
    public ArrayList<Outfit> viewSavedOutfits() {
        return savedOutfits;
    }
}