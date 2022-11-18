
-- creating tire type enum and adding it to vehicle table
-- changed column name from "tire_type" to "vehicle_tire_type"

CREATE TYPE tire_type AS ENUM('snow_tire', 'four_season_tire');
ALTER TABLE vehicle
    ADD vehicle_tire_type tire_type;
