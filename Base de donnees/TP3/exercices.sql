-- 1. Ecriture de fonctions simples
-- Exercice 1 : Ecrire une fonction qui prend deux chaînes et retourne la plus longue. 
-- La fonction retourne la première chaîne si elles ont la même longueur
CREATE OR REPLACE FUNCTION chaine (x text, y text)
RETURNS TEXT AS $$
DECLARE
BEGIN
    IF char_length(x) >= char_length(y) THEN
            RETURN x;
        ELSE 
            RETURN y;
    END IF;
END; $$ LANGUAGE plpgsql;

SELECT chaine ('ceci est un test', 'encore un');
SELECT chaine ('un deuxième test', 'voila un deuxième test pour vérifier que tout fonctionne');
SELECT chaine ('Et enfin', 'le dernier');

-- Exercice 2 : Ecrire une fonction qui prend un texte et affiche (notice) tous les mots un par un.
-- N’oubliez pas que les notices s’affichent dans la fenêtre messages.
-- On considère que les mots sont séparés par des espaces et rien d’autre. 
DROP FUNCTION IF EXISTS afficheMots(text);
CREATE OR REPLACE FUNCTION afficheMots (chaine text)
RETURNS TEXT AS $$
DECLARE
	resultat text[];
	t text;
BEGIN
	resultat = regexp_split_to_array(chaine,' ');
	
FOREACH t IN ARRAY resultat
LOOP
	RAISE NOTICE '%', t;
END LOOP;
END; $$ LANGUAGE plpgsql;

SELECT afficheMots('ici ma super chaine');
SELECT afficheMots('ici une chaine');

-- Exercice 3 :  Ecrire une version itérative de la fonction factorielle. 
-- Votre fonction doit avoir le même comportement que la version récursive du slide 11 du cours.
DROP FUNCTION IF EXISTS factorielle(integer);
CREATE FUNCTION factorielle(n integer)
RETURNS INTEGER AS $$
DECLARE 
    res integer := 1;
    increment integer := 2;
BEGIN
    WHILE increment <= n LOOP
        res = increment*res;
        increment = increment +1;
    END LOOP;
RETURN res;
END; $$ LANGUAGE plpgsql;

SELECT factorielle(5);
SELECT factorielle(0);
SELECT factorielle(-1); --Devrait retourner -1

-- Exercice 4 :  Calculer la somme des durées de tous les films en écrivant une requête SQL.
-- Puis faire la même chose avec une fonction parcourant tous les enregistrements un par un (avec for x in et un RECORD) et retournant le même résultat. 
-- Assurez-vous que les deux méthodes retournent le même résultat.
SELECT SUM(films.Duree) AS somme_duree
FROM films

-- Fonction parcourant tous les enregistrements
DROP FUNCTION IF EXISTS sommeDuree();
CREATE FUNCTION sommeDuree()
RETURNS INTEGER AS $$
DECLARE
	somme int :=0;
	rec RECORD;
BEGIN
	FOR rec IN SELECT Duree FROM films LOOP
		somme = somme + rec.Duree;
		RAISE NOTICE '%', somme;
	END LOOP;
RETURN somme;
END; $$ LANGUAGE plpgsql;
	
SELECT sommeDuree();

--Exercice 5 : Calculer le prix moyen d’achat des films en écrivant une requête SQL 
-- puis refaites de même avec une fonction parcourant les enregistrements avec un curseur.
-- Et une boucle.
-- La fonction devra lever une exception s’il n’y a aucun élément dans la table.
-- Assurez-vous que les deux méthodes retournent le même résultat et testez l’exception en vidant la table
-- (TRUNCATE TABLE)
SELECT AVG(PrixAchat) 
	FROM dvds
	
-- Fonction parcourant les enregistrements avec un curseur
DROP FUNCTION IF EXISTS parcoursCurseur();
CREATE OR REPLACE FUNCTION parcoursCurseur()
RETURNS FLOAT AS $$
DECLARE	
	curs CURSOR FOR SELECT PrixAchat FROM dvds;
	rec RECORD;
	n integer :=0;
	moyenne float :=0.0;
	somme float :=0.0;
BEGIN
	OPEN curs;
	LOOP
		FETCH curs INTO rec;
		IF NOT FOUND THEN EXIT; END IF;
			somme = somme + rec.PrixAchat;
			n = n+1;
	END LOOP;
	CLOSE curs;
	moyenne = somme/n;
RETURN moyenne;
END; $$ LANGUAGE plpgsql;

SELECT parcoursCurseur();


-- Exercice 7 : Ecrire un trigger (avec la fonction associée) qui lève une exception
-- si on tente d’insérer ou de modifier un film en mettant une année de sortie inférieure à 1891.
--  L’exception doit afficher l’année que l’on tente d’insérer.
CREATE OR REPLACE FUNCTION exception1891()
RETURNS TRIGGER AS $monTrigger$ $$
BEGIN
	IF films.AnneeSortie < 1891
		RAISE EXCEPTION '% n'est pas une entrée valide';
	END IF;
RETURN 
END;
$monTrigger$; $$ LANGUAGE plpgsql;

CREATE TRIGGER monTrigger BEFORE INSERT OR UPDATE on films
	FOR EACH ROW EXECUTE PROCEDURE monTrigger();

SELECT exception1891();	
