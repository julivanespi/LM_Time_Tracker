/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChargeNumberList {
    
    @XmlElement(name = "ChargeNumber")
    private List<ChargeNumber> myList;
    
    public ChargeNumberList(){
        List<ChargeNumber> temp = new ArrayList<>();
        temp.add(new ChargeNumber("Add", "#"));
        temp.add(new ChargeNumber("12345", "sample"));
        this.myList = temp;
    }
    
    public ChargeNumberList(List<ChargeNumber> cn){
        this.myList = cn;
    }

    @Override
    public String toString() {
        return "ChargeNumberList{" + "myList=" + myList + '}';
    }

    public List<ChargeNumber> getMyList() {
        return myList;
    }

    public void setMyList(List<ChargeNumber> myList) {
        this.myList = myList;
    }
    
    
}
