INSERT INTO User (user_pk, email, password) VALUES (null, 'user1@test.com', 'psd');
INSERT INTO User (user_pk, email, password) VALUES (null, 'user2@test.com', 'psd');

INSERT INTO TaskList (tasklist_pk, label, user_fk) VALUES (null, 'List1', 1);
INSERT INTO TaskList (tasklist_pk, label, user_fk) VALUES (null, 'List1', 2);
INSERT INTO TaskList (tasklist_pk, label, user_fk) VALUES (null, 'List2', 2);

INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, 'Task1', 1);
INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, 'Task2', 1);
INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, 'Task1', 2);
INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, 'Task1', 3);
INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, 'Task2', 3);