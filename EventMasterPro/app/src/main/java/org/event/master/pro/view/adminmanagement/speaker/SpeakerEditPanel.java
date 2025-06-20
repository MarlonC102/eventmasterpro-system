/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.event.master.pro.view.adminmanagement.speaker;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.event.master.pro.person.speaker.Speaker;
import org.event.master.pro.person.speaker.SpeakerDAO;
import org.event.master.pro.util.FormatUtil;
import static org.event.master.pro.util.ShowPanelUtil.*;
import org.event.master.pro.util.UIUtil;

/**
 *
 * @author Luisa
 */
public class SpeakerEditPanel extends javax.swing.JPanel {

    Speaker speaker = new Speaker();
    SpeakerDAO sdao = new SpeakerDAO();
    private final JFrame container;
    private String doc;

    /**
     * Creates new form EditSpeakerPanel
     */
    public SpeakerEditPanel(JFrame container, String document) {
        initComponents();
        this.container = container;
        this.doc = document;
        propertiePlaceHolder();
        artistData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        speakerDocumentNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        speakerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        speakerMusicalGenre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        speakerRequirements = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        speakerPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        speakerEmail = new javax.swing.JTextField();
        speakerPhoneNumber = new javax.swing.JTextField();
        editSpeakerButton = new javax.swing.JButton();
        cancelEditSpeakerButton = new javax.swing.JButton();

        jLabel2.setText("Document Number");

        jLabel3.setText("Name");

        jLabel4.setText("Musical Genre");

        jLabel5.setText("Requirements");

        speakerRequirements.setColumns(20);
        speakerRequirements.setRows(5);
        jScrollPane1.setViewportView(speakerRequirements);

        jLabel6.setText("Price");

        jLabel7.setText("Email");

        jLabel8.setText("Phone Number");

        editSpeakerButton.setText("Save");
        editSpeakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSpeakerButtonActionPerformed(evt);
            }
        });

        cancelEditSpeakerButton.setText("Cancel");
        cancelEditSpeakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditSpeakerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
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
                                .addComponent(speakerMusicalGenre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(speakerName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(speakerDocumentNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(speakerEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(speakerPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(speakerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(editSpeakerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelEditSpeakerButton)))
                .addContainerGap(50, Short.MAX_VALUE))
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
                    .addComponent(speakerDocumentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speakerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speakerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speakerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speakerMusicalGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speakerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSpeakerButton)
                    .addComponent(cancelEditSpeakerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editSpeakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSpeakerButtonActionPerformed
        List<Speaker> artist = new ArrayList<Speaker>();
        String documentNumber = speakerDocumentNumber.getText();
        String name = speakerName.getText();
        String email = speakerEmail.getText();
        String genre = speakerMusicalGenre.getText();
        String phone = speakerPhoneNumber.getText();
        double price = Double.parseDouble(speakerPrice.getText().replace(".", ""));
        String requirements = speakerRequirements.getText();
        boolean availability = true;
        Speaker a = new Speaker(documentNumber, name, email, phone, requirements, price, genre, availability);
        artist.add(a);
        sdao.editSpeaker(artist);
        showListSpeakerPanel(container);
    }//GEN-LAST:event_editSpeakerButtonActionPerformed

    private void cancelEditSpeakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditSpeakerButtonActionPerformed
        showListSpeakerPanel(container);
    }//GEN-LAST:event_cancelEditSpeakerButtonActionPerformed

    public void propertiePlaceHolder() {
        UIUtil.setPlaceHolder("Document number", speakerDocumentNumber);
        UIUtil.setPlaceHolder("Name", speakerName);
        UIUtil.setPlaceHolder("Speciality", speakerMusicalGenre);
        UIUtil.setPlaceHolder("Price", speakerPrice);
        UIUtil.setPlaceHolder("Phone number", speakerPhoneNumber);
        UIUtil.setPlaceHolder("Requeriments", speakerRequirements);
        UIUtil.setPlaceHolder("Mail", speakerEmail);
        UIUtil.propertiesText(speakerDocumentNumber, Color.WHITE);
    }

    public void artistData() {
        List<Speaker> speakerToEdit = sdao.viewSpeakerDetail(doc);
        for (Speaker a : speakerToEdit) {
            speakerDocumentNumber.setText(a.getDocumenNumber());
            speakerDocumentNumber.setEnabled(false);
            speakerName.setText(a.getName());
            speakerEmail.setText(a.getMail());
            speakerMusicalGenre.setText(a.getSpeciality());
            speakerPhoneNumber.setText(a.getPhone());
            speakerPrice.setText(FormatUtil.formatNumber(a.getPrice()));
            speakerRequirements.setText(a.getRequirements());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelEditSpeakerButton;
    private javax.swing.JButton editSpeakerButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField speakerDocumentNumber;
    private javax.swing.JTextField speakerEmail;
    private javax.swing.JTextField speakerMusicalGenre;
    private javax.swing.JTextField speakerName;
    private javax.swing.JTextField speakerPhoneNumber;
    private javax.swing.JTextField speakerPrice;
    private javax.swing.JTextArea speakerRequirements;
    // End of variables declaration//GEN-END:variables
}
