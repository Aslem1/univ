var principale = function () {
    //Exercice 1
    var ex1 = function () {
        //Selection de l'élement à supprimer
        let ex1 = document.querySelectorAll("ul#boutonSupprimerEx1 li")
        //Selection du père
        ex1.addEventListener("click",supprimer);
        //Supression
        ex1.removeChild(boutonSupprimerEx1);
    }
}

window.addEventListener('DOMContentLoaded', principale); //Fonction éxecutée lorsque la page est chargée