/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker.Settings;

import TimeTracker.StartUp.InitTimeTracker;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julivanespi
 */
public class SettingsController implements Initializable {

    @FXML
    private Button homeButtonAction;
    @FXML
    private Button timerButton;
    @FXML
    private Button chargeNumberButton;
    @FXML
    private Button settingButton;
    @FXML
    private ComboBox<String> styleComboBox;

    ObservableList<String> options
            = FXCollections.observableArrayList(
                    "default",
                    "light"
            );

    // Side menu buttons
    @FXML
    private void homeButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 1!");
        Parent homeButtonParent = FXMLLoader.load(getClass().getResource("/TimeTracker/HomeView/Scene1.fxml"));
        Scene homeButtonScene = new Scene(homeButtonParent);
        if (InitTimeTracker.isDefaultCss()) {
            homeButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTracker.css");
        } else {
            homeButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTrackerLight.css");
        }
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeButtonScene);
        window.show();
    }

    @FXML
    private void timerButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 2!");
        Parent timerButtonParent = FXMLLoader.load(getClass().getResource("/TimeTracker/Timer/Scene2.fxml"));
        Scene timerButtonScene = new Scene(timerButtonParent);
        if (InitTimeTracker.isDefaultCss()) {
            timerButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTracker.css");
        } else {
            timerButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTrackerLight.css");
        }
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(timerButtonScene);
        window.show();
    }

    @FXML
    private void chargeNumberButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 3!");
        Parent chargeNumParent = FXMLLoader.load(getClass().getResource("/TimeTracker/ChargeNumber/Scene3.fxml"));
        Scene chargeNumButtonScene = new Scene(chargeNumParent);
        if (InitTimeTracker.isDefaultCss()) {
            chargeNumButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTracker.css");
        } else {
            chargeNumButtonScene.getStylesheets().add("/TimeTracker/Styles/TimeTrackerLight.css");
        }
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chargeNumButtonScene);
        window.show();
    }

    @FXML
    private void settingsButtonAction(ActionEvent event) throws IOException {
        // Does nothing
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        styleComboBox.setItems(options);
        try {
            if (InitTimeTracker.isDefaultCss()) {
                styleComboBox.setPromptText("default");
            } else {
                styleComboBox.setPromptText("light");
            }
        } catch (IOException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void styleComboBoxAction(ActionEvent event) {
        String selection = styleComboBox.getValue();

        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/config.txt";
        String filePathLoc = System.getProperty("user.home") + "/Documents/TimerTracker/";
        File filePath = new File(filePathLoc);
        File chargeNumFile = new File(fileName);
        try {
            PrintWriter writer = new PrintWriter(chargeNumFile, "UTF-8");
            if (styleComboBox.getValue().equalsIgnoreCase("default")) {
                writer.println("style,default");
            } else {
                writer.println("style,light");
            }

            writer.close();
            System.out.println("done!");
        } catch (Exception e) {
            System.err.println("Coudln't create config number file.");
        }
    }

}
