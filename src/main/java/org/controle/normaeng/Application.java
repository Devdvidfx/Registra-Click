package org.controle.normaeng;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 430);
        // stage.getIcons().add(new Image());
        stage.setTitle("Sua Empresa Aqui");
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[]args){
        launch();
    }
}