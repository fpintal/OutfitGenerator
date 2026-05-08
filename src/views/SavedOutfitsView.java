package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

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
            ArrayList<String> currentOutfitLines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                // Outfit header
                if (parts.length == 2) {

                    currentOutfitLines = new ArrayList<>();
                    currentOutfitLines.add(line);

                    currentOutfitBox = new VBox(8);

                    currentOutfitBox.setStyle(
                            "-fx-alignment: center;" +
                            "-fx-border-color: lightgray;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 15;"
                    );

                    Label outfitName = new Label("Outfit: " + parts[1]);

                    Button deleteButton = new Button("Delete Outfit");

                    ArrayList<String> outfitToDelete = currentOutfitLines;

                    deleteButton.setOnAction(e -> {
                        deleteOutfit(outfitToDelete);

                        Stage currentStage = (Stage) outfitsBox.getScene().getWindow();
                        currentStage.close();

                        new SavedOutfitsView().start(new Stage());
                    });

                    currentOutfitBox.getChildren().addAll(
                            outfitName,
                            deleteButton
                    );

                    outfitsBox.getChildren().add(currentOutfitBox);
                }

                // Clothing item line
                if (parts.length == 4 && currentOutfitBox != null) {

                    currentOutfitLines.add(line);

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

    private void deleteOutfit(ArrayList<String> outfitLines) {

        try {

            File inputFile = new File("data/savedOutfits.txt");

            BufferedReader reader = new BufferedReader(
                    new FileReader(inputFile)
            );

            ArrayList<String> remainingLines = new ArrayList<>();

            String line;

            while ((line = reader.readLine()) != null) {

                if (!outfitLines.contains(line)) {
                    remainingLines.add(line);
                }
            }

            reader.close();

            FileWriter writer = new FileWriter(inputFile);

            for (String remainingLine : remainingLines) {
                writer.write(remainingLine + "\n");
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error deleting outfit: " + e.getMessage()
            );
        }
    }
}