package com.dumetella.simplexmethodcalculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 600);
        stage.setTitle("SMCalculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        Controller ctrl = (fxmlLoader.getController());
        ctrl.init();
    }

    public static void main(String[] args) {
        launch();
    }
}