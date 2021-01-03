INSERT INTO User (email)
VALUES ('user1@test.com'),
       ('user2@test.com');

INSERT INTO List (label, user_fk)
VALUES ('List1', 1),
       ('List1', 2),
       ('List2', 2);

INSERT INTO Task (label, list_fk)
VALUES ('Task1', 1),
       ('Task2', 1),
       ('Task1', 2),
       ('Task1', 3),
       ('Task2', 3);