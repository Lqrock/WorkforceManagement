-- Table: public.furniture

-- DROP TABLE IF EXISTS public.furniture;

CREATE TABLE IF NOT EXISTS public.furniture
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying COLLATE pg_catalog."default",
    room_id integer,
    accommodation_id integer,
    CONSTRAINT furniture_pkey PRIMARY KEY (id),
    CONSTRAINT fk_accommodation_id FOREIGN KEY (accommodation_id)
        REFERENCES public.accommodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_room_id FOREIGN KEY (room_id)
        REFERENCES public.room (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.furniture
    OWNER to postgres;