package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class WardrobeView {

    public void start(Stage stage) {

        String[] topImages = loadImagesFromFolder("assets/tops");
        String[] bottomImages = loadImagesFromFolder("assets/bottoms");
        String[] shoeImages = loadImagesFromFolder("assets/shoes");

        Label title = new Label("My Wardrobe");

        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;"
        );

        VBox wardrobeBox = new VBox(25);
        wardrobeBox.setStyle("-fx-padding: 20;");

        wardrobeBox.getChildren().add(
                createCategorySection("Tops", topImages)
        );

        wardrobeBox.getChildren().add(
                createCategorySection("Bottoms", bottomImages)
        );

        wardrobeBox.getChildren().add(
                createCategorySection("Shoes", shoeImages)
        );

        ScrollPane scrollPane = new ScrollPane(wardrobeBox);
        scrollPane.setFitToWidth(true);

        Button backButton = createButton("Back");

        backButton.setOnAction(e -> {
            stage.close();
        });

        VBox card = new VBox(20);

        card.setStyle(
                "-fx-padding: 25;" +
                "-fx-background-color: white;" +
                "-fx-background-radius: 16;" +
                "-fx-border-radius: 16;" +
                "-fx-border-color: #dddddd;"
        );

        card.getChildren().addAll(
                title,
                scrollPane,
                backButton
        );

        VBox root = new VBox();
        root.setStyle(
                "-fx-padding: 30;" +
                "-fx-alignment: center;" +
                "-fx-background-color: #f4f1ed;"
        );

        root.getChildren().add(card);

        Scene scene = new Scene(root, 850, 700);

        stage.setTitle("Wardrobe");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createCategorySection(
            String categoryName,
            String[] imagePaths
    ) {

        Label categoryLabel = new Label(categoryName);

        categoryLabel.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        FlowPane imagePane = new FlowPane();

        imagePane.setHgap(15);
        imagePane.setVgap(15);

        for (String imagePath : imagePaths) {

            VBox itemBox = new VBox(8);

            itemBox.setStyle(
                    "-fx-alignment: center;" +
                    "-fx-padding: 10;"
            );

            ImageView imageView = new ImageView(
                    new Image("file:" + imagePath)
            );

            imageView.setFitWidth(140);
            imageView.setPreserveRatio(true);

            Label fileNameLabel = new Label(
                    getFileName(imagePath)
            );

            itemBox.getChildren().addAll(
                    imageView,
                    fileNameLabel
            );

            imagePane.getChildren().add(itemBox);
        }

        VBox section = new VBox(10);

        section.setStyle(
                "-fx-padding: 15;" +
                "-fx-border-color: #dddddd;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
        );

        section.getChildren().addAll(
                categoryLabel,
                imagePane
        );

        return section;
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

    private String getFileName(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    private Button createButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(220);
        button.setPrefHeight(40);

        button.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-background-color: #2b2b2b;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;"
        );

        return button;
    }
}