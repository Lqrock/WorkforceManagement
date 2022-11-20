CREATE TABLE project(
    id BIGINT NOT NULL,
    name VARCHAR NOT NULL,
    code VARCHAR NOT NULL,
    address TEXT NOT NULL,
    starting_date DATE NOT NULL,
    finishing_date DATE NOT NULL,
    maximum_employees_number INT,
    employee_id INT,
    PRIMARY KEY(id),
    CONSTRAINT fk_employee_id FOREIGN KEY(employee_id) REFERENCES employee(id)
);