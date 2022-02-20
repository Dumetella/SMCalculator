package com.dumetella.simplexmethodcalculator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    @FXML
    private ChoiceBox<String> nConstraints;

    @FXML
    private ChoiceBox<String> mConstraints;

    @FXML
    private GridPane mainGrid;

    @FXML
    private GridPane subGrid;

    @FXML
    private GridPane xGrid;

    @FXML
    private Button solveButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button toDuoButton;

    private int gridN;

    private int gridM;

    private Constraints SpecialConstraints;

    public Controller() {
        this.gridN = 4;
        this.gridM = 4;
        this.SpecialConstraints = new Constraints();
    }

    @FXML
    private void resizeGrid() {

        int n = Integer.parseInt(nConstraints.getValue()) - 1;
        int m = Integer.parseInt(mConstraints.getValue()) - 1;

        if (this.gridN > n) {
            for (int i = this.gridN; i > n; i--) {
                deleteRow(this.mainGrid, i);
                deleteRow(this.subGrid, i);
                this.gridN--;
            }
        } else if (this.gridM > m) {
            for (int j = this.gridM; j > m; j--) {
                deleteColumn(this.mainGrid, j);
                deleteColumn(this.xGrid, j);
                this.gridM--;
            }
        } else if (this.gridN < n) {
            for (int i = this.gridN; i < n; i++) {
                this.addRowToMainGrid(this.mainGrid, SpecialConstraints.row20);
                this.addRowToSubGrid(this.subGrid, SpecialConstraints.row20);
                this.gridN++;
            }
        } else if (this.gridM < m) {
            for (int j = this.gridM; j < m; j++) {
                this.addColumnToMainGrid(this.mainGrid, SpecialConstraints.column20);
                this.addColumnToXgrid(this.xGrid, SpecialConstraints.column20);
                this.gridM++;
            }
        }

        return;
    }

    private Node getNode(Integer row, Integer column, GridPane gridPane) {
        if (row == 0) {
            row = null;
        }
        if (column == 0) {
            column = null;
        }
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return node;
            }
        }
        return null;
    }

    private void deleteRow(GridPane grid, final int row) {
        Set<Node> deleteNodes = new HashSet<>();
        for (Node child : grid.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(child);

            int r = rowIndex == null ? 0 : rowIndex;

            if (r > row) {
                GridPane.setRowIndex(child, r - 1);
            } else if (r == row) {
                deleteNodes.add(child);
            }
        }
        grid.getChildren().removeAll(deleteNodes);
        grid.getRowConstraints().remove(row);
    }

    private void deleteColumn(GridPane grid, final int col) {
        Set<Node> deleteNodes = new HashSet<>();
        for (Node child : grid.getChildren()) {
            Integer columnIndex = GridPane.getColumnIndex(child);

            int r = columnIndex == null ? 0 : columnIndex;

            if (r > col) {
                GridPane.setColumnIndex(child, r - 1);
            } else if (r == col) {
                deleteNodes.add(child);
            }
        }
        grid.getChildren().removeAll(deleteNodes);
        grid.getColumnConstraints().remove(col);
    }

    private void addRowToMainGrid(GridPane grid, RowConstraints constraints) {
        grid.getRowConstraints().add(constraints);
        for (int i = 0; i <= this.gridM; i++) {
            grid.addColumn(i, new BoxedTextField(45, 30).BoxedTextField);
        }
    }

    private void addColumnToMainGrid(GridPane grid, ColumnConstraints constraints) {
        grid.getColumnConstraints().add(constraints);
        for (int i = 0; i <= this.gridN; i++) {
            grid.addRow(i, new BoxedTextField(45,30).BoxedTextField);
        }
    }

    private void addColumnToXgrid(GridPane grid, ColumnConstraints constraints) {
        grid.getColumnConstraints().add(constraints);
        String text = "X" + (this.gridM + 2);
        grid.addRow(0, new BoxedLabel(45, 30, text).BoxedLabel);
        grid.addRow(1, new BoxedTextField(45, 30).BoxedTextField);
    }

    private void addRowToSubGrid(GridPane grid, RowConstraints constraints) {
        grid.getRowConstraints().add(constraints);
        grid.addColumn(0, new BoxedMultiChoice(50, 30).BoxedMultiChoice);
        grid.addColumn(1, new BoxedTextField(80, 30).BoxedTextField);
    }

    public void init() {

    }
}