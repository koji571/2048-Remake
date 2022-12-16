package game.controller;

import game.cell.Data;
import game.scenes.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the controller class of Menu.fxml
 * @author LeoHaiKen Tan -modified
 */
public class Controller extends Data implements Initializable {

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
    private CheckBox hardCheckBox;
    @FXML
    private CheckBox easyCheckBox;

    //setting default bgcolour
    public Color bgcolor = Color.rgb(189, 177, 92);

    /**
     * Method to change the color of the background with the one selected from the colorpicker
     */
    //method to change the bgcolor
    public void changeColor() {

        Color myColor = myColorPicker.getValue();
        bgcolor = myColor;
    }

    /**
     * Method to allow the user to select a grid size of 3 and multiply their score by 2
     */
    //allow user to change the grid size to 3
    public void enableHard() {
        Integer hardGrid = 3;
        if (hardCheckBox.isSelected()){
            myComboBox.getItems().add(hardGrid);
        }else{
            myComboBox.getItems().removeAll(hardGrid);
            setN(4);
        }

    }

    /**
     * Method to allow the user to select a grid size of 5 or 6 and multiply their score by 0.5
     */
    //allow user to change the grid size to 5,6
    public void setEasy() {
        Integer[] easyGrid = {5,6};
        if (easyCheckBox.isSelected()){
            myComboBox.getItems().addAll(easyGrid);
        }else{
            myComboBox.getItems().removeAll(easyGrid);
            setN(4);
        }
    }

    /**
     * Method to change the grid size based on what the user selected in the combo box
     */
    //change the grid size
    public void changeGrid() {
        setN(myComboBox.getValue());
    }

    /**
     * method to display the HowTo.fxml file
     * @throws IOException if stream to file cannot be written to or closed.
     */
    //show the How To Play Stage
    public void toggleHow() throws IOException {

        FXMLLoader howtoload = new FXMLLoader((getClass().getResource("/HowTo.fxml")));
        Parent root = howtoload.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("How To Play!");
        stage.setX(150);
        stage.setY(400);
        stage.show();

    }

    /**
     * Called to initialize controller after its root element has been completely processed.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //display sizes available
        myComboBox.getItems().add(4);
    }

    /**
     * This method is called when the user clicks the start button and is used to initialise the game
     * @param event the ActionEvent Object to process
     */
    //method to switch to the main game
    public void switchToGame(ActionEvent event) {

        //setting the stage
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, bgcolor);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);

        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        //show stage
        primaryStage.show();


    }


}
