package src.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UploadView {

    public void start(Stage stage) {

        Label title = new Label("Upload Clothing");

        Label message = new Label("Upload feature will be added later.");

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

        stage.setTitle("Upload Clothing");
        stage.setScene(scene);
        stage.show();
    }
}