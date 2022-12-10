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
yet to be created

## List of Features implemented and working

1. Implemented a start/menu screen suing FXML where the user can select the background colour of the game.

## List of Features implemented and not working

## List of features that were not implemented
1. Win criteria, where the user achieves 2048 and wins the game.
2. Ability to undo a move.
3. Setting the grid number.
4. Account creation + High Score tracker.
5. Option to retry the game.

## List of new Java classes
1. SceneController  
This class is used as a controller class for the implemented Menu.fxml 

## List of modified Java classes

1. Main  
 This class was edited so that the program will boot the Menu.fxml file to start the game instead of running straight into the game.  


2. GameScene  
i. Modified the game function to include a condition when a valid key is pressed, i.e.(Arrow UP,DOWN,LEFT,RIGHT).   
ii. Added boolean variable to check if the direction to be moved is valid and will spawn a random object.  
iii. Added boolean variable to prevent more than two cells to combine.