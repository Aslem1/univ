/* 3. La date de création d'un groupe doit être inférieure à sa date de fin */
SELECT *
FROM
	musiciens m
	
WHERE 
	g.date_creation > g.date_fin;


/* 3. De la même façon, la table “musiciens” 
enregistre la date de naissance et de décès d’un artiste. 
Définissez une contrainte qui s’assure que la date de décès
d’un musicien intervient au moins 16 ans après sa naissance (sans quoi
sa présence en base de données n’est pas autorisée : interval ‘16 years’).*/
SELECT *
FROM 
	musiciens m
WHERE
	m.date_naissance INTERVAL '16 years' m.date_deces;
	


/* 1. Écrivez une requête qui ajoute l’attribut “cachet” (type entier) 
à la table “contrats”(par défaut, le cachet est de 1000 dollars) 
après création des tables.*/
ALTER TABLE contrats
ADD cachet numeric;


/* 3. Construire une requête affichant tous les noms (distincts et ordonnés),
prénoms des musiciens, leur date de naissance, leur date de décès, leur
instrument et le nom de leur groupe.*/
SELECT
	m.nom,
	m.prenom,
	m.date_naissance,
	m.date_deces,
	m.instrument,
	f.groupe
FROM
	musiciens m
	JOIN formation f ON m.instrument = f.instrument;
	
/* 4. Construire une requête affichant tous les noms de labels, leur type de
production, le nombre de groupes qu’ils produisent et leur chiffre
d’affaire, sachant que pour chaque spectateur, la compagnie gagne 20
euros. */
SELECT
	*
FROM
	labels l
	JOIN groupes g ON l.id_label = g.label;

/*5. Construire une requête qui affichera : les noms (ordonnés, distincts) des
groupes (ALIAS nom_groupe) dont l’âge moyen des membres est
inférieure à 60 et, pour chacun de ces groupes, l'âge moyen de leur
membres (ALIAS age_moyenne). Indice pour gérer le fait que certains
membres sont morts, d'autres toujours vivants : la fonction
COALESCE(a,b) retourne a si a n’est pas NULL, sinon, elle retourne b.
Utilisez current_date pour les membres qui ne sont pas morts. */











