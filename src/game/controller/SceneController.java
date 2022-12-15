package game.controller;

import game.cell.Data;
import game.scenes.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneController extends Data implements Initializable {

    protected static final int WIDTH = 900;
    protected static final int HEIGHT = 900;

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
    public Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
    public Group winGameRoot = new Group();
    public Scene winGameScene = new Scene(winGameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
    @FXML
    private ColorPicker myColorPicker;
    @FXML
    private ComboBox<Integer> myComboBox;
    @FXML
    public CheckBox hardCheckBox;
    @FXML
    public CheckBox easyCheckBox;

    //setting default bgcolour
    public Color bgcolor = Color.rgb(189, 177, 92);

    //method to change the bgcolor
    public void changeColor(ActionEvent event) {

        Color myColor = myColorPicker.getValue();
        bgcolor = myColor;
    }

    //allow user to change the grid size to 3
    public void enableHard(ActionEvent event) {
        Integer hardGrid = 3;
        if (hardCheckBox.isSelected()){
            myComboBox.getItems().add(hardGrid);
        }else{
            myComboBox.getItems().removeAll(hardGrid);
        }

    }
    //allow user to change the grid size to 5,6
    public void setEasy(ActionEvent event) {
        Integer[] easyGrid = {5,6};
        if (easyCheckBox.isSelected()){
            myComboBox.getItems().addAll(easyGrid);
        }else{
            myComboBox.getItems().removeAll(easyGrid);
        }
    }

    //change the grid size
    public void changeGrid(ActionEvent event) {
        setN(myComboBox.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //display sizes available
        myComboBox.getItems().add(4);
        //disable the grid size selector on default
    }

    //method to switch to the main game
    public void switchToGame(ActionEvent event) {

        if(! easyCheckBox.isSelected() && hardCheckBox.isSelected()){
            setN(4);
        }


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

    public void HighScore() {
        //High score screen
    }

    public void AccountCreate() {
        //screen to create account
    }


}
