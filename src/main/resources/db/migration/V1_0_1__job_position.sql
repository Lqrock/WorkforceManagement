-- Table: public.job_position

-- DROP TABLE IF EXISTS public.job_position;

CREATE TABLE IF NOT EXISTS public.job_position
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying COLLATE pg_catalog."default",
    CONSTRAINT job_position_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.job_position
    OWNER to postgres;