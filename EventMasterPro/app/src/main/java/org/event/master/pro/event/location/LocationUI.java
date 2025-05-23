/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.location;

import java.util.List;
import javax.swing.JComboBox;
import static org.event.master.pro.event.location.LocationDAO.consultLocation;

/**
 *
 * @author Luisa
 */
public class LocationUI {
    public List<Location> locationList(JComboBox location){
        location.removeAllItems();
        List<Location> listLocation = consultLocation();
        for (Location loc : listLocation) {
                location.addItem(loc);
        }
        return listLocation;
    }
}
