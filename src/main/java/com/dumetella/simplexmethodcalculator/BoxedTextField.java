package com.dumetella.simplexmethodcalculator;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BoxedTextField {
    public HBox BoxedTextField;

    public BoxedTextField(int width, int height) {
        this.BoxedTextField = new HBox();
        TextField insert = new TextField();
        insert.setMaxSize(width, height);
        insert.setMinSize(width, height);
        this.BoxedTextField.getChildren().add(insert);
    }
}
