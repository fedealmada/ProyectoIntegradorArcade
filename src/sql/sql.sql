DROP DATABASE IF EXISTS arcade; 

CREATE DATABASE arcade;

use arcade;

CREATE TABLE users (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(24) NOT NULL,
    password VARCHAR(64) NOT NULL,
    answer VARCHAR(64) NOT NULL,
    question INT(2) NOT NULL,
    registrationDate DATETIME,
    lastLoginDate DATETIME,
    scorePacman INT(11) NOT NULL DEFAULT 0,
    scoreTateti INT(11) NOT NULL DEFAULT 0,
    scoreTetris INT(11) NOT NULL DEFAULT 0,
    scoreAtari INT(11) NOT NULL DEFAULT 0,
    logged INT(2) NOT NULL DEFAULT 0,
    coins INT(11) NOT NULL DEFAULT 0
 );  
 
DESCRIBE users;

CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    type VARCHAR(15) NOT NULL,
    price INT NOT NULL 
);
                  
DESCRIBE items;                  

CREATE TABLE  sales (
    id INT auto_increment PRIMARY KEY,
    users_id INT(11) NOT NULL,
    items_id INT NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (items_id) REFERENCES items(id)
); 
 
 DESCRIBE sales;


INSERT INTO items 
(name, type, price) VALUES 
    ('Caja de Guaymallen x40', 'comidas', 12),
    ('Medialunas x60', 'comidas', 30),
    ('M&M 1Kg', 'comidas', 25),
    ('Manzana mordida', 'comidas', 25), 

    ('Secco Cola 2L x4', 'bebidas', 4),
    ('Manaos Uva 2L x6', 'bebidas', 12),

    ('Play Station 5', 'electronicos', 500),
    ('PC Gamer', 'electronicos', 1400),
    ('Dron', 'electronicos', 250),
    ('Silla Gamer', 'electronicos', 125),
    
    ('Fifa 25 por 24h', 'servicios', 7),
    ('The Last of Us por 24h', 'servicios', 8),
    ('Sparking Zero por 24h', 'servicios', 9),
    ('Goat Simulator por 48h', 'servicios', 5);

