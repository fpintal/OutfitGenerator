package src.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Outfit Generator");
        title.setStyle(
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #2b2b2b;"
        );

        Label subtitle = new Label("Virtual Dress-Up System");
        subtitle.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-text-fill: #666666;"
        );

        Button uploadButton = createMenuButton("Upload Clothing");
        Button buildOutfitButton = createMenuButton("Build Outfit");
        Button wardrobeButton = createMenuButton("View Wardrobe");
        Button savedOutfitsButton = createMenuButton("Saved Outfits");
        Button exitButton = createMenuButton("Exit");

        uploadButton.setOnAction(e -> {
            new UploadView().start(new Stage());
        });

        buildOutfitButton.setOnAction(e -> {
            new OutfitBuilderView().start(new Stage());
        });

        wardrobeButton.setOnAction(e -> {
            new WardrobeView().start(new Stage());
        });

        savedOutfitsButton.setOnAction(e -> {
            new SavedOutfitsView().start(new Stage());
        });

        exitButton.setOnAction(e -> {
            stage.close();
        });

        VBox card = new VBox(18);
        card.setStyle(
                "-fx-padding: 40;" +
                "-fx-alignment: center;" +
                "-fx-background-color: white;" +
                "-fx-border-color: #dddddd;" +
                "-fx-border-radius: 16;" +
                "-fx-background-radius: 16;"
        );

        card.getChildren().addAll(
                title,
                subtitle,
                uploadButton,
                buildOutfitButton,
                wardrobeButton,
                savedOutfitsButton,
                exitButton
        );

        VBox root = new VBox();
        root.setStyle(
                "-fx-padding: 40;" +
                "-fx-alignment: center;" +
                "-fx-background-color: #f4f1ed;"
        );

        root.getChildren().add(card);

        Scene scene = new Scene(root, 550, 600);

        stage.setTitle("Outfit Generator");
        stage.setScene(scene);
        stage.show();
    }

    private Button createMenuButton(String text) {
        Button button = new Button(text);

        button.setPrefWidth(240);
        button.setPrefHeight(42);

        button.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-background-color: #2b2b2b;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );

        return button;
    }
}