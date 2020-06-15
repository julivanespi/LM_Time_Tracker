/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ChargeNumberManager;
import services.SettingsManager;

/**
 *
 * @author Julio
 */
public class TimerTrackerLauncher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // try new settings thing
        SettingsManager sm = new SettingsManager();
        ChargeNumberManager cnm = new ChargeNumberManager();
        
        // Init config file
        InitTimeTracker.applicationInitCofig();

        Parent root = FXMLLoader.load(getClass().getResource("/view/MainShell.fxml"));

        Scene scene = new Scene(root);
        // Checking the css.
        if (sm.parse().getTheme().equals(Theme.DEFAULT.getLabel())) {
            scene.getStylesheets().add("view/resources/TimeTracker.css");
        } else {
            scene.getStylesheets().add("view/resources/TimeTrackerLight.css");
        }
        stage.setScene(scene);
        stage.setMinWidth(845.00);
        stage.setMinHeight(477.0);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
