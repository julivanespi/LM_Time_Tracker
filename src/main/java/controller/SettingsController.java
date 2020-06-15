/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.xml.bind.JAXBException;
import model.Settings;
import model.Theme;
import services.SettingsManager;

/**
 * FXML Controller class
 *
 * @author julivanespi
 */
public class SettingsController implements Initializable {

    private SettingsManager sm = new SettingsManager();
    @FXML
    private ComboBox<String> styleComboBox;

    ObservableList<String> options
            = FXCollections.observableArrayList(
                    "default",
                    "light"
            );
    @FXML
    private TextField starsUrlTextBox;
    @FXML
    private TextField personalUrlTextBox;
    @FXML
    private TextField chargeNumberTextBox;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        styleComboBox.setItems(options);
        
        try {
            if (sm.parse().getTheme().equals(Theme.DEFAULT.getLabel())) {
                styleComboBox.setPromptText("default");
            } else {
                styleComboBox.setPromptText("light");
            }
            starsUrlTextBox.setText(sm.parse().getStarsUrl());
            personalUrlTextBox.setText(sm.parse().getPersonalUrl());
            chargeNumberTextBox.setText(sm.parse().getLocationChargeNumbers());
        } catch (JAXBException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void styleComboBoxAction(ActionEvent event) throws JAXBException {
        Settings settings = sm.parse();
        settings.setTheme(styleComboBox.getValue());
        sm.write(settings);
        
        
    }

    @FXML
    private void browseButton(ActionEvent event) {
    }

}
