package org.event.master.pro.util.sql;

public enum Update {
    UPDATE_PERSON("UPDATE person SET name = ?, email = ?, phone_number = ? WHERE id_person = ?"),
    UPDATE_CUSTOMER("UPDATE customer SET birth_date = ? WHERE id_customer = ?"),
    UPDATE_ARTIST("UPDATE artist SET genre = ?, price_artist = ? WHERE id_artist = ?"),
    UPDATE_SPEAKER("UPDATE speaker SET specialty = ?, topic = ?, price_speaker = ? WHERE id_speaker = ?"),
    UPDATE_LOCATION("UPDATE location SET capacity = ?, price_location = ? WHERE id_location = ?"),
    UPDATE_EVENT("UPDATE event SET description = ?, sponsor = ? WHERE id_event = ?"),
    UPDATE_TICKET("UPDATE ticket SET price_ticket = ?, status_ticket = ? WHERE id_ticket = ?"),
    UPDATE_PAYMENT("UPDATE payment SET status = ? WHERE id_payment = ?"),
    UPDATE_PURCHASE("UPDATE purchase SET total_amount = ? WHERE id_purchase = ?"),
    UPDATE_FINANCE("UPDATE finance SET income_total = ?, expenses_total = ?, balance = ? WHERE id_finance = ?"),
    UPDATE_REVENUE("UPDATE revenue SET amount = ?, source = ? WHERE id_revenue = ?"),
    UPDATE_EXPENSE("UPDATE expense SET amount = ?, category = ? WHERE id_expense = ?");

    private final String query;

    Update(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
