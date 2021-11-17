set datestyle to 'european';

DROP TABLE IF EXISTS address, city, country, customer, inventory, payment, rental, staff, store;

CREATE TABLE country (
  country_id SMALLINT  NOT NULL,
  country VARCHAR(50) NOT NULL
);

CREATE TABLE city (
  city_id SMALLINT  NOT NULL,
  city VARCHAR(50) NOT NULL,
  country_id SMALLINT  NOT NULL
);


CREATE TABLE address (
  address_id SMALLINT  NOT NULL,
  address VARCHAR(50) NOT NULL,
  address2 VARCHAR(50) DEFAULT NULL,
  district VARCHAR(20) NOT NULL,
  city_id SMALLINT  NOT NULL,
  postal_code VARCHAR(10) DEFAULT NULL,
  phone VARCHAR(20) NOT NULL
);

CREATE TABLE staff (
  staff_id SMALLINT  NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  address_id SMALLINT  NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  store_id SMALLINT  NOT NULL,
  active SMALLINT NOT NULL DEFAULT 1,
  username VARCHAR(16) NOT NULL,
  password VARCHAR(40) DEFAULT NULL
);

CREATE TABLE store (
  store_id SMALLINT  NOT NULL,
  manager_staff_id SMALLINT  NOT NULL,
  address_id SMALLINT  NOT NULL
);

CREATE TABLE customer (
  customer_id SMALLINT  NOT NULL,
  store_id SMALLINT  NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  address_id SMALLINT  NOT NULL,
  active SMALLINT NOT NULL DEFAULT 1,
  create_date TIMESTAMP NOT NULL
);

CREATE TABLE inventory (
  inventory_id INTEGER  NOT NULL,
  film_id SMALLINT  NOT NULL,
  store_id SMALLINT  NOT NULL
);

CREATE TABLE payment (
  payment_id SMALLINT  NOT NULL,
  customer_id SMALLINT  NOT NULL,
  staff_id SMALLINT  NOT NULL,
  rental_id INT DEFAULT NULL,
  amount DECIMAL(5,2) NOT NULL,
  payment_date TIMESTAMP NOT NULL
);

CREATE TABLE rental (
  rental_id INT NOT NULL,
  rental_date TIMESTAMP NOT NULL,
  inventory_id INTEGER  NOT NULL,
  customer_id SMALLINT  NOT NULL,
  return_date TIMESTAMP,
  staff_id SMALLINT  NOT NULL
);