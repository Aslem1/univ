<?php
chdir(__DIR__);
require "../Config/Database.php";

class Model {
    //Attributs
    public PDO $connexion;
    public $table;

    /**
     * Model constructor.
     * @param $connexion
     * @param $table
     */
    public function __construct($table) {
        $this->table = $table;
        $db = new Database();
        $this->connexion = $db->getConnexion();
    }

    public function find() {
        $sql = "SELECT * FROM `$this->table`";

        $query=$this->connexion->prepare($sql);
        $donnees = [];
        if ($query->execute()){
            $donnees = $query->fetchAll();
        }
        return $donnees;
    }
}
?>