CREATE TABLE accommodation (
	owners_name VARCHAR(255) NOT NULL,
	owners_phone_number VARCHAR(255) NOT NULL,
	wners_email VARCHAR(255) NOT NULL,
	owners_bank_account BIGINT,
	owners_type VARCHAR NOT NULL,
	province VARCHAR NOT NULL,
	city VARCHAR NOT NULL,
	address TEXT NOT NULL,
	postal_code BIGINT NOT NULL,
	house_number INT NOT NULL,
	floor_count INT NOT NULL,
	number_of_floors INT NOT NULL,
	has_internet BOOLEAN,
	has_parking BOOLEAN,
	rent FLOAT,
	deposit FLOAT,
	PRIMARY KEY (postal_code)
);