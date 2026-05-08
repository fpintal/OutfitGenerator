package src.services;

import src.models.*;

public class SaveService {

    public void saveWardrobe(User user) {
        System.out.println("Saving wardrobe for " + user.getName() + "...");
    }

    public void saveOutfit(User user, Outfit outfit) {
        user.saveOutfit(outfit);
        System.out.println("Outfit saved successfully.");
    }

    public void loadSavedOutfits(User user) {
        System.out.println("Loading saved outfits for " + user.getName() + "...");
    }
}