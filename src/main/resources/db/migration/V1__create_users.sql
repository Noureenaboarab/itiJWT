CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    birthdate DATE,
    job VARCHAR(255),
    credit_no VARCHAR(255),
    credit_limit DECIMAL(19,2),
    phone VARCHAR(50),
    role VARCHAR(50) NOT NULL
);
-- pass
INSERT INTO users (user_id, user_name, email, password, birthdate, job, credit_no, credit_limit, phone, role) VALUES
(
    1,
    'Admin User',
    'admin@ecomus.com',
    '$2a$10$saa4qhi4SMYQzN6P6oUtRO30bnqAmKAFJE8JI06cQoFtYNxGO1Ske',
    '1990-01-01',
    'System Administrator',
    '4111111111111111',
    50000.00,
    '01001234567',
    'ADMIN'
),
(
    2,
    'John Doe',
    'john@ecomus.com',
    '$2a$10$saa4qhi4SMYQzN6P6oUtRO30bnqAmKAFJE8JI06cQoFtYNxGO1Ske',
    '1995-06-15',
    'Software Engineer',
    '4222222222222222',
    10000.00,
    '01012345678',
    'USER'
),
(
    3,
    'Jane Smith',
    'jane@ecomus.com',
    '$2a$10$saa4qhi4SMYQzN6P6oUtRO30bnqAmKAFJE8JI06cQoFtYNxGO1Ske',
    '1998-03-22',
    'Designer',
    '4333333333333333',
    8000.00,
    '01023456789',
    'USER'
),
(
    4,
    'Ahmed Hassan',
    'ahmed@ecomus.com',
    '$2a$10$saa4qhi4SMYQzN6P6oUtRO30bnqAmKAFJE8JI06cQoFtYNxGO1Ske',
    '1992-11-08',
    'Product Manager',
    '4444444444444444',
    15000.00,
    '01034567890',
    'USER'
);