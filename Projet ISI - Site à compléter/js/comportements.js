/** Comportements.js ******/
$(document).ready(

    function() // Fonction anonyme principale
    {
        // Ecouteur d'événement 
        $('form').submit(executerRequete) ;
        console.log("***** Exécution du programme javascipt *****"); 
        
        
        /*** Gestionnaire d'événement **/
        function executerRequete(evt)
        {
            // Pour manipuler le formulaire
            let $form = $(this) ;

            // Quel formulaire a été utilisé ?
            let idForm = $form.attr("id") ;
            let BDLocale = idForm=="pourBDetd" ;
            
            console.log("Bonjour, je suis la fonction javascript qui s'exécute après la validation du formulaire "+ idForm)
            // Empêcher le comportement par défaut lié à cet événement, c'est-à-dire le rechargement de la page
            evt.preventDefault() ;
            // Récupérer le texte de la requete
            
            // Supprimer l'entête de la table éventuellement présente dans la page
            $('.sortieBD thead').remove() ;
                
            // Supprimer le corps de table éventuellement présent dans la page
            $('.sortieBD tbody').remove() ;
            
            // Supprimer le message d'érreur éventuellement présent
            $('.messageErreur').text('') ;
            
            
            let texteRequete = $form.find('[name=requeteChoisie]').val() ;
            console.log("\t J'ai récupéré ce texte de requête : "+ texteRequete) ;
            
           
            let adresseDesDonnees ;  
            if(BDLocale) 
            {  adresseDesDonnees = "php/soumettreRequete.php" ;
                console.log("\t Nous allons travailler sur la BD locale de l'étudiant") ;
            }
            else
            {  
                adresseDesDonnees = "https://web2noninfo.lpmiaw.univ-lr.fr/ISI/projet/api/soumettreRequete.php" ;
                console.log("\t Nous allons travailler sur la BD d'un enseignant") ;
            }
            console.log("\t J'envoie la requête à l'adresse "+adresseDesDonnees)
             let optionsAjax = 
                {
                "url" : adresseDesDonnees, // où aller chercher les données    
                    "dataType" : "json", // Sous quel format les récupérer
                    "type" :"POST",
                    "data" : {"texteRequete" : texteRequete }
                } ;
            // Appel Ajax
            var promesseRequete = $.ajax(optionsAjax) ;
        
            // Le résultat d'un appel Ajax est une promesse, qui peut être tenue ou pas
        
            // En cas de promesse non tenue (échec de l'appel Ajax), exécuter la fonction erreurAjax
            promesseRequete.fail(erreurAjax);
        
            // En cas de réussite de l'appel Ajax, exécuter la fonction afficherResultat
            promesseRequete.done(afficherResultatsRequete);
        }

     
         // Fonction dont l'exécution est déclenchée si l'appel Ajax échoue
        function erreurAjax()
        { 
            console.log("Une erreur Ajax s'est produite, je ne peux pas récupérer les données !") ;
            $('.messageErreur').text('Erreur Ajax !')
        }
            
        function afficherResultatsRequete(enregistrements)
        {
            console.log("L'appel Ajax permettant de récupérer les infos des utilisateurs a fonctionné !") ;
            console.log("Voici la donnée fournie par le prog php : ") ;
            console.log(enregistrements) ;
            // la variable utilisateurs contient un tableau de données
            // Pour chaque élément de ce tableau, exécuter la fonction afficherUnUtilisateur
            if (false) // Détecter une réponse erronée
            {    erreurAjax()
            }
            else
            {
                let $table=$('.sortieBD table') ;
                // Créer le corps de la table
                var $tbody = $('<tbody>') ;
                var $thead = $('<thead>') ;
                
                // Créer l'entête du tableau 
                let nomDesChamps = Object.keys(enregistrements[0]) ;
                let $tr=$('<tr>');
                nomDesChamps.forEach(
                    function(unChamp)
                    {
                        let $th=$('<th>').text(unChamp) ;
                        $tr.append($th) ;
                    }
                );// fin forEach
                $thead.append($tr) ;
                $table.append($thead) ;
                   
                // Pour chaque élément du tableau enregistrements, l'afficher
                $(enregistrements).each(
                    function()
                    {
                        let $ligne = $('<tr>') ;
                        let enregistrement = this ;
                        nomDesChamps.forEach(
                            function(unChamp)
                            {
                                let $td = $('<td>').text(enregistrement[unChamp]) ;
                                $ligne.append($td) ;
                            }
                        );// fin forEach
                        $tbody.append($ligne) ;
                    }
                ) ;
                $table.append($tbody) ;
            }
            
            
        } // fin de afficherResultatsRequete
        
        
        
        
    } // Fin de la fonction anonyme principale
    
    
); // Fin $(document).ready