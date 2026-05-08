package src.services;

import src.models.*;
import java.util.ArrayList;

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

    /**
     * Replaces one clothing item in an outfit based on category.
     * Example: replace the current Top while keeping Bottom and Shoe unchanged.
     */
    public void switchItemByCategory(Outfit outfit, ClothingItem newItem) {
        ArrayList<ClothingItem> items = outfit.getClothingItems();

        ClothingItem itemToRemove = null;

        for (ClothingItem item : items) {
            if (item.getCategory().equalsIgnoreCase(newItem.getCategory())) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            outfit.removeItem(itemToRemove);
        }

        outfit.addItem(newItem);
    }
}