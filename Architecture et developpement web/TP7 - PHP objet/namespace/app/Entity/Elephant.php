<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Interfaces/Animaux.php');

unset($file_to_require);

class Elephant extends Animaux {
    use Geolocalisation;

    const ESPECE = "Mamifère";
    const FAMILLE = "Elephantidae";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "L'éspèce de cet animal est ". Elephant::ESPECE . "et sa famille est ". Elephant::FAMILLE;;
    }
}
?>