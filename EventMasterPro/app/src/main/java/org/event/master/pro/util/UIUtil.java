/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.util;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Color;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Luisa
 */
public class UIUtil {

    public static void setPlaceHolder(String text, JTextComponent component) {
        TextPrompt placeHolder = new TextPrompt(text, component);
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

    public static void propertiesText(JTextField field, Color textColor) {
        field.setEnabled(false);
        field.setDisabledTextColor(textColor);
    }

    public static void propertiesText(JTextArea field, Color textColor) {
        field.setEnabled(false);
        field.setDisabledTextColor(textColor);
    }

    public static void propertiesText(JComboBox<String> field, Color textColor) {
        field.setEnabled(false);
    }

    public static void propertiesText(JTextPane field, Color textColor) {
        field.setEnabled(false);
        field.setDisabledTextColor(textColor);
    }

    public static void propertiesText(DateTimePicker field, Color textColor) {
        field.setEnabled(false);
    }

    public static void hideButtons(String account, JTable table) {
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
        if (!account.equals("organizer")) {
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
        } if (!account.equals("counter")) {
            table.getColumnModel().getColumn(9).setMinWidth(0);
            table.getColumnModel().getColumn(9).setMaxWidth(0);
            table.getColumnModel().getColumn(9).setPreferredWidth(0);
        }if (!account.equals("customer")) {
            table.getColumnModel().getColumn(10).setMinWidth(0);
            table.getColumnModel().getColumn(10).setMaxWidth(0);
            table.getColumnModel().getColumn(10).setPreferredWidth(0);
        }
    }
    
    public static void hideButtonNotsCounter(String account, JTable table) {
        if (!account.equals("counter")) {
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
        }
    }

    public static void eventButtons(DefaultTableModel modelTableTicket, JTable table) {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int column = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && column == table.getColumnModel().getColumnIndex("Delete")) {
                    modelTableTicket.removeRow(table.getSelectedRow());
                }
            }
        });
    }

    public static void enableBasicLineWrap(JTextPane textPane) {
        textPane.setEditable(true);
        textPane.setFocusable(true);
        textPane.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        textPane.setSize(textPane.getParent().getWidth(), Short.MAX_VALUE);
    }

}
