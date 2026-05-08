package src.models;

import java.util.ArrayList;

/**
 * Represents a user's wardrobe.
 */
public class Wardrobe {
    private String wardrobeID;
    private ArrayList<ClothingItem> clothingItems;

    /**
     * Constructor for Wardrobe.
     *
     * @param wardrobeID Unique identifier for the wardrobe.
     */
    public Wardrobe(String wardrobeID) {
        this.wardrobeID = wardrobeID;
        this.clothingItems = new ArrayList<>();
    }

    // Getter
    public String getWardrobeID() {
        return wardrobeID;
    }

    /**
     * Adds a clothing item to the wardrobe.
     *
     * @param item The clothing item to add.
     */
    public void addClothingItem(ClothingItem item) {
        clothingItems.add(item);
    }

    /**
     * Removes a clothing item from the wardrobe.
     *
     * @param item The clothing item to remove.
     */
    public void removeClothingItem(ClothingItem item) {
        clothingItems.remove(item);
    }

    /**
     * Retrieves all clothing items in the wardrobe.
     *
     * @return List of clothing items.
     */
    public ArrayList<ClothingItem> getClothingItems() {
        return clothingItems;
    }
}