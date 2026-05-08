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
        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;"
        );

        VBox outfitsBox = new VBox(25);
        outfitsBox.setStyle("-fx-alignment: center;");

        loadSavedOutfitImages(outfitsBox, stage);

        ScrollPane scrollPane = new ScrollPane(outfitsBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(520);

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

        Scene scene = new Scene(root, 650, 700);

        stage.setTitle("Saved Outfits");
        stage.setScene(scene);
        stage.show();
    }

    private void loadSavedOutfitImages(VBox outfitsBox, Stage stage) {

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

                if (parts.length == 2) {

                    currentOutfitLines = new ArrayList<>();
                    currentOutfitLines.add(line);

                    currentOutfitBox = new VBox(10);
                    currentOutfitBox.setStyle(
                            "-fx-alignment: center;" +
                            "-fx-padding: 18;" +
                            "-fx-background-color: #fafafa;" +
                            "-fx-background-radius: 14;" +
                            "-fx-border-radius: 14;" +
                            "-fx-border-color: #dddddd;"
                    );

                    Label outfitName = new Label("Outfit: " + parts[1]);
                    outfitName.setStyle(
                            "-fx-font-size: 18px;" +
                            "-fx-font-weight: bold;"
                    );

                    Button deleteButton = createDeleteButton("Delete Outfit");

                    ArrayList<String> outfitToDelete = currentOutfitLines;

                    deleteButton.setOnAction(e -> {
                        deleteOutfit(outfitToDelete);
                        stage.close();
                        new SavedOutfitsView().start(new Stage());
                    });

                    currentOutfitBox.getChildren().addAll(
                            outfitName,
                            deleteButton
                    );

                    outfitsBox.getChildren().add(currentOutfitBox);
                }

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
            System.out.println("Error deleting outfit: " + e.getMessage());
        }
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

    private Button createDeleteButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(160);
        button.setPrefHeight(35);

        button.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-background-color: #8b2f2f;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;"
        );

        return button;
    }
}