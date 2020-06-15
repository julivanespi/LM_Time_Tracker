/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author Julio
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ChargeNumber {

    @XmlTransient
    private SimpleStringProperty ioNumber;
    @XmlTransient
    private SimpleStringProperty nickName;
    @XmlTransient
    private CheckBox select;
    private String _ioNumber;
    private String _nickName;
    
    public ChargeNumber(String ioNumber, String nickName){
        this.ioNumber = new SimpleStringProperty(ioNumber);
        this.nickName = new SimpleStringProperty(nickName);
        this.select = new CheckBox();
        this._ioNumber = ioNumber;
        this._nickName = nickName;
    }
    
    public ChargeNumber(){
    }

    @Override
    public String toString() {
        return "ChargeNumber{" + "IoNumber=" + _ioNumber + ", NickName=" + _nickName + '}';
    }
    
    public String getIoNumber() {
        return ioNumber.get();
    }
    
    public String get_IoNumber(){
        return _ioNumber;
    }
    
    public void setIoNumber(String ioNumber) {
        this.ioNumber = new SimpleStringProperty(ioNumber);
        this._ioNumber = ioNumber;
    }

    public String getNickName() {
        return nickName.get();
    }
    
    public String get_NickName(){
        return _nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = new SimpleStringProperty(nickName);
        this._nickName = nickName;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    @XmlTransient
    public void setSelect(CheckBox select){
        this.select = select;
    }
    
}
