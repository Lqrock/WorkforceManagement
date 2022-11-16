CREATE TYPE gender AS ENUM ('male', 'female', 'other');
ALTER TABLE employee
    ADD employee_gender gender;