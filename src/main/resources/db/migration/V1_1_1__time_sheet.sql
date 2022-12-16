-- Table: public.time_sheet

-- DROP TABLE IF EXISTS public.time_sheet;

CREATE TABLE IF NOT EXISTS public.time_sheet
(
    job_type character varying(125) COLLATE pg_catalog."default",
    starting_time time without time zone,
    finishing_time time without time zone,
    pause_time integer,
    project_name character varying(255) COLLATE pg_catalog."default",
    job_position_id integer,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer,
    CONSTRAINT time_sheet_pkey PRIMARY KEY (id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_job_position FOREIGN KEY (job_position_id)
        REFERENCES public.job_position (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.time_sheet
    OWNER to postgres;