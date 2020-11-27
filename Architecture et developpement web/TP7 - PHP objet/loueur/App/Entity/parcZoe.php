<?php
class parcZoe implements \Countable {
    public $mesZoe;

    //Constructeur de Zoe
    public function __construct($mesZoe) {
        $this->mesZoe = $mesZoe;
        $mesZoe[0] = new Zoe('blanc', 'electrique', 'AB-123-CD');
        $mesZoe[1] = new Zoe('bleu', 'electrique', 'EF-456-GH');
        $mesZoe[2] = new Zoe('violet', 'electrique', 'IJ-789-KL');
    }

    public function count() {
        return count ($this->mesZoe);
    }

    //Méthode statique pub
    public static function pub() {
        return "Zoe Renault, tous les jours un bruit nouveau";
    }
}
?>