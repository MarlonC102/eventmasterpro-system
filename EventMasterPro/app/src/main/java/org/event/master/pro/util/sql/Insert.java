package org.event.master.pro.util.sql;

public enum Insert {
    INSERT_PERSON("INSERT INTO person (document_type, document_number, name, email, phone_number) VALUES (?, ?, ?, ?, ?)"),
    INSERT_INVITED("MERGE INTO event_invited_artist (event_id, artist_id) VALUES (?, ?)"),
    INSERT_ARTIST("INSERT INTO artist (requirements, genre_topic, price_artist, person_id, type_person) VALUES (?, ?, ?, (SELECT id_person FROM person WHERE document_number = ?), ?)"),
    INSERT_LOCATION("INSERT INTO location (name, address, capacity, city, department, type_location, price_location, consideration, person_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
    INSERT_EVENT("INSERT INTO event (name, description, date_event, location_id, duration, sponsor, type, classification, participants_number, principal_artist_id, date_end_event, person_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"),
    INSERT_TICKET("INSERT INTO ticket (price_ticket, seat_number, zone, description, event_id, status_ticket) VALUES (?, ?, ?, ?, ?, ?)"),
    ASSIGN_TICKET_TO_CUSTOMER("INSERT INTO ticket_detail (ticket_id, customer_id) VALUES (?, ?)"),
    ADD_REVENUE("INSERT INTO revenue (description, amount, date, source, finance_id) VALUES (?, ?, ?, ?, ?)"),
    ADD_EXPENSE("INSERT INTO expense (description, amount, date, category, finance_id) VALUES (?, ?, ?, ?, ?)"),
    SAVE_FINANCE("INSERT INTO finance (event_id, budget_total, person_id) VALUES (?, ?, ?)")
    
    ;

    private final String query;

    Insert(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
