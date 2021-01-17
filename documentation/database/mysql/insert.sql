INSERT INTO User (user_pk, email, password)
VALUES (null, 'user1@test.com', 'psd'),
       (null, 'user2@test.com', 'psd');

INSERT INTO TaskList (tasklist_pk, label, user_fk)
VALUES (null, 'List1', 1),
       (null, 'List1', 2),
       (null, 'List2', 2);

INSERT INTO Task (task_pk, label, tasklist_fk)
VALUES (null, 'Task1', 1),
       (null, 'Task2', 1),
       (null, 'Task1', 2),
       (null, 'Task1', 3),
       (null, 'Task2', 3);