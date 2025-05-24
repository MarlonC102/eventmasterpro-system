/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.util;

import java.awt.Color;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.event.master.pro.person.account.Account;

/**
 *
 * @author Luisa
 */
public class UIUtil {
    public static void setPlaceHolder(String text, JTextComponent component){
        TextPrompt placeHolder = new TextPrompt(text,component);
    }
    
    public static void setGlobalFont(Font font) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof Font) {
                UIManager.put(key, font);
            }
        }
    }
    
    public static void propertiesText(JTextField field, Color textColor){
        field.setEnabled(false);
        field.setDisabledTextColor(textColor);
    }
    
    public static void propertiesText(JTextArea field, Color textColor){
        field.setEnabled(false);
        field.setDisabledTextColor(textColor);
    }

    public static void propertiesText(JComboBox<String> field, Color textColor) {
        field.setEnabled(false);
    }
    
    public static void hideButtons(String account, JTable table){
        if (!account.equals("admin")) {
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
        }
    }
    
}
