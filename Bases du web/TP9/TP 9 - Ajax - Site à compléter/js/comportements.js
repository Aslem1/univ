document.addEventListener('DOMContentLoaded', principale);

function principale() {
    console.log("Exécution de la fonction principale");

    function onClickGo(){



        // Tentative de récupération d'une donnée externe 
        let promesseRecupUnePersonne = axios.get('https://prodrigu.lpmiaw.univ-lr.fr/TP6/recupererUnePersAuHasard/') ;

        promesseRecupUnePersonne.then(
            reponseAjax=>
            {
                /*console.log(reponseAjax);
                console.log(reponseAjax.data);
                console.log(reponseAjax.data.nom);*/
                let res = document.querySelector('.resultat');
                res.textContent = 'Résultat : ' + reponseAjax.data.nom
            }) ; // Fin du then

        promesseRecupUnePersonne.catch(
            erreur=>
            {

            }) ; // Fin du catch



    }

    function onClickGo2(){
        // Tentative de récupération d'une donnée externe 
        let promesseRecupLesPersonne = axios.get('https://prodrigu.lpmiaw.univ-lr.fr/TP6/recupererLesPers/') ;

        promesseRecupLesPersonne.then(
            reponseAjax=>
            {
                //console.log("reponse ajax", reponseAjax);
                let lesPersonnes = reponseAjax.data
                //console.log("les personnes", lesPersonnes);
                let res = document.querySelector('.resultat2');
                //res.textContent = 'Go : ' + lesPersonnes[0].nom + " " + lesPersonnes[0].prenom
                //console.log(lesPersonnes[0].nom, lesPersonnes[0].prenom);

                //Foreach
                lesPersonnes.forEach(personne => {
                    console.log(personne.nom);
                    //res.textContent += personne.nom + " " ;
                    let liste = document.createElement("li");
                    liste.textContent += personne.nom + " " + personne.prenom;
                    res.append(liste);
                })

            }) ; // Fin du then

        promesseRecupLesPersonne.catch(
            erreur=>
            {
                console.log(erreur);
            }) ; // Fin du catch

    }

    document.querySelector('.bouton').addEventListener('click',onClickGo)
    document.querySelector('.go').addEventListener('click',onClickGo2)

} // fin de la fonction principale

