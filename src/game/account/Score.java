package game.account;

import game.cell.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score extends Data {

    //default constructor
    public Score() {
    }

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

    //method to read score file
    public void readFile(){
        //reading score file

        try {
            File scorefile = new File("score.txt");
            Scanner scanner = new Scanner(scorefile);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                newdata = Long.parseLong(data);
                System.out.println(newdata);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    //method to compare new score with previous highscore
    public long compareScore(long score,long newdata){
        if (score > newdata) {
            newdata = score;
            String newwrite = String.valueOf(newdata);
            try {
                FileWriter write = new FileWriter("score.txt");
                write.write(newwrite);
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return newdata;
        }
        return score;
    }

}
