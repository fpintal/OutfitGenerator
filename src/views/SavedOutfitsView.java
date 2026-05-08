package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavedOutfitsView {

    public void start(Stage stage) {

        Label title = new Label("Saved Outfits");

        Label message = new Label("Saved outfits will appear here.");

        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            stage.close();
            new MainView().start(new Stage());
        });

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        root.getChildren().addAll(
                title,
                message,
                backButton
        );

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Saved Outfits");
        stage.setScene(scene);
        stage.show();
    }
}