package game.cell;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This class is used to store value for each individual cell
 */

public class Cell {
    private Rectangle rectangle;
    private Group root;

    //creating an object of the class
    private Text textClass;

    //boolean modify
    private boolean modify = false;
    public void setModify(boolean modify) {
        this.modify = modify;
    }
    public boolean getModify() {
        return modify;
    }

    //default constructor of cell
    public Cell(double x, double y, double scale, Group root) {
        //assigning class type rectangle
        rectangle = new Rectangle();
        //setting position
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);

        //set group
        this.root = root;
        //set colour
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        //creating text
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        //adding the rectangle to the group
        root.getChildren().add(rectangle);
    }

    //setter method to assign text
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * This method is used to overwrite a cell from the contents of another cell
     * @param cell the cell that will be overwriten
     */

    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        //setting the cell by number in cell
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * This method is used to add the contents of two cells together
     * @param cell the cell whose contents will be added to
     */

    //function to add number to two cells together
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }


    /**
     * This method will set the color of the cell based on the value it holds
     * @param number the value of the cell to be colored
     */
    //set colour of cells
    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
                break;
            case 2:
                rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
                break;
            case 4:
                rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
                break;
            case 8:
                rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
                break;
            case 16:
                rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
                break;
            case 32:
                rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
                break;
            case 64:
                rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
                break;
            case 128:
                rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
                break;
            case 256:
                rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
                break;
            case 512:
                rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(250,0,0,1));


        }

    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
