package com.soz.creaditevaluator.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.soz.creaditevaluator.CreditApplication;
import com.soz.creaditevaluator.models.customerenums.MaritalStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class CreditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<MaritalStatus> martialStatusComboBox;

    @FXML
    private Button nextButton;
    @FXML
    private Button exitButton;

    @FXML
    void exitAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    void nextButtonOnAction(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(CreditApplication.class.getResource("customer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
        stage.setTitle("Customer");
        stage.setScene(scene);
        stage.show();
        nextButton.setVisible(false);
    }


    @FXML
    void initialize() {
        assert martialStatusComboBox != null : "fx:id=\"martialStatusComboBox\" was not injected: check your FXML file 'credit-view.fxml'.";
        martialStatusComboBox.getItems().setAll(MaritalStatus.values());

    }

}
