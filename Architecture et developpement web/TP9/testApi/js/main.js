$(document).ready(function(){
    
   
    
    //creation de la carte
    mymap = L.map('mapid').setView([51.505, -0.09], 2);
    
    
	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymap);


    
    //appel des données
    $.getJSON("test.json",traitement);
  
    
});
             
//traitement des données
function traitement(data){
    console.log(data);
    
    $.each(data.records,function(i,e){
        console.log(e.fields.nom);
        
        let lat=e.fields.geo[0];
        let long=e.fields.geo[1];
        let nomVille=e.fields.nom;
        
        L.marker([lat, long]).addTo(mymap)
		.bindPopup(nomVille);
        
    })
}           
              
              
             


