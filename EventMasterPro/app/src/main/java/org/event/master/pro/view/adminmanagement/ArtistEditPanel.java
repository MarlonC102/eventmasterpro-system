/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.event.master.pro.view.adminmanagement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.event.master.pro.person.artist.Artist;
import org.event.master.pro.person.artist.ArtistDAO;
import org.event.master.pro.util.FormatUtil;
import static org.event.master.pro.util.ShowPanelUtil.showListArtistPanel;
import org.event.master.pro.util.UIUtil;

/**
 *
 * @author Luisa
 */
public class ArtistEditPanel extends javax.swing.JPanel {
    Artist artist = new Artist();
    ArtistDAO adao = new ArtistDAO();
    private final JFrame container;
    private String doc;
    
    public ArtistEditPanel(JFrame container, String document) {
        initComponents();
        this.container = container;
        this.doc = document;
        artistData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        artistDocumentNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        artistName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        artistMusicalGenre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        artistRequirements = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        artistPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        artistEmail = new javax.swing.JTextField();
        artistPhoneNumber = new javax.swing.JTextField();
        editArtistSaveButton = new javax.swing.JButton();
        canelEditArtistButton = new javax.swing.JButton();

        jLabel2.setText("Document Number");

        jLabel3.setText("Name");

        jLabel4.setText("Musical Genre");

        jLabel5.setText("Requirements");

        artistRequirements.setColumns(20);
        artistRequirements.setRows(5);
        jScrollPane1.setViewportView(artistRequirements);

        jLabel6.setText("Price");

        jLabel7.setText("Email");

        jLabel8.setText("Phone Number");

        editArtistSaveButton.setText("Save");
        editArtistSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editArtistSaveButtonActionPerformed(evt);
            }
        });

        canelEditArtistButton.setText("Cancel");
        canelEditArtistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canelEditArtistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(artistMusicalGenre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(artistName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(artistDocumentNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(artistEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(artistPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(artistPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(editArtistSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canelEditArtistButton)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistDocumentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistMusicalGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editArtistSaveButton)
                    .addComponent(canelEditArtistButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void propertiePlaceHolder(){
        UIUtil.setPlaceHolder("Document number", artistDocumentNumber);
        UIUtil.setPlaceHolder("Name", artistName);
        UIUtil.setPlaceHolder("Musical genre", artistMusicalGenre);
        UIUtil.setPlaceHolder("Price", artistPrice);
        UIUtil.setPlaceHolder("Phone number", artistPhoneNumber);
        UIUtil.setPlaceHolder("Requeriments", artistRequirements);
        UIUtil.propertiesText(artistDocumentNumber,Color.WHITE);
    }
    
    public void artistData(){
        List<Artist> artistToEdit = adao.viewArtistDetail(doc);
        for (Artist a : artistToEdit) {
            artistDocumentNumber.setText(a.getDocumenNumber());
            UIUtil.propertiesText(artistDocumentNumber,Color.WHITE);
            artistName.setText(a.getName());
            artistEmail.setText(a.getMail());
            artistMusicalGenre.setText(a.getGenre());
            artistPhoneNumber.setText(a.getPhone());
            artistPrice.setText(FormatUtil.formatNumber(a.getPrice()));
            artistRequirements.setText(a.getRequirements());
        }
    }
    
    
    
    private void editArtistSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editArtistSaveButtonActionPerformed
        List<Artist> artist = new ArrayList<Artist>();
        String documentNumber = artistDocumentNumber.getText();
        String name = artistName.getText();
        String email = artistEmail.getText();
        String genre = artistMusicalGenre.getText();
        String phone = artistPhoneNumber.getText();
        double price = Double.parseDouble(artistPrice.getText().replace(".", ""));
        String requirements = artistRequirements.getText();
        boolean availability = true;
        Artist a = new Artist(documentNumber, name, email, phone,requirements, price, genre, availability);
        artist.add(a);
        adao.editArtist(artist);
        showListArtistPanel(container);
    }//GEN-LAST:event_editArtistSaveButtonActionPerformed

    private void canelEditArtistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canelEditArtistButtonActionPerformed
        showListArtistPanel(container);
    }//GEN-LAST:event_canelEditArtistButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artistDocumentNumber;
    private javax.swing.JTextField artistEmail;
    private javax.swing.JTextField artistMusicalGenre;
    private javax.swing.JTextField artistName;
    private javax.swing.JTextField artistPhoneNumber;
    private javax.swing.JTextField artistPrice;
    private javax.swing.JTextArea artistRequirements;
    private javax.swing.JButton canelEditArtistButton;
    private javax.swing.JButton editArtistSaveButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
