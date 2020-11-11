<?php
//Création de la classe PersonneManager
class PersonneManager {
    private $db;
    //Ecrivez le constructeur et la méthode setDb()
    public function __construct($db) {
        $this->setDb($db);
    }

    public function setDb(PDO $db) {
        $this->db = $db;
    }

    //Ecrivez les méthodes suivantes :
    //public function add(Personne $p){}
    public function add(Personne $p){
        echo $p;
        // $sql = 'INSERT INTO personne (nom, prenom) VALUES (:nom, :prenom)';

        // $q = $this->db->prepare($sql);
        // $q->bindValue(':nom', $p->getNom());
        // $q->bindValue(':prenom', $p->getPrenom());
        
        $sql = "INSERT INTO `personne` (`nom`, `prenom`) VALUES (?, ?)";

        $q = $this->db->prepare($sql);
        $q->bindValue(1, $p->getNom(), PDO::PARAM_STR);
        $q->bindValue(2, $p->getPrenom(), PDO::PARAM_STR);
        $q->debugDumpParams();

        $r=$q->execute();

        return $r;
    }

    //public function getAll(){} --> retourne un tableau de Personne
    public function getAll(){
        $data=array();
        $sql='SELECT * FROM personne';

        $query=$this->db->prepare($sql);
        echo 
        $donnees=$query->execute();
        echo $donnees;
        /*foreach($donnees as $k=>$v) {
            $data[]=new Personne($v);
        }*/
        return $donnees;
    }

    //public function get($id){} --> retourne une Personne
    public function get($id){
        $sql = "SELECT * FROM `personne` WHERE id = :id ";

        $q = $this->db->prepare($sql);
        $q->bindValue(':id', $id, PDO::PARAM_INT);

        $r=$q->execute();
        return $r;
    }

    //public function delete(Personne $perso){}
    public function delete(Personne $perso){
        $sql = "DELETE FROM `personne` WHERE id = :id";
        
        $q = $this->db->prepare($sql);
        $q->bindValue(':id', $id, PDO::PARAM_INT);

        $r=$q->execute();
        return $r;
    }

    //public function update(Personne $p)
    public function update(Personne $p){
        $sql = "UPDATE `personne` SET `nom`=:nom,`prenom`=:prenom WHERE id = :id";
        
        $q = $this->db->prepare($sql);
        $q->bindValue(':id', $p->getid(), PDO::PARAM_INT);
        $q->bindValue(':nom', $p->getNom(), PDO::PARAM_STR);
        $q->bindValue(':prenom', $p->getprenom(), PDO::PARAM_STR);

        $r=$q->execute();
        return $r;
    }

}
?>