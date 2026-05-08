package src.services;

import src.models.*;
import java.io.FileWriter;
import java.io.IOException;

public class SaveService {

    public void saveWardrobe(User user) {
        try {
            FileWriter writer = new FileWriter("data/clothingItems.txt");

            for (ClothingItem item : user.getWardrobe().getClothingItems()) {
                writer.write(
                        item.getItemID() + "," +
                        item.getImagePath() + "," +
                        item.getCategory() + "," +
                        item.getColor() + "\n"
                );
            }

            writer.close();
            System.out.println("Wardrobe saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving wardrobe: " + e.getMessage());
        }
    }

    public void saveOutfits(User user) {
    try {
        FileWriter writer = new FileWriter("data/savedOutfits.txt", true);

        for (Outfit outfit : user.viewSavedOutfits()) {
            writer.write(outfit.getOutfitID() + "," + outfit.getOutfitName() + "\n");

            for (ClothingItem item : outfit.getClothingItems()) {
                writer.write(
                        item.getItemID() + "," +
                        item.getImagePath() + "," +
                        item.getCategory() + "," +
                        item.getColor() + "\n"
                );
            }
        }

        writer.close();
        System.out.println("Outfits saved successfully.");

    } catch (IOException e) {
        System.out.println("Error saving outfits: " + e.getMessage());
    }
}

    public void saveOutfit(User user, Outfit outfit) {
        user.saveOutfit(outfit);
        saveOutfits(user);
    }
}