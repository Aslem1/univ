<?php
require('App/Interfaces/Vehicule.php');

abstract class Voiture implements Vehicule {
    //Attribut couleur
    public $couleur;
    //Attribut type (diesel, essence, electrique, hybride)
    public $type;
    //Attribut immatriculation
    public $immatriculation;
    //Attribut nom
    public $nom;

    //Constructeur couleur, type et immatriculation
    public function __construct($couleur, $type, $immatriculation,$nom) {
        $this->couleur = $couleur;
        $this->type = $type;
        $this->immatriculation = $immatriculation;
        $this->nom = $nom;
    }

    // ------------------------------------------------
    //Getter couleur
    public function getcouleur() {
        return $this->couleur;
    }

    //Setter couleur
    public function setcouleur($couleur) {
        $this->couleur=$couleur;
    }

    // ------------------------------------------------
    //Getter type
    public function gettype() {
        return $this->type;
    }

    //Setter type
    public function settype($type) {
        $this->type=$type;
    }

    // ------------------------------------------------
    //Getter immatriculation
    public function getimmatriculation() {
        return $this->immatriculation;
    }

    //Setter immatriculation
    public function setimmatriculation($immatriculation) {
        $this->immatriculation=$immatriculation;
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

    //Méthode __toString
    public function __toString() {
        return "Je suis un jet ski";
    }

    //Méthode polluer
    public abstract function polluer();

    //Redéfinition des méthodes de l'interface
    public function rouler() {
        $this->rouler=false;
    }

    public function naviguer() {
        $this->naviguer=true;
    }

    public function voler() {
        $this->voler=false;
    }
}
?>