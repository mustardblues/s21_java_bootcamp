DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.user(
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.room(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner_id INT NOT NULL,

    FOREIGN KEY (owner_id) REFERENCES chat.user(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS chat.message(
    id SERIAL PRIMARY KEY,
    auhtor_id INT NOT NULL,
    room_id INT NOT NULL,
    text TEXT NOT NULL,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (auhtor_id) REFERENCES chat.user(id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES chat.room(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS chat.roomlist(
    user_id INT NOT NULL,
    room_id INT NOT NULL,

    PRIMARY KEY(user_id, room_id),
    FOREIGN KEY (user_id) REFERENCES chat.user(id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES chat.room(id) ON DELETE CASCADE
);