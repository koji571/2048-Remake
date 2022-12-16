package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static game.cell.Data.scoreclass;

/**
 * The main entry class of the application
 * @author LeoHaiKen Tan -modified
 */
public class Main extends Application {

    /**
     * Method to start the application
     * @param primaryStage stage at which the application was started
     */
    //setup for scene
    @Override
    public void start(Stage primaryStage) {

        try {

            //setting name for game
            primaryStage.setTitle("2048");

            //setting icon for application
            Image image = new Image(String.valueOf(getClass().getResource("/logo.png")));
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

    /**
     * the application entry point
     * @param args an array of command-line arguments for the application
     */
    //launch method
    public static void main(String[] args) {

        scoreclass.checkFile();

        launch(args);
    }
}
