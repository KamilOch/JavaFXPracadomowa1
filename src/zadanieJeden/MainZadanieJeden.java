package zadanieJeden;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainZadanieJeden extends Application {

    private static final RunLengthEncoder runLengthEncoder = new RunLengthEncoder();


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


            enterButton.setOnAction(event -> {
                if (codingRadioButton.isSelected()) {
                    outputData.clear();
                    outputData.appendText(runLengthEncoder.encoder(inputData.getText()));
                }
                else if (decodingRadioButton.isSelected()) {
                    outputData.clear();
                    outputData.appendText(runLengthEncoder.decode(inputData.getText()));
                } else {
                    outputData.clear();
                    outputData.appendText("Błąd!  Wybierz operacje kodowanie lub dekodowanie!");
                }
            });

            copyButton.setOnAction(event -> {
                if(outputData.getText().length()>0)
                inputData.clear();
                inputData.appendText(outputData.getText());
                outputData.clear();
            });


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
