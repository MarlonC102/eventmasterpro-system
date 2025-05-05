package org.event.master.pro.util.sql;

public enum Select {
    SELECT_PERSON_BY_EMAIL("SELECT * FROM person WHERE email = ?"),
    SELECT_CUSTOMER_BY_BIRTH_YEAR("SELECT * FROM customer WHERE birth_date >= ?"),
    SELECT_ARTIST_BY_GENRE("SELECT * FROM artist WHERE genre LIKE ?"),
    SELECT_SPEAKER("SELECT * FROM speaker"),
    SELECT_SPEAKER_BY_SPECIALTY("SELECT * FROM speaker WHERE specialty = ?"),
    SELECT_LOCATION("SELECT * FROM location"),
    SELECT_LOCATION_BY_NAME("SELECT * FROM location WHERE name LIKE ?"),
    SELECT_EVENT_BY_TYPE("SELECT * FROM event WHERE type = ?"),
    SELECT_TICKET_BY_ZONE("SELECT * FROM ticket WHERE zone = ?"),
    SELECT_PAYMENT_BY_STATUS("SELECT * FROM payment WHERE status = ?"),
    SELECT_PURCHASE_BY_CUSTOMER("SELECT * FROM purchase WHERE customer_id = ?"),
    SELECT_REVENUE_BY_DATE("SELECT * FROM revenue WHERE date = ?"),
    SELECT_EXPENSE_BY_CATEGORY("SELECT * FROM expense WHERE category = ?");

    private final String query;

    Select(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
