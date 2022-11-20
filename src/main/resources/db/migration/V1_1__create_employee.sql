CREATE TABLE employee (
    id BIGINT NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	identity_number INT NOT NULL,
	gender VARCHAR NOT NULL,
	marital_status VARCHAR NOT NULL,
	nationality VARCHAR(255) NOT NULL,
	citizenship_country VARCHAR(255) NOT NULL,
	date_of_birth DATE NOT NULL,
	place_of_birth VARCHAR(255) NOT NULL,
	address TEXT NOT NULL,
	phone_number VARCHAR(125) NOT NULL,
	email VARCHAR(255) NOT NULL,
	bank_name VARCHAR(255) NOT NULL,
	bank_account_number BIGINT NOT NULL,
	has_drivers_license BOOLEAN NOT NULL,
	job_position VARCHAR,
	starting_date DATE NOT NULL,
	finishing_date DATE NOT NULL,
	salary_per_hour DOUBLE PRECISION,
	contract_type VARCHAR(255) NOT NULL,
	vehicle_id INT,
	accommodation_id INT,
	PRIMARY KEY (id),
	CONSTRAINT FK_vehicle_id
	FOREIGN KEY (vehicle_id)
	REFERENCES vehicle(id),
    	CONSTRAINT FK_accommodation_id
    	FOREIGN KEY (accommodation_id)
    	REFERENCES accommodation(id)
);