/* 1. Numéros des factures non réglées, en ordre croissant, et nom du client correspondant. */
/*
SELECT 
    distinct f.nofacture,
    c.nom
FROM 
    factures f
    JOIN interventions i ON f.nofacture = i.nofacture
    JOIN remplacements r ON r.nointerv = i.nointerv
    JOIN clients c ON i.noclient = c.noclient
WHERE 
    f.etat = 'C';
*/

/* 2. Désignation des produits qui n’ont jamais été remplacés */

/*
SELECT distinct
	designation p
FROM
	produits p
*/
/*produits qui n'ont jamais été relplacés = produits pas dans la table remplacement
*/

/* 3. Numéros et dates des factures réglées du client Rivoire, avec en plus numéros et date
des factures en cours du client Dallalon. */

SELECT
	f.nofacture
FROM
	factures f
	JOIN interventions i ON i.nofacture = f.nofacture
	JOIN clients c ON c.noclient = i.noclient
WHERE c.nom = 'Rivoire';

/* 4. Numéros des factures pour lesquelles à la fois Bonnaz et Saultier sont intervenus */

