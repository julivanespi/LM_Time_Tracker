/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.JAXBException;
import model.ChargeNumber;
import services.ChargeNumberManager;

/**
 *
 * @author Julio
 */
public class ChargeNumViewController implements Initializable {

    private ChargeNumberManager chm = new ChargeNumberManager();
    @FXML
    private TableView<ChargeNumber> myTableView;
    @FXML
    private TextField ioTextFieldBox;
    @FXML
    private TextField nicknameTextFieldBox;

    @FXML
    private TableColumn<ChargeNumber, String> ioColumn = new TableColumn("IO");
    @FXML
    private TableColumn<ChargeNumber, String> nicknameColumn = new TableColumn("Nickname");
    @FXML
    private TableColumn<ChargeNumber, CheckBox> selectColumn = new TableColumn("Select");

    ObservableList<ChargeNumber> chargeNumList = observableArrayList();

    /**
     * This action event method is called when the user clicks the "Add" button
     * when presenting Scene3.
     *
     * @param event
     */
    @FXML
    private void addChargeNumButtonAction(ActionEvent event) {
        if (chargeNumList.get(0).getIoNumber().equalsIgnoreCase("")) {
            chargeNumList.clear();
        } else if (chargeNumList.get(0).getIoNumber().equalsIgnoreCase("Add")) {
            chargeNumList.clear();
        }
        ChargeNumber cn = new ChargeNumber(ioTextFieldBox.getText(), nicknameTextFieldBox.getText());
        myTableView.getItems().add(cn);
        ioTextFieldBox.clear();
        nicknameTextFieldBox.clear();
    }

    /**
     * This action event method deletes a specified charge number.
     *
     * @param event
     */
    @FXML
    private void deleteChargeNumButtonAction(ActionEvent event) {
        // TODO: Add functionality to delete charge numbers
        //myTableView.getItems().removeAll(myTableView.getSelectionModel().getSelectedItem());
        ObservableList<ChargeNumber> dataListRemove = FXCollections.observableArrayList();
        // looping through all the checked charge numbers
        for (ChargeNumber pair : chargeNumList) {
            if (pair.getSelect().isSelected()) {
                dataListRemove.add(pair);
            }
        }
        chargeNumList.removeAll(dataListRemove);
    }

    /**
     * This method is called when the user clicks the "Save" button when
     * presenting Scene3.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void saveChargeNumsButtonAction(ActionEvent event) throws IOException, JAXBException {
//        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/charge_numbers.txt";
//        File dir = new File(fileName);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
        chm.clearTheList();
        for (ChargeNumber ioNum : myTableView.getItems()) {
            chm.addChargeNumber(ioNum);
//            writer.write(ioNum.getIoNumber() + "," + ioNum.getNickName());
//            writer.newLine();
        }
//        writer.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("yup");
        // read the charge number file in documents
        try {
            // might not have to add this if else
            if (readSavedChargeNum() == null) {
                chargeNumList = observableArrayList(new ChargeNumber("Add", "Charge #"));
            } else {
                chargeNumList = readSavedChargeNum();
            }
        } catch (IOException | JAXBException ex) {
            Logger.getLogger(ChargeNumViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ioColumn.setCellValueFactory(new PropertyValueFactory<>("IoNumber"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("NickName"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("Select"));
        // Size the columns evently
        ioColumn.prefWidthProperty().bind(myTableView.widthProperty().divide(3)); // w * 1/3
        nicknameColumn.prefWidthProperty().bind(myTableView.widthProperty().divide(3)); // w * 1/3
        selectColumn.prefWidthProperty().bind(myTableView.widthProperty().divide(3)); // w * 1/3
        myTableView.setItems(chargeNumList);
    }

    /**
     * This reads the charge number file and adds the numbers to the column.
     *
     * @return cn ObservableList of ChargeNumber objects.
     * @throws IOException
     */
    public ObservableList<ChargeNumber> readSavedChargeNum() throws IOException, JAXBException {
        
        ObservableList<ChargeNumber> cn = observableArrayList();
        
        for(ChargeNumber chargeNumber : chm.parse().getMyList()){
            ChargeNumber temp = new ChargeNumber(chargeNumber.get_IoNumber(), chargeNumber.get_NickName());
            cn.add(temp);
        }

//        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/charge_numbers.txt";
//        File dir = new File(fileName);
//        ObservableList<ChargeNumber> cn = observableArrayList();
//        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] ioAndNickName = line.split(",");
//            // Add the student to the list
//            cn.add(new ChargeNumber(ioAndNickName[0], ioAndNickName[1]));
//        }
        return cn;
    }

}
