package game.scenes;

import game.cell.Cell;
import game.cell.Logic;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 public class GameScene extends Logic {

    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot, Scene winGameScene, Group winGameRoot) {
        this.root = root;

        //assigning values to the cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        //setting up score text
        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);

        //setting up display for score
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        //fill two random numbers
        randomFillNumber(1);
        randomFillNumber(1);

        //scanning for button presses
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    boolean val = false;
                    if (key.getCode() == KeyCode.DOWN) {
                        GameScene.this.moveDown();
                        val = true;
                    } else if (key.getCode() == KeyCode.UP) {
                        GameScene.this.moveUp();
                        val = true;
                    } else if (key.getCode() == KeyCode.LEFT) {
                        GameScene.this.moveLeft();
                        val = true;
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        GameScene.this.moveRight();
                        val = true;
                    }

                    //running the haveEmptyCell method
                    int haveEmptyCell = GameScene.this.haveEmptyCell();

                    //end game condition
                    if (haveEmptyCell == -1 && canNotMove() || haveEmptyCell == 0 ) {//if neither 0 nor 2048 on board and cannot move, game ends

                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, haveEmptyCell);
                            root.getChildren().clear();

                    } else if((haveEmptyCell == 1 && val && move )) { //spawning new cell on the board if 0 and button pressed
                        GameScene.this.randomFillNumber(2);
                        scoreText.setText(score + "");
                    }
                    move = false;
                });
            });
    }
}
