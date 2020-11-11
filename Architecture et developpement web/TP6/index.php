<?php
require('Personne.php');
require('database.php');
require('PersonneManager.php');
/*
$P1 = new Personne('Solid', 'Snake');
$P2 = new Personne('de Riv', 'Gerlat');
$P3 = new Personne ('Strife', 'Cloud');
*/

$database = new database();
$connex = $database->getConnexion();

//Utilisation de l'hydratation
$P1 = new Personne (
  array (
    "nom"=>"Solid",
    "prenom"=>"Snake"
  )
);

$P2 = new Personne (
  array (
    "nom"=>"de Riv",
    "prenom"=>"Gerlat"
  )
);

$P3 = new Personne (
  array (
    "nom"=>"Strife",
    "prenom"=>"Cloud"
  )
);

$P4 = new Personne (
  array (
    "nom"=>"Redfield",
    "prenom"=>"Claire"
  )
);

//Manager de Personne
$manageP = new PersonneManager($connex);
//$info = $manageP->add($P4);
//echo $info;
//echo $P1;
//echo $P2;
//echo $P3;
//echo $P4;

$donneesBD = $manageP->getAll();
echo $donneesBD;

//echo $P1, " --- ", $P2, " --- ", $P3;
?>

<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Titre de la page</title>
  <link rel="stylesheet" href="style.css">
  <script src="script.js"></script>
</head>
<body>
  <ul>
    <?php //foreach ($donneesBD as $p) : ?>
    <li><?php//=$p?></li>
    <?php //endforeach;?>
  </ul>
</body>
</html>