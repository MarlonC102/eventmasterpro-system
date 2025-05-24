package org.event.master.pro.util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.event.master.pro.event.Event.Event;
import org.event.master.pro.view.adminmanagement.AdminHomePanel;
import org.event.master.pro.view.adminmanagement.artist.ArtistListPanel;
import org.event.master.pro.view.adminmanagement.artist.ArtistEditPanel;
import org.event.master.pro.view.adminmanagement.artist.ArtistCreatePanel;
import org.event.master.pro.view.adminmanagement.artist.ArtistConsultPanel;
import org.event.master.pro.view.adminmanagement.location.LocationConsultPanel;
import org.event.master.pro.view.adminmanagement.location.LocationCreatePanel;
import org.event.master.pro.view.adminmanagement.location.LocationEditPanel;
import org.event.master.pro.view.adminmanagement.location.LocationListPanel;
import org.event.master.pro.view.adminmanagement.speaker.SpeakerConsultPanel;
import org.event.master.pro.view.adminmanagement.speaker.SpeakerEditPanel;
import org.event.master.pro.view.adminmanagement.speaker.SpeakerCreatePanel;
import org.event.master.pro.view.adminmanagement.speaker.SpeakerListPanel;
import org.event.master.pro.view.organizermanagement.event.TicketCreatePanel;
import org.event.master.pro.view.organizermanagement.event.CreateEventPanel;
import org.event.master.pro.view.organizermanagement.OrganizerHomePanel;
import org.event.master.pro.view.organizermanagement.event.ConsultEventPanel;
import org.event.master.pro.view.organizermanagement.event.ListEventPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luisa
 */
public class ShowPanelUtil {
    //Esta clase se crea para "dibujar" los paneles en el jframe
    public static void switchToPanel(JFrame container, JPanel panel) {
        container.setContentPane(panel);
        container.revalidate();
        container.repaint();
    }
    
     public static void switchToPanel(JFrame container, JScrollPane panel) {
        container.setContentPane(panel);
        container.revalidate();
        container.repaint();
    }
    
//
    public static void showLogin(JFrame container) {
        //switchToPanel(container, new LoginPanel());
    }
    
    
        //Home panel
    public static void showAdminHome(JFrame container) {
        switchToPanel(container, new AdminHomePanel(container));
    }
    public static void showOrganizerHome(JFrame container) {
        switchToPanel(container, new OrganizerHomePanel(container));
    }
    
    
    
    
    
    //Panels for artist
    public static void showListArtistPanel(JFrame container) {
        switchToPanel(container, new ArtistListPanel(container));
    }
    
    public static void showEditArtistPanel(JFrame container, String document){
        switchToPanel(container, new ArtistEditPanel(container, document));
    }
    
    public static void showNewArtistPanel(JFrame container){
        switchToPanel(container, new ArtistCreatePanel(container));
    }
    
    public static void showSeeArtistPanel(JFrame container, String document){
        switchToPanel(container, new ArtistConsultPanel(container, document));
    }

    //Panels for speaker
    public static void showListSpeakerPanel(JFrame container) {
        switchToPanel(container, new SpeakerListPanel(container));
    }
    
    public static void showEditSpeakerPanel(JFrame container, String document){
        switchToPanel(container, new SpeakerEditPanel(container, document));
    }
    
    public static void showNewSpeakerPanel(JFrame container){
        switchToPanel(container, new SpeakerCreatePanel(container));
    }
    
    public static void showSeeSpeakerPanel(JFrame container, String document){
        switchToPanel(container, new SpeakerConsultPanel(container, document));
    }
    
    //Panels for location
    public static void showListLocationPanel(JFrame container) {
        switchToPanel(container, new LocationListPanel(container));
    }
    
    public static void showEditLocationPanel(JFrame container, String id){
        switchToPanel(container, new LocationEditPanel(container, id));
    }
    
    public static void showNewLocationPanel(JFrame container){
        switchToPanel(container, new LocationCreatePanel(container));
    }
    
    public static void showSeeLocationPanel(JFrame container, String document){
        switchToPanel(container, new LocationConsultPanel(container, document));
    }
    
    //Organizer panel
    //Event Panel
    public static void showNewEventPanel(JFrame container){
        switchToPanel(container,new CreateEventPanel(container));
    }
    public static void showListEventPanel(JFrame container){
        switchToPanel(container, new ListEventPanel(container));
    }
    public static void showEditEventPanel(JFrame container){
        //switchToPanel(container, new TicketCreatePanel(container));
    }
    public static void showSeeEventPanel(JFrame container, Event event){
        switchToPanel(container, new ConsultEventPanel(container, event));
    }
    
    
    
}
