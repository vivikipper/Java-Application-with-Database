package com.example.javaa1test2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 518, 420);
        stage.getIcons().add(new Image("shot_glass.jpg"));
        stage.setTitle("Keeping healthy");
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
//<a href="https://br.freepik.com/vetores-gratis/shot-glass_35202660.htm#query=copo%20de%20agua&position=49&from_view=keyword&track=ais">Imagem de juicy_fish</a> no Freepik