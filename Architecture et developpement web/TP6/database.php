<?php
/**Créez la classe Database.php
 * Cette classe a 5 attributs comprenant les 4 paramètres deconnexion 
 * à la base de données et le point de connexion*/

class database {
    private $host = "localhost";
    private $db_name = "td6";
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