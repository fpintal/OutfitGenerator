package src.models;

/**
 * Represents a top clothing item.
 */
public class Top extends ClothingItem {
    private String sleeveType;

    /**
     * Constructor for Top.
     *
     * @param itemID    Unique identifier for the top.
     * @param imagePath Path to the image of the top.
     * @param category  Category of the top.
     * @param color     Color of the top.
     * @param sleeveType Type of sleeves (e.g., short, long).
     */
    public Top(String itemID, String imagePath, String category, String color, String sleeveType) {
        super(itemID, imagePath, category, color);
        this.sleeveType = sleeveType;
    }

    // Getter
    public String getSleeveType() {
        return sleeveType;
    }

    /**
     * Displays the top details.
     */
    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Sleeve Type: " + sleeveType);
    }
}