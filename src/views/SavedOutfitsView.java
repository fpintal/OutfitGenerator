package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SavedOutfitsView {

    public void start(Stage stage) {

        Label title = new Label("Saved Outfits");

        VBox outfitsBox = new VBox(25);
        outfitsBox.setStyle("-fx-alignment: center;");

        loadSavedOutfitImages(outfitsBox);

        ScrollPane scrollPane = new ScrollPane(outfitsBox);
        scrollPane.setFitToWidth(true);

        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            stage.close();
            new MainView().start(new Stage());
        });

        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        root.getChildren().addAll(
                title,
                scrollPane,
                backButton
        );

        Scene scene = new Scene(root, 500, 700);

        stage.setTitle("Saved Outfits");
        stage.setScene(scene);
        stage.show();
    }

    private void loadSavedOutfitImages(VBox outfitsBox) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("data/savedOutfits.txt")
            );

            String line;
            VBox currentOutfitBox = null;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 2) {
                    currentOutfitBox = new VBox(8);
                    currentOutfitBox.setStyle(
                            "-fx-alignment: center;" +
                            "-fx-border-color: lightgray;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 15;"
                    );

                    Label outfitName = new Label("Outfit: " + parts[1]);
                    currentOutfitBox.getChildren().add(outfitName);

                    outfitsBox.getChildren().add(currentOutfitBox);
                }

                if (parts.length == 4 && currentOutfitBox != null) {
                    String imagePath = parts[1];

                    ImageView imageView = new ImageView(
                            new Image("file:" + imagePath)
                    );

                    imageView.setFitWidth(150);
                    imageView.setPreserveRatio(true);

                    currentOutfitBox.getChildren().add(imageView);
                }
            }

            reader.close();

        } catch (IOException e) {
            outfitsBox.getChildren().add(
                    new Label("No saved outfits found.")
            );
        }
    }
}