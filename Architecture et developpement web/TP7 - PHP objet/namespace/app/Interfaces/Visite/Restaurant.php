<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Interfaces/Visite/infoVisite.php');

unset($file_to_require);

class Restaurant extends infoVisite {
    use Geolocalisation;

    const LIEU = "Restaurant";
    const LOCALISATION = "3 rue Jean Jaurès";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "Ce lieu est un". Restaurant::LIEU . "et il est situé ". Restaurant::LOCALISATION;
    }
}
?>