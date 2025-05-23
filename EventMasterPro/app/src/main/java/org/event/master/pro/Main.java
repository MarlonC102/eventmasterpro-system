package org.event.master.pro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.sql.SQLException;
import javax.swing.plaf.BorderUIResource;
import mdlaf.themes.MaterialOceanicTheme;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.UIUtil;
import org.event.master.pro.view.Login;
import org.event.master.pro.view.dashboard.AdminDashboard;
import org.event.master.pro.view.dashboard.OrganizerDashboard;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
            UIUtil.setGlobalFont(new Font("Segoe UI", Font.PLAIN, 14));
            UIManager.put("Panel.margin", new Insets(0, 0, 0, 0));
            UIManager.put("TextField.margin", new Insets(2, 2, 2, 2));
            UIManager.put("ComboBox.padding", new Insets(0, 0, 0, 0));
            UIManager.put("Button.margin", new Insets(0, 0, 0, 0));
            UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder());
            UIManager.put("TextPane.border", BorderFactory.createLineBorder(Color.WHITE));
                        
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Database.upDatabase();
        //Login.showLogin();
        //AdminDashboard.openDashboard();
        OrganizerDashboard.openDashboard();


    }
}