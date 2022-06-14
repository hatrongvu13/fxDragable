package com.jax.draggable;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createScene()));
        stage.show();
    }

    private Parent createScene() {

        Circle circle = new Circle(25, 25, 25, Color.GOLDENROD);
        Rectangle rectangle = new Rectangle(150, 30, Color.RED);
        Label label = new Label("Hello Draggable");
        label.setFont(Font.font(42));

        setTranslate(circle, 50, 50);
        setTranslate(rectangle, 150, 50);
        setTranslate(label, 250, 100);

        var root = new Pane(circle, rectangle, label);
        root.setPrefSize(800, 600);
        root.getChildren().forEach(this::makeDraggable);
        return root;
    }

    private void setTranslate(Node node, double x, double y) {
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    private double startX;
    private double startY;
    private void makeDraggable(Node node) {
        node.setOnMousePressed(evt ->{
            startX = evt.getSceneX() - node.getTranslateX();
            startY = evt.getSceneY() - node.getTranslateY();
        });

        node.setOnMouseDragged(evt -> {
            node.setTranslateX(evt.getSceneX() - startX);
            node.setTranslateY(evt.getSceneY() - startY);
        });
    }
}
