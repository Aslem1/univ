var app = new Vue({
    el: '#test',
    data() {
        return {
            visible: true,
            liste: [
                {'nom' : 'charles'},
                {'nom': 'bob'},
                {'nom' : 'gilbert'}
            ],
            titre : 'Bienvenue',
            btnTexte: 'Cacher'
        }
    },
    methods: {
        affiche() {
            this.visible=!this.visible
            if(this.visible) {
                this.btnTexte='Cacher'
            } else {
                this.btnTexte='Montrer'
            }
        }
    }
})
