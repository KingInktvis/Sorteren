package sorteren.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by rik on 28-2-17.
 */
public class Gui extends Application{

    public void go(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        primaryStage.setTitle("Sorteren");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
