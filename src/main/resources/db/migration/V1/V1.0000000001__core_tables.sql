CREATE TABLE if not exists cars (
id BIGSERIAL PRIMARY KEY,
vin VARCHAR(30) UNIQUE NOT NULL,
auction_name VARCHAR(255),
auction_date DATE,
shipping_ports TEXT,
other_details TEXT
);

CREATE TABLE if not exists users (
id BIGSERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists car_photos (
id BIGSERIAL PRIMARY KEY,
car_id bigint REFERENCES cars (id) ON DELETE CASCADE,
photo_url VARCHAR(255),
uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table if not exists role(
    id bigserial primary key,
    name varchar(255) not null
);

create table if not exists user_role (
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES role(id),
    PRIMARY KEY (user_id, role_id)
);
