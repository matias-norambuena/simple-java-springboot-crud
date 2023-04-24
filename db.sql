create table public.tareas
(
    id              bigint generated always as identity
        primary key,
    descripcion     varchar(255) not null,
    "fechaCreacion" timestamp    not null,
    vigente         boolean      not null
);