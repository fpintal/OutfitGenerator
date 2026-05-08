package src;

import src.models.*;
import src.services.*;

public class Main {

    public static void main(String[] args) {

        // Create services
        WardrobeService wardrobeService = new WardrobeService();
        OutfitService outfitService = new OutfitService();
        SaveService saveService = new SaveService();
        ImageService imageService = new ImageService();

        // Create user
        User user = new User("1", "Keith");

        // Create clothing items
        Top hoodie = new Top(
                "101",
                "assets/tops/hoodie.png",
                "Top",
                "Black",
                "Long Sleeve"
        );

        Bottom jeans = new Bottom(
                "201",
                "assets/bottoms/jeans.png",
                "Bottom",
                "Blue",
                "Baggy"
        );

        Shoe sneakers = new Shoe(
                "301",
                "assets/shoes/sneakers.png",
                "Shoe",
                "White",
                "Sneakers"
        );

        // Test image validation
        System.out.println("Is hoodie image valid? "
                + imageService.isValidImageFile(hoodie.getImagePath()));

        // Add clothing items using WardrobeService
        wardrobeService.addItemToWardrobe(user, hoodie);
        wardrobeService.addItemToWardrobe(user, jeans);
        wardrobeService.addItemToWardrobe(user, sneakers);

        // Create outfit using OutfitService
        Outfit casualFit = outfitService.createOutfit("401", "Casual Fit");

        outfitService.addItemToOutfit(casualFit, hoodie);
        outfitService.addItemToOutfit(casualFit, jeans);
        outfitService.addItemToOutfit(casualFit, sneakers);

        // Save outfit using SaveService
        saveService.saveOutfit(user, casualFit);

        // Display results
        System.out.println("\nUser Name: " + user.getName());
        System.out.println("Number of Wardrobe Items: "
                + user.getWardrobe().getClothingItems().size());

        System.out.println("Number of Saved Outfits: "
                + user.viewSavedOutfits().size());

        System.out.println("\nWardrobe Items:");
        wardrobeService.displayWardrobe(user);

        System.out.println("\nOutfit Details:");
        outfitService.displayOutfit(casualFit);
    }
}