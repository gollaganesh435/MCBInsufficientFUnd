DROP TABLE IF EXISTS users;
CREATE TABLE users (
id INT AUTO_INCREMENT  PRIMARY KEY,
username VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL,
buisnessUnit VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS fund_requests;
CREATE TABLE fund_requests (
id INT AUTO_INCREMENT  PRIMARY KEY,
business_key VARCHAR(50) ,
application VARCHAR(50) ,
comments VARCHAR(255) ,
transaction_currency VARCHAR(50) ,
transaction_amount INT,
amount_in_mur INT,
debit_account_number VARCHAR(255),
account_short_name VARCHAR(50),
debit_account_ccy VARCHAR(50),
payment_details_1 VARCHAR(255),
payment_details_2 VARCHAR(255),
payment_details_3 VARCHAR(255),
payment_details_4 VARCHAR(255),
verified VARCHAR(50),
discrepancy_reason VARCHAR(50),
created_by VARCHAR(50),
created_on Date,
updated_by VARCHAR(50),
updated_on Date,
customer_number VARCHAR(255),
customer_name VARCHAR(50),
account_officer VARCHAR(50),
alt_account_officer VARCHAR(50),
date_mail_sent DATE,
override VARCHAR(50),
bu_name VARCHAR(50),
amount_in_debit_account_ccy INT,
debit_account_balance INT,
beneficiary_account_number VARCHAR(50),
beneficiary_name VARCHAR(50),
beneficiary_bank_name VARCHAR(50),
beneficiary_bank_swift_code VARCHAR(50),
agreed_rate Number,
status VARCHAR(50)


);


