CREATE TABLE IF NOT EXISTS person (
    id_person INT AUTO_INCREMENT PRIMARY KEY,
    document_type VARCHAR(10) NOT NULL,
    document_number VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    status_person BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS account (
    id_account INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS customer (
    id_customer INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    birth_date DATE NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS artist (
    id_artist INT AUTO_INCREMENT PRIMARY KEY,
    requirements TEXT NOT NULL,
    genre_topic VARCHAR(50) NOT NULL,
    price_artist DECIMAL(10, 2) NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    type_person BOOLEAN,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS location (
    id_location INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    type_location VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    status_location BOOLEAN DEFAULT TRUE,
    price_location DECIMAL(10, 2) NOT NULL,
    consideration VARCHAR(255),
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);
--ALTER TABLE event ALTER COLUMN status_event SET DEFAULT 'Created';
--UPDATE event SET status_event = 'Created' WHERE status_event = 'created';
CREATE TABLE IF NOT EXISTS event (
    id_event INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    date_event DATETIME NOT NULL,
    status_event VARCHAR(20) DEFAULT 'Created',
    location_id INT NOT NULL,
    duration TINYINT NOT NULL,
    sponsor VARCHAR(255) NOT NULL,
    type VARCHAR(20) NOT NULL,
    classification VARCHAR(100) NOT NULL,
    participants_number INT NOT NULL,
    principal_artist_id INT NOT NULL,
    person_id INT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location(id_location),
    FOREIGN KEY (person_id) REFERENCES person(id_person),
    FOREIGN KEY (principal_artist_id) REFERENCES artist(id_artist)
);

CREATE TABLE IF NOT EXISTS event_invited_artist (
    event_id INT NOT NULL,
    artist_id INT NOT NULL,
    PRIMARY KEY (event_id, artist_id),
    FOREIGN KEY (event_id) REFERENCES event(id_event),
    FOREIGN KEY (artist_id) REFERENCES artist(id_artist)
);



--ALTER TABLE ticket DROP FOREIGN KEY customer;
--ALTER TABLE ticket DROP COLUMN type;
--ALTER TABLE ticket ALTER COLUMN status_ticket VARCHAR(20) NOT NULL;
CREATE TABLE IF NOT EXISTS ticket (
    id_ticket INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price_ticket DECIMAL(10, 2) NOT NULL,
    status_ticket VARCHAR(20) NOT NULL,
    seat_number INT NOT NULL,
    zone VARCHAR(20) NOT NULL,
    event_id INT NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event(id_event)
);

CREATE TABLE IF NOT EXISTS ticket_detail (
    id_ticket_detail INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket),
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer)
);

CREATE TABLE IF NOT EXISTS history (
    id_history INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    ticket_id INT NOT NULL,
    customer_id INT NOT NULL,
    purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    price_paid DECIMAL(10,2),
    FOREIGN KEY (event_id) REFERENCES event(id_event),
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket),
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer)
);

CREATE TABLE IF NOT EXISTS payment_method (
    id_payment_method INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    provider VARCHAR(50),
    last_four_digits CHAR(4)
);

CREATE TABLE IF NOT EXISTS payment (
    id_payment INT AUTO_INCREMENT PRIMARY KEY,
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'in progress',
    payment_method_id INT NOT NULL,
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method)
);

CREATE TABLE IF NOT EXISTS purchase (
    id_purchase INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    payment_id INT NOT NULL,
    purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer),
    FOREIGN KEY (payment_id) REFERENCES payment(id_payment)
);

CREATE TABLE IF NOT EXISTS finance (
    id_finance INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    event_id INT NOT NULL,
    budget_total DECIMAL(10, 2) NOT NULL,
    income_total DECIMAL(10, 2) DEFAULT 0.00,
    expenses_total DECIMAL(10, 2) DEFAULT 0.00,
    balance DECIMAL(10, 2) DEFAULT 0.00,
    status VARCHAR(20) DEFAULT 'active',
    FOREIGN KEY (person_id) REFERENCES person(id_person),
    FOREIGN KEY (event_id) REFERENCES event(id_event)
);

CREATE TABLE IF NOT EXISTS revenue (
    id_revenue INT AUTO_INCREMENT PRIMARY KEY,
    finance_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    source VARCHAR(100),
    FOREIGN KEY (finance_id) REFERENCES finance(id_finance)
);

CREATE TABLE IF NOT EXISTS expense (
    id_expense INT AUTO_INCREMENT PRIMARY KEY,
    finance_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    category VARCHAR(100),
    FOREIGN KEY (finance_id) REFERENCES finance(id_finance)
);

CREATE TABLE IF NOT EXISTS attendance (
    id_attendance INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT NOT NULL,
    check_in_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket)
);


--ALTER TABLE event ALTER COLUMN classification VARCHAR(100) NOT NULL;
