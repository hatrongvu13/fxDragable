package com.jax.draggable.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    private AnchorPane draggableContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addGrid();
    }

    private void addGrid() {
        double w = draggableContent.getPrefWidth();
        double h = draggableContent.getPrefHeight();
        Canvas grid = new Canvas(w, h);
        grid.setMouseTransparent(true);

        GraphicsContext gc = grid.getGraphicsContext2D();

        gc.setStroke(Color.GRAY);

        double offset = 10;
        for (double i = offset; i < w; i+=offset) {

            if (i%8==0) {
                gc.setLineWidth(0.5);
            } else {
                gc.setLineWidth(0.1);
            }

            gc.strokeLine(i, 0, i, h);
            gc.strokeLine(0, i, w, i);
        }

        draggableContent.getChildren().add(grid);
        grid.toBack();
    }
}
