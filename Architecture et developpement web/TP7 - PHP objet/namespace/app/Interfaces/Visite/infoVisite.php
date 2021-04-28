<?php 
class infoVisite {
    //Attribut lieu
    public $lieu;
    //Attribut localisation
    public $localisation;

    //Constructeur lieu, localisation
    public function __construct($lieu, $localisation) {
        $this->lieu = $lieu;
        $this->localisation = $localisation;
    }

    //Getter lieu
    public function getlieu() {
        return $this->lieu;
    }

    //Setter lieu
    public function setlieu($lieu) {
        $this->lieu=$lieu;
    }

    //Getter localisation
    public function getlocalisation() {
        return $this->localisation;
    }

    //Setter localisation
    public function setlocalisation($localisation) {
        $this->localisation=$localisation;
    }
}
?>