package src.services;

import src.models.*;

public class OutfitService {

    public Outfit createOutfit(String outfitID, String outfitName) {
        return new Outfit(outfitID, outfitName);
    }

    public void addItemToOutfit(Outfit outfit, ClothingItem item) {
        outfit.addItem(item);
    }

    public void removeItemFromOutfit(Outfit outfit, ClothingItem item) {
        outfit.removeItem(item);
    }

    public void saveOutfit(User user, Outfit outfit) {
        user.saveOutfit(outfit);
    }

    public void displayOutfit(Outfit outfit) {
        outfit.displayOutfit();
    }
}