package com.dumetella.simplexmethodcalculator;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

public class BoxedMultiChoice {
    public HBox BoxedMultiChoice;

    public BoxedMultiChoice(int width, int height) {
        this.BoxedMultiChoice = new HBox();
        ChoiceBox<String> insert = new ChoiceBox();
        insert.getItems().addAll(">=", "=", "<=");
        insert.setValue(">=");
        insert.setMaxSize(width, height);
        insert.setMinSize(width, height);
        this.BoxedMultiChoice.getChildren().add(insert);
    }
}
