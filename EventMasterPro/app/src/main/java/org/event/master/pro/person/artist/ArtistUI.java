/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.person.artist;

import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Luisa
 */
public class ArtistUI {
    ArtistDAO adao = new ArtistDAO();
    public List<Artist> artistList(JComboBox artist){
            List<Artist> listArtist = adao.consultArtist();
        for (Artist art : listArtist) {
                artist.addItem(art);
        }
        return listArtist;
    }
    
    public List<Artist> artistList(JComboBox artist, String artistI){
            List<Artist> listArtist = adao.consultArtist();
        for (Artist art : listArtist) {
            if (!art.getName().equals(artistI)) {
                artist.addItem(art);
            }    
        }
    return listArtist;
    }
}
