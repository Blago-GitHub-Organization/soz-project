package com.soz.creaditevaluator.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import com.soz.creaditevaluator.CreditApplication;
import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.models.customerenums.EducationLevel;
import com.soz.creaditevaluator.models.customerenums.EmploymentType;
import com.soz.creaditevaluator.models.customerenums.MaritalStatus;
import com.soz.creaditevaluator.service.RiskCalculator;
import com.soz.creaditevaluator.service.implementation.CreditServiceImplementation;
import com.soz.creaditevaluator.service.implementation.CreditToCustomerServiceImplementation;
import com.soz.creaditevaluator.service.implementation.CustomerServiceImplementation;
import com.soz.creaditevaluator.service.interfaces.CreditService;
import com.soz.creaditevaluator.service.interfaces.CreditToCustomerService;
import com.soz.creaditevaluator.service.interfaces.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerController
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DPckrBirthDate;

    @FXML
    private Button btnRequest;

    @FXML
    private ChoiceBox<EducationLevel> chboxEducationLevel;

    @FXML
    private ChoiceBox<EmploymentType> chboxEmploymentStatus;

    @FXML
    private ChoiceBox<MaritalStatus> chboxMaritalStatus;

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

    private final Customer customer;

    private Credit credit;

    private final CreditService creditService = new CreditServiceImplementation();
    private final CreditToCustomerService creditToCustomerService = new CreditToCustomerServiceImplementation();
    private final CustomerService customerService = new CustomerServiceImplementation();
    private final RiskCalculator riskCalculator = new RiskCalculator(creditService, creditToCustomerService, customerService);

    public void setCredit(Credit credit)
    {
        this.credit = credit;
    }

    public CustomerController()
    {
        customer = new Customer();
    }

    @FXML
    void btnRequestOnAction(ActionEvent event) throws IOException
    {
        customer.setFirstName(txtFName.getText());
        customer.setMiddleName(txtMName.getText());
        customer.setLastName(txtLName.getText());
        customer.setBirthDate(DPckrBirthDate.getValue());
        customer.setEgn(txtEgn.getText());
        customer.setMaritalStatus(chboxMaritalStatus.getValue());
        customer.setEmploymentStatus(chboxEmploymentStatus.getValue());
        customer.setEducationLevel(chboxEducationLevel.getValue());
        customer.setAddress(txtAdress.getText());
        customer.setSalary(new BigDecimal(Long.parseLong(txt.getText())));
        customer.setFullWorkExperience(Integer.parseInt(txtFullExperience.getText()));
        customer.setWorkExperienceWithCurrentEmployer(Integer.parseInt(txtCurEmpExp.getText()));

        calculate();

    }

    private void calculate() throws IOException
    {
        final BigDecimal result = riskCalculator.calculateRisk(customer, credit);
        System.out.println(result);
        final BigDecimal threshold = new BigDecimal("80000");
        if (result.compareTo(threshold) >= 0)
        {
            showApprove();
        }
        else {
            showReject();
        }
    }

    private void showApprove() throws IOException
    {
        Stage stage = new Stage();

        URL fxmlLocation = CreditApplication.class.getResource("approve-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root, 800, 340);
        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#b3ffb3"))));
        stage.setTitle("Approve");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void showReject() throws IOException
    {
        Stage stage = new Stage();

        URL fxmlLocation = CreditApplication.class.getResource("reject-view.com.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root, 800, 340);
        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#ff0000")),
                new Stop(1, Color.web("#660000"))));
        stage.setTitle("Reject");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void initialize()
    {
        assetFields();
        loadEnums();
    }

    private void loadEnums()
    {
        chboxEducationLevel.getItems().setAll(EducationLevel.values());
        chboxEmploymentStatus.getItems().setAll(EmploymentType.values());
        chboxMaritalStatus.getItems().setAll(MaritalStatus.values());
    }

    private void assetFields()
    {
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