/*t-shirts.js*/


/*Ecriture de la fonction principale*/
function principale(){
    console.log("Execution de la fonction principale");


    function msgCommande(){
        console.log("Exécution de la fonction commande");
        let prix = this.value *15;
        let fdp = 5;

        /*Si le prix est supérieur à 50€ les frais de port sont offerts*/
        if (prix > 50){
            fdp = 0;
        }

        /*Si le prix est supérieur ou égal à 0 afficher le message de commande*/
        if (prix >= 0){
            document.getElementById("zoneRetourClient").textContent = "Vous avez choisi de commander " + this.value + " t-shirts, pour un montant de " + prix + " €. " + "Les frais de port s'élèvent à " + fdp + " €."; 
        }
        
        /*Si le prix est inférieur à 0 afficher un message d'erreur et force le compteur à 0*/
        else {
            document.getElementById("zoneRetourClient").textContent = "Veuillez entrer un nombre positif."
            this.value = 0;
            prix = 0;
        }
        
        /*Si le nb de t-shirts est supérieur à 1 ajoute un "s" à t-shirt*/
        if (this.value > 1){
            document.getElementById("zoneRetourClient").textContent = "Vous avez choisi de commander " + this.value + " t-shirts, pour un montant de " + prix + " €. " + "Les frais de port s'élèvent à " + fdp + " €.";
        }
        
        /*Sinon affiche t-shirt sans "s"*/
        else{
            document.getElementById("zoneRetourClient").textContent = "Vous avez choisi de commander " + this.value + " t-shirt, pour un montant de " + prix + " €. " + "Les frais de port s'élèvent à " + fdp + " €.";
        }

    }

    document.getElementById("saisieNbTS").addEventListener('change',msgCommande);

}
/*Ecouteur d'évenement qui lance la fonction "principale" lorsque la page est prête*/
document.addEventListener('DOMContentLoaded', principale);