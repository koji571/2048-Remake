<img height="150" src="src/logo.png" width="150"/>  

image source: https://logodix.com/2048

# COMP2042_CW_hcylt1

Author: Leo Tan Hai Ken  
Student ID: 20412776

## How To Compile the Code
1. Clone the GitHub repository.
2. Ensure that the JavaJDK has been installed, download can be found at https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
   (Download the version following your system hardware and software)
3. Add the javafx library to your project, download can be found at https://gluonhq.com/products/javafx/
   (Download the version following your system hardware and software)
4. Compile and run the game!

## Javadoc Documentation
/COMP2042TanLeoHaiKen/javadoc

## List of Features implemented and working

1. Implemented a start/menu screen using FXML .
2. Allowed user to select grid colour and enable hard mode to change grid size.
3. High Score Tracker.
4. Implemented a How To Play window using FXML.

## List of Features implemented and not working
1. Allowed user to retry the game at the end but displays old EndScene GUI.

## List of features that were not implemented
1. Ability to undo a move.
- I was not sure how I could implement a retry button in an instance of GameScene without not being able to scan for arrow keys, and aslo how to store the values of the cells of the prior move.
2. Account creation.
- I did not have enough time to figure how to store account name with their unique high score.

## List of new Java classes
1. Data  
   This class is used to store all the variables needed to be used by multiple classes.
2. Logic  
   This class is used to store all the game movement logic.
3. Score  
   This class is used to keeep track of user's current high score.

## List of modified Java classes

1. Main  
   This class was edited so that the program will boot the Menu.fxml file to start the game instead of running straight into the game.

2. GameScene   
   i. Original game Logic and Data was moved to seperate classes to improve encapsulation  
   Modification to the original game functions are:-  
   i. Modified the game function to include a condition when a valid key is pressed, i.e.(Arrow UP,DOWN,LEFT,RIGHT).   
   ii. Added boolean variable to check if the direction to be moved is valid and will spawn a random object.  
   iii. Added boolean variable to prevent more than two cells to combine in a single move.   
   iv. Score now adds up within moveHorizontally and moveVertically.  
   v. Modified hasEmptyCell method to search for a 2048 tile then 0 tile.

3. EndGame  
   i. Allowed the stage to close when user wants to quit the program.  
   ii. Added a retry button to enable user to retry the game reaches this scene.  
   iii. Added condition if player wins the game a congratulatory messages appears.
   iv. Added text to tell user their final score and high Score.

4. Controller  
i. Added functionality to this class to be used as a controller class for Menu.fxml

5. Main  
i. Added icon and text to the main stage.  
ii. The application will launch a .fxml file on start.  
ii. Check for a score.txt
