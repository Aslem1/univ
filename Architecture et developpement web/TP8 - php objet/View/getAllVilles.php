<?php
chdir(__DIR__);
require "Database.php";

class getAllVilles {
    public function getVille() {
        $data = array();
        $sql = `SELECT * FROM `ville``;
        $query = $this->db->prepare($sql);
        $donnes = $query->execute();
        var_dump($donnes);
    }
}
?>