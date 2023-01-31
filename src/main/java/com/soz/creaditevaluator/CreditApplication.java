package com.soz.creaditevaluator;

import com.soz.creaditevaluator.service.StateManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditApplication extends Application
{
    StateManager stateManager = new StateManager();
    @Override
    public void start(Stage stage) throws IOException
    {
       stateManager.showCreditStage(stage);
    }

    public static void main(String[] args)
    {
        launch();
    }
}