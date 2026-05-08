package src.models;

import java.util.ArrayList;

/**
 * Represents an outfit composed of various clothing items.
 */
public class Outfit {
    private String outfitID;
    private String outfitName;
    private ArrayList<ClothingItem> clothingItems;

    /**
     * Constructor for Outfit.
     *
     * @param outfitID   Unique identifier for the outfit.
     * @param outfitName Name of the outfit.
     */
    public Outfit(String outfitID, String outfitName) {
        this.outfitID = outfitID;
        this.outfitName = outfitName;
        this.clothingItems = new ArrayList<>();
    }

    // Getters
    public String getOutfitID() {
        return outfitID;
    }

    public String getOutfitName() {
        return outfitName;
    }

    /**
     * Adds a clothing item to the outfit.
     *
     * @param item The clothing item to add.
     */
    public void addItem(ClothingItem item) {
        clothingItems.add(item);
    }

    /**
     * Removes a clothing item from the outfit.
     *
     * @param item The clothing item to remove.
     */
    public void removeItem(ClothingItem item) {
        clothingItems.remove(item);
    }

    /**
     * Displays the outfit details.
     */
    public void displayOutfit() {
        System.out.println("Outfit: " + outfitName);
        for (ClothingItem item : clothingItems) {
            item.displayItem();
        }
    }

    public ArrayList<ClothingItem> getClothingItems() {
    return clothingItems;
}

    
}