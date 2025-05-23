package org.event.master.pro.util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.event.master.pro.view.adminmanagement.AdminHomePanel;
import org.event.master.pro.view.adminmanagement.ArtistListPanel;
import org.event.master.pro.view.adminmanagement.ArtistEditPanel;
import org.event.master.pro.view.adminmanagement.ArtistCreatePanel;
import org.event.master.pro.view.adminmanagement.ArtistConsultPanel;
import org.event.master.pro.view.adminmanagement.LocationConsultPanel;
import org.event.master.pro.view.adminmanagement.LocationCreatePanel;
import org.event.master.pro.view.adminmanagement.LocationEditPanel;
import org.event.master.pro.view.adminmanagement.LocationListPanel;
import org.event.master.pro.view.adminmanagement.SpeakerEditPanel;
import org.event.master.pro.view.adminmanagement.SpeakerCreatePanel;
import org.event.master.pro.view.adminmanagement.SpeakerListPanel;
import org.event.master.pro.view.organizermanagement.event.TicketCreatePanel;
import org.event.master.pro.view.organizermanagement.event.CreateEventPanel;
import org.event.master.pro.view.organizermanagement.OrganizerHomePanel;

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
        switchToPanel(container, new ArtistConsultPanel(container, document));
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
        //switchToPanel(container, new TicketCreatePanel(container));
    }
    public static void showEditEventPanel(JFrame container){
        //switchToPanel(container, new TicketCreatePanel(container));
    }
    public static void showSeeEventPanel(JFrame container){
        //switchToPanel(container, new TicketCreatePanel(container));
    }
    
}
