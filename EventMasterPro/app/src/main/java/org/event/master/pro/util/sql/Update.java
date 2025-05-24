package org.event.master.pro.util.sql;

public enum Update {
    //UPDATE_PERSON("UPDATE person SET name = ?, email = ?, phone_number = ? WHERE id_person = ?"),
    //UPDATE_CUSTOMER("UPDATE customer SET birth_date = ? WHERE id_customer = ?"),
    UPDATE_ARTIST_P1("UPDATE artist SET  requirements = ?, price_artist = ?, genre_topic = ? WHERE person_id = (SELECT id_person FROM person WHERE document_number = ?)"),
    UPDATE_ARTIST_P2("UPDATE person SET name = ?, email = ?, phone_number = ? WHERE document_number = ?"),
    //UPDATE_SPEAKER("UPDATE speaker SET specialty = ?, topic = ?, price_speaker = ? WHERE id_speaker = ?"),
    UPDATE_LOCATION("UPDATE location SET name = ?, address = ?, city = ?, department = ?, type_location = ?, capacity = ?, price_location = ?, consideration = ? WHERE id_location = ?"),
    UPDATE_EVENT("UPDATE event SET description = ?, sponsor = ? WHERE id_event = ?"),
    //UPDATE_TICKET("UPDATE ticket SET price_ticket = ?, status_ticket = ? WHERE id_ticket = ?"),
    //UPDATE_PAYMENT("UPDATE payment SET status = ? WHERE id_payment = ?"),
    //UPDATE_PURCHASE("UPDATE purchase SET total_amount = ? WHERE id_purchase = ?"),
    //UPDATE_FINANCE("UPDATE finance SET income_total = ?, expenses_total = ?, balance = ? WHERE id_finance = ?"),
    //UPDATE_REVENUE("UPDATE revenue SET amount = ?, source = ? WHERE id_revenue = ?"),
    //UPDATE_EXPENSE("UPDATE expense SET amount = ?, category = ? WHERE id_expense = ?"),
    CHANGE_STATUS_ARTIST("UPDATE person  SET status_person = ? WHERE id_person = ( SELECT a.person_id FROM artist a JOIN person p ON a.person_id = p.id_person WHERE p.document_number = ?)"),
    CHANGE_STATUS_LOCATION("UPDATE location SET status_location = ? WHERE id_location = ?"),
    CHANGE_STATIS_TICKET("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    SELL_TICKET("UPDATE ticket SET status = 'SOLD' WHERE id_ticket = ?"),
    ADD_MOVEMENTS("UPDATE finance SET income_total = ?, expenses_total = ?, balance = ? WHERE id_finance = ?"),
    CHANGE_STATUS_TICKET("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    TICKET_USED("UPDATE ticket SET status = ? WHERE id_ticket = ?"),
    UPDATE_EVENT_STATUS("UPDATE event SET status_event = ? WHERE id_event = ?"),
    CANCEL_FINANCE_STATUS("UPDATE finance SET balance = 0, income_total = 0 WHERE id_finance = ?\"")
    ;
    

    private final String query;

    Update(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
