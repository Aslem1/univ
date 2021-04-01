new Vue({
    el: '#panier',
        data: {
            panier: [
                { article: "Cahier", quantite: 2, prix: '5.30' },
                { article: "Crayon", quantite: 4, prix: '1.10' },
                { article: "Gomme", quantite: 1, prix: '3.25' }
            ],
            input: { article: '', quantite: 0, prix: 0 },
            poubelle: [
                {article: "test", quantite : 1, prix : 10}
            ]
        },
        computed: {
            total() {
                let total = 0
                this.panier.forEach(el => {
                    total += el.prix * el.quantite
                })
                return total.toFixed(2)
            },
        },
        methods: {
            ajouter() {
                if (typeof this.input.quantite === 'number' && typeof this.input.prix === 'number' && this.input.quantite !== 0 && this.input.prix !== 0 && this.input.article !== '') {
                    this.panier.push(this.input)
                    this.input = { article: '', quantite: 0, prix: 0 }
                }
                else {
                    alert("Veuillez saisir une entrée correcte");
                }
            },
            modifier(index) {
                this.input = this.panier[index]
                this.panier.splice(index, 1)
                this.$refs.modif.focus()
            },
            supprimer(index) {
                this.panier.splice(index, 1)
            }
        }
    })

    let ordonner = function (a, b) { 
        return (a.article.toUpperCase() > b.article.toUpperCase())
    }
