<?php
require('Entity/Ville.php');
require('Controller/ControllerVille.php');
// $data = array(["id"=>"1", "nom"=>"La Rochelle", "population"=>"80000", "pays_id"=>"1"]);
$data = [];
$ville = new Ville($data);

$ville->setid(1);
$ville->setnom("La Rochelle");
$ville->setpopulation(80000);
$ville->setpays_id(1);
$ville->setLatitude(1);
$ville->setLongitude(1);

var_dump($ville);
echo $ville;

$ctrl = new ControllerVille();
$liste = $ctrl->getAll();
var_dump($liste);


?>