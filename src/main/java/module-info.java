module com.dumetella.simplexmethodcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dumetella.simplexmethodcalculator to javafx.fxml;
    exports com.dumetella.simplexmethodcalculator;
}