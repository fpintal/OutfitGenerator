package src.models;

/**
 * Represents a bottom clothing item.
 */
public class Bottom extends ClothingItem {
    private String fitType;

    /**
     * Constructor for Bottom.
     *
     * @param itemID    Unique identifier for the bottom.
     * @param imagePath Path to the image of the bottom.
     * @param category  Category of the bottom.
     * @param color     Color of the bottom.
     * @param fitType   Fit type of the bottom (e.g., slim, regular).
     */
    public Bottom(String itemID, String imagePath, String category, String color, String fitType) {
        super(itemID, imagePath, category, color);
        this.fitType = fitType;
    }

    // Getter
    public String getFitType() {
        return fitType;
    }

    /**
     * Displays the bottom details.
     */
    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Fit Type: " + fitType);
    }
}