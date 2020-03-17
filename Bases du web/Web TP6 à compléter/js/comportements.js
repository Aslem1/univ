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
    

};
//Introduction
window.addEventListener('DOMContentLoaded', principale); //Fonction éxecutée lorsque la page est chargée

//Exercice 4 
var effacer = function() {
    console.log("Evénement détecté !")
    
    let fig4 = document.getElementById('figureEx4')
    fig4.classList.add('invisible') 
}
document.getElementById('boutonEffacerEx4').addEventListener("click",effacer); //Peut se mettre tout en bas

var afficher = function(){
    let fig4 = document.getElementById('figureEx4')
    fig4.classList.remove('invisible')
}
document.getElementById('boutonAfficherEx4').addEventListener("click",afficher); //Peut se mettre tout en bas

var montrer_masquer = function(){
    let fig4 = document.getElementById('figureEx4')
    if()
}
document.getElementById('boutonDoubleEx4').addEventListener("click",afficher);