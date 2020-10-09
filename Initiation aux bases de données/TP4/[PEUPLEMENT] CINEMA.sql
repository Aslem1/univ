set datestyle to 'Euro';

drop table if exists voir, aimer, jouer, projection, films, individus;

CREATE TABLE  INDIVIDUS (

	nopers varchar(3) primary key,

	nompers varchar(10) );



CREATE TABLE FILMS (  

	nofilm varchar(3) not null primary key,

	titre varchar(10) not null,

	norealisateur varchar(3) not null references INDIVIDUS(nopers),

	noproducteur  varchar(3) not null references INDIVIDUS(nopers)

	);



CREATE TABLE PROJECTION  (

	nofilm varchar(3) not null references FILMS(nofilm),

	nosalle integer not null,

	date_proj date,
	heure time not null ,

	primary key (date_proj, nosalle, heure)

);

CREATE TABLE JOUER ( 

	nofilm varchar(3) references FILMS (nofilm),

	noacteur  varchar(3) references  INDIVIDUS(nopers),

	primary key (nofilm, noacteur)

			);



CREATE TABLE VOIR ( 

	nofilm varchar(3) references FILMS (nofilm),

	nospect  varchar(3) references INDIVIDUS(nopers),

	primary key (nofilm, nospect)

			);


CREATE TABLE AIMER ( 

	nofilm varchar(3) references FILMS (nofilm),

	nospect  varchar(3) references INDIVIDUS(nopers),

	primary key (nofilm, nospect)

			);


insert into INDIVIDUS values ( 'P1','Martin');
insert into INDIVIDUS values ( 'P2','Dupont');

insert into INDIVIDUS values ( 'P3','Ravaud');
insert into INDIVIDUS values ( 'P4','Deferre');

insert into INDIVIDUS values ( 'P5','Drouet');
insert into INDIVIDUS values ( 'P6','Barre');

insert into INDIVIDUS values ( 'P7','Claveau');
insert into INDIVIDUS values ( 'P8','Dejollat');

insert into INDIVIDUS values ( 'P9','Arnault');
insert into INDIVIDUS values ( 'P10','Breart');

insert into INDIVIDUS values ( 'P11','Yaly');
insert into INDIVIDUS values ( 'P12','Jegou');

insert into INDIVIDUS values ( 'P13','Cerdan');
insert into INDIVIDUS values ( 'P14','Amirault');

insert into INDIVIDUS values ( 'P15','Got');
insert into INDIVIDUS values ( 'P16','Gaillard');

insert into INDIVIDUS values ( 'P17','Barbot');
insert into INDIVIDUS values ( 'P18','Paire');

insert into INDIVIDUS values ( 'P19','Besson');
insert into INDIVIDUS values ( 'P20','Bernard');

insert into INDIVIDUS values ( 'P21','Maurat');
insert into INDIVIDUS values ( 'P22','Hay');

insert into INDIVIDUS values ( 'P23','Bouyer');
insert into INDIVIDUS values ( 'P24','Cornuaud');

insert into INDIVIDUS values ( 'P25','Petiton');
insert into INDIVIDUS values ( 'P26','Caillaud');

insert into INDIVIDUS values ( 'P27','Luneau');
insert into INDIVIDUS values ( 'P28','Brisson');

insert into INDIVIDUS values ( 'P29','Besse');
insert into INDIVIDUS values ( 'P30','Andreu');

insert into INDIVIDUS values ( 'P31','Nguyen');
insert into INDIVIDUS values ( 'P32','Cheam');

insert into INDIVIDUS values ( 'P33','Muron');
insert into INDIVIDUS values ( 'P34','Bonneau');

insert into INDIVIDUS values ( 'P35','Lauer');
insert into INDIVIDUS values ( 'P36','Matthieu');

insert into INDIVIDUS values ( 'P37','Ravard');



insert into FILMS values ( 'F01', 'film1', 'P7', 'P7');
insert into FILMS values ( 'F02', 'film2', 'P3', 'P2');

insert into FILMS values ( 'F03', 'film3', 'P37', 'P14');
insert into FILMS values ( 'F04', 'film4', 'P35', 'P23');

insert into FILMS values ( 'F05', 'film5', 'P6', 'P9');
insert into FILMS values ( 'F06', 'film6', 'P36', 'P11');

insert into FILMS values ( 'F07', 'film7', 'P36', 'P18');
insert into FILMS values ( 'F08', 'film8', 'P36', 'P12');

insert into FILMS values ( 'F09', 'film9', 'P35', 'P14');
insert into FILMS values ( 'F10', 'film10', 'P37', 'P18');

insert into FILMS  values ( 'F11', 'film11', 'P35','P35'); 
insert into FILMS  values ( 'F12', 'film12', 'P35','P35'); 



insert into jouer values ( 'F01','P7');
insert into jouer values ( 'F01','P8');
insert into jouer values ( 'F01','P9');

insert into jouer values ( 'F03','P12');
insert into jouer values ( 'F03','P22');
insert into jouer values ( 'F03','P23');

insert into jouer values ( 'F03','P25');
insert into jouer values ( 'F04','P7');
insert into jouer values ( 'F04','P30');

insert into jouer values ( 'F04','P25');
insert into jouer values ( 'F05','P30');
insert into jouer values ( 'F05','P9');

insert into jouer values ( 'F05','P12');
insert into jouer values ( 'F07','P29');
insert into jouer values ( 'F07','P8');

insert into jouer values ( 'F07','P22');
insert into jouer values ( 'F07','P18');
insert into jouer values ( 'F08','P9');

insert into jouer values ( 'F08','P12');
insert into jouer values ( 'F08','P23');
insert into jouer values ( 'F08','P7');

insert into jouer values ( 'F09','P28');
insert into jouer values ( 'F10','P7');
insert into jouer values ( 'F10','P8');

insert into jouer values ( 'F10','P12');
insert into jouer values ( 'F10','P25');
insert into jouer values ( 'F10','P23');

insert into jouer values ( 'F10','P9');





insert into projection values ( 'F03', 1, '01/07/2012','20:00');
insert into projection values ( 'F04', 1, '01/08/2012', '18:00');

insert into projection values ( 'F05', 2, '12/07/2012', '22:00');
insert into projection values ( 'F06', 2, '18/07/2012', '18:00');

insert into projection values ( 'F01', 3, '03/08/2012', '20:00');
insert into projection values ( 'F01', 4, '01/09/2012', '18:00');

insert into projection values ( 'F10', 3, '03/09/2012', '20:00');
insert into projection values ( 'F09', 4, '11/08/2012', '22:00');

insert into projection values ( 'F01', 5, '12/09/2012', '20:00');





insert into VOIR values ( 'F01','P1');
insert into VOIR values ( 'F01','P3');
insert into VOIR values ( 'F01','P4');

insert into VOIR values ( 'F01','P5');
insert into VOIR values ( 'F01','P6');
insert into VOIR values ( 'F01','P7');

insert into VOIR values ( 'F01','P8');
insert into VOIR values ( 'F01','P9');
insert into VOIR values ( 'F01','P10');

insert into VOIR values ( 'F01','P11');
insert into VOIR values ( 'F01','P12');
insert into VOIR values ( 'F01','P13');

insert into VOIR values ( 'F01','P14');
insert into VOIR values ( 'F01','P15');
insert into VOIR values ( 'F01','P16');

insert into VOIR values ( 'F01','P17');
insert into VOIR values ( 'F01','P18');
insert into VOIR values ( 'F01','P19');

insert into VOIR values ( 'F01','P20');
insert into VOIR values ( 'F01','P21');
insert into VOIR values ( 'F01','P22');

insert into VOIR values ( 'F01','P23');
insert into VOIR values ( 'F01','P24');
insert into VOIR values ( 'F01','P25');

insert into VOIR values ( 'F01','P26');
insert into VOIR values ( 'F01','P27');
insert into VOIR values ( 'F01','P28');

insert into VOIR values ( 'F01','P29');

insert into VOIR values ( 'F02','P4');
insert into VOIR values ( 'F02','P5');
insert into VOIR values ( 'F02','P6');

insert into VOIR values ( 'F02','P7');
insert into VOIR values ( 'F02','P8');
insert into VOIR values ( 'F02','P9');

insert into VOIR values ( 'F02','P10');
insert into VOIR values ( 'F02','P11');
insert into VOIR values ( 'F02','P12');

insert into VOIR values ( 'F02','P13');
insert into VOIR values ( 'F02','P14');
insert into VOIR values ( 'F02','P15');

insert into VOIR values ( 'F02','P16');
insert into VOIR values ( 'F02','P17');
insert into VOIR values ( 'F02','P18');

insert into VOIR values ( 'F02','P19');
insert into VOIR values ( 'F02','P20');
insert into VOIR values ( 'F02','P21');

insert into VOIR values ( 'F02','P22');
insert into VOIR values ( 'F02','P23');
insert into VOIR values ( 'F02','P24');

insert into VOIR values ( 'F02','P25');
insert into VOIR values ( 'F02','P26');
insert into VOIR values ( 'F02','P27');

insert into VOIR values ( 'F02','P28');
insert into VOIR values ( 'F02','P29');
insert into VOIR values ( 'F02','P30');

insert into VOIR values ( 'F02','P31');
insert into VOIR values ( 'F02','P32');
insert into VOIR values ( 'F02','P33');

insert into VOIR values ( 'F03','P6');
insert into VOIR values ( 'F03','P7');
insert into VOIR values ( 'F03','P8');

insert into VOIR values ( 'F03','P9');
insert into VOIR values ( 'F03','P10');
insert into VOIR values ( 'F03','P11');

insert into VOIR values ( 'F03','P12');
insert into VOIR values ( 'F03','P13');
insert into VOIR values ( 'F03','P14');

insert into VOIR values ( 'F03','P15');
insert into VOIR values ( 'F03','P16');
insert into VOIR values ( 'F03','P17');

insert into VOIR values ( 'F03','P18');
insert into VOIR values ( 'F03','P19');

insert into VOIR values ('F04','P12');
insert into VOIR values ('F04','P13');
insert into VOIR values ('F04','P14');

insert into VOIR values ('F04','P15');
insert into VOIR values ('F04','P16');
insert into VOIR values ('F04','P17');

insert into VOIR values ('F04','P18');
insert into VOIR values ('F04','P19');
insert into VOIR values ('F04','P20');

insert into VOIR values ('F04','P21');
insert into VOIR values ('F04','P22');
insert into VOIR values ('F04','P23');

insert into VOIR values ('F04','P24');
insert into VOIR values ('F04','P25');
insert into VOIR values ('F04','P26');

insert into VOIR values ('F04','P27');
insert into VOIR values ('F04','P28');
insert into VOIR values ('F04','P29');

insert into VOIR values ('F04','P30');
insert into VOIR values ('F04','P31');
insert into VOIR values ('F04','P32');

insert into VOIR values ('F04','P33');


insert into VOIR values ('F05','P7');insert into VOIR values ('F05','P8');insert into VOIR values ('F05','P9');

insert into VOIR values ('F05','P10');insert into VOIR values ('F05','P11');insert into VOIR values ('F05','P12');

insert into VOIR values ('F05','P13');insert into VOIR values ('F05','P14');


insert into VOIR values ('F06','P8');insert into VOIR values ('F06','P9');insert into VOIR values ('F06','P10');

insert into VOIR values ('F06','P11');insert into VOIR values ('F06','P12');insert into VOIR values ('F06','P13');

insert into VOIR values ('F06','P14');insert into VOIR values ('F06','P15');insert into VOIR values ('F06','P16');

insert into VOIR values ('F06','P17');insert into VOIR values ('F06','P18');insert into VOIR values ('F06','P19');

insert into VOIR values ('F06','P20');insert into VOIR values ('F06','P21');insert into VOIR values ('F06','P22');

insert into VOIR values ('F06','P23');insert into VOIR values ('F06','P24');insert into VOIR values ('F06','P25');

insert into VOIR values ('F06','P26');insert into VOIR values ('F06','P27');insert into VOIR values ('F06','P28');

insert into VOIR values ('F06','P29');insert into VOIR values ('F06','P30');insert into VOIR values ('F06','P31');

insert into VOIR values ('F06','P32');insert into VOIR values ('F06','P33');insert into VOIR values ('F06','P34');

insert into VOIR values ('F06','P35');



insert into VOIR values ('F07','P13');insert into VOIR values ('F07','P14');insert into VOIR values ('F07','P15');

insert into VOIR values ('F07','P16');insert into VOIR values ('F07','P17');insert into VOIR values ('F07','P18');

insert into VOIR values ('F07','P19');insert into VOIR values ('F07','P20');insert into VOIR values ('F07','P21');

insert into VOIR values ('F07','P22');insert into VOIR values ('F07','P23');insert into VOIR values ('F07','P24');



insert into VOIR values ('F08','P10');insert into VOIR values ('F08','P11');insert into VOIR values ('F08','P12');

insert into VOIR values ('F08','P13');insert into VOIR values ('F08','P14');insert into VOIR values ('F08','P15');

insert into VOIR values ('F08','P18');insert into VOIR values ('F08','P19');insert into VOIR values ('F08','P20');

insert into VOIR values ('F08','P21');


insert into VOIR values ('F09','P13');insert into VOIR values ('F09','P14');insert into VOIR values ('F09','P25');

insert into VOIR values ('F09','P26');insert into VOIR values ('F09','P27');insert into VOIR values ('F09','P28');

insert into VOIR values ('F09','P29');insert into VOIR values ('F09','P30');insert into VOIR values ('F09','P31');

insert into VOIR values ('F09','P32');insert into VOIR values ('F09','P33');insert into VOIR values ('F09','P34');

insert into VOIR values ('F09','P35');





insert into VOIR values ( 'F02', 'P34');

insert into VOIR values ( 'F02', 'P35');

insert into VOIR values ( 'F02', 'P36');

insert into VOIR values ( 'F02', 'P37');

insert into VOIR values ( 'F02', 'P1');

insert into VOIR values ( 'F02', 'P3');



insert into VOIR values ('F10','P1');insert into VOIR values ('F02','P2');insert into VOIR values ('F10','P3');

insert into VOIR values ('F10','P4');insert into VOIR values ('F10','P5');insert into VOIR values ('F10','P6');

insert into VOIR values ('F10','P7');insert into VOIR values ('F10','P8');insert into VOIR values ('F10','P9');

insert into VOIR values ('F10','P10');insert into VOIR values ('F10','P11');insert into VOIR values ('F10','P12');

insert into VOIR values ('F10','P13');insert into VOIR values ('F10','P14');insert into VOIR values ('F10','P15');

insert into VOIR values ('F10','P16');insert into VOIR values ('F10','P17');insert into VOIR values ('F10','P18');

insert into VOIR values ('F10','P19');insert into VOIR values ('F10','P20');insert into VOIR values ('F10','P21');

insert into VOIR values ('F10','P22');insert into VOIR values ('F10','P23');insert into VOIR values ('F10','P24');

insert into VOIR values ('F10','P25');insert into VOIR values ('F10','P26');insert into VOIR values ('F10','P27');

insert into VOIR values ('F10','P28');insert into VOIR values ('F10','P29');insert into VOIR values ('F10','P30');

insert into VOIR values ( 'F11', 'P37'); insert into VOIR values ( 'F11', 'P36');  

insert into VOIR values ( 'F11', 'P13'); insert into VOIR values ( 'F11', 'P14');    

insert into VOIR values ( 'F12','P13'); insert into VOIR values ( 'F12', 'P14'); 



insert into AIMER values ('F01','P1');
insert into AIMER values ('F10','P1');

insert into AIMER values ('F02','P2');
insert into AIMER values ('F01','P4');
insert into AIMER values ('F02','P4');

insert into AIMER values ('F10','P4');

insert into AIMER values ('F01','P5');
insert into AIMER values ('F02','P5');

insert into AIMER values ('F01','P6');
insert into AIMER values ('F02','P6');

insert into AIMER values ('F03','P7');
insert into AIMER values ('F02','P7');
insert into AIMER values ('F05','P7');

insert into AIMER values ('F03','P9');
insert into AIMER values ('F06','P9');
insert into AIMER values ('F05','P9');

insert into AIMER values ('F06','P10');
insert into AIMER values ('F08','P10');
insert into AIMER values ('F10','P10');

insert into AIMER values ('F08','P11');
insert into AIMER values ('F06','P11');
insert into AIMER values ('F05','P11');

insert into AIMER values ('F01','P12');
insert into AIMER values ('F02','P12');
insert into AIMER values ('F03','P12');

insert into AIMER values ('F04','P12');
insert into AIMER values ('F05','P12');
insert into AIMER values ('F06','P12');

insert into AIMER values ('F08','P12');
insert into AIMER values ('F10','P12');

insert into AIMER values ('F07','P13');
insert into AIMER values ('F08','P13');
insert into AIMER values ('F09','P13');

insert into AIMER values ('F03','P13');
insert into AIMER values ('F04','P13');
insert into AIMER values ('F05','P13');

insert into AIMER values ('F03','P14');
insert into AIMER values ('F04','P14');
insert into AIMER values ('F05','P14');

insert into AIMER values ('F08','P14');

insert into AIMER values ('F02','P15');
insert into AIMER values ('F03','P15');
insert into AIMER values ('F06','P15');

insert into AIMER values ('F08','P15');

insert into AIMER values ('F01','P16');
insert into AIMER values ('F06','P16');
insert into AIMER values ('F07','P16');

insert into AIMER values ('F01','P17');
insert into AIMER values ('F02','P17');
insert into AIMER values ('F03','P17');

insert into AIMER values ('F04','P17');
insert into AIMER values ('F06','P17');
insert into AIMER values ('F07','P17');

insert into AIMER values ('F10','P17');

insert into AIMER values ('F07','P18');
insert into AIMER values ('F10','P18');

insert into AIMER values ('F01','P19');
insert into AIMER values ('F02','P19');
insert into AIMER values ('F03','P19');

insert into AIMER values ('F04','P19');
insert into AIMER values ('F08','P19');

insert into AIMER values ('F01','P20');
insert into AIMER values ('F02','P20');
insert into AIMER values ('F04','P20');

insert into AIMER values ('F06','P20');
insert into AIMER values ('F07','P20');
insert into AIMER values ('F08','P20');

insert into AIMER values ('F10','P20');

insert into AIMER values ('F01','P21');
insert into AIMER values ('F02','P21');
insert into AIMER values ('F04','P21');

insert into AIMER values ('F06','P21');
insert into AIMER values ('F07','P21');
insert into AIMER values ('F08','P21');

insert into AIMER values ('F10','P21');

insert into AIMER values ('F01','P22');
insert into AIMER values ('F02','P22');
insert into AIMER values ('F04','P22');

insert into AIMER values ('F06','P22');

insert into AIMER values ('F04','P23');
insert into AIMER values ('F06','P23');

insert into AIMER values ('F07','P23');
insert into AIMER values ('F10','P23');

insert into AIMER values ('F06','P24');
insert into AIMER values ('F07','P24');

insert into AIMER values ('F09','P25');

insert into AIMER values ('F04','P26');

insert into AIMER values ('F01','P28');
insert into AIMER values ('F02','P28');
insert into AIMER values ('F09','P28');

insert into AIMER values ('F02','P29');
insert into AIMER values ('F04','P29');
insert into AIMER values ('F06','P29');

insert into AIMER values ('F04','P30');
insert into AIMER values ('F09','P30');

insert into AIMER values ('F09','P31');

insert into AIMER values ('F04','P32');

insert into AIMER values ('F02','P33');

insert into AIMER values ('F09','P34');
insert into AIMER values ('F06','P34');

insert into AIMER values ('F09','P35');
insert into AIMER values ('F06','P35');

insert into AIMER values ( 'F05','P8');

insert into AIMER values ( 'F05','P10');




