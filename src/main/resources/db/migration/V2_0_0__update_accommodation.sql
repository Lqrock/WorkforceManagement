ALTER TABLE accommodation
    ADD employee_id INT,
    ADD CONSTRAINT fk_employee_id FOREIGN KEY(employee_id) REFERENCES employee(id);