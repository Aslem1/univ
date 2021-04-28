<?php
class database {
    private string $host = "localhost";
    private string $db_name = "voyage";
    private string $db_port = "3306";
    private string $username = "root";
    private string $password = "";
    private PDO $conn;

    //Cette classe a la méthode getConnexion() permettant de créer le point de connexion
    public function getConnexion():PDO {
        try {
            $this->conn = new PDO ("mysql:host=" . $this->host . ";dbname=" . $this->db_name. ";port=" . $this->db_port, $this->username, $this->password);
            $this->conn->exec("set names utf8");
        } catch (PDOException $exception) {
            echo "Connection error: " . $exception->getMessage();
        }
        return $this->conn;
    }
}
?>