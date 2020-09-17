drop table if exists clients; 
drop table if exists societe;
drop table if exists contrat;
drop table if exists materiel;
drop table if exists type;

create table clients(
	no_client integer
);

create table societe (
	code_societe integer,
	raison_sociale varchar(50) not null, --raison sociale = nom entreprise
	adresse varchar(50) not null,
	ville varchar(50) not null,
	codepostal integer not null,
	PRIMARY KEY(code_societe),
	FOREIGN KEY (no_contrat) REFERENCES no_type (no_contrat, no_type)
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
	no_serie int not null,
	designation varchar(50) not null,
	no_contrat int not null,
	type char not null,
	PRIMARY KEY(no_materiel),
	FOREIGN KEY (no_contrat) REFERENCES no_contrat(materiel)
);

create table type (
	no_type integer,
	designation varchar(50) not null,
	caracteristiques text,
	PRIMARY KEY(no_type),
	FOREIGN KEY (carasteristiques) REFERENCES no_type (designation)
);