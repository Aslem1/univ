<?php
//Création de la classe ArticleManager
class ArticleManager {
    private $db;

    public function __construct($db){
        $this->setDb($db);
    }

    public function setDb(PDO $db){
        $this->db = $db;
    }

    public function get3(){
        $data=array();
        $sql='SELECT * FROM article ORDER BY RAND() LIMIT 3';

        $query=$this->db->prepare($sql);
        $donnees = [];
        if ($query->execute()){
            $donnees = $query->fetchAll();
        }
        $data = [];
        foreach($donnees as $k=>$v) {
            $data[$k] = new Article($v);
        }
        return $data;
    }


    public function add(Article $a){
        $sql = 'INSERT INTO article (id_article, id_categorie, designation, prix, tva, description, img_article) VALUES (:id_article, :id_categorie, :designation, :prix, :tva, :description, :img_article)';

        $q = $this->db->prepare($sql);
        $q->bindValue(':id_article', $p->getid_article());
        $q->bindValue(':id_categorie', $p->getid_categorie());
        $q->bindValue(':designation', $p->getdesignation());
        $q->bindValue(':prix', $p->getprix());
        $q->bindValue(':tva', $p->gettva());
        $q->bindValue(':description', $p->getdescription());
        $q->bindValue(':img_article', $p->getimg_article());
        
        /*
        $sql = "INSERT INTO `personne` (`nom`, `prenom`) VALUES (?, ?)";

        $q = $this->db->prepare($sql);
        $q->bindValue(1, $p->getNom(), PDO::PARAM_STR);
        $q->bindValue(2, $p->getPrenom(), PDO::PARAM_STR);
        $q->debugDumpParams();

        $r=$q->execute();

        return $r;*/
    }

    //public function getAll(){} --> retourne un tableau d'Article
    public function getAll(){
    }

    //public function get($id){} --> retourne un Article
    public function get($id){
        // Préparation de la requête
        $sql='SELECT * FROM `article` WHERE id_article = :id';
        $query=$this->db->prepare($sql);

        // Mapping id
        $query->bindValue(':id', $id, PDO::PARAM_INT);

        // Execution de la requête
        $donnees;
        if ($query->execute()){
            // Récupération de la donnée
            $donnees = $query->fetch();
            $data = new Article($donnees);
        }
        return $data;
    }

    /*
    public function delete(Article $perso){
        /*$sql = "DELETE FROM `article` WHERE id = :id";
        
        $q = $this->db->prepare($sql);
        $q->bindValue(':id', $id, PDO::PARAM_INT);

        $r=$q->execute();
        return $r;
    }

    public function update(Article $p){
       $sql = "UPDATE `article` SET `nom`=:nom,`prenom`=:prenom WHERE id = :id";
        
        $q = $this->db->prepare($sql);
        $q->bindValue(':id', $p->getid(), PDO::PARAM_INT);
        $q->bindValue(':nom', $p->getNom(), PDO::PARAM_STR);
        $q->bindValue(':prenom', $p->getprenom(), PDO::PARAM_STR);

        $r=$q->execute();
        return $r;
    }
    */
}
?>