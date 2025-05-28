/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.person.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Select;

/**
 *
 * @author Luisa
 */
public class AccountDAO {

    Account account;

    public Account login(String password, String userName) {
        String sql = Select.SELECT_ACCOUNT_BY_USERV2.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("user_name").equals(userName) || rs.getString("password").equals(password)) {
                    account = new Account();
                    account.setName(rs.getString("name"));
                    account.setRol(rs.getString("role"));
                    account.setIsLoggedIn(true);
                    account.setName(rs.getString("name"));
                    Account.id = rs.getString("id_person");
                } else {
                    Account.setIsLoggedIn(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        /*if (isStatus()){
            if (documenNumbert.equals(getDocumenNumbert()) && password.equals(this.password)){
                printMessage(String.format("Successful login. Welcome, %s",getName()));
                isLoggedIn = true;
            }else{
                printMessage("Incorrect document or password.");
                isLoggedIn = false;
            }
        }else{
            printMessage("The account is inactive.");
            isLoggedIn=false;
        }*/
        return account;
    }
}
