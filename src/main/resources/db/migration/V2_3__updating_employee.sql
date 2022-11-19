-- creating enum job_position and adding the related column to employee table

CREATE TYPE job_position AS ENUM('worker');

ALTER TABLE employee
    ADD employee_job_position job_position;