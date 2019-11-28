package zadanieJeden;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainZadanieJeden extends Application {

    private static final RunLengthEncoder runLengthEncoder = new RunLengthEncoder();


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 600, 300);

            //TODO file with CSS style
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.initStyle(StageStyle.TRANSPARENT);


            Label sourceLabel = new Label("Źródło:");
            sourceLabel.setLayoutX(0);
            sourceLabel.setLayoutY(50);

            TextField inputData = new TextField();
            inputData.setPrefColumnCount(20);
            inputData.setLayoutX(0);
            inputData.setLayoutY(80);

            Label resultLabel = new Label("Wynik operacji:");
            resultLabel.setLayoutX(0);
            resultLabel.setLayoutY(140);

            Button copyButton = new Button("Kopiuj");
            copyButton.setLayoutX(235);
            copyButton.setLayoutY(125);
            copyButton.getStyleClass().add("my-button");

            TextField outputData = new TextField();
            outputData.setPrefColumnCount(20);
            outputData.setLayoutX(0);
            outputData.setLayoutY(170);

            Button enterButton = new Button("Wykonaj");
            enterButton.setLayoutX(0);
            enterButton.setLayoutY(220);
            enterButton.getStyleClass().add("my-button");

            Group centerGroup = new Group();
            centerGroup.getChildren().addAll(sourceLabel, inputData, resultLabel, copyButton, outputData, enterButton);
            root.setCenter(centerGroup);

            Label operationLabel = new Label("Operacja:");
            RadioButton codingRadioButton = new RadioButton("kodowanie");
            RadioButton decodingRadioButton = new RadioButton("dekodowanie");
            ToggleGroup toggleGroup = new ToggleGroup();
            codingRadioButton.setToggleGroup(toggleGroup);
            decodingRadioButton.setToggleGroup(toggleGroup);

            VBox rightVBox = new VBox(5);
            rightVBox.setPadding(new Insets(55));
            rightVBox.getChildren().addAll(operationLabel, codingRadioButton, decodingRadioButton);
            root.setRight(rightVBox);


            enterButton.setOnAction(event -> {
                if (codingRadioButton.isSelected()) {
                    outputData.clear();
                    outputData.appendText(runLengthEncoder.encoder(inputData.getText()));
                } else if (decodingRadioButton.isSelected()) {
                    outputData.clear();
                    outputData.appendText(runLengthEncoder.decode(inputData.getText()));
                } else {
                    outputData.clear();
                    outputData.appendText("Błąd!  Wybierz operacje kodowanie lub dekodowanie!");
                }
            });

            copyButton.setOnAction(event -> {
                if (outputData.getText().length() > 0)
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
