--INSERT

String insertPerson = "INSERT INTO person (document_type, document_number, name, email, phone_number) VALUES (?, ?, ?, ?, ?)";
String insertAccount = "INSERT INTO account (person_id, password, role) VALUES (?, ?, ?)";
String insertCustomer = "INSERT INTO customer (person_id, birth_date) VALUES (?, ?)";
String insertArtist = "INSERT INTO artist (requirements, genre, price_artist, person_id) VALUES (?, ?, ?, ?)";
String insertSpeaker = "INSERT INTO speaker (specialty, topic, requirements, price_speaker, person_id) VALUES (?, ?, ?, ?, ?)";
String insertAdmin = "INSERT INTO admin (person_id) VALUES (?)";
String insertOrganizer = "INSERT INTO organizer (person_id) VALUES (?)";
String insertCounter = "INSERT INTO counter (person_id) VALUES (?)";
String insertLocation = "INSERT INTO location (name, address, capacity, type, status_location, price_location, person_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
String insertEvent = "INSERT INTO event (name, description, date_event, time_event, status_event, location_id, duration, sponsor, type, classification, participants_number, person_id, invited_artist_id, organizer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
String insertTicket = "INSERT INTO ticket (type, description, price_ticket, status_ticket, seat_number, zone, customer_id, event_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
String insertPaymentMethod = "INSERT INTO payment_method (type, provider, last_four_digits) VALUES (?, ?, ?)";
String insertPayment = "INSERT INTO payment (amount, status, payment_method_id) VALUES (?, ?, ?)";
String insertPurchase = "INSERT INTO purchase (customer_id, payment_id, total_amount) VALUES (?, ?, ?)";
String insertFinance = "INSERT INTO finance (counter_id, event_id, budget_total, income_total, expenses_total, balance, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
String insertRevenue = "INSERT INTO revenue (finance_id, description, amount, date, source) VALUES (?, ?, ?, ?, ?)";
String insertExpense = "INSERT INTO expense (finance_id, description, amount, date, category) VALUES (?, ?, ?, ?, ?)";