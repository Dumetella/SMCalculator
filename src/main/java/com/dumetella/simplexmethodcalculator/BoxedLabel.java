package com.dumetella.simplexmethodcalculator;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BoxedLabel {
    public HBox BoxedLabel;
    private Label insert;

    public BoxedLabel(int width, int height, String text) {
        this.BoxedLabel = new HBox();
        this.insert = new Label(text);
        this.insert.setMaxSize(width, height);
        this.insert.setMinSize(width, height);
        this.insert.setAlignment(Pos.CENTER);
        this.BoxedLabel.getChildren().add(this.insert);
    }
}
