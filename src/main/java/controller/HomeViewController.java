/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import TimeTracker.StartUp.InitTimeTracker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class HomeViewController implements Initializable {

    @FXML
    private Button homeButtonAction;
    @FXML
    private Button timerButton;
    @FXML
    private Button chargeNumberButton;
    @FXML
    private Button settingButton;
    @FXML
    private AnchorPane viewPane;

    // Side menu buttons
    @FXML
    private void homeButtonAction(ActionEvent event) throws IOException {
        // Does nothing
    }

    @FXML
    private void timerButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 2!");
    }

    @FXML
    private void chargeNumberButtonAction(ActionEvent event) throws IOException {
        VBox vbox = FXMLLoader.load(getClass().getResource("/view/ChargeNumberView.fxml"));
        viewPane.getChildren().setAll(vbox);
    }

    @FXML
    private void settingsButtonAction(ActionEvent event) throws IOException {
        
        VBox vbox = FXMLLoader.load(getClass().getResource("/view/SettingsView.fxml"));
        viewPane.getChildren().setAll(vbox);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            InitTimeTracker.initFiles();
        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
