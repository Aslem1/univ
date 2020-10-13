
/* 1. Nombre de films vus (Alias as nbre_films_vus) par spectateur (nom du
spectateur et nombre de films). */

SELECT 
	i.nompers,
	COUNT (v.nofilm) AS nbre_films_vus
FROM 
	voir v
	JOIN individus i ON v.nospect = i.nopers
GROUP BY 
	i.nompers
ORDER BY
	i.nompers ASC;


/* 2. Numéros et noms des acteurs qui ont joué plus de 3 films (strictement). */
SELECT 
	j.noacteur, 
	i.nompers
FROM
	individus i
	JOIN jouer j ON j.noacteur = i.nopers
GROUP BY
	j.noacteur,
	i.nopers
HAVING 
	COUNT (j.nofilm) > 3
ORDER BY
	COUNT (j.nofilm) DESC;


/* 3. Numéros et titres des films qui ont été aimés par plus de dix personnes
(strictement). */
SELECT 
	f.nofilm,
	f.titre
FROM 
	films f
	JOIN aimer a ON f.nofilm = a.nofilm
GROUP BY
	f.nofilm,
	f.titre
HAVING
	COUNT (a.nospect) > 10
ORDER BY
	COUNT (a.nospect) DESC;


/* 4. Titres des films et nombre de spectateurs (Alias as nbre_spectateurs) qui
ont été vus par moins de 5 personnes (strictement). */
SELECT 
	f.titre,
	COUNT (v.nospect) AS nbre_spectateurs
FROM
	films f
	JOIN voir v ON f.nofilm = v.nofilm
GROUP BY
	f.titre
HAVING
	COUNT (v.nospect) < 5;


/* 5. Nombre de personnes distinctes (Alias as nbre_films_de_matthieu_aimes)
qui ont aimé les films réalisés par Matthieu. Donnez deux requêtes
possibles, dont une avec une sous-requête (un seul dépôt Moodle).*/
SELECT 
	COUNT (DISTINCT a.nospect) AS nbre_films_de_matthieu_aimes
FROM 
	aimer a
	JOIN films f ON a.nofilm = f.nofilm
	JOIN individus i ON f.norealisateur = i.nopers
WHERE
	i.nompers = 'Matthieu';


/* 6. Nombre d'acteurs (Alias AS nbre) qui ont produit un film. Donnez deux
requêtes possibles, dont une avec une sous-requête (un seul dépôt
Moodle). */
SELECT
	COUNT (DISTINCT j.noacteur) AS nbre
FROM 
	jouer j
	JOIN films f ON j.noacteur = f.noproducteur;
	

/* 7. Numéros et noms des acteurs qui jouent dans un film qu’ils ont produit. */
SELECT 
	j.noacteur,
	i.nompers
FROM
	jouer j
	JOIN individus i ON j.noacteur = i.nopers
	JOIN films f ON j.nofilm = f.nofilm
WHERE 
	f.noproducteur = j.noacteur;


/* 8. Numéros et noms des personnes qui ont vu au moins un film (voire
plusieurs), mais qui n’en ont aimé aucun. 
Donnez deux requêtes possibles (une avec NOT IN, une avec NOT EXISTS) 
(Un seul dépôt Moodle). */
SELECT 
	DISTINCT i.nopers,
	i.nompers
FROM
	voir v
	JOIN individus i ON v.nospect = i.nopers
WHERE
	i.nopers NOT IN (SELECT a.nospect FROM aimer a);


/* 9. Numéros des films que personne n’a aimés (c’est-à-dire qu’aucun des
spectateurs qui les a vus ne les a aimés). Donnez deux requêtes
possibles (une avec NOT IN, une avec NOT EXISTS) (Un seul dépôt
Moodle). */
SELECT
	DISTINCT v.nofilm
FROM
	voir v
WHERE
	v.nofilm NOT IN (SELECT a.nofilm FROM aimer a)
ORDER BY v.nofilm ASC;


/* 10. Numéros (producteur) et noms des producteurs qui ne voient que
les films qu’ils produisent (il n’existe aucun film qu’ils ont vus mais qu’ils
n’ont pas produit). Donnez deux requêtes possibles (Un seul dépôt
Moodle). */


