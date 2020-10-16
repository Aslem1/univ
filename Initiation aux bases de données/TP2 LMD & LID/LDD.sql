/*-- Database: Gestion

-- DROP DATABASE "Gestion";

CREATE DATABASE "Gestion" 
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;*/


drop table IF EXISTS clients; 
drop table IF EXISTS produits;
drop table IF EXISTS factures;
drop table IF EXISTS remplacements;
drop table IF EXISTS interventions;
drop table if EXISTS tauxHoraire;


create table clients (
	noclients integer not null,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	adresse varchar(50) not null,
	ville varchar(50) not null,
	cp integer not null,
	tel integer not null,
	PRIMARY KEY(noclients)
);

create table factures (
	nofacture integer not null,
	datefacture date not null,
	etat varchar(50),
	PRIMARY KEY(nofacture)
);

create table tauxHoraire (
	codetaux real not null,
	txhoraire real,
	PRIMARY KEY(codetaux)
);

create table interventions (
	nointerv integer not null,
	dateinterv date not null,
	nomresponsable varchar(50) not null,
	nominterv varchar(50) not null,
	temps date not null,
	noclient integer not null,
	nofacture integer not null,
	codetaux real not null,
	PRIMARY KEY(nointerv),
	FOREIGN KEY (noclient) REFERENCES clients (noclients),
	FOREIGN KEY (nofacture) REFERENCES factures (nofacture),
	FOREIGN KEY (codetaux) REFERENCES tauxHoraire (codetaux)
);

create table produits (
	reference integer,
	designation varchar(50) not null,
	prixht real not null,
	qtestock integer,
	qtesecurite integer,
	PRIMARY KEY(reference)
);

create table remplacements (
	reference integer not null,
	nointerv integer not null,
	qteremplacee varchar(50),
	PRIMARY KEY(reference),
	FOREIGN KEY (nointerv) REFERENCES interventions (nointerv),
	FOREIGN KEY (reference) REFERENCES produits (reference)
);

/* --- I.Exercice 1 : LMD --- */

/* 1 */
INSERT INTO clients VALUES  
    ('Dupont', 'Raphael', '5 rue des coquelicots', 'Niort', '79000', '06.33.32.31.30'),
    ('Dupuy', '', '3 rue des lys', 'Saintes', '17100', '06.23.58.64.10');

/*
/* 2 */
INSERT INTO clients VALUES
	('10', 'Dupont', 'Raphael', '5 rue des coquelicots', 'Niort', '79000', '06.33.32.31.30'),
	('10', 'Dupuy', 'Paul', '3 rue des lys', 'Saintes', '17100', '06.23.58.64.10');

/* 3 */
INSERT INTO produits
	VALUES ('7', 'designation1', '14.2', '','');
	
/* 4 */
INSERT INTO produits
	VALUES ('7', 'designation1', '14.2', '4.6','8.8');
	
/* 5 */
insert into factures values ( 1000,'01/01/2009','R');
insert into factures values ( 1001,'12/02/2009','R');
insert into factures values ( 1002,'17/03/2009','R');
insert into factures values ( 1003,'24/04/2009','R');
insert into factures values ( 1004,'16/05/2009','R');
insert into factures values ( 1005,'08/07/2009','R');
insert into factures values ( 1006,'08/07/2009','R');
insert into factures values ( 1007,'15/07/2009','R');
insert into factures values ( 1008,'15/07/2009','R');
insert into factures values ( 1009,'22/07/2009','C');
insert into factures values ( 1010,'22/07/2009','C');
insert into factures values ( 1011,'29/07/2009','C');
insert into factures values ( 1012,'30/08/2009','R');
insert into factures values ( 1013,'19/10/2009','R')

/* 6 */
DELETE FROM 'factures'
WHERE nofacture = 1010;

/* 7 */
DELETE FROM 'factures'
WHERE etat = R;

/* 8 */
INSERT INTO interventions VALUES


/* 9 */

/* 10 */

*/