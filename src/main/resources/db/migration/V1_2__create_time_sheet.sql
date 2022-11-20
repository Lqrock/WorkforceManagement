
CREATE TABLE time_sheet(
    id BIGINT NOT NULL,
    job_type VARCHAR(255),
    starting_time TIME,
    finishing_time TIME,
    pause_time INT,
    project_name VARCHAR,
    job_position VARCHAR,
    PRIMARY KEY(id)
);