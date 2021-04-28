<?php
class Ville2 {
    //Attribut nom
    public $nom;
    //Attribut population
    public $population;
    public $date;

    //Constructeur nom et population
    public function __construct($nom, $population) {
        $this->nom = $nom;
        $this->population = $population;
        $this->date = new DateTime('2015-01-01');
    }

    //Méthode __toString
    public function __toString() {
        //Utilisation de la classe DateTime
        return $this->nom." ".$this->population." ".$this->date->format('Y');
    }
}
?>