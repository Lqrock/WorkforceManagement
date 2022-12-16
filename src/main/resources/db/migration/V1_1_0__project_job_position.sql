-- Table: public.project_job_position

-- DROP TABLE IF EXISTS public.project_job_position;

CREATE TABLE IF NOT EXISTS public.project_job_position
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    project_id integer NOT NULL,
    job_position_id integer NOT NULL,
    CONSTRAINT project_job_position_pkey PRIMARY KEY (id),
    CONSTRAINT fk_job_position FOREIGN KEY (job_position_id)
        REFERENCES public.job_position (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_project FOREIGN KEY (project_id)
        REFERENCES public.project (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.project_job_position
    OWNER to postgres;