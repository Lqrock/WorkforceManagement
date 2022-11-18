CREATE TYPE marital_status AS ENUM('SINGLE', 'MARRIED', 'WIDOWED', 'DIVORCED');
ALTER TABLE employee
    ADD employee_marital_status marital_status;
