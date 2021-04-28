new Vue({
    el: '#panier',
        data: {
            panier: [
                { article: "Cahier", quantite: 2, prix: '5.30' },
                { article: "Crayon", quantite: 4, prix: '1.10' },
                { article: "Gomme", quantite: 1, prix: '3.25' }
            ],
            input: { article: '', quantite: 0, prix: 0 },
            tva: 20,
            poubelle: []
        },
        computed: {
            total() {
                let total = 0
                this.panier.forEach(el => {
                    total += el.prix * el.quantite
                })
                return total.toFixed(2)
            },
            totalTTC() {
                let totalTTC = this.total*(1+this.tva/100)
                return totalTTC.toFixed(2)
            }
        },
        methods: {
            ajouter() {
                if(this.input.article!="") {
                    this.panier.push(this.input)
                    this.input = { article: '', quantite: 0, prix: 0 }
                }
            },
            eliminer(index) {
                this.poubelle.splice(index, 1);
            },
            modifier(index) {
                this.input = this.panier[index]
                this.panier.splice(index, 1)
                this.$refs.modif.focus()
            },
            supprimer(index) {
                this.poubelle.push(this.panier[index]);
                this.poubelle.sort(ordonner)
                this.panier.splice(index, 1)
            },
            retablir(index) {
                this.panier.push(this.poubelle[index]);
                this.panier.sort(ordonner)
                this.poubelle.splice(index, 1)
            }
             
        }
    })

    let ordonner = function (a, b) { 
        return (a.article.toUpperCase() > b.article.toUpperCase())
    }