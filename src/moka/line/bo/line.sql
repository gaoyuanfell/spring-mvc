CREATE TABLE moka.line
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userId INT,
    title VARCHAR(255),
    introduce VARCHAR(255),
    createDate DATETIME
);