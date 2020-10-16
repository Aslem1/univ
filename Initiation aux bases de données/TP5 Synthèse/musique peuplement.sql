
-- TABLE labels
INSERT INTO labels (id_label, nom, type_production) VALUES 
(1, 'Epic Records', '*'),
(2, 'Megaforce', 'MePuRo'),
(3, 'Sanctuary Records', 'ReRoMe'),
(4, 'Roadrunner', 'RoMe'),
(5, 'Track', 'RoMe'),
(6, 'Elektra', 'RoBl');


-- TABLE groupes
INSERT INTO groupes (id_groupe, nom, date_creation, date_fin, label) VALUES
(1, 'Ozzy Osbourne', '01/01/1968', null, 1),
(2, 'Quiet Riot', '01/01/1975', null, 1),
(3, 'Metallica', '01/07/1981', null, 2),
(4, 'Black Sabbath', '01/01/1968', null, 3),
(5, 'Megadeth', '02/01/1983', null, 4),
(6, 'The Jimi Hendrix Experience', '01/01/1966', '18/09/1970', 1),
(7, 'The Doors', '01/01/1965', '31/12/1973', 6),
(8, 'Jimi Hendrix', '01/01/1963', '31/12/1965', 1);


-- TABLE musiciens
INSERT INTO musiciens(id_musicien, prenom, nom, date_naissance, date_deces, instrument) VALUES 
(1,'John Michael','Osbourne','03/12/1948',null, 'V-R'),-- ozzy F1 F2, BlackSab F1
(2,'Randall William','Rhoads','06/12/1956','19/03/1982', 'G-R'), -- grp : ozzy F1, quiet Riot F1
(3,'Robert John','Daisley','13/02/1950',null, 'B-R'), -- ozzy F1
(4,'Lee','Kerslake','16/04/1967',null, 'D-R'),--ozzy F1
(5,'Johnny','Cook','13/01/1956',null, 'G-R'), --ozzy, F2
(6,'Kelly','Garni','14/05/1957',null, 'B-R'), -- quiet riot F1
(7,'Drew','Forsyth','21/11/1951',null, 'D-R'), --quiet riot F1
(8,'James','Hetfield','03/08/1963',null, 'V-R'), -- meta F1 F2
(9,'Lars', 'Ulrich', '26/12/1963', null,'D-R'), -- meta F1 F2
(10,'Dave','Mustaine','13/09/1961', null, 'G-R'), --meta F1 / megadeth
(11,'Kirk','Hammett','18/11/1962', null, 'G-R'), --meta F2
(12,'Cliff','Burton','10/02/1962','27/10/1986', 'B-R'), -- meta F2
(13,'Ron','McGorvey','02/11/1962', null, 'B-R'), --meta F1
(14,'Tony','Iommi','19/02/1948',null, 'G-R'), -- BS F1
(15,'Geezer','Butler','17/07/1949', null, 'B-R'), -- BS F1
(16, 'Jimi', 'Hendrix', '27/11/1942', '18/09/1970', 'G-R'), --JimiH Exp F1 F2
(17, 'Noel', 'Redding', '25/12/1945', '11/05/2003', 'B-R'), -- JmiH Exp F1
(18, 'Mitch', 'Mitchell', '06/07/1947', '12/11/2008', 'D-R'), --JimiH Exp F1 F2
(19, 'Billy', 'Cox', '18/10/1941', null, 'B-R'), --JimiH Exp F2
(20, 'Jim', 'Morrison', '08/12/1943', '03/07/1971', 'V-B'), --The Doors F1 F2
(21, 'John', 'Densmore', '01/12/1944', null, 'D-B'), --The Doors F1 F2
(22, 'Ray', 'Manzarek', '12/02/1939', null, 'P-B'), --The Doors F1 F2
(23, 'Robby', 'Krieger', '08/01/1944', null, 'G-B'); --The Doors F2

-- TABLE formations
INSERT INTO formations(id_formation, date_creation, date_fin, groupe) VALUES
(1, '01/01/1968',  '01/01/1970', 1), --ozzy F1
(2, '02/01/1970', '31/12/1972', 1), --ozzy F2
(3, '01/01/1969', '31/12/1977', 4), --BS F1
(4, '01/01/1975', '31/12/1982', 2), -- quiet riot F1
(5, '01/01/1981', '01/01/1983', 3), --meta F1
(6, '01/02/1983', '01/01/1987', 3), --meta F2
(7, '02/01/1983', null, 5), --mega F1
(8, '01/01/1966', '31/12/1968' , 6), --JmiH Exp F1
(9, '01/01/1969', '18/09/1970' , 6), --JmiH Exp F2
(10, '01/07/1965', '01/09/1965' , 7), --The Doors F1
(11, '01/10/1965', '01/07/1971' , 7), --The Doors F2
(12, '01/01/1963', '31/12/1965', 8); --Jimi H


-- TABLE membres
INSERT INTO membres(musicien, formation, date_debut_participation, date_fin_participation) VALUES 
(1, 1, '01/01/1968', '01/01/1970'),
(1, 2, '02/01/1970', '31/12/1972'),
(2, 1, '01/01/1968', '01/01/1970'),
(2, 4, '01/01/1975', '19/03/1982'),
(3, 1, '01/01/1968', '01/01/1970'),
(4, 1, '01/01/1968', '01/01/1970'),
(5, 2, '02/01/1970', '31/12/1972'),
(6, 4, '01/01/1975', '31/12/1982'),
(7, 4, '01/01/1975', '31/12/1982'),
(8, 5, '01/01/1981', '01/01/1983'),
(8, 6, '01/02/1983', '01/01/1987'),
(9, 5, '01/01/1981', '01/01/1983'),
(9, 6, '01/02/1983', '01/01/1987'),
(10, 5, '01/01/1981', '01/01/1983'),
(10, 7, '02/01/1983', null),
(11, 6, '01/02/1983', '01/01/1987'),
(12, 6, '01/02/1983', '01/01/1987'),
(13, 5, '01/01/1981', '01/01/1983'),
(14, 3, '01/01/1969', '31/12/1977'),
(15, 3, '01/01/1969', '31/12/1977'),
(16, 8, '01/01/1966', '31/12/1968'),
(16, 9, '01/01/1969', '18/09/1970'),
(17, 8, '01/01/1966', '31/12/1968'),
(18, 8, '01/01/1966', '31/12/1968'),
(18, 9, '01/01/1969', '18/09/1970'),
(19, 9, '01/01/1969', '18/09/1970'),
(20, 10, '01/07/1965', '01/09/1965'),
(20, 11, '01/07/1965', '01/09/1965'),
(21, 10, '01/07/1965', '01/09/1965'),
(21, 11, '01/07/1965', '01/09/1965'),
(22, 10, '01/07/1965', '01/09/1965'),
(22, 11, '01/07/1965', '01/09/1965'),
(23, 11, '01/07/1965', '01/09/1965'),
(16, 12, '01/01/1963', '31/12/1965'),
(22, 12, '01/01/1963', '31/12/1965');

-- TABLE contrats
INSERT INTO contrats(id_contrat, date_contrat, cachet) VALUES
(1, '15/08/1969',10000), --woodstock Hendrix F2
(2, '05/07/1970', 25000), -- ilse of wight Hendrix F2
(3, '10/01/1970', 2000), -- Rock in london BS F1
(4, '13/05/1971', 50000), -- NY Festival Ozzy F1
(5, '05/05/1968', 8000), -- BluesNRock LA the Doors F2
(6, '12/06/1964', 5000); -- Jmi Hendrix

-- TABLE evenements
INSERT INTO evenements(id_evenement, nom, lieu, nombre_spectateur, formation, contrat) VALUES
(1, 'Woodstock Festival', 'USA-NY', 500000, 9,1),
(2, 'Isle of Wight Festival', 'UK', 80000, 9, 2),
(3, 'Rock In London', 'UK', 25000, 3, 3),
(4, 'New York Festival', 'USA-NY', 35000, 1, 4),
(5, 'BluesNRock Los Angeles', 'USA', 100000, 11, 5),
(6, 'Rock With Jimi', 'FR', 10000, 12, 6);