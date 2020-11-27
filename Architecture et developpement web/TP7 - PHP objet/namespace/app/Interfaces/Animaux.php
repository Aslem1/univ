<?php

abstract class Animaux {
    //Attribut espèce
    public $espece;
    //Attribut nom
    public $nom;
    //Attribut famille
    public $famille;

    //Constructeur espèce, nom et famille
    public function __construct($espece, $nom, $famille) {
        $this->espece = $espece;
        $this->nom = $nom;
        $this->famille = $famille;
    }

    // ------------------------------------------------
    //Getter espèce
    public function getespece() {
        return $this->espece;
    }

    //Setter espèce
    public function setespece($espece) {
        $this->couleur=$couleur;
    }

    // ------------------------------------------------
    //Getter nom
    public function getnom() {
        return $this->nom;
    }

    //Setter nom
    public function setnom($nom) {
        $this->nom=$nom;
    }
    
    // ------------------------------------------------
    //Getter famille
    public function getfamille() {
        return $this->famille;
    }

    //Setter famille
    public function setfamille($famille) {
        $this->famille=$famille;
    }

    //Méthode __toString
    public function __toString() {
        return "Je suis un animal";
    }

    //Redéfinition des méthodes de l'interface
    public function marcher() {
        $this->marcher=true;
    }

    public function nager() {
        $this->nager=true;
    }

    public function voler() {
        $this->voler=true;
    }
}
?>