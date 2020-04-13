/*comportement.js*/

function principale(){
    console.log("Execution de la fonction principale")

    //A -- Création d'un écouteur d'évènements
    //    let secondeImage = document.querySelector('#vignettes img');
    //    secondeImage.addEventListener('mouseenter',onImageMouseEnter)
    //    console.log("Execution de la fonction principale")

    //D -- Généralisation
    let images = document.querySelectorAll('#vignettes img');
    images.forEach(image => {
        console.log(image);
        image.addEventListener('mouseenter', onImageMouseEnter);
    })

    //E -- Initialisation 
    let event = new Event('mouseenter');
    images[0].dispatchEvent(event);

    console.log('-- principale -- end')

}

function onImageMouseEnter(){
    console.log('-- onImageMouseEnter -- begin');

    let grandeImage = document.getElementById('grandeImage');
    console.log('grandeImage');

    let titreImage = document.getElementById('titreImage');
    console.log('titreImage');
    titreImage.textContent = this.alt

    let name = getImageName(this.src)
    grandeImage.src = "images/grandes/" + name

    console.log ('-- onImageMouseEnter -- end')
}

function getImageName (imagePath){
    let names = imagePath.split('/');
    let name = names[names.length -1]
    return name;
}

document.addEventListener('DOMContentLoaded', principale);