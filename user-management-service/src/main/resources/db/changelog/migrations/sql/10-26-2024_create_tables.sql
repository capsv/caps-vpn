CREATE TABLE IF NOT EXISTS person
(
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR(255),
    last_name           VARCHAR(255),
    email               VARCHAR(255) UNIQUE NOT NULL,
    phone_number        VARCHAR(20),
    avatar_url          VARCHAR(255),

    password_hash       VARCHAR(255)        NOT NULL,
    salt                VARCHAR(255),
    is_2fa_enabled      BOOLEAN     DEFAULT FALSE,
    two_factor_secret   VARCHAR(255),
    last_login          TIMESTAMPTZ,

    subscription_plan   VARCHAR(100),
    subscription_start  TIMESTAMPTZ,
    subscription_end    TIMESTAMPTZ,

    language            VARCHAR(10) DEFAULT 'en',
    timezone            VARCHAR(50) DEFAULT 'UTC',
    email_notifications BOOLEAN     DEFAULT FALSE,
    push_notifications  BOOLEAN     DEFAULT FALSE,

    is_active           BOOLEAN     DEFAULT TRUE,
    is_deleted          BOOLEAN     DEFAULT FALSE,
    created_date        TIMESTAMPTZ,
    updated_date        TIMESTAMPTZ
);

CREATE TABLE device
(
    id               SERIAL PRIMARY KEY,
    user_id          INT REFERENCES person (id) ON DELETE CASCADE,
    device_id        VARCHAR(255) UNIQUE NOT NULL,
    device_type      VARCHAR(100),
    device_name      VARCHAR(255),
    operating_system VARCHAR(100),
    app_version      VARCHAR(50),

    ip_address       VARCHAR(45),
    last_connection  TIMESTAMPTZ,
    is_active        BOOLEAN     DEFAULT FALSE,

    registered_date  TIMESTAMPTZ,
    is_trusted       BOOLEAN     DEFAULT FALSE
);

CREATE INDEX idx_person_email ON person(email);
CREATE INDEX idx_device_user_id ON device(user_id);
CREATE INDEX idx_device_last_connection ON device(last_connection);