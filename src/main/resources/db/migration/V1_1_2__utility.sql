-- Table: public.utility

-- DROP TABLE IF EXISTS public.utility;

CREATE TABLE IF NOT EXISTS public.utility
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying COLLATE pg_catalog."default",
    accommodation_id integer,
    CONSTRAINT utility_pkey PRIMARY KEY (id),
    CONSTRAINT fk_accommodation FOREIGN KEY (accommodation_id)
        REFERENCES public.accommodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.utility
    OWNER to postgres;