package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WardrobeView {

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

    public void start(Stage stage) {

        Label title = new Label("My Wardrobe");

        VBox wardrobeBox = new VBox(25);
        wardrobeBox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        wardrobeBox.getChildren().add(createCategorySection("Tops", topImages));
        wardrobeBox.getChildren().add(createCategorySection("Bottoms", bottomImages));
        wardrobeBox.getChildren().add(createCategorySection("Shoes", shoeImages));

        ScrollPane scrollPane = new ScrollPane(wardrobeBox);
        scrollPane.setFitToWidth(true);

        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            stage.close();
            new MainView().start(new Stage());
        });

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        root.getChildren().addAll(
                title,
                scrollPane,
                backButton
        );

        Scene scene = new Scene(root, 700, 600);

        stage.setTitle("Wardrobe");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createCategorySection(String categoryName, String[] imagePaths) {

        Label categoryLabel = new Label(categoryName);

        HBox imageRow = new HBox(15);
        imageRow.setStyle("-fx-alignment: center;");

        for (String imagePath : imagePaths) {
            VBox itemBox = new VBox(8);
            itemBox.setStyle("-fx-alignment: center;");

            ImageView imageView = new ImageView(new Image("file:" + imagePath));
            imageView.setFitWidth(130);
            imageView.setPreserveRatio(true);

            Label fileNameLabel = new Label(getFileName(imagePath));

            itemBox.getChildren().addAll(imageView, fileNameLabel);
            imageRow.getChildren().add(itemBox);
        }

        VBox section = new VBox(10);
        section.setStyle(
                "-fx-padding: 15;" +
                "-fx-border-color: lightgray;" +
                "-fx-border-width: 1;" +
                "-fx-alignment: center;"
        );

        section.getChildren().addAll(categoryLabel, imageRow);

        return section;
    }

    private String getFileName(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }
}