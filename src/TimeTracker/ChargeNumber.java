/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Julio
 */
public class ChargeNumber {
    
    private SimpleStringProperty ioNumber;
    private SimpleStringProperty nickName;
    
    ChargeNumber(String ioNumber, String nickName){
        this.ioNumber = new SimpleStringProperty(ioNumber);
        this.nickName = new SimpleStringProperty(nickName);
    }

    public String getIoNumber() {
        return ioNumber.get();
    }

    public void setIoNumber(String ioNumber) {
        this.ioNumber = new SimpleStringProperty(ioNumber);
    }

    public String getNickName() {
        return nickName.get();
    }

    public void setNickName(String nickName) {
        this.nickName = new SimpleStringProperty(nickName);
    }
    
     
    
}
