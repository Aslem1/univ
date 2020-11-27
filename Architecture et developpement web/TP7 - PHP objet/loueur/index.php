<?php
require('App/Entity/Voiture.php');
require('App/Entity/Zoe.php');

//$Voiture = new Voiture('bleu', 'diesel', 'AB-123-CD');
//var_dump($Voiture);
$Zoe = new Zoe('blanc', 'electrique', 'EF-456-GH');
var_dump($Zoe);
echo $Zoe;
?>