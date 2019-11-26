package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


//TODO homework one (java 1.8)

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1000, 600);
            //TODO file with CSS style
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


            Label sourceLabel = new Label("Źródło:");
            TextField inputData = new TextField();
            Button copyButton = new Button("KOPIUJ");
            TextField outputData = new TextField();
            Button enterButton = new Button("WYKONAJ");

            VBox centerVbox = new VBox(20);
            centerVbox.getChildren().addAll(sourceLabel, inputData, copyButton, outputData, enterButton);
            root.setCenter(centerVbox);

            Label operationLabel = new Label("Operacja:");
            RadioButton codingRadioButton = new RadioButton("kodowanie");
            RadioButton decodingRadioButton = new RadioButton("dekodowanie");
            ToggleGroup toggleGroup = new ToggleGroup();
            codingRadioButton.setToggleGroup(toggleGroup);
            decodingRadioButton.setToggleGroup(toggleGroup);

            VBox rightVBox = new VBox(5);
            rightVBox.getChildren().addAll(operationLabel, codingRadioButton, decodingRadioButton);
            root.setRight(rightVBox);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

