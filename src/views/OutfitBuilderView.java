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

    private final String[] topImages = {
            "assets/tops/hoodie.png",
            "assets/tops/tshirt.png"
    };

    private final String[] bottomImages = {
            "assets/bottoms/jeans.png",
            "assets/bottoms/cargos.png"
    };

    private final String[] shoeImages = {
            "assets/shoes/sneakers.png",
            "assets/shoes/boots.png"
    };

    @Override
    public void start(Stage stage) {

        Label title = new Label("Outfit Generator");

        ImageView topView = createImageView(topImages[topIndex]);
        ImageView bottomView = createImageView(bottomImages[bottomIndex]);
        ImageView shoeView = createImageView(shoeImages[shoeIndex]);

        Button switchTopButton = new Button("Switch Top");
        Button switchBottomButton = new Button("Switch Bottom");
        Button switchShoesButton = new Button("Switch Shoes");
        Button saveButton = new Button("Save Outfit");

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
            System.out.println("Outfit Saved!");
            System.out.println("Top: " + topImages[topIndex]);
            System.out.println("Bottom: " + bottomImages[bottomIndex]);
            System.out.println("Shoes: " + shoeImages[shoeIndex]);
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
                saveButton
        );

        Scene scene = new Scene(root, 500, 700);

        stage.setTitle("Outfit Generator");
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