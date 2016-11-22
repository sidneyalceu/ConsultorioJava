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

CREATE TABLE dentista
(
    id serial,
    cro integer,
    nome character varying(50)
)
--------------------------------------------------------------
TABELA PACIENTE

CREATE TABLE paciente
(
    id serial,
    nome character varying,
    cpf integer
)
--------------------------------------------------------------
TABELA SERVIÇO

CREATE TABLE servico
(
    id integer,
    descricao character varying(30)
)
--------------------------------------------------------------
 TABELA AGENDAMENTO

CREATE TABLE agenda
(
    id serial,
    idpaciente integer,
    iddentista integer,
    idservico integer,
    data date
)