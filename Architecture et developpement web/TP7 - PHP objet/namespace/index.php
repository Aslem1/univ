<?php
require('app/Ville.php');
require('app2/Ville2.php');

$ville = new Ville('La Rochelle');
var_dump($ville);
echo $ville;

$ville2 = new Ville2 ('Niort', 58952);
var_dump($ville2);
echo $ville2;
?>