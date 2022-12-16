-- Table: public.vehicle

-- DROP TABLE IF EXISTS public.vehicle;

CREATE TABLE IF NOT EXISTS public.vehicle
(
    model character varying COLLATE pg_catalog."default" NOT NULL,
    plate_number character varying COLLATE pg_catalog."default" NOT NULL,
    insurance_type character varying COLLATE pg_catalog."default" NOT NULL,
    gps_number character varying COLLATE pg_catalog."default" NOT NULL,
    owners_name character varying COLLATE pg_catalog."default",
    tuf_expiration_date date NOT NULL,
    insurance_expiration_date date NOT NULL,
    oil_change_indicator integer NOT NULL,
    fuel_injector_change_indicator integer NOT NULL,
    fuel_injector_filter_change_required boolean,
    anti_frost_change_required_change_required boolean,
    air_filter_change_required boolean,
    inside_air_filter_change_required boolean,
    brake_fluid_change_required boolean,
    project_id integer,
    tire_type character varying COLLATE pg_catalog."default",
    timing_belt_change_indicator integer,
    dkv_number character varying COLLATE pg_catalog."default",
    mileage integer,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    vin bigint NOT NULL,
    employee_id integer,
    CONSTRAINT vehicle_pkey PRIMARY KEY (id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vehicle
    OWNER to postgres;