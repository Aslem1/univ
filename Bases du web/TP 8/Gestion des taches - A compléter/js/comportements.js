/*comportements.js*/

document.addEventListener('DOMContentLoaded', onDOMCOntentLoaded);

function onDOMCOntentLoaded(){
    console.log('-- onDOMContentLoaded -- begin');

    let taches = document.querySelectorAll('.tache:not(.saisie)')
    console.log(taches);

    //Exercice 1 -- Rendre boutons X réactifs
    taches.forEach(
        tache => {
            let bouton = tache.querySelector('.suppression');
            console.log(bouton);
            bouton.addEventListener('click', onTacheCLick);
        }
    )

    //Exercice 4 -- Validation du formulaire
    let formulaire = document.querySelector('form');
    console.log(formulaire);
    formulaire.addEventListener('submit', onFormulaireSubmit);

    console.log('-- onDOMContentLoaded -- end');
}

//Exercice 2
function onTacheCLick(){
    console.log('-- onDOMContentLoaded -- begin')

    //Exercice 3 -- Suppression de tache avec X
    console.log(this);
    this.closest('.tache').remove();

    console.log('-- onDOMContentLoaded -- end');
}

function onFormulaireSubmit(event){
    console.log('-- onFormSubmit -- begin (' + event + ')');

    //Exercice 5 -- Supprimer le comportement par défaut de cet événement avec preventDefault
    event.preventDefault();

    //Exercice 6 -- Traiter cet événement en récupérant les valeurs des champs qui et quoi
    console.log(this)
    let quoi = this.querySelector('.quoi').value;
    let qui = this.querySelector('.qui').value;

    console.log(quoi);
    console.log(qui);


    ajouterTache (quoi,qui);

    console.log('-- onDOMContentLoaded -- end');
}

function ajouterTache (quoi, qui){
    let tacheInvisible = document.querySelector('.tache.invisible');
    console.log(tacheInvisible)
    let nouvelleTache = tacheInvisible.cloneNode(true);

    //Exercice 7 -- Injecter ces valeur dans la tâche invisible
    nouvelleTache.querySelector('.quoi').textContent = quoi;
    nouvelleTache.querySelector('.qui').textContent = qui;

    nouvelleTache.classList.remove('invisible');

    let bouton = nouvelleTache.querySelector('.suppression');
    console.log(bouton);
    bouton.addEventListener('click', onTacheCLick);

    //Exercice 8 -- Dupliquer la tâche invisible, rendre son clone visible et l'insérer dans la liste des tâches à effectuer

    let tachesAEffectuer = document.querySelector('.taches.a_effectuer');

    tachesAEffectuer.append(nouvelleTache);

    console.log(tachesAEffectuer)
    console.log('-- ajouterTache -- end')
}


