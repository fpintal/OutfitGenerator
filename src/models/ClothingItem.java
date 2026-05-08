package src.models;

import java.util.Objects;

/**
 * Represents a generic clothing item.
 */
public class ClothingItem {
    private String itemID;
    private String imagePath;
    private String category;
    private String color;

    /**
     * Constructor for ClothingItem.
     *
     * @param itemID    Unique identifier for the clothing item.
     * @param imagePath Path to the image of the clothing item.
     * @param category  Category of the clothing item (e.g., Top, Bottom).
     * @param color     Color of the clothing item.
     */
    public ClothingItem(String itemID, String imagePath, String category, String color) {
        this.itemID = itemID;
        this.imagePath = imagePath;
        this.category = category;
        this.color = color;
    }

    // Getters
    public String getItemID() {
        return itemID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    /**
     * Displays the clothing item details.
     */
    public void displayItem() {
        System.out.println("Clothing Item: " + itemID + ", Category: " + category + ", Color: " + color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothingItem that = (ClothingItem) o;
        return Objects.equals(itemID, that.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID);
    }
}