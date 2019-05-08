/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker;

import java.io.File;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class HomeViewController implements Initializable {

    @FXML
    private TableView myTableView;

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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String fileName = System.getProperty("user.home") + "/Desktop/TimerTracker/charge_numbers.txt";
        String filePathLoc = System.getProperty("user.home") + "/Desktop/TimerTracker/";
        if (!(new File(fileName).exists())) {
            File filePath = new File(filePathLoc);
            File chargeNumFile = new File(fileName);
            try {
                filePath.mkdirs();
                chargeNumFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
