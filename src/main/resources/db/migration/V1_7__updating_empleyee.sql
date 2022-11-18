
-- creating gender enum and adding it to employee table
-- also changed column name from "gender" to "employee_gender"

CREATE TYPE gender AS ENUM ('male', 'female', 'other');
ALTER TABLE employee
    ADD employee_gender gender;