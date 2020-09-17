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
	codepostal serial
);

create table contrat (
	no_contrat integer;
	date_expiration date;
	duree time;
	montant money;
	societe text;
);

create table materiel (
	no_materiel integer;
	no_serie integer;
	designation text;
	no_contrat integer;
	type text
);

create table type (
	no_type integer;
	designation text;
	caracteristiques text;
);