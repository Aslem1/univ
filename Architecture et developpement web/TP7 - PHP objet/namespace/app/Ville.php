<?php
class Ville {
    //Attribut nom
    public $nom;
    //Constructeur
    public function __construct($nom) {
        $this->nom = $nom;
    }

    //Méthode __toString
    public function __toString() {
        return $this->nom;
    }
}
?>