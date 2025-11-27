-- MySQL schema for CafeShopManagementSystem

CREATE DATABASE IF NOT EXISTS javafxdb;
USE javafxdb;

-- Table for employee
CREATE TABLE IF NOT EXISTS employee (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
--    question VARCHAR(255),
--    answer VARCHAR(255),
--    date DATE
);

-- Table for product
CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prod_id VARCHAR(255) UNIQUE NOT NULL,
    prod_name VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    stock INT,
    price DOUBLE,
    status VARCHAR(255),
    image VARCHAR(255),
    date DATE
);

-- Table for customer (orders)
CREATE TABLE IF NOT EXISTS customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    prod_id VARCHAR(255),
    prod_name VARCHAR(255),
    type VARCHAR(255),
    quantity INT,
    price DOUBLE,
    date DATE,
    image VARCHAR(255),
    em_username VARCHAR(255)
);

-- Table for receipt (transactions)
CREATE TABLE IF NOT EXISTS receipt (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    total DOUBLE,
    date DATE,
    em_username VARCHAR(255)
);
