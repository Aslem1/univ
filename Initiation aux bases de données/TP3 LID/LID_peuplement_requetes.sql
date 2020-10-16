/* 1. Numéros des factures non réglées, en ordre croissant, et nom du client correspondant. */

SELECT 
    distinct f.nofacture,
    c.nom
FROM 
    factures f
    JOIN interventions i ON f.nofacture = i.nofacture
    JOIN clients c ON i.noclient = c.noclient
WHERE 
    f.etat = 'C'
ORDER BY f.nofacture;


/* 2. Désignation des produits qui n’ont jamais été remplacés */

SELECT
	p.designation 
FROM
	produits p
WHERE 
	p.reference NOT IN (SELECT r.reference FROM remplacements r);


/* 3. Numéros et dates des factures réglées du client Rivoire, avec en plus numéros et date
des factures en cours du client Dallalon. */

SELECT
	f.nofacture,
	f.datefacture
FROM
	factures f
	JOIN interventions i ON i.nofacture = f.nofacture
	JOIN clients c ON c.noclient = i.noclient
WHERE 
	(c.nom = 'Rivoire' AND 
	f.etat = 'R') OR
	(c.nom = 'Dallalon' AND
	f.etat = 'C');

/* 4. Numéros des factures pour lesquelles à la fois Bonnaz et Saultier sont intervenus */

SELECT
	i.nofacture
FROM 
	interventions i
WHERE 
	i.nominterv = 'Bonnaz' AND 
	i.nofacture IN (SELECT
	i2.nofacture
FROM
	interventions i2
WHERE
	i2.nominterv = 'Saultier');
	

/* 5.Liste des factures par ordre croissant des numéros, en indiquant pour chaque facture le no de la facture et le nom du client. */

SELECT
	DISTINCT i.nofacture,
	c.nom
FROM
	interventions i
	JOIN clients c ON i.noclient = c.noclient
ORDER BY i.nofacture;

/* 6.Liste de toutes les références de produits par ordre décroissant des quantités remplacées, 
en indiquant pour chaque produit sa référence, le numéro de l’intervention,et leur quantité remplacée. 
Même les références de produits qui n’ont jamais été remplacés doivent y figurer, dans ce cas la colonne qteremplacee devra être vide 
(c.f. fichier RESULTATS.rtf). */

SELECT
	p.reference,
	r.nointerv,
	r.qteremplacee
FROM
	produits p
	LEFT JOIN remplacements r ON p.reference = r.reference
ORDER BY r.qteremplacee DESC,
p.reference ASC;

/* 7.Liste de toutes les factures en ordre croissant des numéros de facture, en indiquant les numéros d’interventions correspondants. 
Même les factures n’ayant pas donné lieu à une intervention doivent apparaître dans le résultat, 
dans ce cas la colonne nointerv devra être vide (c.f. fichier RESULTATS.rtf). */
SELECT 
	f.nofacture,
	i.nointerv
FROM
	factures f
	LEFT JOIN interventions i ON f.nofacture = i.nofacture
ORDER BY f.nofacture;


/* 8.Liste des clients (numéro et nom) qui n’ont jamais eu d’intervention. 
(Proposez 2 solutions : l'une avec IN, l'autre avec EXISTS; une seule solution sera déposée sur Moodle). */ 

/* Solution IN*/
SELECT
	c.noclient,
	c.nom
FROM
	clients c
WHERE c.noclient NOT IN (SELECT i.noclient FROM interventions i);

/* Solution EXISTS */
SELECT
	c.noclient,
	c.nom
FROM
	clients c
WHERE NOT EXISTS (SELECT i.noclient FROM interventions i WHERE i.noclient = c.noclient);


/* 9.Liste des références et désignations des produits qui ont été remplacés dans toutes les interventions (COUNT INTERDIT). 
Avec le jeu de données actuel, cette requête ne retourne aucun tuple. 
Insérez des tuples dans certaines tables de sorte que cette requête ait au moins un tuple en sortie. */

SELECT
	p.reference,
	p.designation
FROM
	produits p
WHERE NOT EXISTS (
	SELECT 
		1
	FROM
		interventions i
	WHERE NOT EXISTS (
		SELECT
			1
		FROM
			remplacements r
		WHERE i.nointerv = r.nointerv AND r.reference = p.reference
	)
);

/* 10.Clients (tous les attributs) qui n’ont pas subi d’interventions 
(proposez 2 solutions : l'une avec IN, l'autre avec EXISTS; une seule solution sera déposée sur Moodle). */

/* Solution IN*/
SELECT
	c.*
FROM
	clients c
WHERE c.noclient NOT IN (SELECT i.noclient FROM interventions i);


/* Solution EXISTS */
SELECT
	c.*
FROM
	clients c
WHERE NOT EXISTS (SELECT i.noclient FROM interventions i WHERE i.noclient = c.noclient);
