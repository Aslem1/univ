<?php

chdir(__DIR__);
require "../Traits/Geolocalisation.php";

class Ville {
    //Attributs
    public $id;
    public $nom;
    public $population;
    public $pays_id;

    use Geolocalisation;

    //Constructeur
    public function __construct(array $data) {
        $this->hydrate($data);
    }

    //Hydratation
    public function hydrate(array $donnees) {
        foreach ($donnees as $key => $value) {
            $method = 'set'.ucfirst($key);
            if (method_exists($this, $method)) {
                $this->$method($value);
            }
        }
    }

    //toString
    public function __toString() {
        return $this->id. " ".$this->nom. " ".$this->population. " ".$this->pays_id;
    }

    /**
     * @return mixed
     */
    public function getid() {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setid($id): void {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getnom() {
        return $this->nom;
    }

    /**
     * @param mixed $nom
     */
    public function setnom($nom): void {
        $this->nom = $nom;
    }

    /**
     * @return mixed
     */
    public function getpopulation() {
        return $this->population;
    }

    /**
     * @param mixed $population
     */
    public function setpopulation($population): void {
        $this->population = $population;
    }

    /**
     * @return mixed
     */
    public function getpays_id() {
        return $this->pays_id;
    }

    /**
     * @param mixed $pays_id
     */
    public function setpays_id($pays_id): void {
        $this->pays_id = $pays_id;
    }

}
?>