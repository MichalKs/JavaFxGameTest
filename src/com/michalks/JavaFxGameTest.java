package com.michalks;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by mik on 06.07.16.
 */
public class JavaFxGameTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFxGameTest");

        Group root = new Group();
        Scene scene = new Scene(root, 500, 320, Color.CADETBLUE);

        Button helloButton = new Button("Hello world");
        helloButton.setLayoutX(100);
        helloButton.setLayoutY(100);
        helloButton.setOnAction(event -> {
            System.out.println("Hello world!");
        });
        root.getChildren().add(helloButton);

        Line blueLine = new Line(50, 50, 300, 50);
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(20);
        blueLine.setStrokeLineCap(StrokeLineCap.ROUND);

        root.getChildren().add(blueLine);

        Text helloText = new Text("Hello world");
        helloText.setLayoutX(50);
        helloText.setLayoutY(250);
        root.getChildren().add(helloText);

        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(50);
        slider.setLayoutY(150);
        slider.valueProperty().
                addListener((observable, oldValue, newValue) -> {
                    helloText.setText("Hello times " + newValue);
                });
        root.getChildren().add(slider);
        blueLine.layoutXProperty().bind(slider.valueProperty());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
