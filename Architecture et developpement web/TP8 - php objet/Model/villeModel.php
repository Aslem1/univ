<?php
require ("Model.php");
class villeModel extends Model {

    /**
     * villeModel constructor.
     */
    public function __construct() {
        parent::__construct("ville");
    }

    public function findAll() {
        $villes = [];
        $liste = parent::find();
        foreach ($liste as $tabVille) {
            array_push($villes, new Ville($tabVille));
        }
        return $villes;
    }
}
?>
