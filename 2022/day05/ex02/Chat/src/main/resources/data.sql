INSERT INTO chat.user (login, password) VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3'),
('user4', 'password4'),
('user5', 'password5');

INSERT INTO chat.room (name, owner_id) VALUES
('chatroom1', 1),
('chatroom2', 2),
('chatroom3', 3),
('chatroom4', 4),
('chatroom5', 5);

INSERT INTO chat.message (auhtor_id, room_id, text) VALUES
(1, 1, 'Message from user1 in room 1'),
(2, 1, 'Message from user2 in room 1'),
(3, 3, 'Message from user3 in room 3'),
(1, 2, 'Message from user1 in room 2'),
(4, 5, 'Message from user4 in room 5'),
(5, 4, 'Message from user5 in room 4');

INSERT INTO chat.roomlist (user_id, room_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(2, 1),
(1, 2),
(4, 5),
(5, 4);