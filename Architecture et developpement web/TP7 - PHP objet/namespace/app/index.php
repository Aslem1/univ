<?php
require('namespace/App/Interfaces/Animaux.php');
require('namespace/App/Interfaces/Visite/infoVisite.php');

$Crocodile = new Crocodile('Reptile', 'Crocodile', 'Crocodylidae');
var_dump($Crocodile);
echo $Crocodile;

$Elephant = new Elephant('Mamifère', 'Elephant', 'Elephantidae');
var_dump($Elephant);
echo $Elephant;

$pandaRoux = new pandaRoux('Mamifère', 'Panda Roux', 'Ailuridae');
var_dump($pandaRoux);
echo $pandaRoux;

$Restaurant = new Restaurant('Restaurant', '3 rue Jean Jaurès');
var_dump($Restaurant);
echo $Restaurant;

$Parc = new Parc('Parc', '4 rue Jean Moulin');
var_dump($Parc);
echo $Parc;

$Monument = new Monument('Monument', '5 rue Léon Gambetta');
var_dump($Monument);
echo $Monument;
?>