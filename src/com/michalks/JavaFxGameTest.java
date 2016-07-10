package com.michalks;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by mik on 06.07.16.
 */
public class JavaFxGameTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("Font families");
        Font.getFamilies().stream().forEach(i -> System.out.println(i));
        System.out.println("Font names");
        Font.getFontNames().stream().forEach(i -> System.out.println(i));
        Font f = Font.font("Ubuntu Mono", 30);

        primaryStage.setTitle("JavaFxGameTest");

        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.CADETBLUE);

        Button helloButton = new Button("Hello world");
        helloButton.setFont(f);
        helloButton.setTextFill(Color.CRIMSON);
        helloButton.setLayoutX(50);
        helloButton.setLayoutY(70);
        helloButton.setOnAction(event -> {
            System.out.println("Hello world!");
        });
        helloButton.setOnMouseEntered(event -> {
            System.out.println("Mouse entered");
        });
        root.getChildren().add(helloButton);

        Line blueLine = new Line(50, 50, 300, 50);
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(20);
        blueLine.setStrokeLineCap(StrokeLineCap.ROUND);

        root.getChildren().add(blueLine);



        Text helloText = new Text("Hello world");
        DropShadow ds = new DropShadow();
        ds.setOffsetX(5.0f);
        ds.setOffsetY(5.0f);
        ds.setColor(Color.rgb(50,50,50,.8));
        helloText.setEffect(ds);
        helloText.setFont(f);
        helloText.setFill(Color.CORAL);
        helloText.setLayoutX(50);
        helloText.setLayoutY(250);
        root.getChildren().add(helloText);

        Text text2 = new Text("Hello world");
        Reflection r = new Reflection();
        r.setFraction(0.9f);
        r.setTopOffset(10);
        text2.setEffect(r);
        text2.setFont(f);
        text2.setFill(Color.HONEYDEW);
        text2.setLayoutX(50);
        text2.setLayoutY(290);
        root.getChildren().add(text2);

        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(50);
        slider.setLayoutY(150);
        slider.valueProperty().
                addListener((observable, oldValue, newValue) -> {
                    helloText.setText("Hello times " + newValue);
                });
        root.getChildren().add(slider);
        blueLine.layoutXProperty().bind(slider.valueProperty());

        Rectangle rect = new Rectangle(300, 200, 200, 100);
        rect.setFill(Color.BISQUE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(15);
        LinearGradient lg = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.1f, Color.rgb(0, 200, 255, 0.4)),
                new Stop(0.9f, Color.rgb(0,0,0,0.4)));
        rect.setFill(lg);

        root.getChildren().add(rect);

        TextField textField = new TextField();
        textField.setLayoutX(50);
        textField.setLayoutY(340);

        text2.textProperty().bind(textField.textProperty());
        text2.setSmooth(true);
        root.getChildren().add(textField);


        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(50);
        passwordField.setLayoutY(400);
        root.getChildren().add(passwordField);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
