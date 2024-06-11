CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);
CREATE TABLE clock_interval(
    id SERIAL PRIMARY KEY,
    id_user INT,
    start_date date,
    start_time time,
    end_date date,
    end_time time
);
