package com.dumetella.simplexmethodcalculator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

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

    private int gridN;

    private int gridM;

    private final Constraints SpecialConstraints;

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
                this.addColumnToXGrid(this.xGrid, SpecialConstraints.column20);
                this.gridM++;
            }
        }
        return;
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
            grid.addRow(i, new BoxedTextField(45, 30).BoxedTextField);
        }
    }

    private void addColumnToXGrid(GridPane grid, ColumnConstraints constraints) {
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

    @FXML
    private void Clear() {
        this.clearMainGrid();
        this.clearXGrid();
        this.clearSubGrid();
    }

    private void ClearTextField(Integer row, Integer column, GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node).equals(row) && GridPane.getColumnIndex(node).equals(column)) {
                if (node instanceof HBox) {
                    for (Node inner : ((HBox) node).getChildren()) {
                        if (inner instanceof TextField) {
                            ((TextField) inner).setText("");
                        }
                    }
                }
            }
        }
    }

    private void clearMainGrid() {
        for (int i = 0; i <= this.gridM; i++) {
            for (int j = 0; j <= this.gridN; j++) {
                this.ClearTextField(j, i, this.mainGrid);
            }
        }
    }

    private void clearSubGrid() {
        for (int j = 0; j <= this.gridN; j++) {
            this.ClearTextField(j, 1, this.subGrid);
        }
    }

    private void clearXGrid() {
        for (int i = 0; i <= this.gridM; i++) {
            this.ClearTextField(1, i, this.xGrid);
        }
    }

    private void gatherData() {

    }

    public void init() {

    }
}