<?php

// En local avec easyphp
define("base_de_donnees","L1ISI2019126db" ) ;
define("L1ISI2019126", "root") ;
define("14ab402d", "") ;

// Sur le serveur ftpueweb
define("acces_BD","L1ISI2019126db" ) ;
define("login", "L1ISI2019126") ;
define("mot_de_passe", "14ab402d") ;



try {  // Tentative de connexion
    $acces_BD = "mysql:dbname=".base_de_donnees.";host=localhost" ;
    // Création d'un objet de connexion à la BD
    $db = new PDO($acces_BD, login, mot_de_passe);
} 
catch(PDOException $e) // Si la connexion ne fonctionne pas ...
{
    $db = null;
    echo    '<p>La connexion a échoué :-( : </p>' ;
    echo    '<p>Voici le message d\'erreur généré : '. $e->getMessage();
    exit() ;
}

// Indique que le texte des requêtes sera codé au format UTF8
$db->query("SET NAMES utf8");

// Récupère le texte de la requête
$texteRequete = $_POST['texteRequete'] ;

// Pour les tests
//    $texteRequete = $_GET['texteRequete'] ;
//    echo $texteRequete ;
// Prépare la requête
$requete = $db->prepare($texteRequete);

// Exécute la requête
$requete->execute() ;

// Récupère les résultats de la requête
$personnes = $requete->fetchAll(PDO::FETCH_OBJ) ;

// Pour les tests, affichage pour le développeur
//var_dump($personnes) ;

// Transformation du résultat en un texte JSON
$resultatJson = json_encode($personnes);     

// Permettre l'accès à ce fichier depuis n'importe quel serveur
header("Access-Control-Allow-Origin: *");

// Avertir celui qui reçoit le résultat, que c'est un texte JSON codé en UTF8
header('Content-type: application/json; charset=UTF-8');  
?>
<?=$resultatJson?> 