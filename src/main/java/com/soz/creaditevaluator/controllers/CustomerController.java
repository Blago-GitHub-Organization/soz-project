package com.soz.creaditevaluator.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class CustomerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DPckrBirthDate;

    @FXML
    private Button btnRequest;

    @FXML
    private ChoiceBox<?> chboxEducationLevel;

    @FXML
    private ChoiceBox<?> chboxEmploymentStatus;

    @FXML
    private ChoiceBox<?> chboxMaritalStatus;

    @FXML
    private TextArea txt;

    @FXML
    private TextArea txtAdress;

    @FXML
    private TextArea txtCurEmpExp;

    @FXML
    private TextArea txtEgn;

    @FXML
    private TextArea txtFName;

    @FXML
    private TextArea txtFullExperience;

    @FXML
    private TextArea txtLName;

    @FXML
    private TextArea txtMName;

    @FXML
    private Text txtSalary;

    @FXML
    void btnRequestOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert DPckrBirthDate != null : "fx:id=\"DPckrBirthDate\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert btnRequest != null : "fx:id=\"btnRequest\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert chboxEducationLevel != null : "fx:id=\"chboxEducationLevel\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert chboxEmploymentStatus != null : "fx:id=\"chboxEmploymentStatus\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert chboxMaritalStatus != null : "fx:id=\"chboxMaritalStatus\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txt != null : "fx:id=\"txt\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtAdress != null : "fx:id=\"txtAdress\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtCurEmpExp != null : "fx:id=\"txtCurEmpExp\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtEgn != null : "fx:id=\"txtEgn\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtFName != null : "fx:id=\"txtFName\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtFullExperience != null : "fx:id=\"txtFullExperience\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtLName != null : "fx:id=\"txtLName\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtMName != null : "fx:id=\"txtMName\" was not injected: check your FXML file 'customer-view.fxml'.";
        assert txtSalary != null : "fx:id=\"txtSalary\" was not injected: check your FXML file 'customer-view.fxml'.";

    }

}