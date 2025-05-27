package org.event.master.pro.util.sql;

public enum Insert {
    INSERT_PERSON("INSERT INTO person (document_type, document_number, name, email, phone_number) VALUES (?, ?, ?, ?, ?)"),
    //INSERT_ACCOUNT("INSERT INTO account (person_id, password, role) VALUES (?, ?, ?)"),
    //INSERT_CUSTOMER("INSERT INTO customer (person_id, birth_date) VALUES (?, ?)"),
    INSERT_INVITED("MERGE INTO event_invited_artist (event_id, artist_id) VALUES (?, ?)"),
    INSERT_ARTIST("INSERT INTO artist (requirements, genre_topic, price_artist, person_id, type_person) VALUES (?, ?, ?, (SELECT id_person FROM person WHERE document_number = ?), ?)"),
    //INSERT_SPEAKER("INSERT INTO speaker (specialty, topic, requirements, price_speaker, person_id) VALUES (?, ?, ?, ?, ?)"),
    //INSERT_ADMIN("INSERT INTO admin (person_id) VALUES (?)"),
    //INSERT_ORGANIZER("INSERT INTO organizer (person_id) VALUES (?)"),
    //INSERT_COUNTER("INSERT INTO counter (person_id) VALUES (?)"),
    INSERT_LOCATION("INSERT INTO location (name, address, capacity, city, department, type_location, price_location, consideration, person_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
    INSERT_EVENT("INSERT INTO event (name, description, date_event, location_id, duration, sponsor, type, classification, participants_number, principal_artist_id, date_end_event, person_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"),
    INSERT_TICKET("INSERT INTO ticket (price_ticket, seat_number, zone, description, event_id, status_ticket) VALUES (?, ?, ?, ?, ?, ?)"),
    //INSERT_PAYMENT_METHOD("INSERT INTO payment_method (type, provider, last_four_digits) VALUES (?, ?, ?)"),
    //INSERT_PAYMENT("INSERT INTO payment (amount, status, payment_method_id) VALUES (?, ?, ?)"),
    //INSERT_PURCHASE("INSERT INTO purchase (customer_id, payment_id, total_amount) VALUES (?, ?, ?)"),
    //INSERT_FINANCE("INSERT INTO finance (counter_id, event_id, budget_total, income_total, expenses_total, balance, status) VALUES (?, ?, ?, ?, ?, ?, ?)"),
    //INSERT_REVENUE("INSERT INTO revenue (finance_id, description, amount, date, source) VALUES (?, ?, ?, ?, ?)"),
    //INSERT_EXPENSE("INSERT INTO expense (finance_id, description, amount, date, category) VALUES (?, ?, ?, ?, ?)"),
    ASSIGN_TICKET_TO_CUSTOMER("INSERT INTO ticket_detail (ticket_id, customer_id) VALUES (?, ?)"),
    ADD_REVENUE("INSERT INTO revenue (description, amount, date, source, finance_id) VALUES (?, ?, ?, ?, ?)"),
    ADD_EXPENSE("INSERT INTO expense (description, amount, date, category, finance_id) VALUES (?, ?, ?, ?, ?)");

    private final String query;

    Insert(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
