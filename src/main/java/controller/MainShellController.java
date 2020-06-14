/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.InitTimeTracker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Julio
 */
public class MainShellController implements Initializable {
    
    VBox vbox = new VBox();

    @FXML
    private AnchorPane viewPane;

    // Side menu buttons
    @FXML
    private void homeButtonAction(ActionEvent event) throws IOException {
        vbox = FXMLLoader.load(getClass().getResource("/view/HomeView.fxml"));
        viewPane.getChildren().setAll(vbox);
    }

    @FXML
    private void timerButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 2!");
    }

    @FXML
    private void chargeNumberButtonAction(ActionEvent event) throws IOException {
        vbox = FXMLLoader.load(getClass().getResource("/view/ChargeNumberView.fxml"));
        viewPane.getChildren().setAll(vbox);
    }

    @FXML
    private void settingsButtonAction(ActionEvent event) throws IOException {
        
        vbox = FXMLLoader.load(getClass().getResource("/view/SettingsView.fxml"));
        viewPane.getChildren().setAll(vbox);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            InitTimeTracker.initFiles();
            vbox = FXMLLoader.load(getClass().getResource("/view/HomeView.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainShellController.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewPane.getChildren().setAll(vbox);
        
    }

}
