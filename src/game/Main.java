package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

/*
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    //default constructor
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));


    //private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    */

    //setup for scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        

        //Group menuRoot = new Group();
        //Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        //Group accountRoot = new Group();
        //Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        //Group getAccountRoot = new Group();
        //Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));

        //end game display

        //Group endgameRoot = new Group();
        //Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

        //Group rankRoot = new Group();
        //Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));

        //BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        //Background background = new Background(background_fill);

        //unknown
        /*
        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);
        */

        //unknown
        /*
        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);
        */
        try {

            primaryStage.setTitle("2048");

            Image image = new Image("logo.png");
            primaryStage.getIcons().add(image);

            Parent root = FXMLLoader.load(getClass().getResource("/game/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

/*
        //background for main game stage
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);

        //GameScene game = new GameScene();
        //game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        //show stage
        primaryStage.show();
*/
    }

    //launch constructor
    public static void main(String[] args) {
        launch(args);
    }
}
