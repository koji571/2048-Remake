package game.scenes;


import game.controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;


public class EndGame extends Controller {
    private static EndGame singleInstance = null;
    private EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score, int haveEmptyCell) {
        
        long oldHigh = scoreclass.readFile();
        long newHigh = scoreclass.compareScore(score, oldHigh);

        //determining message to display
        if (haveEmptyCell == -1) {
            Text text = new Text("GAME OVER");
            text.relocate(100, 100);
            text.setFont(Font.font(60));
            root.getChildren().add(text);
        } else if (haveEmptyCell == 0) {
            Text text = new Text("Congratulations!\n YOU WIN ");
            text.relocate(100, 100);
            text.setFont(Font.font(40));
            root.getChildren().add(text);
        }

        //displaying score text
        Text scoreText = new Text("Final Score:\n" + score + "");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(100, 500);
        scoreText.setFont(Font.font(50));
        root.getChildren().add(scoreText);

        //displaying highscore text
        Text highText = new Text("High Score:\n" + newHigh + "");
        highText.setFill(Color.BLACK);
        highText.relocate(100, 600);
        highText.setFont(Font.font(50));
        root.getChildren().add(highText);


        //displaying quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100, 30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(100, 800);

        //displaying retry button
        Button retryButton = new Button("RETRY");
        retryButton.setPrefSize(100, 30);
        retryButton.setTextFill(Color.BLACK);
        root.getChildren().add(retryButton);
        retryButton.relocate(700, 800);

        //eventHandler if quit is selected
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    root.getChildren().clear();
                    primaryStage.close();
                }
            }
        });

        //eventHandler if Retry button is clicked
        retryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
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
        });


    }
}
