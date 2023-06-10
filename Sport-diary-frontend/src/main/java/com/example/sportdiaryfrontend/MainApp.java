package com.example.sportdiaryfrontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("demo-slided-login.fxml"));
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        Scene scene = new Scene(fxmlLoader.load(), bounds.getWidth()*0.50, bounds.getHeight()*0.40);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}