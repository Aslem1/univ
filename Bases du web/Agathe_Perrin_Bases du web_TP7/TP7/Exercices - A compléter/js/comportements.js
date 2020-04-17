/*exercices.js*/

/*Ecriture de la fonction principale*/
function principale(){
    console.log("Execution de la fonction principale");

    /*Exercice 1*/
    function supprimerEx1 (){
        console.log("Exécution de la fonction supprimerEx1")
        //Sélection de l'élement à supprimer
        let liste = document.querySelector("#ex1 li");
        //Sélection du père
        let parent1 = liste.parentNode;
        //Suppression
        parent1.removeChild(liste);
    }
    let bouton = document.getElementById('boutonSupprimerEx1');
    bouton.addEventListener('click',supprimerEx1)


    /*Exercice 2*/
    function deplacerEx2 (){
        console.log("Execution de la fonction deplacerEx2")
        //Sélection de l'élement à déplacer
        let elem = document.querySelector("#ex2 li");
        //Sélection du père
        let parent1 = elem.parentNode;
        //Insertion
        parent1.appendChild(elem)

    }
    document.getElementById('boutonDeplacerEx2').addEventListener('click',deplacerEx2);


    /*Exercice 3*/
    function disparuEx3 (){
        console.log("Execution de la fonction disparuEx3")
        //Sélection de l'élement à rendre invisible
        let ingredientKebab = document.querySelector('#ingredients li:not(.invisible)');
        //Rendre l'élement invisble
        ingredientKebab.classList.add('invisible')
    }

    function reafficherEx3 (){
        console.log("Execution de la fonction reafficherEx3")
        //Sélection de l'élement à reafficher
        let listeKebab = document.querySelectorAll('#ingredients li')
        //Reafficher
        for (ingredient of listeKebab){
            ingredient.classList.remove('invisible')
        }  
    }

    document.querySelector('#ex3 .control.reaf').addEventListener('click',reafficherEx3);
    document.getElementById('ingredients').addEventListener('click',disparuEx3);


    /*Exercice 4*/
    function masquerEx4 (){
        console.log("Execution de la fonction masquerEx4")
        //Sélection de l'élement à masquer
        this.classList.add('invisible')
    }

    function reafficherEx4 (){
        console.log("Execution de la fonction reafficherEx4")
        //Sélection de l'élement à reafficher
        let listeNom = document.querySelectorAll('#lesPrenoms li');
        //Reafficher
        for (ingredient of listeNom){
            ingredient.classList.remove('invisible')
        }  
    }

    document.querySelector('#ex4 .control.reaf').addEventListener('click',reafficherEx4);

    let listePrenomEx4 = document.querySelectorAll('#lesPrenoms li')
    for (prenom of listePrenomEx4){
        prenom.addEventListener('click',masquerEx4);
    }


    /*Exercice 5*/
    function masquerEx5 (){
        console.log("Execution de la fonction masquerEx5")
        if (this.classList.contains ('texte')) {
            console.log("Coucou ici le if")
            let parent1 = this.parentNode;
            let freres = parent1.getElementsByClassName('texte');

            for(frere of freres){
                frere.classList.add('invisible')
            }

        }
        if (this.classList.contains ('nombre')) {
            console.log("Coucou ici le 2eme if")
            let parent1 = this.parentNode;
            let freres = parent1.getElementsByClassName('nombre');

            for(frere of freres){
                frere.classList.add('invisible')
            }

        }
    }

    function reafficherEx5 (){
        console.log("Execution de la fonction reafficherEx5")
        let liste = document.querySelectorAll('#lettresEtNombres li');
        //Reafficher
        for (elem of liste){
            elem.classList.remove('invisible')
        }   
    }
    document.querySelector('#ex5 .control.reaf').addEventListener('click',reafficherEx5);

    let listeEx5 = document.querySelectorAll('#lettresEtNombres li');
    for (elem of listeEx5){
        elem.addEventListener('click',masquerEx5);
    }


    /*Exercice 6*/
    function deplacerEx6 (){
        console.log("Execution de la fonction deplacerEx6")
        //Sélection de l'élement à déplacer
        //Sélection du père
        let parent1 = this.parentNode;
        //Insertion
        parent1.appendChild(this)

    }

    let listeEx6 = document.querySelectorAll('#ex6 li')
    for (elem of listeEx6){
        elem.addEventListener('click',deplacerEx6);
    }

}

/*Ecouteur d'évenement qui lance la fonction "principale" lorsque la page est prête*/
document.addEventListener('DOMContentLoaded', principale);