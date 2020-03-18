var principale = function() {
    //Affiche "ready" dans la console
    console.log("ready!");
    //alert("he ho let's go !");


    //Exercice 1
    console.log("Je suis le programme principal !")

    let ingredients = document.querySelectorAll("ul#ingredients li") //Créer une variable ingredients 
    console.log(ingredients.length); //Affiche la taille du tableau ingrédients
    console.log("J'ai trouvé " + ingredients.length + " ingrédients")


    //Exercice 2
    let elementsEx2 = document.querySelector('#elemEx2')
    console.log(elementsEx2.classList)


    elementsEx2 = document.getElementById('elemEx2') //Prend l'element qui à pour ID elemEx2
    elementsEx2.classList.remove('control') //Enleve la classe control de l'élement elemEx2
    console.log(elementsEx2) //Affiche

    elementsEx2.classList.add('inverse')
    console.log(elementsEx2)


    //Exercice 3
    document.getElementById('reussite').textContent="ha ok, j'ai compris !" 

    let image = document.getElementById('dog');
    let nomFichierImage = image.getAttribute('alt');
    console.log(image)
    console.log(nomFichierImage)

    let fig = document.getElementById('legendeDog').textContent = nomFichierImage

    document.getElementById('boutonEffacerEx4').addEventListener("click",effacer); //Peut se mettre tout en bas
    document.getElementById('boutonAfficherEx4').addEventListener("click",afficher); //Peut se mettre tout en bas
    document.getElementById('boutonDoubleEx4').addEventListener("click",montrer_masquer);


    //Exercice 6
    //Selection de l'élement dont la classe est "ex6"
    let image_ex6 = document.querySelector('#ex6 img');
    //Mise en place d'un écouteur pour l'évenement "clic"
    image_ex6.addEventListener("click",deTravers);

};

//Exercice 4 
var effacer = function() {
    console.log("Evénement détecté !")

    let fig4 = document.getElementById('figureEx4')
    fig4.classList.add('invisible') 
}

var afficher = function(){
    let fig4 = document.getElementById('figureEx4')
    fig4.classList.remove('invisible')
}

var montrer_masquer = function(){
    let fig4 = document.getElementById('figureEx4')

    if (fig4.classList.contains('invisible')) {
        console.log('caché')
        afficher()
    }

    else {
        console.log('afficher')
        effacer()
    }

}



//Exercice 5
var ex5 = function(){
    let liste_ex5 = document.querySelectorAll("ul#liste_tetes li")
    for(n=0; n<liste_ex5.length; n++){
        //console.log("Element n " + n)
        liste_ex5.item(n).classList.add('penche');
        //ajouter addEventListener("click",) sur chaque image pour enlever penche
        liste_ex5.item(n).addEventListener("click",image_penche);
        liste_ex5.item(n).addEventListener('mouseover',hover);
        liste_ex5.item(n).addEventListener('mouseout',hover_out);
    }


    let h2_ex5 = document.querySelectorAll("h2")
    for (n=0; n<h2_ex5.length; n++){
        h2_ex5.item(n).classList.add('centre')
    }
}


//Exercice 6
//Création de la fonction de gestion de l'évenement
function deTravers(){
    //Ajouter une classe à l'élement qui a reçu l'évenement
    this.classList.add("penche");
}

function image_penche(){
    //Ajouter une classe à l'élement qui a reçu l'évenement
    if(this.classList.contains('penche')){
        this.classList.remove("penche");
    }
    else {
        this.classList.add('penche');
    }
}

//Fin Exercice 6
function hover(){
    this.classList.add("penche");
}

function hover_out(){
    this.classList.remove("penche");
}

//Introduction
window.addEventListener('DOMContentLoaded', principale); //Fonction éxecutée lorsque la page est chargée
//Exercice 5
window.addEventListener('DOMContentLoaded', ex5);