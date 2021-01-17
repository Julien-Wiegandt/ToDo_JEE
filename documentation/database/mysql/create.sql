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

CREATE TABLE Task (
    task_pk int NOT NULL AUTO_INCREMENT,
    label varchar(255) NOT NULL,
    list_fk int NOT NULL,
    PRIMARY KEY (task_pk),
    CONSTRAINT FK_TaskList_Task FOREIGN KEY (list_fk) REFERENCES TaskList (list_pk)
);

CREATE TABLE TaskList (
    tasklist_pk int NOT NULL AUTO_INCREMENT,
    label varchar(255) NOT NULL,
    user_fk int NOT NULL,
    PRIMARY KEY (tasklist_pk),
    CONSTRAINT FK_User_TaskList FOREIGN KEY (user_fk) REFERENCES User (user_pk)
  );