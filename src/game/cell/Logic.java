package game.cell;

import javafx.scene.text.Text;
import java.util.Random;

/**
 * This class is used to store the methods of the game logic
 * @author LeoHaiKen Tan
 */

public abstract class Logic extends Data {

    //creating object for class TextMaker
    private TextMaker textMaker = TextMaker.getSingleInstance();

    /**
     * This method is used to spawn random numbers on the game board
     */
    //function to fill in random 2,4 into open cells
    protected void randomFillNumber() {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;

        //traverse the cells to locate 0
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }

        //create text
        Text text;
        //create RNG
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0) //gets random number and if its even then changes putTwo to False
            putTwo = false;

        //selecting a random cell with 0
        int xCell, yCell;
        xCell = random.nextInt(aForBound+1);
        yCell = random.nextInt(bForBound+1);
        //inputting 2 as new number
        if (putTwo)
        {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        }
        else // putting 4 as new number
        {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    /**
     * This method is called when the user intends to move the cells left
     */
    //moving the cells left
    protected void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    /**
     * This method is called when the user intends to move the cells right
     */
    //moving the cells right
    protected void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    /**
     * This method is called when the user intends to move the cells up
     */
    //moving the cells up
    protected void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    /**
     * This method is called when the user intends to move the cells down
     */
    //moving the cells down
    protected void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This method determines if the cell horizontally can be added to one another
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @param des the index on the x axis of the adjacent cell in the direction of the current cell passed
     * @param sign -1 for left, 1 for right
     * @return a boolean value, true if it can be moved, false for the later
     */

    //determining if the cell can be moved horizontally can be added
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to calculate the new values of the cells on the board when moved horizontally
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @param des the index on the y axis of the adjacent cell in the direction of the current cell passed
     * @param sign -1 for left, 1 for right
     */
    //changing cell data horizontally when moving
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)){ //if true adding
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des + sign].setModify(true);
            move = true;
            if(n == 4){
                score += cells[i][des+sign].getNumber();
            } else if (n == 3) {
                score += 2L * (cells[i][des+sign].getNumber());
            } else if (n == 5 || n == 6) {
                score += 0.5 * (cells[i][des+sign].getNumber());
            }
        } else if (des != j) {//just moving
            cells[i][j].changeCell(cells[i][des]);
            if(cells[i][des].getNumber() != 0)
            {
                move = true;
            }
        }

    }

    /**
     *This method determines if the cell vertically can be added to one another
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @param des the index on the x axis of the adjacent cell in the direction of the current cell passed
     * @param sign -1 for down, 1 for up
     * @return
     */
    //determining if the cell can be moved vertically can be added
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    /**
     * This method is used to calculate the new values of the cells on the board when moved vertically
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @param des the index on the x axis of the adjacent cell in the direction of the current cell passed
     * @param sign -1 for down, 1 for up
     */
    //changing the cell data vertically when moving
    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des + sign][j].setModify(true);
            move = true;
            if(n == 4){
                score += cells[des+sign][j].getNumber();
            } else if (n == 3) {
                score += 2L * (cells[des+sign][j].getNumber());
            } else if (n == 5 || n == 6) {
                score += 0.5 * (cells[des+sign][j].getNumber());
            }
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
            if(cells[des][j].getNumber() != 0){
                move = true;
            }
        }
    }

    /**
     * Method to check if adjacent cells have identical values
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @return return true if there are identical values and false if not
     */
    //compares value of cells below and to the right and checks if equal
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            //check if right cell equal
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            //check if bottom cell equal
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     *
     * @param i the x-axis index of the current cell passed
     * @param j the y-axis index of the current cell passed
     * @param direct the direction the user intends to move
     * @return index of one of the axis of the cell adjacent to the cell passed
     */
    //switch cases to determine which way the cells will move
    private int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * Method to check if cells on the board cannot be moved in any direction
     * @return return true if cells cannot be moved, false if can
     */
    //check if cells below and right are equal if yes, then return false
    protected boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to check for 2048 or available spots on the board
     * @return returns 0 if 2048 is present, returns 1 if there is an empty cell and return -1 if all the tiles are filed
     */
    //traverse the cells to search for 2048 then 0
    protected int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;

            }
        }
        return -1;
    }

}
