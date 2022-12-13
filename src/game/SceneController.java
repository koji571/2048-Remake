package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SceneController {

    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    //default constructor
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    private Stage primaryStage;


    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

    Group winGameRoot = new Group();
    Scene winGameScene = new Scene(winGameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));


    @FXML
    private ColorPicker myColorPicker;

    //setting default bgcolour
    Color bgcolor = Color.rgb(189, 177, 92);

    //method to change the bgcolor
    public void changeColor(ActionEvent event){

        Color myColor = myColorPicker.getValue();
        bgcolor = myColor;
    }

    //method to switch to the main game
    public void switchToGame(ActionEvent event){

        //setting the stage
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, bgcolor);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);

        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot, winGameScene, winGameRoot);

        //show stage
        primaryStage.show();


    }

    public void HighScore(){
        //High score screen
    }

    public void AccountCreate(){
        //screen to create account
    }

}
