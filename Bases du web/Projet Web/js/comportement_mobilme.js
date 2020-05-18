
document.addEventListener('DOMContentLoaded', demarrer);

/*Ecriture de la fonction principale*/
function demarrer(){
    
    function onArticleCLick (){
        this.classList.add("enDetail");
        
        console.log(this.querySelector('h2').textContent)
    }
    
    let articles = document.querySelectorAll('#appartementsALouer article')
    console.log(articles)
    articles.forEach(
        article => {
            
            article.addEventListener('click', onArticleCLick);
        }
    )
    
        

}