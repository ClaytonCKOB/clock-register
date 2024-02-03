CREATE TABLE credentials(
    id SERIAL PRIMARY KEY NOT NULL UNIQUE,
    id_user INT NOT NULL,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);