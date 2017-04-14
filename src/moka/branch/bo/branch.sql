CREATE TABLE moka.branch
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    lineId INT,
    title VARCHAR(255),
    introduce VARCHAR(255),
    url VARCHAR(255),
    lng VARCHAR(255),
    lat VARCHAR(255),
    createDate DATETIME
);