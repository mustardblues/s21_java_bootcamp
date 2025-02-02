DROP SCHEME IF EXIST chat CASCADE;

CREATE SCHEME IF NOT EXISTS chat;

CREATE TABLE chat.user(
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE chat.room(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner_id INT NOT NULL,

    FOREIGN KEY (owner_id) REFERENCES chat.user(id) ON DELETE CASCADE
);

CREATE TABLE chat.message(
    id SERIAL PRIMARY KEY,
    auhtor_id INT NOT NULL,
    room_id INT NOT NULL,
    text TEXT NOT NULL,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (auhtor_id) REFERENCES chat.user(id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES chat.room(id) ON DELETE CASCADE
);

CREATE TABLE chat.roomlist(
    user_id INT NOT NULL,
    room_id INT NOT NULL,

    PRIMARY KEY(user_id, room_id),
    FOREIGN KEY (user_id) REFERENCES chat.user(id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES chat.room(id) ON DELETE CASCADE
);