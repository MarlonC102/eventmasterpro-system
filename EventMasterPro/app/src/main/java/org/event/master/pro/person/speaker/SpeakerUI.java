/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.person.speaker;

import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Luisa
 */
public class SpeakerUI {
    SpeakerDAO adao = new SpeakerDAO();
    public List<Speaker> spekertList(JComboBox<String> speaker){
            List<Speaker> listArtist = adao.consultSpeaker();
        for (Speaker art : listArtist) {
                speaker.addItem(art.getName());
        }
        return listArtist;
    }
}
