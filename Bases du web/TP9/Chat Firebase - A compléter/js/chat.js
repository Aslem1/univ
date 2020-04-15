/* chat.js */
document.addEventListener('DOMContentLoaded', principale) ;


    function principale(){
        
        // Initialisation de Firebase
            // infos de configuration pour l'accès à la BD du chat
    let config  = {
    apiKey: "AIzaSyBBD0aAS0FwAIgMHvAK0rnbiWg6_0Zs-4U",
    authDomain: "chat-firebase-f09e4.firebaseapp.com",
    databaseURL: "https://chat-firebase-f09e4.firebaseio.com",
    projectId: "chat-firebase-f09e4",
    storageBucket: "chat-firebase-f09e4.appspot.com",
    messagingSenderId: "324349367485"
  };
        
            //Initialisation de la communication avec la base de données
        firebase.initializeApp(config);
        
        // Récupération des noeuds principaux de la BD
       
        
        
       /****** Mise en place des écouteurs d'événements ********/  
        
        // Lorsque ce prog se connecte à la BD Firebase
        // Il reçoit un événement child_added pour chaque enregistrement de la BD 
        BDMessages.on('child_added', insererDansLaPage) ;
        
       // Quand on valide le formulaire, ajouter le nouveau message dans la BD 
       
 
        // Quand un message est supprimé de la BD, l'enlever de la page
      
        
        // La mise en place de l'écouteur d'événement pour pour la suppression d'un message par l'internaute et fait dans la fonction d'affichage du message dans la page
        
        /****** Fin des écouteurs d'événements ***********/
        
        /****** Gestionnaires d'événements **************/
        
         // Déclenchement lorsqu'un internaute envoie un nouveau message
        function ajouterUnMessageDansLaBD(){
            
            console.log("Ajout d'un message dans la BD") ;
            
            // Récupération des valeurs saisies
            

            // Clear du texte du message dans le formulaire
     
            
           // Construction de la donnée à ajouter à la BD
           
            
            // Ajout dans la BD
          
        }
        
        
        
        
        
        function insererDansLaPage(message){
            // Déclenchement lorsqu'un message est ajouté à la BD
            // Insère le message dans la page
            console.log("Fonction insererDansLaPage")
            console.log(message.val().texte) ;
            
           
        }
        
       
     
       

        
    } // /fonction principale


