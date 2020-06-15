/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.ChargeNumber;
import model.ChargeNumberList;

/**
 *
 * @author julio
 */
public class ChargeNumberManager {
    static private String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/chargenumbers/charge_numbers.xml";
    static private String filePathLoc = System.getProperty("user.home") + "/Documents/TimerTracker/chargenumbers";
    private ChargeNumberList chargeNumberList;
    private List<ChargeNumber> theList;
    public ChargeNumberManager(){
        this.checkForChargeNumbers();
        try {
            this.chargeNumberList = this.parse();
        } catch (JAXBException ex) {
            Logger.getLogger(ChargeNumberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addChargeNumber(ChargeNumber cn) throws JAXBException{
       
        chargeNumberList.getMyList().add(cn);
        JAXBContext context = JAXBContext.newInstance(ChargeNumberList.class);
        // Create marshaller
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(chargeNumberList, new File(fileName));
    }
    
    public void checkForChargeNumbers(){
        if(!(new File(fileName).exists())){
            try {
                File filePath = new File(filePathLoc);
                File settingsFile = new File(fileName);
                filePath.mkdirs();
                settingsFile.createNewFile();
                generateEmptyList();
            } catch (JAXBException ex) {
                Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void clearTheList(){
        chargeNumberList.getMyList().clear();
    }
    
    
    public void generateEmptyList() throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(ChargeNumberList.class);
        // Create marshaller
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ChargeNumberList(), new File(fileName));
    }
    
    public ChargeNumberList parse()throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(ChargeNumberList.class);
        Unmarshaller um = context.createUnmarshaller();
        ChargeNumberList cnl = (ChargeNumberList) um.unmarshal(new File(fileName));
        return cnl;
    }
}
