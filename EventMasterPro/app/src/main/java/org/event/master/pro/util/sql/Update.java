package org.event.master.pro.util.sql;

public enum Update {
    UPDATE_ARTIST_P1("UPDATE artist SET  requirements = ?, price_artist = ?, genre_topic = ? WHERE person_id = (SELECT id_person FROM person WHERE document_number = ?)"),
    UPDATE_ARTIST_P2("UPDATE person SET name = ?, email = ?, phone_number = ? WHERE document_number = ?"),
    UPDATE_LOCATION("UPDATE location SET name = ?, address = ?, city = ?, department = ?, type_location = ?, capacity = ?, price_location = ?, consideration = ? WHERE id_location = ?"),
    UPDATE_EVENT("UPDATE event SET name = ?, description = ?, duration = ?, sponsor = ?, classification = ?, date_event = ? WHERE id_event = ?"),
    CHANGE_STATUS_ARTIST("UPDATE person  SET status_person = ? WHERE id_person = ( SELECT a.person_id FROM artist a JOIN person p ON a.person_id = p.id_person WHERE p.document_number = ?)"),
    CHANGE_STATUS_LOCATION("UPDATE location SET status_location = ? WHERE id_location = ?"),
    CHANGE_STATIS_TICKET("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    SELL_TICKET("UPDATE ticket SET status = 'SOLD' WHERE id_ticket = ?"),
    ADD_MOVEMENTS("UPDATE finance SET income_total = ?, expenses_total = ?, balance = ? WHERE id_finance = ?"),
    CHANGE_STATUS_TICKET("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    TICKET_USED("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    UPDATE_EVENT_STATUS("UPDATE event SET status_event = ? WHERE id_event = ?"),
    CANCEL_FINANCE_STATUS("UPDATE finance SET balance = 0, income_total = 0 WHERE id_finance = ?"),
    UPDATE_FINANCE("UPDATE finance SET budget_total = ? WHERE event_id = ?"),
    UPDATE_EXPENSES_TOTAL("UPDATE finance SET expenses_total = expenses_total + ?, balance = budget_total - (expenses_total + ?) WHERE id_finance = ?"),
    UPDATE_FINANCE_BALANCE("UPDATE finance SET balance = ? WHERE id_finance = ?"),
    UPDATE_FINANCE_TOTALS("UPDATE finance SET income_total = ?, balance = ? WHERE id_finance = ?"),
    UPDATE_FINANCE_TOTALS_EXPENSE("UPDATE finance SET expenses_total = ?, balance = ? WHERE id_finance = ?");

    private final String query;

    Update(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
