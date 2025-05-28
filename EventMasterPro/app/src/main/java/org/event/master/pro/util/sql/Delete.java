/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.util.sql;

/**
 *
 * @author Luisa
 */
public enum Delete {
    DELETE_INVITED_ARTIST("DELETE FROM event_invited_artist WHERE event_id = ?");

    private final String query;

    Delete(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
