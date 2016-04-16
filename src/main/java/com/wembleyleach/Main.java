package com.wembleyleach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene mainScene = new Scene(root);
        mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setTitle("");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.initStyle(StageStyle.UNIFIED);

        primaryStage.toFront();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
