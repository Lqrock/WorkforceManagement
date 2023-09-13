-- Table: public.language

-- DROP TABLE IF EXISTS public.language;

CREATE TABLE IF NOT EXISTS public.language
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    spoken_language character varying COLLATE pg_catalog."default",
    employee_id integer,
    CONSTRAINT language_pkey PRIMARY KEY (id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.language
    OWNER to postgres;