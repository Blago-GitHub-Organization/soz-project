package com.soz.creaditevaluator.service;

import com.soz.creaditevaluator.CreditApplication;
import com.soz.creaditevaluator.controllers.ApproveController;
import com.soz.creaditevaluator.controllers.CreditController;
import com.soz.creaditevaluator.controllers.CustomerController;
import com.soz.creaditevaluator.controllers.RejectController;
import com.soz.creaditevaluator.service.implementation.CreditServiceImplementation;
import com.soz.creaditevaluator.service.implementation.CreditToCustomerServiceImplementation;
import com.soz.creaditevaluator.service.implementation.CustomerServiceImplementation;
import com.soz.creaditevaluator.service.interfaces.CreditService;
import com.soz.creaditevaluator.service.interfaces.CreditToCustomerService;
import com.soz.creaditevaluator.service.interfaces.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StateManager
{
    private final CreditService creditService = new CreditServiceImplementation();
    private final CreditToCustomerService creditToCustomerService = new CreditToCustomerServiceImplementation();
    private final CustomerService customerService = new CustomerServiceImplementation();
    private final RiskCalculator riskCalculator = new RiskCalculator(creditService, creditToCustomerService, customerService);
    private final CustomerController customerController = new CustomerController();
    private final CreditController creditController = new CreditController();
    private final ApproveController approveController = new ApproveController();
    private final RejectController rejectController = new RejectController();


    public void showCreditStage(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(CreditApplication.class.getResource("credit-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
        stage.setTitle("Credit");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void showCustomerStage(ActionEvent event) throws IOException
    {
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(CreditApplication.class.getResource("customer-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
//        stage.setTitle("Customer");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();

        creditController.nextButtonOnAction();
    }

}
