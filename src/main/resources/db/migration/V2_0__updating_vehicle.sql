
CREATE TYPE tire_type AS ENUM('snow_tire', 'four_season_tire');
ALTER TABLE vehicle
    ADD vehicle_tire_type tire_type;
