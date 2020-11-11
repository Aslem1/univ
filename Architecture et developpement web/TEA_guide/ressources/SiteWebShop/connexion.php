<?php
class connexion {
    private $host = "localhost:3306";
    private $db_name = "sitewebshop";
    private $db_port = "3306";
    private $username = "root";
    private $password = "";
    private $conn;

    //Cette classe a la méthode getConnexion() permettant de créer le point de connexion
    public function getConnexion() {
        $this->conn = null;
        try {
            $this->conn = new PDO ("mysql:host=" . $this->host . ";dbname=" . $this->db_name. ";port=" . $this->db_port, $this->username, $this->password);
            $this->conn->exec("set names utf8");
        }
        
        catch (PDOException $exception) {
            echo "Connection error: " . $exception->getMessage();
        }
        return $this->conn;
    }
}
?>