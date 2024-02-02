CREATE TABLE user(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE clock_interval(
    id SERIAL PRIMARY KEY,
    start timestamp,
    end timestamp
);