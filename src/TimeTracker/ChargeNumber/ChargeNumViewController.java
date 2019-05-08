/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker.ChargeNumber;

import TimeTracker.ChargeNumber.ChargeNumber;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class ChargeNumViewController implements Initializable {

    @FXML
    private TableView<ChargeNumber> myTableView;
    @FXML
    private TextField ioTextFieldBox;
    @FXML
    private TextField nicknameTextFieldBox;
    @FXML
    private Button homeButtonAction;
    @FXML
    private Button timerButton;
    @FXML
    private Button chargeNumberButton;
    @FXML
    private Button addChargeNumButton;
    @FXML
    private Button deleteCharNumButton;
    @FXML
    private Button saveCharNumsButton;
    @FXML
    private TableColumn<ChargeNumber, String> ioColumn = new TableColumn("IO");
    @FXML
    private TableColumn<ChargeNumber, String> nicknameColumn = new TableColumn("Nickname");

    ObservableList<ChargeNumber> chargeNumList = observableArrayList();

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

    @FXML
    private void addChargeNumButtonAction(ActionEvent event) {
        System.out.print("Test");
        if (chargeNumList.get(0).getIoNumber().equalsIgnoreCase("")) {
            System.out.print("Clearing the list because it said Add");
            chargeNumList.clear();
        } else if (chargeNumList.get(0).getIoNumber().equalsIgnoreCase("Add")) {
            System.out.print("Clearing the list because it was null");
            chargeNumList.clear();
        }
        ChargeNumber cn = new ChargeNumber(ioTextFieldBox.getText(), nicknameTextFieldBox.getText());
        myTableView.getItems().add(cn);
        ioTextFieldBox.clear();
        nicknameTextFieldBox.clear();
    }

    @FXML
    private void deleteChargeNumButtonAction(ActionEvent event) {
    }

    @FXML
    private void saveChargeNumsButtonAction(ActionEvent event) throws IOException {
        String fileName = System.getProperty("user.home") + "/Desktop/TimerTracker/charge_numbers.txt";
        File dir = new File(fileName);
        dir.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
        for (ChargeNumber ioNum : myTableView.getItems()) {
            writer.write(ioNum.getIoNumber() + "," + ioNum.getNickName());
            writer.newLine();
        }
        writer.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (readSavedChargeNum() == null) {
                chargeNumList = observableArrayList(new ChargeNumber("Add", "Charge #"));
            } else {
                chargeNumList = readSavedChargeNum();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChargeNumViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ioColumn.setCellValueFactory(new PropertyValueFactory<>("IoNumber"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("NickName"));
        // Size the columns evently
        ioColumn.prefWidthProperty().bind(myTableView.widthProperty().divide(2)); // w * 1/4
        nicknameColumn.prefWidthProperty().bind(myTableView.widthProperty().divide(2)); // w * 1/4
        myTableView.setItems(chargeNumList);
    }

    public ObservableList<ChargeNumber> readSavedChargeNum() throws IOException {
        String fileName = System.getProperty("user.home") + "/Desktop/TimerTracker/charge_numbers.txt";
        File dir = new File(fileName);
        dir.createNewFile();
        ObservableList<ChargeNumber> cn = observableArrayList();
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] ioAndNickName = line.split(",");
            // Add the student to the list
            cn.add(new ChargeNumber(ioAndNickName[0], ioAndNickName[1]));
            System.out.println(line);

        }
        return cn;
    }
}
