package org.event.master.pro.util.sql;

public enum Select {
    COUNT_ACTIVE_LOCATION("SELECT COUNT(id_location) AS total_location FROM location WHERE status_location = TRUE"),
    CONSULT_DOCUMENT_NUMBER("SELECT document_number FROM person WHERE document_number = ?"),
    COUNT_ACTIVE_SPEAKER("SELECT COUNT(A.id_artist) AS total_speaker FROM artist A INNER JOIN person B  ON A.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = FALSE"),
    COUNT_ACTIVE_ARTIST("SELECT COUNT(A.id_artist) AS total_artist FROM artist A INNER JOIN person B  ON A.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = TRUE"),
    SELECT_SPECIFIC_ARTIST_BY_DOC("SELECT * FROM artist A INNER JOIN person B ON A.person_id = B.id_person WHERE B.document_number = ? AND A.type_person = ?"),
    SELECT_SPECIFIC_ARTIST("SELECT * FROM artist A INNER JOIN person B ON A.person_id = B.id_person WHERE A.id_artist = ? AND A.type_person = ?"),
    SELECT_ARTIST("SELECT * FROM artist A INNER JOIN person B ON a.person_id = B.id_person WHERE B.status_person = TRUE AND A.type_person = ? AND A.availability = TRUE"),
    SELECT_LOCATION("SELECT * FROM location WHERE status_location = ?"),
    SELECT_ACCOUNT_BY_USERV2("SELECT *  FROM person A INNER JOIN account B ON B.person_id = A.id_person WHERE B.user_name = ? AND B.password = ?"),
    SELECT_SPECIFIC_LOCATION("SELECT * FROM location WHERE id_location = ? AND status_location = TRUE"),
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
            + "LEFT JOIN person pi ON ai.person_id = pi.id_person WHERE e.status_event =  ? GROUP BY t.id_ticket "
            + "ORDER BY e.date_event DESC"),
    SELECT_EVENT_BY_ID("SELECT t.id_ticket, t.price_ticket, t.seat_number, t.zone, t.description AS ticket_description,"
            + "e.id_event, e.name AS event_name, e.description AS event_description, e.date_event, e.status_event,"
            + "e.duration, e.sponsor, e.type, e.classification, e.participants_number,"
            + "ap.id_artist AS principal_artist_id, pp.name AS principal_artist_name, pp.email AS principal_artist_email,"
            + "l.id_location, l.name AS location_name, l.address AS location_address, l.city, l.department,"
            + "l.type_location, l.capacity, l.price_location, l.consideration,"
            + "GROUP_CONCAT(DISTINCT pi.name SEPARATOR ', ') AS invited_artists"
            + "FROM ticket t"
            + "JOIN event e ON t.event_id = e.id_event"
            + "LEFT JOIN location l ON e.location_id = l.id_location "
            + "LEFT JOIN artist ap ON e.principal_artist_id = ap.id_artist"
            + "LEFT JOIN person pp ON ap.person_id = pp.id_person"
            + "LEFT JOIN event_invited_artist ei ON ei.event_id = e.id_event"
            + "LEFT JOIN artist ai ON ei.artist_id = ai.id_artist"
            + "LEFT JOIN person pi ON ai.person_id = pi.id_person"
            + "WHERE e.id_event = ?"
            + "GROUP BY t.id_ticket"
            + "ORDER BY e.date_event DESC"),
    SELECT_LOCATION_NOT_FINISHED_CANCELLED("SELECT COUNT(*) AS count FROM event WHERE location_id = ? AND status_event NOT IN ('Finished', 'Cancelled')"),
    SELECT_TICKET_BY_EVENT("SELECT id_ticket, price_ticket, seat_number, zone, description, status_ticket FROM ticket WHERE event_id = ?"),
    SELECT_FINANCE("SELECT id_finance, budget_total, income_total, expenses_total, balance FROM finance WHERE event_id = ?;"),
    SELECT_REVENUE("SELECT r.id_revenue, r.description, r.amount, r.date, r.source FROM revenue r WHERE r.finance_id = ?"),
    SELECT_EXPENSE("SELECT e.id_expense, e.description, e.amount, e.date, e.category FROM expense e WHERE e.finance_id = ?"),
    SELECT_FINANCE_BY_ID_EVENT("SELECT id_finance FROM finance WHERE event_id = ?"),
    SELECT_TICKET("SELECT * FROM ticket WHERE id_ticket = ? AND status = ?"),
    ATTENDANCE("SELECT COUNT(*) FROM ticket WHERE event_id = ? AND status = ?"),
    SELECT_EVENT("SELECT e.id_event AS id_event, e.name AS event_name, e.type AS event_type, e.date_event AS date_event, e.description AS description, e.participants_number as participants_number, e.status_event AS status_event, l.type_location AS type_location, l.name AS location_name, l.id_location AS id_location FROM event e JOIN location l ON e.location_id = l.id_location  WHERE status_event = ?"),
    //SELECT_EVENT("SELECT e.id_event AS id_event, e.name AS name, e.date_event AS date_event, e.description AS description, e.participants_number as participants_number, e.status_event AS status_event, l.type_location AS type_location, l.name AS location_name, l.id_location FROM event e JOIN location l ON e.location_id = l.id_location  WHERE status_event NOT IN ('Cancelled', 'Finished')"),
    SELECT_INVITED_ARTIST("SELECT a.id_artist,a.genre_topic AS genre_topic,a.requirements,a.price_artist,a.availability,a.type_person,a.person_id,p.name FROM artist a INNER JOIN person p ON a.person_id = p.id_person INNER JOIN event_invited_artist eia ON a.id_artist = eia.artist_id WHERE eia.event_id = ?"),
    //    SELECT_INVITED_ARTIST("SELECT a.* FROM event_invited_artist eia JOIN artist a ON a.id_artist = eia.artist_id WHERE eia.event_id = ?")
    SELECT_EVENT_SPECIFIC("SELECT \n"
            + "    t.id_ticket, t.price_ticket, t.seat_number, t.zone, t.description AS ticket_description,\n"
            + "    e.id_event, e.name AS event_name, e.description AS event_description, e.date_event, e.status_event,\n"
            + "    e.duration, e.sponsor, e.type, e.classification, e.participants_number,\n"
            + "    ap.id_artist AS principal_artist_id, pp.name AS principal_artist_name, ap.genre_topic, ap.price_artist, pp.email AS principal_artist_email,\n"
            + "    l.id_location, l.name AS location_name, l.availability, l.address AS location_address, l.city, l.department,\n"
            + "    l.type_location, l.capacity, l.price_location, l.consideration,\n"
            + "    GROUP_CONCAT(DISTINCT pi.name SEPARATOR ', ') AS invited_artists\n"
            + "FROM event e\n"
            + "LEFT JOIN ticket t ON t.event_id = e.id_event\n"
            + "LEFT JOIN location l ON e.location_id = l.id_location\n"
            + "LEFT JOIN artist ap ON e.principal_artist_id = ap.id_artist\n"
            + "LEFT JOIN person pp ON ap.person_id = pp.id_person\n"
            + "LEFT JOIN event_invited_artist ei ON ei.event_id = e.id_event\n"
            + "LEFT JOIN artist ai ON ei.artist_id = ai.id_artist\n"
            + "LEFT JOIN person pi ON ai.person_id = pi.id_person\n"
            + "WHERE e.id_event = ?\n"
            + "GROUP BY e.id_event, t.id_ticket\n"
            + "ORDER BY e.date_event DESC"),
    SELECT_COUNT_MAIN_ARTIST("SELECT COUNT(*) AS count " +
        "FROM event e " +
        "JOIN artist a ON e.principal_artist_id = a.id_artist " +
        "JOIN person p ON a.person_id = p.id_person " +
        "WHERE p.document_number = ? " +
        "AND e.status_event NOT IN ('Finished', 'Cancelled')"),
    SELECT_COUNT_INVIDET_ARTIST("SELECT COUNT(*) AS count " +
        "FROM event_invited_artist ei " +
        "JOIN artist a ON ei.artist_id = a.id_artist " +
        "JOIN person p ON a.person_id = p.id_person " +
        "JOIN event e ON ei.event_id = e.id_event " +
        "WHERE p.document_number = ? " +
        "AND e.status_event NOT IN ('Finished', 'Cancelled')"),
    SELECT_COUNT_LOCATION_OCCUPED("SELECT COUNT(*) AS count FROM event WHERE location_id = ? AND (" +
                  "? BETWEEN date_event AND date_end_event OR " +
                  "? BETWEEN date_event AND date_end_event OR " +
                  "date_event BETWEEN ? AND ? OR " +
                  "date_end_event BETWEEN ? AND ?)"),
    SELECT_FINANCE_ASSIGNED("SELECT COUNT(*) AS count FROM finance WHERE event_id = ?"),
    SELECT_PRINCIPAL_ARTIST_PRICE("SELECT a.price_artist, p.name FROM event e JOIN artist a ON e.principal_artist_id = a.id_artist JOIN person p ON a.person_id = p.id_person WHERE e.id_event = ?"),
    SELECT_INVITED_ARTIST_PRICE("SELECT a.price_artist, p.name FROM event_invited_artist eia JOIN artist a ON eia.artist_id = a.id_artist JOIN person p ON a.person_id = p.id_person WHERE eia.event_id = ?"),
    SELECT_LOCATION_PRICE("SELECT l.price_location, l.name FROM event e JOIN location l ON e.location_id = l.id_location WHERE e.id_event = ?"),
    SELECT_FINANCE_BY_ID("SELECT * FROM finance WHERE id_finance = ?"),
    SELECT_FULL_FINANCE("SELECT id_finance, budget_total, income_total, expenses_total, balance FROM finance WHERE event_id = ?")
    
    ;
    private final String query;

    Select(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
