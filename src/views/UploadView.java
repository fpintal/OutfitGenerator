package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UploadView {

    private File selectedFile;

    public void start(Stage stage) {

        Label title = new Label("Upload Clothing");
        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;"
        );

        Label selectedFileLabel = new Label("No file selected");

        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("tops", "bottoms", "shoes");
        categoryBox.setPromptText("Select category");

        ImageView previewImage = new ImageView();
        previewImage.setFitWidth(220);
        previewImage.setPreserveRatio(true);

        Button chooseFileButton = createButton("Choose Image");
        Button uploadButton = createButton("Upload");
        Button backButton = createButton("Back");

        chooseFileButton.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Clothing Image");

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "Image Files",
                            "*.png",
                            "*.jpg",
                            "*.jpeg"
                    )
            );

            selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                selectedFileLabel.setText(selectedFile.getName());

                previewImage.setImage(
                        new Image(selectedFile.toURI().toString())
                );
            }
        });

        uploadButton.setOnAction(e -> {

            String category = categoryBox.getValue();

            if (selectedFile == null) {
                selectedFileLabel.setText("Choose an image first.");
                return;
            }

            if (category == null) {
                selectedFileLabel.setText("Select a category.");
                return;
            }

            try {

                File destinationFolder =
                        new File("assets/" + category);

                if (!destinationFolder.exists()) {
                    destinationFolder.mkdirs();
                }

                File destinationFile = new File(
                        destinationFolder,
                        selectedFile.getName()
                );

                Files.copy(
                        selectedFile.toPath(),
                        destinationFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );

                selectedFileLabel.setText(
                        "Uploaded: " + selectedFile.getName()
                );

            } catch (IOException ex) {

                selectedFileLabel.setText("Upload failed.");

                System.out.println(
                        "Error uploading file: " + ex.getMessage()
                );
            }
        });

        backButton.setOnAction(e -> {
            stage.close();
        });

        VBox card = new VBox(15);

        card.setStyle(
                "-fx-padding: 30;" +
                "-fx-alignment: center;" +
                "-fx-background-color: white;" +
                "-fx-background-radius: 16;" +
                "-fx-border-radius: 16;" +
                "-fx-border-color: #dddddd;"
        );

        card.getChildren().addAll(
                title,
                categoryBox,
                chooseFileButton,
                selectedFileLabel,
                previewImage,
                uploadButton,
                backButton
        );

        VBox root = new VBox();
        root.setStyle(
                "-fx-padding: 30;" +
                "-fx-alignment: center;" +
                "-fx-background-color: #f4f1ed;"
        );

        root.getChildren().add(card);

        Scene scene = new Scene(root, 550, 650);

        stage.setTitle("Upload Clothing");
        stage.setScene(scene);
        stage.show();
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