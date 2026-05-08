package src.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import src.models.*;
import src.services.*;

import java.io.File;
import java.util.Random;

public class OutfitBuilderView extends Application {

    private int topIndex = 0;
    private int bottomIndex = 0;
    private int shoeIndex = 0;

    private String[] topImages;
    private String[] bottomImages;
    private String[] shoeImages;
    private Random random = new Random();

    private User user = new User("1", "Keith");
    private SaveService saveService = new SaveService();

    @Override
    public void start(Stage stage) {

        topImages = loadImagesFromFolder("assets/tops");
        bottomImages = loadImagesFromFolder("assets/bottoms");
        shoeImages = loadImagesFromFolder("assets/shoes");

        Label title = new Label("Build Outfit");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        TextField outfitNameField = new TextField();
        outfitNameField.setPromptText("Enter outfit name");
        outfitNameField.setMaxWidth(250);
        outfitNameField.setStyle("-fx-background-radius: 10; -fx-padding: 8;");

        ImageView topView = createImageView(topImages, topIndex, 200);
        ImageView bottomView = createImageView(bottomImages, bottomIndex, 200);
        ImageView shoeView = createImageView(shoeImages, shoeIndex, 160);

        VBox outfitDisplay = new VBox(10);
        outfitDisplay.setStyle(
                "-fx-padding: 15;" +
                "-fx-alignment: center;" +
                "-fx-border-color: #dddddd;" +
                "-fx-border-radius: 16;" +
                "-fx-background-radius: 16;" +
                "-fx-background-color: #fafafa;"
        );

        outfitDisplay.getChildren().addAll(
                topView,
                bottomView,
                shoeView
        );

        Label statusLabel = new Label("");
        statusLabel.setStyle("-fx-text-fill: #2f6b3f;");

        Button randomizeButton = createButton("Randomize");
        Button switchTopButton = createButton("Switch Top");
        Button switchBottomButton = createButton("Switch Bottom");
        Button switchShoesButton = createButton("Switch Shoes");
        Button saveButton = createButton("Save Outfit");
        Button backButton = createButton("Back");

        randomizeButton.setOnAction(e -> {
    if (topImages.length > 0) {
        topIndex = random.nextInt(topImages.length);
        topView.setImage(new Image("file:" + topImages[topIndex]));
    }

    if (bottomImages.length > 0) {
        bottomIndex = random.nextInt(bottomImages.length);
        bottomView.setImage(new Image("file:" + bottomImages[bottomIndex]));
    }

    if (shoeImages.length > 0) {
        shoeIndex = random.nextInt(shoeImages.length);
        shoeView.setImage(new Image("file:" + shoeImages[shoeIndex]));
    }

    statusLabel.setText("Random outfit generated!");
});

        switchTopButton.setOnAction(e -> {
            if (topImages.length > 0) {
                topIndex = (topIndex + 1) % topImages.length;
                topView.setImage(new Image("file:" + topImages[topIndex]));
            }
        });

        switchBottomButton.setOnAction(e -> {
            if (bottomImages.length > 0) {
                bottomIndex = (bottomIndex + 1) % bottomImages.length;
                bottomView.setImage(new Image("file:" + bottomImages[bottomIndex]));
            }
        });

        switchShoesButton.setOnAction(e -> {
            if (shoeImages.length > 0) {
                shoeIndex = (shoeIndex + 1) % shoeImages.length;
                shoeView.setImage(new Image("file:" + shoeImages[shoeIndex]));
            }
        });

        saveButton.setOnAction(e -> {
            if (topImages.length == 0 || bottomImages.length == 0 || shoeImages.length == 0) {
                statusLabel.setText("Cannot save. Missing clothing images.");
                return;
            }

            String outfitID = "OUTFIT_" + System.currentTimeMillis();

            String outfitName = outfitNameField.getText();

            if (outfitName.isEmpty()) {
                outfitName = "Saved Outfit";
            }

            Outfit outfit = new Outfit(outfitID, outfitName);

            Top selectedTop = new Top(
                    "TOP_" + System.currentTimeMillis(),
                    topImages[topIndex],
                    "Top",
                    "Selected",
                    "N/A"
            );

            Bottom selectedBottom = new Bottom(
                    "BOTTOM_" + System.currentTimeMillis(),
                    bottomImages[bottomIndex],
                    "Bottom",
                    "Selected",
                    "N/A"
            );

            Shoe selectedShoe = new Shoe(
                    "SHOE_" + System.currentTimeMillis(),
                    shoeImages[shoeIndex],
                    "Shoe",
                    "Selected",
                    "N/A"
            );

            outfit.addItem(selectedTop);
            outfit.addItem(selectedBottom);
            outfit.addItem(selectedShoe);

            saveService.saveOutfit(user, outfit);

            statusLabel.setText("Outfit saved: " + outfitName);
            outfitNameField.clear();
        });

        backButton.setOnAction(e -> {
            stage.close();
        });

        HBox switchButtons = new HBox(10);
        switchButtons.setStyle("-fx-alignment: center;");
        switchButtons.getChildren().addAll(
                randomizeButton,
                switchTopButton,
                switchBottomButton,
                switchShoesButton
        );

        HBox actionButtons = new HBox(10);
        actionButtons.setStyle("-fx-alignment: center;");
        actionButtons.getChildren().addAll(
                saveButton,
                backButton
        );

        VBox card = new VBox(15);
        card.setStyle(
                "-fx-padding: 25;" +
                "-fx-alignment: center;" +
                "-fx-background-color: white;" +
                "-fx-background-radius: 16;" +
                "-fx-border-radius: 16;" +
                "-fx-border-color: #dddddd;"
        );

        card.getChildren().addAll(
                title,
                outfitNameField,
                outfitDisplay,
                switchButtons,
                actionButtons,
                statusLabel
        );

        VBox root = new VBox();
        root.setStyle(
                "-fx-padding: 30;" +
                "-fx-alignment: center;" +
                "-fx-background-color: #f4f1ed;"
        );

        root.getChildren().add(card);

        Scene scene = new Scene(root, 650, 800);

        stage.setTitle("Outfit Builder");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView createImageView(String[] imagePaths, int index, int width) {

        ImageView imageView = new ImageView();

        if (imagePaths.length > 0) {
            imageView.setImage(new Image("file:" + imagePaths[index]));
        }

        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    private String[] loadImagesFromFolder(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists()) {
            return new String[0];
        }

        File[] files = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".png") ||
                        name.toLowerCase().endsWith(".jpg") ||
                        name.toLowerCase().endsWith(".jpeg")
        );

        if (files == null) {
            return new String[0];
        }

        String[] imagePaths = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            imagePaths[i] = files[i].getPath();
        }

        return imagePaths;
    }

    private Button createButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(130);
        button.setPrefHeight(38);

        button.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-background-color: #2b2b2b;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;"
        );

        return button;
    }
}