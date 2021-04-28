var app = new Vue({
    el: '#test',
    data() {
        return {
            titre : 'Bienvenue',
            visible : true,
            liste : [
                { nom: 'nom1'},
                { nom: 'nom2'},
                { nom: 'nom3'}
            ],
            btnTexte : 'Cacher',
        }
    },
    methods: {
        affiche() {
            this.visible=!this.visible
            if(this.visible) {
                this.btnTexte = 'Cacher'
            }
            else {
                this.btnTexte='Montrer'
            }
        }
    }
})