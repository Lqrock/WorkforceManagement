ALTER TABLE employee
    ADD accommodation_id int,
    add CONSTRAINT FK_accommodation_id
    FOREIGN KEY (accommodation_id)
    REFERENCES accommodation(postal_code);