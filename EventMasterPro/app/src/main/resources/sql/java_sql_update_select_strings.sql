--UPDATE
String updatePerson = "UPDATE person SET name = ?, email = ?, phone_number = ? WHERE id_person = ?";
String updateCustomer = "UPDATE customer SET birth_date = ? WHERE id_customer = ?";
String updateArtist = "UPDATE artist SET genre = ?, price_artist = ? WHERE id_artist = ?";
String updateSpeaker = "UPDATE speaker SET specialty = ?, topic = ?, price_speaker = ? WHERE id_speaker = ?";
String updateLocation = "UPDATE location SET capacity = ?, price_location = ? WHERE id_location = ?";
String updateEvent = "UPDATE event SET description = ?, sponsor = ? WHERE id_event = ?";
String updateTicket = "UPDATE ticket SET price_ticket = ?, status_ticket = ? WHERE id_ticket = ?";
String updatePayment = "UPDATE payment SET status = ? WHERE id_payment = ?";
String updatePurchase = "UPDATE purchase SET total_amount = ? WHERE id_purchase = ?";
String updateFinance = "UPDATE finance SET income_total = ?, expenses_total = ?, balance = ? WHERE id_finance = ?";
String updateRevenue = "UPDATE revenue SET amount = ?, source = ? WHERE id_revenue = ?";
String updateExpense = "UPDATE expense SET amount = ?, category = ? WHERE id_expense = ?";

--SELECT
String selectPersonByEmail = "SELECT * FROM person WHERE email = ?";
String selectCustomerByBirthYear = "SELECT * FROM customer WHERE birth_date >= ?";
String selectArtistByGenre = "SELECT * FROM artist WHERE genre LIKE ?";
String selectSpeakerBySpecialty = "SELECT * FROM speaker WHERE specialty = ?";
String selectLocationByName = "SELECT * FROM location WHERE name LIKE ?";
String selectEventByType = "SELECT * FROM event WHERE type = ?";
String selectTicketByZone = "SELECT * FROM ticket WHERE zone = ?";
String selectPaymentByStatus = "SELECT * FROM payment WHERE status = ?";
String selectPurchaseByCustomer = "SELECT * FROM purchase WHERE customer_id = ?";
String selectRevenueByDate = "SELECT * FROM revenue WHERE date = ?";
String selectExpenseByCategory = "SELECT * FROM expense WHERE category = ?";
String selectAccountByUser = "SELECT * FROM account WHERE role = ?"