document.addEventListener('DOMContentLoaded', init, false);

function init() {
    var burger=document.getElementById("burger");
    burger.addEventListener("click",function(){
        burger.classList.toggle("burgerchecked");
        document.getElementsByTagName("nav").item(0).classList.toggle("navVisible");
    });
}