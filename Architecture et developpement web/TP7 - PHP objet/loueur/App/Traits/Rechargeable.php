<?php
trait Rechargeable {
    //Attribut valeurEnergie
    public $valeurEnergie;

    //Méthode recharger
    public function recharger() {
        $valeurEnergie = 100;
    }

    //Getter valeurEnergie
    public function getvaleurEnergie() {
        return $this->valeurEnergie;
    }

    //Setter valeurEnergie
    public function setvaleurEnergie($valeurEnergie) {
        $this->valeurEnergie = $valeurEnergie;
    }
}
?>