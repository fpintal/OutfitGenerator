package src.services;

import src.models.*;
import java.util.ArrayList;

public class WardrobeService {

    public void addItemToWardrobe(User user, ClothingItem item) {
        user.getWardrobe().addClothingItem(item);
    }

    public void removeItemFromWardrobe(User user, ClothingItem item) {
        user.getWardrobe().removeClothingItem(item);
    }

    public ArrayList<ClothingItem> getItemsByCategory(User user, String category) {
        ArrayList<ClothingItem> filteredItems = new ArrayList<>();

        for (ClothingItem item : user.getWardrobe().getClothingItems()) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }

    public void displayWardrobe(User user) {
        for (ClothingItem item : user.getWardrobe().getClothingItems()) {
            item.displayItem();
        }
    }
}