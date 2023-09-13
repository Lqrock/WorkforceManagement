ALTER TABLE vehicle
    ADD CONSTRAINT fk_project_id FOREIGN KEY(project_id) REFERENCES project(id);