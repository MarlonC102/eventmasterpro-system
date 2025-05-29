CREATE TABLE IF NOT EXISTS person (
    id_person INT AUTO_INCREMENT PRIMARY KEY,
    document_type VARCHAR(10),
    document_number VARCHAR(20) UNIQUE,
    name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(20) UNIQUE,
    status_person BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS account (
    id_account INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    user_name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50),
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS customer (
    id_customer INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    birth_date DATE,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS artist (
    id_artist INT AUTO_INCREMENT PRIMARY KEY,
    requirements TEXT,
    genre_topic VARCHAR(50),
    price_artist DECIMAL(10, 2),
    availability BOOLEAN DEFAULT TRUE,
    type_person BOOLEAN,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS location (
    id_location INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    department VARCHAR(255),
    type_location VARCHAR(255),
    capacity INT,
    availability BOOLEAN DEFAULT TRUE,
    status_location BOOLEAN DEFAULT TRUE,
    price_location DECIMAL(10, 2),
    consideration VARCHAR(255),
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);
--ALTER TABLE event ALTER COLUMN status_event SET DEFAULT 'Created';
--UPDATE event SET status_event = 'Created' WHERE status_event = 'created';
--ALTER TABLE event ADD COLUMN date_end_event TIMESTAMP;
CREATE TABLE IF NOT EXISTS event (
    id_event INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(1000),
    date_event DATETIME,
    date_end_event DATETIME,
    status_event VARCHAR(20) DEFAULT 'Created',
    location_id INT,
    duration TINYINT,
    sponsor VARCHAR(255),
    type VARCHAR(20),
    classification VARCHAR(100),
    participants_number INT,
    principal_artist_id INT,
    person_id INT,
    FOREIGN KEY (location_id) REFERENCES location(id_location),
    FOREIGN KEY (person_id) REFERENCES person(id_person),
    FOREIGN KEY (principal_artist_id) REFERENCES artist(id_artist)
);

CREATE TABLE IF NOT EXISTS event_invited_artist (
    event_id INT,
    artist_id INT,
    PRIMARY KEY (event_id, artist_id),
    FOREIGN KEY (event_id) REFERENCES event(id_event),
    FOREIGN KEY (artist_id) REFERENCES artist(id_artist)
);

CREATE TABLE IF NOT EXISTS ticket (
    id_ticket INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20),
    description VARCHAR(1000),
    price_ticket DECIMAL(10, 2),
    status_ticket VARCHAR(20),
    seat_number INT,
    zone VARCHAR(20),
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES event(id_event)
);

CREATE TABLE IF NOT EXISTS ticket_detail (
    id_ticket_detail INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT,
    customer_id INT,
    uuid CHAR(36) NOT NULL UNIQUE,
    status VARCHAR(20) DEFAULT 'Sold',
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket),
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer)
);

CREATE TABLE IF NOT EXISTS history (
    id_history INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    ticket_id INT,
    customer_id INT,
    purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    price_paid DECIMAL(10,2),
    FOREIGN KEY (event_id) REFERENCES event(id_event),
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket),
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer)
);

CREATE TABLE IF NOT EXISTS finance (
    id_finance INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    event_id INT,
    budget_total DECIMAL(10, 2),
    income_total DECIMAL(10, 2) DEFAULT 0.00,
    expenses_total DECIMAL(10, 2) DEFAULT 0.00,
    balance DECIMAL(10, 2) DEFAULT 0.00,
    status VARCHAR(20) DEFAULT 'active',
    FOREIGN KEY (person_id) REFERENCES person(id_person),
    FOREIGN KEY (event_id) REFERENCES event(id_event)
);

CREATE TABLE IF NOT EXISTS revenue (
    id_revenue INT AUTO_INCREMENT PRIMARY KEY,
    finance_id INT,
    description VARCHAR(255),
    amount DECIMAL(10, 2),
    date DATE,
    source VARCHAR(100),
    FOREIGN KEY (finance_id) REFERENCES finance(id_finance)
);

CREATE TABLE IF NOT EXISTS expense (
    id_expense INT AUTO_INCREMENT PRIMARY KEY,
    finance_id INT,
    description VARCHAR(255),
    amount DECIMAL(10, 2),
    date DATE,
    category VARCHAR(100),
    FOREIGN KEY (finance_id) REFERENCES finance(id_finance)
);

CREATE TABLE IF NOT EXISTS attendance (
    id_attendance INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT,
    check_in_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ticket_id) REFERENCES ticket(id_ticket)
);

--ALTER TABLE finance ALTER COLUMN id_finance RESTART WITH 1;
--ALTER TABLE finance ALTER COLUMN id_finance INT AUTO_INCREMENT;