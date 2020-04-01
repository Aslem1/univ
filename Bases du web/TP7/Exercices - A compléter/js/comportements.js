/*exercices.js*/

/*Ecriture de la fonction principale*/
function principale(){
    console.log("Execution de la fonction principale");

    /*Exercice 1*/
    function supprimerEx1 (){
        console.log("Exécution de la fonction supprimerEx1")
        let liste = document.querySelectorAll("#ex1 li");
        //Trouver 1er element liste 
        //supr
    }
    let bouton = document.getElementById('boutonSupprimerEx1');
    bouton.addEventListener('click',supprimerEx1)

}

/*Ecouteur d'évenement qui lance la fonction "principale" lorsque la page est prête*/
document.addEventListener('DOMContentLoaded', principale);