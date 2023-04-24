create database tareas_system;

\connect tareas_system;

create table tareas (
                    id bigint primary key generated always as identity,
                    descripcion character varying(255) not null,
                    fechaCreacion timestamp not null,
                    vigente boolean not null

                    CONSTRAINT tareas_nombre_uniq UNIQUE (nombre)
);