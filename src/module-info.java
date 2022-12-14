module game {
    requires javafx.controls;
    requires javafx.fxml;

    opens game to javafx.fxml;
    exports game;
    exports game.scenes;
    opens game.scenes to javafx.fxml;
    exports game.controller;
    opens game.controller to javafx.fxml;
    exports game.cell;
    opens game.cell to javafx.fxml;
    exports game.account;
    opens game.account to javafx.fxml;
}