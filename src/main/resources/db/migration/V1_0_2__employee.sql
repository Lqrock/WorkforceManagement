-- Table: public.employee

-- DROP TABLE IF EXISTS public.employee;

CREATE TABLE IF NOT EXISTS public.employee
(
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nationality character varying(255) COLLATE pg_catalog."default" NOT NULL,
    citizenship_country character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_of_birth date NOT NULL,
    place_of_birth character varying(255) COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(125) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    bank_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    bank_account_number bigint NOT NULL,
    has_drivers_license boolean NOT NULL,
    starting_date date NOT NULL,
    finishing_date date NOT NULL,
    salary_per_hour double precision,
    contract_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    gender character varying COLLATE pg_catalog."default",
    marital_status character varying COLLATE pg_catalog."default",
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    identity_number integer NOT NULL,
    vehicle_id integer,
    job_position_id integer,
    accommodation_id integer,
    CONSTRAINT employee_pkey PRIMARY KEY (id),
    CONSTRAINT fk_accommodation_id FOREIGN KEY (accommodation_id)
        REFERENCES public.accommodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_job_position_id FOREIGN KEY (job_position_id)
        REFERENCES public.job_position (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employee
    OWNER to postgres;