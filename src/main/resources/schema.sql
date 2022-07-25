CREATE TABLE clients(
 id SERIAL PRIMARY KEY,
 name VARCHAR (255),
 phone VARCHAR (255),
 address VARCHAR (255),
 email VARCHAR (255),
 status VARCHAR (30)
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY ,
    name VARCHAR (255),
    phone VARCHAR (255),
    email VARCHAR (255),
    role VARCHAR (30)
);

INSERT INTO users(name, phone, email, role)
VALUES ('superAdmin', '89000000000', 'email@smth.ru', 'ADMIN');

CREATE TABLE photos(
    id SERIAL PRIMARY KEY,
    originalName VARCHAR (255),
    mimeType VARCHAR (255),
    description VARCHAR (255),
    uploadDateTime date,
    storageName VARCHAR (255),
    size INTEGER
);

CREATE TABLE products(
    id SERIAL PRIMARY KEY,
    name VARCHAR (255),
    photo_id BIGINT,
    status VARCHAR (30),
    needs INTEGER,
    reserved INTEGER,
    FOREIGN KEY (photo_id) REFERENCES photos(id)
);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    client_id BIGINT,
    address VARCHAR (255),
    date DATE,
    status VARCHAR(30),
    price DECIMAL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE products_in_order(
    id SERIAL PRIMARY KEY,
    product_id BIGINT,
    number INTEGER,
    order_id BIGINT,
    reserved INTEGER,
    needs INTEGER,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE balance(
    id SERIAL PRIMARY KEY,
    product_id BIGINT,
    number INTEGER,
    photo_id BIGINT,
    reserved INTEGER,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (photo_id) REFERENCES photos(id)
);

CREATE TABLE offers_amount(
    id SERIAL PRIMARY KEY,
    type varchar (30),
    amount_part DECIMAL,
    order_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);