/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julio
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings {
    
    private String locationSettings;
    private String locationChargeNumbers;
    private String personalUrl;
    private String starsUrl;
    private String theme;
    
    public Settings(){
        this.locationChargeNumbers = System.getProperty("user.home") + "/Documents/TimeTracker/charge_number.txt";
        this.locationSettings = System.getProperty("user.home") + "/Documents/TimeTracker/charge_number.txt";
        this.personalUrl = "https://www.google.com/";
        this.starsUrl = "www.google.com";
        this.theme = Theme.DEFAULT.getLabel();
    }
    

    public Settings(String locationChargeNumber, String locationSettings, String personalUrl, String startUrl, String theme) {
        this.locationChargeNumbers = locationChargeNumber;
        this.locationSettings = locationSettings;
        this.personalUrl = personalUrl;
        this.starsUrl = startUrl;
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Settings{" + "locationSettings=" + locationSettings + ", locationChargeNumbers=" + locationChargeNumbers + ", personalUrl=" + personalUrl + ", starsUrl=" + starsUrl + ", theme=" + theme + '}';
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLocationSettings() {
        return locationSettings;
    }

    public void setLocationSettings(String locationSettings) {
        this.locationSettings = locationSettings;
    }

    public String getLocationChargeNumbers() {
        return locationChargeNumbers;
    }

    public void setLocationChargeNumbers(String locationChargeNumbers) {
        this.locationChargeNumbers = locationChargeNumbers;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public String getStarsUrl() {
        return starsUrl;
    }

    public void setStarsUrl(String starsUrl) {
        this.starsUrl = starsUrl;
    }
    
    
    
    
}
