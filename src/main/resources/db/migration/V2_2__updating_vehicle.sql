-- adding dkv number enum and column to vehicle

CREATE TYPE dkv_number AS ENUM('one');

ALTER TABLE vehicle
    ADD vehicle_dkv_number dkv_number;