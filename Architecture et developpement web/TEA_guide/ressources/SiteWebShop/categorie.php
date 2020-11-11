<!DOCTYPE html>
<html>
 <head>
	<meta charset="utf-8" />
  	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<title>SiteWebShop</title>
</head>
<body>
<?php require 'header.php'; ?>
<!-- DEBUT de la page -->
	<section>
        <!-- Tester si un paramètre a été passé, si oui afficher les articles correspondant a la cateorie selectionnée -->
        <?php
        if (!empty($_GET['article'])) {
            $numArticle = ($_GET['article']);
        }
        ?>
	</section>
	<section>
		<header>
		</header>
	</section>
	<?php require 'footer.php'; ?>