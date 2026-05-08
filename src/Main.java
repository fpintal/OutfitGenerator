package src;

import src.models.*;

/**
 * Test class for the Outfit Generator & Virtual Dress-Up System.
 */
public class Main {
    public static void main(String[] args) {
        // Step 1: Create a User object
        User user = new User("1", "Keith");

        // Step 2: Create sample clothing items
        Top hoodie = new Top("101", "assets/tops/hoodie.png", "Top", "Black", "Long Sleeve");
        Bottom jeans = new Bottom("201", "assets/bottoms/jeans.png", "Bottom", "Blue", "Baggy");
        Shoe sneakers = new Shoe("301", "assets/shoes/sneakers.png", "Shoe", "White", "Sneakers");

        // Step 3: Add clothing items to the user's wardrobe
        user.getWardrobe().addClothingItem(hoodie);
        user.getWardrobe().addClothingItem(jeans);
        user.getWardrobe().addClothingItem(sneakers);

        // Step 4: Create an Outfit
        Outfit casualFit = new Outfit("401", "Casual Fit");

        // Step 5: Add the top, bottom, and shoes to the outfit
        casualFit.addItem(hoodie);
        casualFit.addItem(jeans);
        casualFit.addItem(sneakers);

        // Step 6: Save the outfit to the user
        user.saveOutfit(casualFit);

        // Step 7: Print user and outfit details
        System.out.println("User Name: " + user.getName());
        System.out.println("Number of Wardrobe Items: " + user.getWardrobe().getClothingItems().size());
        System.out.println("Number of Saved Outfits: " + user.viewSavedOutfits().size());

        // Display outfit details
        System.out.println("Outfit Details:");
        casualFit.displayOutfit();
    }
}