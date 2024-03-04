DROP DATABASE IF EXISTS BankSystem;
create database BankSystem;
use BankSystem;
 create table Bank(
code int AUTO_INCREMENT primary key,
name varchar(50),
address varchar(50)
);

create table BankBranch(
Branch_no int primary key,
address varchar(255) 


);
CREATE TABLE customer (
  SSN INT AUTO_INCREMENT
  PRIMARY KEY,
  name VARCHAR(255),
  address VARCHAR(255),
  phone INT 
  
);

create table loan (
loan_no int AUTO_INCREMENT primary key ,
loan_type varchar(50) ,
loan_amnt int 



);
create table accounts(
acc_no int primary key ,
balance int ,
type varchar(255) 


);
 create table employee(
 ID int AUTO_INCREMENT primary key  ,
password varchar(50)  ,
name varchar(50) ,
mail varchar(50) 
);