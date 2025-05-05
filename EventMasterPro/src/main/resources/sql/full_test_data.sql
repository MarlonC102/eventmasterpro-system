-- Person
MERGE INTO person (document_type, document_number, name, email, phone_number)
KEY (document_number)
VALUES
('CC', '100000001', 'Ana López', 'ana@example.com', '3001112233'),
('CC', '100000002', 'Carlos Gómez', 'carlos@example.com', '3002223344'),
('CC', '100000003', 'Laura Organizadora', 'laura@events.com', '3101234567'),
('CC', '100000004', 'Mario Contador', 'mario@finanzas.com', '3117654321');

-- Account
MERGE INTO account (person_id, password, role)
KEY (person_id)
VALUES
(1, 'pass123', 'admin'),
(2, 'pass456', 'customer'),
(3, 'orgpass', 'organizer'),
(4, 'contpass', 'counter');

-- Customer
MERGE INTO customer (person_id, birth_date)
KEY (person_id)
VALUES
(2, '1990-05-15');

-- Artist
MERGE INTO artist (requirements, genre, price_artist, person_id)
KEY (person_id)
VALUES
('Micrófono, escenario', 'Rock', 1500.00, 2);

-- Organizer
MERGE INTO organizer (person_id)
KEY (person_id)
VALUES
(1),
(3);

-- Counter
MERGE INTO counter (person_id)
KEY (person_id)
VALUES
(4);

-- Location
--MERGE INTO location (name, address, capacity, city, type, status_location, price_location, person_id)
--KEY (name, city)
--VALUES
--('Movistar Arena', 'Cra. 30 # 63-53', 10000,'Medellín', 'Auditorio', TRUE, 5000.00, 1);

-- Event
--INSERT INTO event (
--    name, description, date_event, time_event, status_event,
--    location_id, duration, sponsor, type, classification,
--    participants_number, person_id, invited_artist_id, organizer_id
--)
--VALUES (
--    'Concierto Rock Fest', 'Festival de rock con bandas invitadas',
--    '2025-08-10', '19:00:00', TRUE, 1, 3, 'Red Bull', 'Concert',
--    'All Ages', 1000, 1, 1, 1
--);

-- Ticket
--INSERT INTO ticket (type, description, price_ticket, status_ticket, seat_number, zone, customer_id, event_id) VALUES
--('VIP', 'Asiento preferencial', 120.00, TRUE, 101, 'A', 1, 1);

-- Payment method
--INSERT INTO payment_method (type, provider, last_four_digits) VALUES
--('CreditCard', 'Visa', '1234');

-- Payment
--INSERT INTO payment (amount, status, payment_method_id) VALUES
--(120.00, 'completed', 1);

-- Purchase
--INSERT INTO purchase (customer_id, payment_id, total_amount) VALUES
--(1, 1, 120.00);

-- Finance
--INSERT INTO finance (counter_id, event_id, budget_total, income_total, expenses_total, balance, status) VALUES
--(1, 1, 2000.00, 120.00, 500.00, 1620.00, 'active');

-- Revenue
--INSERT INTO revenue (finance_id, description, amount, date, source) VALUES
--(1, 'Venta de entradas', 120.00, '2025-08-10', 'Taquilla');

-- Expense
--INSERT INTO expense (finance_id, description, amount, date, category) VALUES
--(1, 'Alquiler de sonido', 500.00, '2025-08-08', 'Logística');