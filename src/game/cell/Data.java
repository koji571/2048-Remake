package game.cell;

import game.account.Score;
import javafx.scene.Group;

import java.io.File;

public class Data {
    //default number of cells horizontally, vertically
    protected static int n = 4;

    //creating an object of class cell to store cell data
    protected Cell[][] cells = new Cell[n][n];
    //initialise an object of class score to track highscore
    public static Score scoreclass = new Score();

    //object to point towards a score.txt file
    protected File file = new File("score.txt");

    //setter method for n
    protected static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    //dimension of all the cells
    protected static int HEIGHT = 700;
    //distance between cells
    protected final static int distanceBetweenCells = 10;

    //LENGTH variable calculator
    protected static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;

    //getter method for LENGTH
    protected static double getLENGTH() {
        return LENGTH;
    }

    //set base score
    protected long score = 0;

    //new high score if any
    protected long newdata = 0;

    //creating a Group
    protected Group root;

    //setting default boolean for move
    protected boolean move = false;

}
