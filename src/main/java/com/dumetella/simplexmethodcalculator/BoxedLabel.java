package com.dumetella.simplexmethodcalculator;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BoxedLabel {
    public HBox BoxedLabel;

    public BoxedLabel(int width, int height, String text) {
        this.BoxedLabel = new HBox();
        Label insert = new Label(text);
        insert.setMaxSize(width, height);
        insert.setMinSize(width, height);
        insert.setAlignment(Pos.CENTER);
        this.BoxedLabel.getChildren().add(insert);
    }
}
