DROP TABLE IF EXISTS Task;
DROP TABLE IF EXISTS List;
DROP TABLE IF EXISTS Account;

CREATE TABLE Account (
    account_pk int NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    PRIMARY KEY (account_pk),
    CONSTRAINT UC_Email_Account UNIQUE (email)
);

CREATE TABLE List (
    list_pk int NOT NULL AUTO_INCREMENT,
    label varchar(255) NOT NULL,
    account_fk int NOT NULL,
    PRIMARY KEY (list_pk),
    CONSTRAINT FK_Account_List FOREIGN KEY (account_fk) REFERENCES Account (account_pk)
);

CREATE TABLE Task (
    task_pk int NOT NULL AUTO_INCREMENT,
    label varchar(255) NOT NULL,
    list_fk int NOT NULL,
    PRIMARY KEY (task_pk),
    CONSTRAINT FK_List_Task FOREIGN KEY (list_fk) REFERENCES List (list_pk)
);