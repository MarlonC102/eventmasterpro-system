package org.event.master.pro;

import com.formdev.flatlaf.IntelliJTheme;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.OneDarkTheme;
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
        LafManager.setTheme(new OneDarkTheme()); 
        LafManager.install();
        Database.upDatabase();
        //Login.showLogin();
        //AdminDashboard.openDashboard();
        OrganizerDashboard.openDashboard();

    }
}
