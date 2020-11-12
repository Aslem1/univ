<?php
//Ecrivez la classe Personne contenant 3 attributs privés, id, nom, prénom
class Article {
    //attributs
    private $id_article;
    private $id_categorie;
    private $designation;
    private $prix;
    private $tva;
    private $description;
    private $img_article;

    //Getter id_article
    public function getid_article(){
        return $this->id_article;
    }

    //Setter id_article
    public function setid_article($id_article){
        $this->id_article=$id_article;
    }

    //------------------
    //Getter id_categorie
    public function getid_categorie(){
        return $this->id_categorie;
    }

    //Setter id_categorie
    public function setid_categorie($id_cat){
        $this->id_categorie=$id_cat;
    }

    //------------------
    //Getter designation
    public function getdesignation(){
        return $this->designation;
    }

    //Setter designation
    public function setdesignation($desi){
        $this->designation=$desi;
    }

    //------------------
    //Getter prix
    public function getprix(){
        return $this->prix;
    }

    //Setter prix
    public function setprix($prx){
        $this->prix=$prx;
    }

    //------------------
    //Getter tva
    public function gettva(){
        return $this->tva;
    }

    //Setter tva
    public function settva($t){
        $this->tva=$t;
    }

    //------------------
    //Getter description
    public function getdescription(){
        return $this->description;
    }

    //Setter description
    public function setdescription($desc){
        $this->description=$desc;
    }

    //------------------
    //Getter img_article
    public function getimg_article(){
        return $this->img_article;
    }

    //Setter img_article
    public function setimg_article($img_art){
    $this->img_article=$img_art;
    }


    //Méthode d’affichage __toString()
    public function __toString() {
        return $this->id_article. " ".$this->designation. " ".$this->description;
    }

    public function __construct(array $data) {
        $this->hydrate($data); 
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

    //Affichage html d'un article
    public function toHtml() {
        $texte = tronquer_texte($this->description);
        return "<li class=\"product\"><h2>$this->designation</h2><p>$texte <a href=\"vue_produit.php?article=$this->id_article\"> Voir les détails</a> </p><p>Prix HT : $this->prix</p><p>TVA : $this->tva</p><img src=\"./$this->img_article\"></li>";
        /*
        <li class=\"product\">
            <h2>designation</h2>
            <p>description</p>
            <p>Prix HT : prix</p>
            <p>TVA : tva</p>
            <img src=\"./img_article\">
        </li>
         */
    }
}
?>