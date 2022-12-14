package game.cell;

import javafx.scene.Group;

public class Data {
    //number of cells horizontally, vertically
    protected static int n = 4;

    //cell data for score values
    protected Cell[][] cells = new Cell[n][n];

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

    //creating a Group
    protected Group root;

    //setting default boolean for move
    protected boolean move = false;

}
