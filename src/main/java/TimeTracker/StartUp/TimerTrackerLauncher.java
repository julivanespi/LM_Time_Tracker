/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker.StartUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class TimerTrackerLauncher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Init config file
        InitTimeTracker.applicationInitCofig();

        Parent root = FXMLLoader.load(getClass().getResource("/TimeTracker/HomeView/Scene1.fxml"));

        Scene scene = new Scene(root);
        // Checking the css.
        if (InitTimeTracker.isDefaultCss()) {
            scene.getStylesheets().add("/TimeTracker/Styles/TimeTracker.css");
        } else {
            scene.getStylesheets().add("/TimeTracker/Styles/TimeTrackerLight.css");
        }
        //scene.getStylesheets().add("/TimeTracker/HomeView/HomeView.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
