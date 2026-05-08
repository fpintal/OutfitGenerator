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

        Label title = new Label("Outfit Generator & Virtual Dress-Up System");

        Button uploadButton = new Button("Upload Clothing");
        Button buildOutfitButton = new Button("Build Outfit");
        Button wardrobeButton = new Button("View Wardrobe");
        Button savedOutfitsButton = new Button("Saved Outfits");
        Button exitButton = new Button("Exit");

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

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        root.getChildren().addAll(
                title,
                uploadButton,
                buildOutfitButton,
                wardrobeButton,
                savedOutfitsButton,
                exitButton
        );

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}