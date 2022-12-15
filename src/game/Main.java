package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static game.cell.Data.scoreclass;
public class Main extends Application {

    //setup for scene
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {

            //setting name for game
            primaryStage.setTitle("2048");

            //setting icon for application
            Image image = new Image("logo.png");
            primaryStage.getIcons().add(image);

            //launching Menu.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //launch method
    public static void main(String[] args) {

        scoreclass.checkFile();

        launch(args);
    }
}
