
ALTER TABLE employee
    ADD vehicle_id int,
	ADD CONSTRAINT FK_vehicle_id
	FOREIGN KEY (vehicle_id)
	REFERENCES vehicle(vehicle_identification_number);
