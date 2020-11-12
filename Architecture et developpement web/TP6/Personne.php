<?php
//Ecrivez la classe Personne contenant 3 attributs privés, id, nom, prénom
class Personne {
  //attributs
  private $nom;
  private $prenom;
  private $id;

  //Créez le constructeur de cette classe normalement sans hydratation
  //constructeur
  /**
   * Personne constructor 
   * @param $nom
   * @param $prenom
   * @param $id
   */
  /*
  public function __construct($nom="",$prenom="",$id=null) { //double _ pour construct
    $this->nom=$nom;
    $this->prenom=$prenom;
    $this->id=$id;
  }*/

  //Ajoutez les getteurs et les setteurs sur les attributs
  //Setter nom
  public function setNom($nom) {
      $this->nom = $nom;
  }

  //Getter nom
  public function getNom() {
      return $this->nom;
  }

  //---------------------------------------
  //Setter prenom
  public function setprenom($prenom) {
    $this->prenom = $prenom;
  }

  //Getter prenom
  public function getprenom() {
    return $this->prenom;
  }

  //---------------------------------------
  //Setter id
  public function setid($id) {
    $this->id = $id;
  }
  //Getter id
  public function getid() {
    return $this->id;
  }

  //Créez la méthode d’affichage __toString()
  public function __toString() {
      return $this->nom. " ".$this->prenom. " ".$this->id;
  }

  //Création de la méthode hydrate
  public function hydrate(array $donnees) {
      foreach ($donnees as $key => $value) {
          $method = 'set'.ucfirst($key);
          if (method_exists($this, $method)) {
              $this->$method($value);
          }
      }
  }

  //Modifiez le constructeur pour qu’il utilise la méthode d’hydratation
  public function __construct(array $data) {
      $this->hydrate($data);
  }
}
?>
