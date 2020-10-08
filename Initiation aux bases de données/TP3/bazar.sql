-- Database: Bazar
DROP TABLE IF EXISTS visites;
DROP TABLE IF EXISTS personnes;
DROP TABLE IF EXISTS temps;
DROP TABLE IF EXISTS villes;
DROP DOMAIN IF EXISTS d_idville;
DROP DOMAIN IF EXISTS d_idpers;

CREATE DOMAIN d_idville AS char(6)
  CHECK (VALUE SIMILAR TO '(M|V|B)-[[:digit:]]{4}');

CREATE TABLE villes (
  idville d_idville,
  nom varchar(80),
  emplacement point, -- type specifique à PostGreSQL // MAL
  PRIMARY KEY(idville)
);

INSERT INTO villes (idville, nom, emplacement) 
  VALUES ('V-0001','La Rochelle', '(46.15, -1.15)');
INSERT INTO villes (idville, nom, emplacement) 
  VALUES ('B-0002', 'La Rochelle', '(47.44, 5.43)');
INSERT INTO villes (idville, nom, emplacement) 
  VALUES ('M-0003', 'Bordeaux', '(44.84, -0.58)');
INSERT INTO villes (idville, nom, emplacement) 
  VALUES ('M-0004', 'Paris', '(48.85, 2.35)');
INSERT INTO villes (idville, nom, emplacement) 
  VALUES ('B-0005', 'Melle', '(44.56, 7.32)');

CREATE TABLE temps (
  code d_idville,
  t_basse int,        -- temperature basse
  t_haute int,        -- temperature haute
  prcp real,          -- precipitation en pourcentage
  jour date,
  PRIMARY KEY(code, jour), -- une et une seule donnée météo par ville et par jour
  FOREIGN KEY(code) REFERENCES villes(idville),
  CHECK (prcp BETWEEN 0 AND 100)
);

INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 13, 20, 0.00, '04/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 14, 16, 0.00, '05/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 12, 19, 0.05, '06/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 13, 19, 0.31, '07/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 13, 20, 0.66, '08/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 14, 16, 0.73, '09/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('V-0001', 13, 15, 0.24, '10/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 14, 28, 0.00, '04/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 16, 23, 0.00, '05/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 13, 24, 0.05, '06/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 14, 24, 0.19, '07/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 14, 26, 0.05, '08/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 14, 21, 0.05, '09/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0003', 13, 18, 0.24, '10/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.00, '04/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004',  8, 16, 0.00, '05/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.01, '06/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.01, '07/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.02, '08/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.20, '09/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('M-0004', 12, 20, 0.50, '10/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('B-0005', 12, 24, 0.00, '04/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('B-0005', 15, 21, 0.00, '05/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('B-0005', 12, 21, 0.01, '06/05/2020');
INSERT INTO temps (code, t_basse, t_haute, prcp, jour) 
  VALUES ('B-0005', -12, 21, 0.01, '07/05/2020');

-- SEXE puis ANNEE NAISSANCE 19XX ou 20XX puis CODE
 
CREATE DOMAIN d_idpers AS char(10)
  CHECK (VALUE SIMILAR TO '(F|H|A)-(00|19|20)[[:digit:]]{2}-[[:digit:]]{3}');

CREATE TABLE personnes (
  idpers d_idpers PRIMARY KEY,
  nom     varchar(40),
  prenom  varchar(40),
  parent d_idpers REFERENCES personnes(idpers)
);

INSERT INTO personnes (idpers, nom, prenom) 
  VALUES ('F-1922-001', 'Guirriec', 'Aline');
INSERT INTO personnes (idpers, nom, prenom, parent) 
  VALUES ('H-1948-002', 'Viaud', 'Jean', 'F-1922-001');
INSERT INTO personnes (idpers, nom, prenom, parent) 
  VALUES ('H-1978-003', 'Viaud', 'Jean-François', 'H-1948-002');
INSERT INTO personnes (idpers, nom, prenom) 
  VALUES ('H-2065-004', 'Skywalker', 'Anakin');
INSERT INTO personnes (idpers, nom, prenom, parent) 
  VALUES ('H-2084-005', 'Skywalker', 'Luc', 'H-2065-004');
INSERT INTO personnes (idpers, nom) 
  VALUES ('A-0000-000', 'Dieu');
INSERT INTO personnes (idpers, nom, parent) 
  VALUES ('H-0001-007', 'Lucifer', 'A-0000-000');

CREATE TABLE visites (
  pers d_idpers,
  ville d_idville,  
  jour date,
  PRIMARY KEY (pers, ville, jour), -- Une personne visite une ville par jour
  FOREIGN KEY (pers) REFERENCES personnes(idpers),
  FOREIGN KEY (ville) REFERENCES villes(idville)
);

INSERT INTO visites(pers, ville, jour) VALUES ('F-1922-001', 'V-0001', '13/01/1962');
INSERT INTO visites(pers, ville, jour) VALUES ('F-1922-001', 'B-0002', '18/03/1958');
INSERT INTO visites(pers, ville, jour) VALUES ('F-1922-001', 'M-0003', '11/05/1949');
INSERT INTO visites(pers, ville, jour) VALUES ('F-1922-001', 'M-0004', '01/08/1992');
INSERT INTO visites(pers, ville, jour) VALUES ('F-1922-001', 'B-0005', '22/12/2008');

INSERT INTO visites(pers, ville, jour) VALUES ('H-1948-002', 'V-0001', '07/09/2001');
INSERT INTO visites(pers, ville, jour) VALUES ('H-1948-002', 'M-0003', '11/05/1949');

INSERT INTO visites(pers, ville, jour) VALUES ('H-1978-003', 'V-0001', '24/12/2002');
INSERT INTO visites(pers, ville, jour) VALUES ('H-1978-003', 'M-0003', '24/12/2003');
INSERT INTO visites(pers, ville, jour) VALUES ('H-1978-003', 'B-0005', '24/12/2004');

INSERT INTO visites(pers, ville, jour) VALUES ('A-0000-000', 'B-0005', '01/01/0002');
INSERT INTO visites(pers, ville, jour) VALUES ('H-0001-007', 'B-0005', '01/01/0002');

INSERT INTO visites(pers, ville, jour) VALUES ('A-0000-000', 'V-0001', '01/01/0003');
INSERT INTO visites(pers, ville, jour) VALUES ('H-0001-007', 'V-0001', '01/01/0003');

-- Personnes et Villes qu'ils ont visitées, y compris les personnes hors de la galaxie
-- Puis, modifier les données pour "ville visitée par tout le monde"
-- INSERT INTO visites(pers, ville, jour) VALUES ('H-2065-004', 'V-0001', '01/01/2099');
-- INSERT INTO visites(pers, ville, jour) VALUES ('H-2084-005', 'V-0001', '01/01/2099');


/* Il fait chaud aujourd'hui : 
  Noms des villes (chaude en premier, froide en second) pour lesquelles 
  une température basse (de la ville chaude) correspond à la température 
  haute (de la ville froide), le même jour.
 */
/*
SELECT VG.nom, VD.nom
FROM villes VG
JOIN temps TG on TG.code = VG.idville
JOIN temps TD on TD.t_haute = TG.t_basse
JOIN villes VD on VD.idville = TD.code
WHERE TG.jour = TD.jour;
*/
