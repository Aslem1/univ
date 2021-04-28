<?php

require('../Traits/Geolocalisation.php');
require('../Interfaces/Animaux.php');

unset($file_to_require);

class pandaRoux extends Animaux {
    use Geolocalisation;

    const ESPECE = "Mamifère";
    const FAMILLE = "Ailuridae";


    //Méthode __toString
    public function __toString() {
        return parent::__toString() . "L'éspèce de cet animal est ". Elephant::ESPECE . "et sa famille est ". Elephant::FAMILLE;;
    }
}
?>