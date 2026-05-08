package src.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OutfitBuilderView extends Application {

    private int topIndex = 0;
    private int bottomIndex = 0;
    private int shoeIndex = 0;

    // Top images
    private final String[] topImages = {
            "assets/tops/floral_top.png",
            "assets/tops/tan_buttonup.png"
    };

    // Bottom images
    private final String[] bottomImages = {
            "assets/bottoms/dark_denim_pants.png",
            "assets/bottoms/denim_jorts.png",
            "assets/bottoms/harley_pants.png",
            "assets/bottoms/pink_capris.png"
    };

    // Shoe images
    private final String[] shoeImages = {
            "assets/shoes/brown_dressshoes.png"
    };

    @Override
    public void start(Stage stage) {

        // Title
        Label title = new Label("Outfit Generator");

        // ImageViews
        ImageView topView = createImageView(topImages[topIndex]);
        ImageView bottomView = createImageView(bottomImages[bottomIndex]);
        ImageView shoeView = createImageView(shoeImages[shoeIndex]);

        // Buttons
        Button switchTopButton = new Button("Switch Top");
        Button switchBottomButton = new Button("Switch Bottom");
        Button switchShoesButton = new Button("Switch Shoes");
        Button saveButton = new Button("Save Outfit");
        Button backButton = new Button("Back");

        // Switch top
        switchTopButton.setOnAction(e -> {
            topIndex = (topIndex + 1) % topImages.length;
            topView.setImage(new Image("file:" + topImages[topIndex]));
        });

        // Switch bottom
        switchBottomButton.setOnAction(e -> {
            bottomIndex = (bottomIndex + 1) % bottomImages.length;
            bottomView.setImage(new Image("file:" + bottomImages[bottomIndex]));
        });

        // Switch shoes
        switchShoesButton.setOnAction(e -> {
            shoeIndex = (shoeIndex + 1) % shoeImages.length;
            shoeView.setImage(new Image("file:" + shoeImages[shoeIndex]));
        });

        // Save outfit
        saveButton.setOnAction(e -> {
            System.out.println("Outfit Saved!");

            System.out.println("Top: " + topImages[topIndex]);
            System.out.println("Bottom: " + bottomImages[bottomIndex]);
            System.out.println("Shoes: " + shoeImages[shoeIndex]);
        });

        // Back button
        backButton.setOnAction(e -> {
            stage.close();
            new MainView().start(new Stage());
        });

        // Layout
        VBox root = new VBox(15);

        root.setStyle(
                "-fx-padding: 20;" +
                "-fx-alignment: center;"
        );

        root.getChildren().addAll(
                title,
                topView,
                bottomView,
                shoeView,
                switchTopButton,
                switchBottomButton,
                switchShoesButton,
                saveButton,
                backButton
        );

        // Scene
        Scene scene = new Scene(root, 500, 700);

        // Stage
        stage.setTitle("Outfit Builder");
        stage.setScene(scene);
        stage.show();
    }

    // Helper method for image views
    private ImageView createImageView(String imagePath) {

        Image image = new Image("file:" + imagePath);

        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        return imageView;
    }
}