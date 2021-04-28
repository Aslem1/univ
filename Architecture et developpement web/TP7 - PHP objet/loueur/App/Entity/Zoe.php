<?php

chdir(__DIR__); // Permet de spécifier que l'on travail dans le répertoire contenant ce fichier
require('../Traits/Geolocalisation.php');
require('../Traits/Rechargeable.php');

unset($file_to_require);

class Zoe extends Voiture {
    use Geolocalisation;
    use Rechargeable;

    const TYPE_ENERGY = "electrique";

    //define("TYPE_ENERGY", "electrique");

    //Méthode __toString
    public function __toString() {
        return parent::__toString() . " Zoe de type ". Zoe::TYPE_ENERGY . " immatriculée $this->immatriculation";
    }

    public function polluer() {
        return "Je roule propre";
    }
}
?>