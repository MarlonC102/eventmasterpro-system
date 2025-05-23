-- Person
MERGE INTO person (document_type, document_number, name, email, phone_number)
KEY (document_number)
VALUES
('CC', '100000001', 'Ana López', 'ana@example.com', '3001112233'),
('CC', '100000002', 'Carlos Gómez', 'carlos@example.com', '3002223344'),
('CC', '100000003', 'Laura Organizadora', 'laura@events.com', '3101234567'),
('CC', '100000004', 'Mario Contador', 'mario@finanzas.com', '3117654321'),
('NIT', '200000000', 'Salomé Terrón', 'lpeinado@izaguirre.com', '3202869376'),
('NIT', '200000001', 'Morat', 'contacto@morat.com', '3217654321'),
('NIT', '200000002', 'Natalia Jiménez', 'natalia@musica.com', '3115551111'),
('NIT', '200000003', 'Sebastián Yatra', 'yatra@latino.com', '3126662222'),
('CC', '100000005', 'Juliana Ríos', 'juliana@speakers.com', '3137773333'),
('CC', '100000006', 'Felipe Torres', 'felipe@conferencias.com', '3148884444');

-- Account
MERGE INTO account (person_id, user_name, password, role)
KEY (person_id)
VALUES
(1,'anadm', 'admpass', 'admin'),
(2,'carcus','cuspass', 'customer'),
(3,'lauor','orgpass', 'organizer'),
(4,'marcon','contpass', 'counter');

-- Customer
MERGE INTO customer (person_id, birth_date)
KEY (person_id)
VALUES
(2, '1990-05-15');

-- Artist
MERGE INTO artist (requirements, genre_topic, price_artist, availability, type_person, person_id)
KEY (person_id)
VALUES
('Micrófono, escenario', 'Rock', 15000000.00, TRUE, TRUE, 5),
('Micrófono, escenario, bajo, guitarra', 'Pop', 25500000.00, TRUE, TRUE, 6),
-- Artistas (type_person = TRUE)
('Micrófono inalámbrico, fondo LED', 'Pop', 26000000.00, TRUE, TRUE, 7),
('Micrófono, orquesta en vivo', 'Balada', 28000000.00, FALSE, TRUE, 8),

-- Speakers (type_person = FALSE)
('Proyector, micrófono, agua', 'Liderazgo', 50000000, FALSE, FALSE, 9),
('Micrófono diadema, laptop', 'Innovación', 90000000, TRUE, FALSE, 10);


-- Organizer
--MERGE INTO organizer (person_id)
--KEY (person_id)
--VALUES
--(1),
--(3);

-- Counter
--MERGE INTO counter (person_id)
--KEY (person_id)
--VALUES
--(4);

-- Location
MERGE INTO location (name, address, capacity, city, department, type_location, status_location, price_location, consideration, person_id)
KEY (name, city)
VALUES
('Movistar Arena', 'Cra. 30 # 63-53', 10000,'Medellín','Antioquia', 'Auditorio', TRUE, 5000.00, 'No cuenta con baños' ,1);

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