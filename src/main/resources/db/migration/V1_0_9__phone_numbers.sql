-- Table: public.phone_numbers

-- DROP TABLE IF EXISTS public.phone_numbers;

CREATE TABLE IF NOT EXISTS public.phone_numbers
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    phone_number character varying COLLATE pg_catalog."default",
    project_id integer,
    CONSTRAINT phone_numbers_pkey PRIMARY KEY (id),
    CONSTRAINT fk_project_id FOREIGN KEY (project_id)
        REFERENCES public.project (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.phone_numbers
    OWNER to postgres;