/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker.ChargeNumber;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Julio
 */
public class ChargeNumber {
    
    private SimpleStringProperty ioNumber;
    private SimpleStringProperty nickName;
    private CheckBox select;
    
    ChargeNumber(String ioNumber, String nickName){
        this.ioNumber = new SimpleStringProperty(ioNumber);
        this.nickName = new SimpleStringProperty(nickName);
        this.select = new CheckBox();
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
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect(CheckBox select){
        this.select = select;
    }
    
     
    
}
