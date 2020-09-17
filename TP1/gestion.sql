drop table if exists clients; 
drop table if exists societe;
drop table if exists contrat;
drop table if exists materiel;
drop table if exists type;

create table clients(
	no_client integer
);

create table societe(
	code_societe integer;
	raison_sociale varchar(50);
	adresse varchar(50);
	ville varchar(50);
	codepostal serial;
	PRIMARY KEY(code_societe);
	FOREIGN KEY () REFERENCES code_societe ()
);

create table contrat (
	no_contrat integer;
	date_expiration date;
	duree time;
	montant money;
	societe text;
	PRIMARY KEY(no_contrat);
	FOREIGN KEY () REFERENCES no_contrat ()
);

create table materiel (
	no_materiel integer;
	no_serie integer;
	designation text;
	no_contrat integer;
	type text;
	PRIMARY KEY(no_materiel);
	FOREIGN KEY (no_contrat) REFERENCES no_materiel()
	
);

create table type (
	no_type integer;
	designation text;
	caracteristiques text;
	PRIMARY KEY(no_type)
	FOREIGN KEY () REFERENCES no_type ()
);