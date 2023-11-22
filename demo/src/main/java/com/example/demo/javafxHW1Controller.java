package com.example.demo;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class javafxHW1Controller {
    @FXML
    private TextField inputField;

    @FXML
    private void buttonClicked() {
        // Get the text from the input field and convert to string
        String input = inputField.getText();
    
        // Show a dialog with the greeting message
        showGreetingDialog(input);
    }

    private void showGreetingDialog(String input) {
        int distanceMove = Integer.parseInt(input);
        Circle circle = new Circle(50, Color.RED);
        circle.setTranslateX(100);
        circle.setTranslateY(50);
        // NEW: Shading effect by layering a shadow, radius effects how much the shadow blends
        circle.setEffect(new DropShadow(20, 10, 15, Color.web("#050505")));
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), circle);
        translateTransition.setByX(distanceMove);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);

        
        Rectangle rectangle = new Rectangle(100, 50, Color.BLACK);
        rectangle.setTranslateX(50);
        rectangle.setTranslateY(150);
        TranslateTransition diagonalMoveTransition = new TranslateTransition(Duration.seconds(3), rectangle);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), rectangle);
        diagonalMoveTransition.setByX(200);
        diagonalMoveTransition.setByY(200);
        diagonalMoveTransition.setCycleCount(TranslateTransition.INDEFINITE);
        diagonalMoveTransition.setAutoReverse(true);
        // You can make the rectangle spin x amount of times by multiples of 360, and negative rotates counterclockwise
        rotateTransition.setByAngle(-1080);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);

        // Couldn't find an individual class for square, so if it does exist, I am not using it for this HW
        Rectangle square = new Rectangle(75, 75, Color.BLUE);
        square.setTranslateX(50);
        square.setTranslateY(400);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), square);
        // Scaling transitions by x and y scale differently when they are different numbers, turning the
        // Square into a rectangle
        scaleTransition.setToX(2);
        scaleTransition.setToY(4);
        scaleTransition.setCycleCount(RotateTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, rectangle, square);

        // Create a Scene and add the Pane to it
        Scene scene = new Scene(pane, 750, 600);

        // Set the stage title and scene, then show the stage
        Stage stage = new Stage();
        stage.setTitle("Multiple Animations");
        stage.setScene(scene);
        stage.show();

        translateTransition.play();
        diagonalMoveTransition.play();
        rotateTransition.play();
        scaleTransition.play();

    }
}