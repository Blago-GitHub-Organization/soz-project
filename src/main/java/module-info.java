module com.soz.creaditevaluator.creaditevaluator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.soz.creaditevaluator to javafx.fxml;
    exports com.soz.creaditevaluator;
}