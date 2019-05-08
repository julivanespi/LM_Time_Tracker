/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class TimerViewController implements Initializable{
    
    // Side menu buttons
    @FXML
    private void homeButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 1!");
        Parent homeButtonParent = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene homeButtonScene = new Scene(homeButtonParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeButtonScene);
        window.show();
    }

    @FXML
    private void timerButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 2!");
        Parent timerButtonParent = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene timerButtonScene = new Scene(timerButtonParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(timerButtonScene);
        window.show();
    }

    @FXML
    private void chargeNumberButtonAction(ActionEvent event) throws IOException {
        System.out.println("Scene 3!");
        Parent chargeNumParent = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        Scene chargeNumButtonScene = new Scene(chargeNumParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chargeNumButtonScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
