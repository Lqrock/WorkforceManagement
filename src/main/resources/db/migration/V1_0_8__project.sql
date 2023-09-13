-- Table: public.project

-- DROP TABLE IF EXISTS public.project;

CREATE TABLE IF NOT EXISTS public.project
(
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying COLLATE pg_catalog."default" NOT NULL,
    emails character varying(255) COLLATE pg_catalog."default",
    starting_date date NOT NULL,
    finishing_date date,
    maximum_employees_number integer,
    employee_id integer,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code integer NOT NULL,
    CONSTRAINT project_pkey PRIMARY KEY (id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.project
    OWNER to postgres;