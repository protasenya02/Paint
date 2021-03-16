package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {

        scene = new Scene(loadFXML("primary"), 1100, 800);      // создание сцены и подключение fxml файла
        primaryStage.setScene(scene);                                  // установка сцены для объекта primaryStage
        primaryStage.setTitle("Paint");                                // установка заголовка
        primaryStage.centerOnScreen();                                 // расположение окна в центре экрана
        primaryStage.show();                                           // показ окна
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}