-- Table: public.accommodation

-- DROP TABLE IF EXISTS public.accommodation;

CREATE TABLE IF NOT EXISTS public.accommodation
(
    owners_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    owners_phone_number character varying(255) COLLATE pg_catalog."default" NOT NULL,
    owners_email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    owners_bank_account bigint,
    ownership_type character varying COLLATE pg_catalog."default" NOT NULL,
    province character varying COLLATE pg_catalog."default" NOT NULL,
    city character varying COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    house_number integer NOT NULL,
    has_internet boolean,
    has_parking boolean,
    rent double precision,
    deposit double precision,
    rental_period integer,
    notice_period integer,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 0 MINVALUE 0 MAXVALUE 2147483647 CACHE 1 ),
    postal_code bigint NOT NULL,
    CONSTRAINT accommodation_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accommodation
    OWNER to postgres;