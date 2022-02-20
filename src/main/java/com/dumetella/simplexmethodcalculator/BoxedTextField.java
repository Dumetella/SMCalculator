package com.dumetella.simplexmethodcalculator;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BoxedTextField {
    public HBox BoxedTextField;
    private TextField insert;

    public BoxedTextField(int width, int height) {
        this.BoxedTextField = new HBox();
        this.insert = new TextField();
        this.insert.setMaxSize(width, height);
        this.insert.setMinSize(width, height);
        this.BoxedTextField.getChildren().add(this.insert);
    }
}
