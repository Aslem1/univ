<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Interfaces/Visite/infoVisite.php');

unset($file_to_require);

class Parc extends infoVisite {
    use Geolocalisation;

    const LIEU = "Parc";
    const LOCALISATION = "4 rue Jean Moulin";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "Ce lieu est un". Parc::LIEU . "et il est situé ". Parc::LOCALISATION;
    }
}
?>