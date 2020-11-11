<?php 
require 'utile.php';
require 'connexion.php';
?>
<!-- DEBUT de la page -->
<header>
	<div class="wrap">
	<h1><a href="#"><img src="images/openshop_logo.png" alt="logo open shop"></a></h1>
	<nav>
		<ul>
			<li><a href="index.php">accueil</a></li>
			<li><a href="login.php">login</a></li>
			<li><a href="creer_compte.php">créer compte</a></li>
			<li><a href="panier.php">panier</a></li>
		</ul>
	</nav>
	
	<form id="search" action="recherche.php" method="post" enctype="multipart/form-data">
			<p>
				<label for="searchText">Rechercher :</label>
				<input id="searchText" name="query" type="text" value="" />
				<input id ="searchBtn" type="submit" class="bouton" value="OK" />
			</p>
		</form>
	
	
		<nav id="menu-categorie">
		<ul>
			<li class="smenu"><a href="#">tous les produits</a></li>
			<li class="smenu"><a href="#">vetements</a></li>
			<li class="smenu"><a href="#">accessoires</a></li>
			<li class="smenu"><a href="#">posters</a></li>
			<li class="smenu"><a href="#">dvd</a></li>
		</ul>
		</nav>
</div>
</header>