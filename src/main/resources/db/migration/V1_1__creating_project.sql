CREATE TABLE project (
	name VARCHAR(255) NOT NULL,
	project_code INT NOT NULL,
	address TEXT NOT NULL,
	phone_number VARCHAR NOT NULL,
	emails VARCHAR(255),
	starting_date DATE NOT NULL,
	finishing_date DATE,
	maximum_employees_number INT,
	employee_id INT,
	PRIMARY KEY (project_code),
	CONSTRAINT FK_employee_id FOREIGN KEY (employee_id) REFERENCES employee(identity_number)
);