package com.dumetella.simplexmethodcalculator;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Constraints {
    public final ColumnConstraints column20;
    public final RowConstraints row20;

    public Constraints() {
        this.column20 = new ColumnConstraints();
        this.column20.setPercentWidth(20);
        this.column20.setHgrow(Priority.NEVER);

        this.row20 = new RowConstraints();
        this.row20.setPercentHeight(20);
        this.row20.setVgrow(Priority.NEVER);
    }
}
