<!DOCTYPE html>
<html>
 <head>
	<meta charset="utf-8" />
  	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<title>SiteWebShop</title>

</head>
<body>
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

	<section>
				

				<header>Bienvenue <span class="ss-titre">Nous sommes le ?????? </span></header>
				<p>La boutique en ligne <strong>openSHOP</strong> est un travail réalisé par <em>Thomas Jouannic</em> & <em>Jérome Saunier</em> 
				puis modifié et adapté <strong>au cours de Sites Web Avancés</strong>.</p>
				<p>Dans la partie haute, vous trouverez un moyen pour vous identifiez ou créer un compte si vous n'en n'avez aucun. Le champ de recherche 
				vous permet d'afficher simplement les produits correspondants à ce que vous souhaitez. Vous pouvez aussi naviguer entre les différentes 
				catégorie de produits en cliquant sur celle que vous désirez voir.</p>
				<p>Bonne naviguation !</p>
	</section>
	<section>
		<header>
					<h2>Au hasard...</h2>
		</header>
				<!--Affichage de 3 articles au hasard -->
				
	</section>

	
	<footer>
		<p>	<a id="goto-admin" href="admin.php">Admin</a></p>
		<p id="extra">
				Site Web Avancés - Année 2016 - version HTML 5
			</p>
		
	</footer>

</body>
</html>