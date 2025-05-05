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
    genre VARCHAR(50) NOT NULL,
    price_artist DECIMAL(10, 2) NOT NULL,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS speaker (
    id_speaker INT AUTO_INCREMENT PRIMARY KEY,
    specialty VARCHAR(50) NOT NULL,
    topic TEXT NOT NULL,
    requirements TEXT NOT NULL,
    price_speaker DECIMAL(10, 2) NOT NULL,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS admin (
    id_admin INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS organizer (
    id_organizer INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS counter (
    id_counter INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS location (
    id_location INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    status_location BOOLEAN DEFAULT TRUE,
    price_location DECIMAL(10, 2) NOT NULL,
    person_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id_person)
);

CREATE TABLE IF NOT EXISTS event (
    id_event INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    date_event DATE NOT NULL,
    time_event TIME NOT NULL,
    status_event BOOLEAN DEFAULT TRUE,
    location_id INT NOT NULL,
    duration TINYINT NOT NULL,
    sponsor VARCHAR(255) NOT NULL,
    type VARCHAR(20) NOT NULL,
    classification VARCHAR(20) NOT NULL,
    participants_number INT NOT NULL,
    person_id INT NOT NULL,
    invited_artist_id INT NOT NULL,
    organizer_id INT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location(id_location),
    FOREIGN KEY (person_id) REFERENCES person(id_person),
    FOREIGN KEY (invited_artist_id) REFERENCES artist(id_artist),
    FOREIGN KEY (organizer_id) REFERENCES organizer(id_organizer)
);

CREATE TABLE IF NOT EXISTS ticket (
    id_ticket INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price_ticket DECIMAL(10, 2) NOT NULL,
    status_ticket BOOLEAN DEFAULT TRUE,
    seat_number INT NOT NULL,
    zone VARCHAR(20) NOT NULL,
    customer_id INT NOT NULL,
    event_id INT NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event(id_event),
    FOREIGN KEY (customer_id) REFERENCES customer(id_customer)
);

CREATE TABLE IF NOT EXISTS history (
    id_history INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    ticket_id INT NOT NULL,
    customer_id INT NOT NULL,
    purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'completed',
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
    status VARCHAR(20) DEFAULT 'completed',
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
    counter_id INT NOT NULL,
    event_id INT NOT NULL,
    budget_total DECIMAL(10, 2) NOT NULL,
    income_total DECIMAL(10, 2) DEFAULT 0.00,
    expenses_total DECIMAL(10, 2) DEFAULT 0.00,
    balance DECIMAL(10, 2) DEFAULT 0.00,
    status VARCHAR(20) DEFAULT 'active',
    FOREIGN KEY (counter_id) REFERENCES counter(id_counter),
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