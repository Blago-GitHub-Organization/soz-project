
package com.soz.creaditevaluator.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Interest;

    @FXML
    private ChoiceBox<?> chboxCreditType;

    @FXML
    private Button exitButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextArea txtCapital;

    @FXML
    private TextArea txtCollateral;

    @FXML
    private TextArea txtInstallment;

    @FXML
    private TextArea txtPeriod;

    @FXML
    void exitAction(ActionEvent event) {

    }

    @FXML
    void nextButtonOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Interest != null : "fx:id=\"Interest\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert chboxCreditType != null : "fx:id=\"chboxCreditType\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert nextButton != null : "fx:id=\"nextButton\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert txtAmount != null : "fx:id=\"txtAmount\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert txtCapital != null : "fx:id=\"txtCapital\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert txtCollateral != null : "fx:id=\"txtCollateral\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert txtInstallment != null : "fx:id=\"txtInstallment\" was not injected: check your FXML file 'credit-view.fxml'.";
        assert txtPeriod != null : "fx:id=\"txtPeriod\" was not injected: check your FXML file 'credit-view.fxml'.";

    }

}

//    @FXML
//    private Button nextButton;
//    @FXML
//    private Button exitButton;
//
//    @FXML
//    void exitAction(ActionEvent event) {
//        Stage stage = (Stage) exitButton.getScene().getWindow();
//        stage.close();
//    }
//
//
//    @FXML
//    void nextButtonOnAction(ActionEvent event) throws IOException
//    {
//        Stage stage = new Stage();
//
//        FXMLLoader fxmlLoader = new FXMLLoader(CreditApplication.class.getResource("customer-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
//        stage.setTitle("Customer");
//        stage.setScene(scene);
//        stage.show();
//        nextButton.setVisible(false);
//    }

//    @FXML
//    private Button nextButton;
//    @FXML
//    private Button exitButton;
//
//    @FXML
//    void exitAction(ActionEvent event) {
//        Stage stage = (Stage) exitButton.getScene().getWindow();
//        stage.close();
//    }
//
//
//    @FXML
//    void nextButtonOnAction(ActionEvent event) throws IOException
//    {
//        Stage stage = new Stage();
//
//        FXMLLoader fxmlLoader = new FXMLLoader(CreditApplication.class.getResource("customer-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
//        stage.setTitle("Customer");
//        stage.setScene(scene);
//        stage.show();
//        nextButton.setVisible(false);
//    }