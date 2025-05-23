package org.event.master.pro.util.sql;

public enum Select {
    COUNT_ACTIVE_LOCATION("SELECT COUNT(id_location) AS total_location FROM location WHERE status_location = TRUE"),
    CONSULT_DOCUMENT_NUMBER("SELECT document_number FROM person WHERE document_number = ?"),
    COUNT_ACTIVE_SPEAKER("SELECT COUNT(A.id_artist) AS total_speaker FROM artist A INNER JOIN person B  ON A.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = FALSE"),
    COUNT_ACTIVE_ARTIST("SELECT COUNT(A.id_artist) AS total_artist FROM artist A INNER JOIN person B  ON A.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = TRUE"),
    SELECT_SPECIFIC_ARTIST("SELECT * FROM artist A INNER JOIN person B ON A.person_id = B.id_person WHERE B.document_number = ?"),
    //SELECT_PERSON_BY_EMAIL("SELECT * FROM person WHERE email = ?"),
    //SELECT_CUSTOMER_BY_BIRTH_YEAR("SELECT * FROM customer WHERE birth_date >= ?"),
    //SELECT_ARTIST_BY_GENRE("SELECT * FROM artist WHERE genre_topic LIKE ? AND type_person = TRUE"),
    SELECT_ARTIST("SELECT * FROM artist A INNER JOIN person B ON a.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = ? AND A.availability = TRUE"),
    //SELECT_SPEAKER_BY_SPECIALTY("SELECT * FROM speaker WHERE specialty = ?"),
    SELECT_LOCATION("SELECT * FROM location WHERE status_location = ?"),
    //SELECT_LOCATION_BY_NAME("SELECT * FROM location WHERE name LIKE ?"),
    //SELECT_EVENT_BY_TYPE("SELECT * FROM event WHERE type = ?"),
    //SELECT_TICKET_BY_ZONE("SELECT * FROM ticket WHERE zone = ?"),
    //SELECT_PAYMENT_BY_STATUS("SELECT * FROM payment WHERE status = ?"),
    //SELECT_PURCHASE_BY_CUSTOMER("SELECT * FROM purchase WHERE customer_id = ?"),
    //SELECT_REVENUE_BY_DATE("SELECT * FROM revenue WHERE date = ?"),
    //SELECT_EXPENSE_BY_CATEGORY("SELECT * FROM expense WHERE category = ?"),
    //SELECT_ACCOUNT_BY_USER("SELECT * FROM account WHERE user_name = ? and password = ?"),
    SELECT_ACCOUNT_BY_USERV2("SELECT *  FROM person A INNER JOIN account B ON B.person_id = A.id_person WHERE B.user_name = ? AND B.password = ?"),
    //SELECT_LAST_PERSON("SELECT id_person FROM person ORDER BY id_person DESC LIMIT 1"),
    //SELECT_LAST_ARTIST("SELECT * FROM person ORDER BY DESC FIRTS"), 
    SELECT_SPECIFIC_LOCATION("SELECT * FROM location WHERE id_location = ? AND status_location = TRUE"),
    //SELECT_LOCATION_AVAILABLE("SELECT * FROM location WHERE availability = TRUE AND status_location = TRUE"),
    SELECT_CONCERT_IN_PROGRESS("SELECT COUNT(id_event) AS total FROM event WHERE type = 'Concert' AND status_event = 'in progress'"),
    SELECT_CONFERENCE_IN_PROGRESS("SELECT COUNT(id_event) AS total FROM event WHERE type = 'Conference' AND status_event = 'in progress'"),
    SELECT_FESTIVAL_IN_PROGRESS("SELECT COUNT(id_event) AS total FROM event WHERE type = 'Festival' AND status_event = 'in progress'"),
    SELECT_EVENTS_INFO("SELECT t.id_ticket, t.price_ticket, t.seat_number, t.zone, t.description AS "
            + "ticket_description, e.id_event, e.name AS event_name, e.description AS event_description, e.date_event, "
            + "e.status_event, e.duration, e.sponsor, e.type, e.classification, e.participants_number, ap.id_artist AS "
            + "principal_artist_id, pp.name AS principal_artist_name, pp.email AS principal_artist_email, l.id_location, "
            + "l.name AS location_name, l.address AS location_address, l.city, l.department, l.type_location, l.capacity, "
            + "l.price_location, l.consideration, GROUP_CONCAT(DISTINCT pi.name SEPARATOR ', ') AS invited_artists FROM "
            + "ticket t JOIN event e ON t.event_id = e.id_event LEFT JOIN location l ON e.location_id = l.id_location "
            + "LEFT JOIN artist ap ON e.principal_artist_id = ap.id_artist LEFT JOIN person pp ON ap.person_id = pp.id_person "
            + "LEFT JOIN event_invited_artist ei ON ei.event_id = e.id_event LEFT JOIN artist ai ON ei.artist_id = ai.id_artist "
            + "LEFT JOIN person pi ON ai.person_id = pi.id_person WHERE e.status_event =  ? AND e.type = ? GROUP BY t.id_ticket "
            + "ORDER BY e.date_event DESC"),
    SELECT_EVENT_BY_ID("SELECT t.id_ticket, t.price_ticket, t.seat_number, t.zone, t.description AS ticket_description," +
        "e.id_event, e.name AS event_name, e.description AS event_description, e.date_event, e.status_event," +
        "e.duration, e.sponsor, e.type, e.classification, e.participants_number," +
        "ap.id_artist AS principal_artist_id, pp.name AS principal_artist_name, pp.email AS principal_artist_email," +
        "l.id_location, l.name AS location_name, l.address AS location_address, l.city, l.department," +
        "l.type_location, l.capacity, l.price_location, l.consideration," +
        "GROUP_CONCAT(DISTINCT pi.name SEPARATOR ', ') AS invited_artists" +
        "FROM ticket t" +
        "JOIN event e ON t.event_id = e.id_event" +
        "LEFT JOIN location l ON e.location_id = l.id_location "+
        "LEFT JOIN artist ap ON e.principal_artist_id = ap.id_artist" +
        "LEFT JOIN person pp ON ap.person_id = pp.id_person" +
        "LEFT JOIN event_invited_artist ei ON ei.event_id = e.id_event" +
        "LEFT JOIN artist ai ON ei.artist_id = ai.id_artist" +
        "LEFT JOIN person pi ON ai.person_id = pi.id_person" +
        "WHERE e.id_event = ?" +
        "GROUP BY t.id_ticket" +
        "ORDER BY e.date_event DESC"),
    SELECT_TICKET_BY_EVENT("SELECT id_ticket, price, seat_number, zone, description, status FROM ticket WHERE event_id = ?"),
    SELECT_REVENUE("SELECT id_revenue, description, amount, date, source FROM revenue WHERE finance_id = ?"),
    SELECT_EXPENSE("SELECT id_expense, description, amount, date, category FROM expense WHERE finance_id = ?")
    ;
    private final String query;

    Select(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
