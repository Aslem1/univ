drop table if exists musiciens, labels, groupes, formations, membres, contrats, evenements cascade;
set datestyle to 'european';

-------------------------------------------
/* Inserez ICI les creations de domaines */
-------------------------------------------
drop domain if exists D_TYPE_PRODUCTION, D_INSTRUMENT;
/* 5. Créez une contrainte de domaine, appelée D_TYPE_PRODUCTION, 
sur l’attribut “type_production” de la table “labels”. */
CREATE DOMAIN 
	D_TYPE_PRODUCTION VARCHAR;
/*CONSTRAINT lablels CHECK type_production IS NOT NULL;*/


/* 6. Créez une contrainte de domaine, appelée D_INSTRUMENT, sur
l’attribut “instrument” de la table “musiciens”. */
CREATE DOMAIN
	D_INSTRUMENT VARCHAR;
/*CONSTRAINT musiciens CHECK instrument */

-------------------------------------------
/* Creations des tables */
-------------------------------------------

-- TABLE labels
create table labels (
	id_label integer primary key,
	nom char(50) not null,
	type_production D_TYPE_PRODUCTION default 'NC'
	);

-- TABLE groupes
create table groupes (
	id_groupe integer primary key,
	nom char(50) not null unique,
	date_creation date not null,
	date_fin date,
	label integer references labels(id_label) on delete cascade on update cascade
	);

-- TABLE musiciens
create table musiciens ( 
	id_musicien serial  primary key,
	prenom char(50) not null,
	nom char(50) not null,
	date_naissance date not null,
	date_deces date null,
	instrument D_INSTRUMENT not null
	);

-- !!!!! TODO !!!!
-- TABLE formations : la table formations schematise une formation musicale composee de differents artisites.
-- Plusieurs formations musicales participent a la renommee d'un groupe (differents musiciens interviennent dans le groupe).
-- Attributs : id_formation, date_creation, date_fin, groupe
create table formations (
	id_formation serial primary key,
	date_creation date not null,
	date_fin date,
	groupe char(50) references groupes(nom)
);

-- !!!!! TODO !!!!
-- TABLE membres : table associative. Assure la correspondance entre musicien/formations 
-- et formation/musiciens 
-- Conserve la date de debut et de fin de la participation d'un musicien à une formation.
-- Attributs : musicien, formation, date_debut_participation, date_fin_participation
create table membres (
	id_membre serial primary key,
	musicien char(50) not null,
	formation char(50) not null,
	date_debut_participation date,
	date_fin_participation date
);

-- TABLE contrats
create table contrats (
	id_contrat integer primary key,
	date_contrat date not null
);

-- TABLE evenements
create table evenements (
	id_evenement integer primary key,
	nom char(60) not null,
	lieu char(60) not null,
	nombre_spectateur integer null,
	formation integer references formations(id_formation),
	contrat integer references contrats(id_contrat)
);

