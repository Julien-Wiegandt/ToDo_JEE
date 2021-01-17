# MySQL database

### Entity relationship diagram

![diagram](database_entity_relationship_diagram.png)

### Creation file

```sql
DROP TABLE IF EXISTS Task;
DROP TABLE IF EXISTS TaskList;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
                      user_pk int NOT NULL AUTO_INCREMENT,
                      email varchar(255) NOT NULL,
                      password varchar(255) NOT NULL,
                      PRIMARY KEY (user_pk),
                      CONSTRAINT UC_Email_User UNIQUE (email)
);

CREATE TABLE TaskList (
                          tasklist_pk int NOT NULL AUTO_INCREMENT,
                          label varchar(255) NOT NULL,
                          user_fk int NOT NULL,
                          PRIMARY KEY (tasklist_pk),
                          CONSTRAINT FK_User_TaskList FOREIGN KEY (user_fk) REFERENCES User (user_pk)
);

CREATE TABLE Task (
                      task_pk int NOT NULL AUTO_INCREMENT,
                      label varchar(255) NOT NULL,
                      tasklist_fk int NOT NULL,
                      PRIMARY KEY (task_pk),
                      CONSTRAINT FK_TaskList_Task FOREIGN KEY (tasklist_fk) REFERENCES TaskList (tasklist_pk)
);
```

### Insertion file

```sql
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
```