-- Si on ajoute un nouveau film, création d'un DVD avec prix à -1 par défaut (prix impossible donc à remplir plus tard)
CREATE OR REPLACE FUNCTION createDvdFromFilm()
RETURNS TRIGGER AS $$
BEGIN
	INSERT INTO dvds VALUES (
		(SELECT MAX(nodvd) FROM dvds) + 1, -- On récupère max nodvd actuel
		-1, -- Valeur d'erreur
		NEW.Titre -- Titre du film
	);
RETURN NEW;
END; $$ LANGUAGE 'plpgsql';

CREATE OR REPLACE TRIGGER trigger_createDvdFromFilm
AFTER INSERT ON films -- On réagit après l'ajout d'un film
FOR EACH ROW
	EXECUTE PROCEDURE createDvdFromFilm();
INSERT INTO films VALUES ('Bohemian Rhapsody', 134, 'Cursus Limited', 'Bryan Singer', 2018, 'biography');

SELECT * FROM dvds WHERE titre = 'Bohemian Rhapsody';


-- Si la durée de location n'est pas renseignée, mettre automatiquement 7j
CREATE OR REPLACE FUNCTION defaultLocationDuration()
RETURNS TRIGGER AS $$
BEGIN
	IF NEW.dureelocation IS NULL THEN
		UPDATE locations
		SET dureelocation = 7
		WHERE 
			nodvd = NEW.nodvd AND
			datelocation = NEW.datelocation;
	END IF;
RETURN NEW;
END; $$ LANGUAGE 'plpgsql';

CREATE OR REPLACE TRIGGER trigger_defaultLocationDuration
AFTER INSERT ON locations -- à la place de l'ajout dans locations
FOR EACH ROW
	EXECUTE PROCEDURE defaultLocationDuration();

INSERT INTO locations VALUES (406054, current_date, 84, NULL);
SELECT * FROM locations WHERE nodvd = 406054 AND datelocation = current_date;