package com.dumetella.simplexmethodcalculator;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

public class BoxedMultiChoice {
    public HBox BoxedMultiChoice;
    private ChoiceBox insert;

    public BoxedMultiChoice(int width, int height) {
        this.BoxedMultiChoice = new HBox();
        this.insert = new ChoiceBox();
        this.insert.getItems().addAll(">=", "=", "<=");
        this.insert.setValue(">=");
        this.insert.setMaxSize(width, height);
        this.insert.setMinSize(width, height);
        this.BoxedMultiChoice.getChildren().add(this.insert);
    }
}
