package src.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import src.models.*;
import src.services.*;

public class OutfitBuilderView extends Application {

    private int topIndex = 0;
    private int bottomIndex = 0;
    private int shoeIndex = 0;

    private User user = new User("1", "Keith");
    private SaveService saveService = new SaveService();

    private final String[] topImages = {
            "assets/tops/floral_top.png",
            "assets/tops/tan_buttonup.png"
    };

    private final String[] bottomImages = {
            "assets/bottoms/dark_denim_pants.png",
            "assets/bottoms/denim_jorts.png",
            "assets/bottoms/harley_pants.png",
            "assets/bottoms/pink_capris.png"
    };

    private final String[] shoeImages = {
            "assets/shoes/brown_dressshoes.png"
    };

    @Override
    public void start(Stage stage) {

        Label title = new Label("Outfit Generator");

        ImageView topView = createImageView(topImages[topIndex]);
        ImageView bottomView = createImageView(bottomImages[bottomIndex]);
        ImageView shoeView = createImageView(shoeImages[shoeIndex]);

        Label statusLabel = new Label("");

        Button switchTopButton = new Button("Switch Top");
        Button switchBottomButton = new Button("Switch Bottom");
        Button switchShoesButton = new Button("Switch Shoes");
        Button saveButton = new Button("Save Outfit");
        Button backButton = new Button("Back");

        switchTopButton.setOnAction(e -> {
            topIndex = (topIndex + 1) % topImages.length;
            topView.setImage(new Image("file:" + topImages[topIndex]));
        });

        switchBottomButton.setOnAction(e -> {
            bottomIndex = (bottomIndex + 1) % bottomImages.length;
            bottomView.setImage(new Image("file:" + bottomImages[bottomIndex]));
        });

        switchShoesButton.setOnAction(e -> {
            shoeIndex = (shoeIndex + 1) % shoeImages.length;
            shoeView.setImage(new Image("file:" + shoeImages[shoeIndex]));
        });

        saveButton.setOnAction(e -> {
            String outfitID = "OUTFIT_" + System.currentTimeMillis();

            Outfit outfit = new Outfit(outfitID, "Saved Outfit");
            Top selectedTop = new Top(
                    "101",
                    topImages[topIndex],
                    "Top",
                    "Selected",
                    "N/A"
            );

            Bottom selectedBottom = new Bottom(
                    "201",
                    bottomImages[bottomIndex],
                    "Bottom",
                    "Selected",
                    "N/A"
            );

            Shoe selectedShoe = new Shoe(
                    "301",
                    shoeImages[shoeIndex],
                    "Shoe",
                    "Selected",
                    "N/A"
            );

            outfit.addItem(selectedTop);
            outfit.addItem(selectedBottom);
            outfit.addItem(selectedShoe);

            saveService.saveOutfit(user, outfit);

            statusLabel.setText("Outfit saved successfully!");
        });

        backButton.setOnAction(e -> {
            stage.close();
            new MainView().start(new Stage());
        });

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        root.getChildren().addAll(
                title,
                topView,
                bottomView,
                shoeView,
                switchTopButton,
                switchBottomButton,
                switchShoesButton,
                saveButton,
                statusLabel,
                backButton
        );

        Scene scene = new Scene(root, 500, 700);

        stage.setTitle("Outfit Builder");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView createImageView(String imagePath) {
        Image image = new Image("file:" + imagePath);
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        return imageView;
    }
}