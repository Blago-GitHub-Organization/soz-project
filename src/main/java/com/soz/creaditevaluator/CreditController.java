package com.soz.creaditevaluator;

import java.net.URL;
import java.util.ResourceBundle;

import com.soz.creaditevaluator.models.customerenums.MaritalStatus;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class CreditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<MaritalStatus> martialStatusComboBox;

    @FXML
    void initialize() {
        assert martialStatusComboBox != null : "fx:id=\"martialStatusComboBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        martialStatusComboBox.getItems().setAll(MaritalStatus.values());

    }

}
