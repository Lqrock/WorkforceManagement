
-- creating marital status enum and adding it to employee table -
-- also changed column name from "marital_status" to "employee_marital_status"

CREATE TYPE marital_status AS ENUM('SINGLE', 'MARRIED', 'WIDOWED', 'DIVORCED');
ALTER TABLE employee
    ADD employee_marital_status marital_status;
