-- Table: public.email

-- DROP TABLE IF EXISTS public.email;

CREATE TABLE IF NOT EXISTS public.email
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying COLLATE pg_catalog."default",
    project_id integer,
    CONSTRAINT email_pkey PRIMARY KEY (id),
    CONSTRAINT fk_project_id FOREIGN KEY (project_id)
        REFERENCES public.project (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.email
    OWNER to postgres;