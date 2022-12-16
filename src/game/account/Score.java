package game.account;

import game.cell.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Objects of this class are used to manipulate score.txt to keep track of the igh score
 *
 * @author LeoHaiKen Tan
 */

public class Score extends Data {

    //default constructor
    public Score() {
    }

    /**
     * This method checks if the score.txt file has been created if not it will create one and initialise it
     */

    //check if the score file exists if not create
    public void checkFile(){

        if (! file.exists()) {
            try {
                FileWriter write = new FileWriter("score.txt");
                write.write("0\n");
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method reads score.txt
     * @return the high score from score.txt
     */

    //method to read score file
    public long readFile(){
        //reading score file

        try {
            File scorefile = new File("score.txt");
            Scanner scanner = new Scanner(scorefile);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                newdata = Long.parseLong(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return newdata;
    }

    /**
     * This method is used to compare two score values
     * @param score the current user's score from the attemopt
     * @param oldscore the previous highscore, stored in score.txt
     * @return the determined higher score
     */

    //method to compare new score with previous highscore
    public long compareScore(long score,long oldscore){
        if (score > oldscore) {
            String newwrite = String.valueOf(score);
            try {
                FileWriter write = new FileWriter("score.txt");
                write.write(newwrite);
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return score;
        }
        return oldscore;
    }

}
