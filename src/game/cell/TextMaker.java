package game.cell;

import game.scenes.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is used to write and change the visible text on the GUI
 */

public class TextMaker {
    //giving no value to single Instance
    private static TextMaker singleInstance = null;

    //default constructor
    private TextMaker() {

    }

    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * This method is used to display text on the GUI
     * @param input the input string to be displayed
     * @param xCell the x coordinated of the visible cell
     * @param yCell the y coordinated of the visible cell
     * @param root the group the cell belongs in, in the scene
     * @return return the text to be displayed
     */
    //placing white text in cell in scene
    public Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

    /**
     * This method is used to swap texts from two locations
     * @param first the text to be replaced by the second
     * @param second the text to be replaced by the first
     */
    //swap text/two numbers
    static void changeTwoText(Text first, Text second) {
        //swapping the string in the first text with second
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        //changing the coordinates of second text with first text
        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
