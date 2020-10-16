/* QUestion 1 : Personnes ayant visité une ville que 'H-1948-002' a visité. */

SELECT
	*
FROM
	personnes p
	JOIN visites v ON v.pers = p.idpers
WHERE 
	v.ville IN (
		SELECT 
			v2.ville
		FROM 
			visites v2
		WHERE
			v2.pers = 'H-1948-002'
	);

/* Question 2 : Personnes ayant visité une ville pour laquelle une température négative a été relevée */

SELECT
	*
FROM
	personnes p
	JOIN visites v ON v.pers = p.idpers
WHERE
	v.ville IN (
		SELECT
			t.code
		FROM
			temps t
		WHERE
			t.t_basse < 0 OR
			t.t_haute < 0
	);

/* Personnes ayant visité toutes les villes - monde fermé (nombre de ville fini) */

SELECT
	p.*
FROM personnes p
WHERE NOT EXISTS (
	SELECT
		1
	FROM
		villes v
	WHERE NOT EXISTS (
		SELECT
			1
		FROM
			visites vs
		WHERE
			vs.ville = v.idville AND
			vs.pers = p.idpers
	)
);

/* Question 4 : Noms des villes et le nombre de jours où la température haute a été >= à 24 lorsque ce nombre de jours est > 3 */

SELECT
	v.nom,
	(SELECT COUNT(*) FROM temps t WHERE t.code = v.idville AND t.t_haute >= 24) AS nb
FROM
	villes v
WHERE 
	(SELECT COUNT(*) FROM temps t WHERE t.code = v.idville AND t.t_haute >= 24) > 3;