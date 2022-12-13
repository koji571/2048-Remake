package game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
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


public class WinGame extends SceneController {
    private static WinGame singleInstance = null;
    private WinGame(){

    }
    public static WinGame getInstance(){
        if(singleInstance == null)
            singleInstance= new WinGame();
        return singleInstance;
    }

    public void winGameShow(Scene winGameScene, Group root, Stage primaryStage,long score){
        Text text = new Text("GAME OVER");
        text.relocate(250,250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);


        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,600);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(100,800);

        Button retryButton = new Button("RETRY");
        retryButton.setPrefSize(100,30);
        retryButton.setTextFill(Color.BLACK);
        root.getChildren().add(retryButton);
        retryButton.relocate(700,800);


        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    primaryStage.close();
                }
            }
        });

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
