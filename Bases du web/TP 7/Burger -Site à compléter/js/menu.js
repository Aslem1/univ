/* menu.js */

/*Ecouteur d'évenement qui lance la fonction "principale" lorsque la page est prête*/
document.addEventListener('DOMContentLoaded', principale);

/*Ecriture de la fonction principale*/
/*Astuce: écrire les fonctions, variables,etc... en français pour différencier le language js et le reste*/
function principale(){
    console.log("Execution de la fonction principale");

    /*Création des fonctions gestionnaires d'évènements*/
    function ouvrirMenu(){
        console.log("Execution de la fonction ouvrirMenu");
        document.getElementById("menu").classList.add("ouvert");
    }

    function fermerMenu(){
        console.log("Execution de la fonction fermerMenu");
        document.getElementById("menu").classList.remove("ouvert");
    }

    /*Création des écouteurs d'évènements*/
    document.getElementById("ouverture_menu").addEventListener("click",ouvrirMenu);
    document.getElementById("fermeture_menu").addEventListener("click",fermerMenu);

    
}