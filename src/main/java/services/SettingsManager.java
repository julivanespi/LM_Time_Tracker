/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Settings;

/**
 *
 * @author julio
 */
public class SettingsManager {
    
    static private String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/settings/settings.xml";
    static private String filePathLoc = System.getProperty("user.home") + "/Documents/TimerTracker/settings";
    
    public SettingsManager(){
        this.checkForSettings();
    }
    
    public Settings parse() throws JAXBException{
        
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        Unmarshaller um = context.createUnmarshaller();
        Settings settings = (Settings) um.unmarshal(new File(fileName));
        
        return settings;
    }
    
    private void checkForSettings(){
        if(!(new File(fileName).exists())){
            try {
                File filePath = new File(filePathLoc);
                File settingsFile = new File(fileName);
                filePath.mkdirs();
                settingsFile.createNewFile();
                writeDefault();
            } catch (JAXBException ex) {
                Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void write(Settings settings) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        // Create marshaller
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(settings, new File(fileName));
    }
    
    public void writeDefault() throws JAXBException, IOException{
        
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        // Create marshaller
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new Settings(), new File(fileName));
        
        
        
    }
    
}
