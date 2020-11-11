<!DOCTYPE html>
<html>
 <head>
	<meta charset="utf-8" />
  	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<title>SiteWebShop</title>
</head>
<body>
<?php 
require 'header.php';
date_default_timezone_set("Europe/Paris");
$date = date("d-m-Y");
$heure = date("H:i");

require 'ArticleManager.php';
require 'Article.php';

$database = new connexion();
$connex = $database->getConnexion();
$managerA = new ArticleManager($connex);

?>
<!-- DEBUT de la page -->
	<section>
		<header>Bienvenue <span class="ss-titre"> <?php echo "Nous sommes le $date et il est $heure" ?> </span></header>
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
				<ul id="product-list">
					<?php
						$donneesBD = $managerA->get3();
						foreach($donneesBD as $article){
							echo $article->toHtml();
						}
					?>
				</ul>
	</section>
	<?php require 'footer.php'; ?>
</body>
</html>