<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Interfaces/Visite/infoVisite.php');

unset($file_to_require);

class Monument extends infoVisite {
    use Geolocalisation;

    const LIEU = "Monument";
    const LOCALISATION = "5 rue Léon Gambetta";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "Ce lieu est un". Monument::LIEU . "et il est situé ". Monument::LOCALISATION;
    }
}
?>