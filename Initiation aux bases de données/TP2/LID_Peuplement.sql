set datestyle to 'european';

drop table if exists remplacements;
drop table if exists interventions;
drop table if exists tauxhoraire;
drop table if exists factures;
drop table if exists clients;
drop table if exists produits;

-- TABLE tauxhoraire

create table tauxhoraire(
	codetaux smallint not null,
	txhoraire numeric(8,2) not null,
	check ( codetaux >0 ),
	primary key (codetaux) );

-- TABLE clients

create table clients (
noclient integer not null check ( noclient > 100 ),
nom varchar(30) not null , 
prenom varchar(30),
adresse varchar(50) not null,
primary key( noclient)
);

-- TABLE factures

create table factures(
 nofacture integer not null ,
 datefacture date not null ,
 etat char(1) not null default 'C' check ( etat in ('R','C')),
 primary key(nofacture)
);

-- TABLE produits

create table produits (
 reference char(5) not null  check ( reference like 'DT___'),
 designation varchar(50) not null,
 prixht numeric (9,2) not null,
 primary key(reference) );

-- TABLE interventions

create table interventions ( 
	nointerv integer not null ,
	dateinterv date not null,
	nomresponsable varchar(30) not null,
	nominterv varchar(30) not null,
	temps float not null check ( temps !=0 AND  temps between 0 and 8),
	noclient integer not null ,
	nofacture integer not null ,
	primary key( nointerv),
	foreign key( noclient) references clients,
	foreign key (nofacture) references factures 
);

-- TABLE remplacements

create table remplacements (
	reference char(5) not null check ( reference like 'DT%'),
	nointerv integer not null,
	qteremplacee smallint,
	primary key ( reference, nointerv ),
	foreign key (reference) references produits,
	foreign key(nointerv) references interventions(nointerv) 
);

-- INSERT tauxhoraire

insert into tauxhoraire values (1, 20.15 );
insert into tauxhoraire values (2, 24.35 );
insert into tauxhoraire values (3, 30.12 );
insert into tauxhoraire values (4, 35.13 );

-- INSERT clients

insert into clients VALUES  ( 105,'Dallalon','Jean','5 Rue Jean Moulin');
insert into clients VALUES  ( 101,'Rivoire',null,'18 rue ronde');
insert into clients VALUES  ( 102,'Favero','Andr�','43 rue Beaujolais');
insert into clients VALUES  ( 103,'Provent','Catherine','38 rue du stade');
insert into clients VALUES  ( 104,'Labric',null,'35 rue des fleurs');
insert into clients VALUES  ( 108,'Usturritz','Noa','27 rue des gentilshommes');
insert into clients VALUES  ( 109,'Lavalee','Amelia','14 Bd de Gaulle');

-- INSERT factures

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
insert into factures values ( 1013,'19/10/2009','R');

-- INSERT produits

insert into produits values ( 'DT010','Disjoncteur 10A',7.21);
insert into produits values ( 'DT180','Bloc Huger',6.12);
insert into produits values ( 'DT802','Boite controle',68.35);
insert into produits values ( 'DT711','cellule',25.36);
insert into produits values ( 'DT125','Bloc Soc',6.89);
insert into produits values ( 'DT015','Disjoncteur 15A',14.94);
insert into produits values ( 'DT205','Bruleur Huger',153.37);
insert into produits values ( 'DT310','bruleur soc',200.20);
insert into produits values ( 'DT120','Connecteur',20.35);
insert into produits values ( 'DT121','Connecteur1',40.25);
insert into produits values ( 'DT122','Connecteur2',34.35);

-- INSERT interventions

insert into  interventions values ( 1039,'03/07/2009','Mauras','Saultier',1,101,1001);
insert into  interventions values ( 1040,'03/07/2009','Foucher','Saultier',1,103,1002);
insert into  interventions values ( 1041,'03/07/2009','Foucher','Saultier',2,103,1002);
insert into  interventions values ( 1042,'03/07/2009','Foucher','Saultier',1,101,1003);
insert into  interventions values ( 1043,'03/07/2009','Mauras','Saultier',2,105,1005);
insert into  interventions values ( 1044,'04/07/2009','Mauras','Saultier',0.5,101,1006);
insert into  interventions values ( 1045,'08/07/2009','Mauras','Bonnaz',1.5,102,1007);
insert into  interventions values ( 1046,'10/07/2009','Foucher','Crespin',1,102,1007);
insert into  interventions values ( 1047,'11/07/2009','Mauras','Crespin',2,103,1008);
insert into  interventions values ( 1048,'15/07/2009','Foucher','Bonnaz',1,105,1009);
insert into  interventions values ( 1049,'18/07/2009','Foucher','Saultier',1.5,101,1010);
insert into  interventions values ( 1050,'22/07/2009','Foucher','Saultier',0.5,104,1011);
insert into  interventions values ( 1051,'23/07/2009','Mauras','Bonnaz',2.5,104,1011);
insert into  interventions values ( 1052,'29/07/2009','Mauras','Saultier',1.5,104,1011);


insert into remplacements values ('DT802',1043,1);
insert into remplacements values ('DT711',1043,2);
insert into remplacements values ('DT180',1043,1);
insert into remplacements values ('DT205',1044,1);
insert into remplacements values ('DT125',1045,2);
insert into remplacements values ('DT010',1045,1);
insert into remplacements values ('DT310',1046,1);
insert into remplacements values ('DT711',1047,3);
insert into remplacements values ('DT120',1047,2);
insert into remplacements values ('DT015',1048,1);
insert into remplacements values ('DT180',1049,4);
insert into remplacements values ('DT711',1049,2);
insert into remplacements values ('DT205',1050,1);
insert into remplacements values ('DT711',1051,2);
insert into remplacements values ('DT120',1051,1);
insert into remplacements values ('DT120',1052,3);

-- clients : ville, cp, tel

alter table clients 
	add column  ville varchar(25)  ;
alter table clients 
	add column  cp char(5)  ;
alter table clients 
	add column  tel char(14) check ( tel like '__-__-__-__-__');

update clients set ville='La Rochelle' ,
		 cp ='17000', 
		tel='05-46-35-37-39'
		where noclient = 105;
update clients set ville='La Rochelle' ,
		 cp ='17000', 
		tel='05-46-41-56-56'
		where noclient = 101;
update clients set ville='Poitiers' ,
		 cp ='86000', 
		tel='05-49-35-63-62'
		where noclient = 102;
update clients set ville='Poitiers' , cp ='86000', 
		tel='05-49-49-45-46'
		where noclient = 103;
update clients set ville='Poitiers' ,
		 cp ='86000', 
		tel='05-49-46-45-48'
		where noclient = 104;
update clients set ville='Poitiers' ,
		 cp ='86000', 
		tel='05-49-46-45-52'
		where noclient = 108;
update clients set ville='Poitiers' ,
		 cp ='86000', 
		tel='05-49-46-45-50'
		where noclient = 109;
		
alter table clients  alter ville set not null;
alter table clients alter cp set not null;
alter table clients alter tel set not null;

-- interventions : codetaux

alter table interventions
	add codetaux smallint not null default 1 check ( codetaux>0) references tauxhoraire(codetaux);
update interventions 
	set codetaux=1 where nominterv = 'Saultier';
update interventions 
	set codetaux=2 where nominterv = 'Crespin';
update interventions 
	set codetaux=3 where nominterv = 'Bonnaz';

-- produits : qtestock, qtesecurite

alter table produits 
	add qtestock smallint ;
alter table produits 
	add qtesecurite smallint ;
alter table produits
	alter qtestock set default 1;
alter table produits
	alter qtesecurite set default 0;
alter table produits
	add constraint controle check (qtestock >= qtesecurite);

update produits
	set qtestock =20, qtesecurite = 10
	where designation like '_ruleur%';
update produits
	set qtestock =30, qtesecurite = 15
	where designation like '_isjoncteur%';
update produits
	set qtestock =40, qtesecurite = 15
	where designation not like '_ruleur%'
	and designation not like '_isjoncteur%';
update produits
	set qtestock =40, qtesecurite = 15
	where designation not like '_ruleur%'
	and designation not like '_isjoncteur%';

/* 1 */
SELECT reference, designation from produits WHERE prixht > 15;

/* 2 */
SELECT nointerv, dateinterv, temps from interventions WHERE nominterv = 'Crespin';

/* 3 */
SELECT nointerv, dateinterv from interventions i JOIN factures f ON i.nofacture = f.nofacture WHERE f.datefacture = '15.07.2009';

/* 4 */
SELECT
	f.nofacture
FROM
	factures f 
	JOIN interventions i ON i.nofacture = f.nofacture
	JOIN clients c ON c.noclient = i.noclient
WHERE
	c.nom = 'Rivoire';

/* 5 */
SELECT 
	designation 
FROM 
	produits p 
	JOIN remplacements r ON p.reference = r.reference
	JOIN interventions i ON i.nointerv = r.nointerv
WHERE 
	i.dateinterv = '03.07.2009';

/* 6 */
SELECT 
	f.datefacture 
FROM 
	factures f
	JOIN interventions i ON f.nofacture = i.nofacture
	JOIN remplacements r ON r.nointerv = i.nointerv
	JOIN produits p ON p.reference = r.reference
WHERE
	(lower(p.designation) LIKE '%bruleur%' OR lower(p.designation) LIKE '%brûleur%') AND
	i.nomresponsable = 'Saultier';
	
/* 7 */ 
SELECT 
	p.designation 
FROM 
	produits p
	JOIN remplacements r ON r.reference = p.reference
	JOIN interventions i ON i.nointerv = r.nointerv
	JOIN clients c ON c.noclient = i.noclient
WHERE 
	c.nom = 'Provent';
	
/* 8 */
SELECT 
	p.designation 
FROM 
	produits p
WHERE 
	p.qtestock - qtesecurite BETWEEN 1 AND 10;


/* 9 */
SELECT 
	p.reference,
	p.designation 
FROM 
	produits p
WHERE 
	p.reference LIKE '%1';