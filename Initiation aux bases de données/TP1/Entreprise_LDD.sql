drop table IF EXISTS materiel;
drop table IF EXISTS contrat;
drop table IF EXISTS type;
drop table IF EXISTS societe;
drop table IF EXISTS clients;


create table clients(
	no_client integer
);

create table societe (
	code_societe integer,
	raison_sociale varchar(50) not null, --raison sociale = nom entreprise
	adresse varchar(50) not null,
	ville varchar(50) not null,
	code_postal integer not null,
	PRIMARY KEY(code_societe)
);

create table type (
	no_type integer,
	designation varchar(50) not null,
	caracteristiques text,
	PRIMARY KEY(no_type)
);

create table contrat (
	no_contrat integer,
	date_expiration date not null,
	duree interval,
	montant real not null,
	societe integer not null,
	PRIMARY KEY(no_contrat),
	FOREIGN KEY (societe) REFERENCES societe (code_societe)
);

create table materiel (
	no_materiel integer,
	no_serie integer not null,
	designation varchar(50) not null,
	no_contrat integer not null,
	type integer not null,
	PRIMARY KEY(no_materiel),
	FOREIGN KEY (no_contrat) REFERENCES contrat(no_contrat),
	FOREIGN KEY (type) REFERENCES type(no_type),
	UNIQUE (no_serie)
);
