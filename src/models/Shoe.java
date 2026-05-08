package src.models;

/**
 * Represents a shoe item.
 */
public class Shoe extends ClothingItem {
    private String shoeType;

    /**
     * Constructor for Shoe.
     *
     * @param itemID    Unique identifier for the shoe.
     * @param imagePath Path to the image of the shoe.
     * @param category  Category of the shoe.
     * @param color     Color of the shoe.
     * @param shoeType  Type of shoe (e.g., sneakers, boots).
     */
    public Shoe(String itemID, String imagePath, String category, String color, String shoeType) {
        super(itemID, imagePath, category, color);
        this.shoeType = shoeType;
    }

    // Getter
    public String getShoeType() {
        return shoeType;
    }

    /**
     * Displays the shoe details.
     */
    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Shoe Type: " + shoeType);
    }
}