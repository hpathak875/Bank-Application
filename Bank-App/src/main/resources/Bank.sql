drop database if exists bankdb;
create database bankdb;

use bankdb;
select * from bank;

use bankdb;
insert into bank(id,account_holder_name,acct_no,phone_no,email,balance,status) values(1,'Ryan','123456','987654310','ryan@gmail.com','15000.0','Active');
