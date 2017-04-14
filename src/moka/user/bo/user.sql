CREATE TABLE moka.user
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userDetailId INT,
    password VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    nickName VARCHAR(255)
);