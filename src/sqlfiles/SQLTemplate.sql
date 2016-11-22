/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sidney
 * Created: Nov 21, 2016
 */

CREATE TABLE dentista (
nome VARCHAR(50) NOT NULL,
id INT(5) NOT NULL
);

TABELA DENTISTA

CREATE TABLE public.dentista
(
    id serial,
    cro integer,
    nome character varying(50) COLLATE "default".pg_catalog
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.dentista
    OWNER to postgres;


--------------------------------------------------------------
TABELA PACIENTE

CREATE TABLE public.paciente
(
    id serial,
    nome character varying COLLATE "default".pg_catalog,
    cpf integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.paciente
    OWNER to postgres;

--------------------------------------------------------------
TABELA SERVIÇO

CREATE TABLE public.servico
(
    id integer,
    descricao character varying(30) COLLATE "default".pg_catalog
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.servico
    OWNER to postgres;

--------------------------------------------------------------
 TABELA AGENDAMENTO

CREATE TABLE public.agenda
(
    id serial,
    idpaciente integer,
    iddentista integer,
    idservico integer,
    data date,
    hora reltime
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.agenda
    OWNER to postgres;