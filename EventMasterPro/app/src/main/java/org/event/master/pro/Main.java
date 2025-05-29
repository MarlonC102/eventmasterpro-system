package org.event.master.pro;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.OneDarkTheme;
import java.sql.SQLException;
import org.event.master.pro.util.Database;
import org.event.master.pro.view.Login;

public class Main {

    public static void main(String[] args) throws SQLException {
        LafManager.setTheme(new OneDarkTheme()); 
        LafManager.install();
        Database.upDatabase();
        Login.showLogin();
        

    }
}
