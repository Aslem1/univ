<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Interfaces/Animaux.php');

unset($file_to_require);

class Crocodile extends Animaux {
    use Geolocalisation;

    const ESPECE = "Reptile";
    const FAMILLE = "Crocodylidae";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "L'espèce de cet animal est ". Crocodile::ESPECE . "et sa famille est ". Crocodile::FAMILLE;
    }
}
?>