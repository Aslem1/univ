<template>
    <div class="container">
        <div class="bloccomposant">
        <p class="composant">Composant MesAdresses</p>
        <h1>Mon carnet d'adresses</h1>
        <liste-contacts :contacts="personnes"></liste-contacts>
        </div>
    </div>
</template>

<script>
    import ListeContacts from './ListeContacts.vue'
    export default {
        name: 'MesAdresses',
        components: {
            ListeContacts
        },
        data() {
            return {
                personnes: [{
                    nom: 'Dupont',
                    prenom: 'Pierre',
                    telephone: '0612345667',
                    adresse: '34 rue Bolivar 17000 La Rochelle',
                    favorite: true
                }, {
                    nom: 'Courboulay',
                    prenom: 'Vincent',
                    telephone: '0612345689',
                    adresse: '41 bd du 11 novembre 1918 17000 La Rochelle',
                    favorite: true
                }, {
                    nom: 'Bourmaud',
                    prenom: 'Anthony',
                    telephone: '0612345611',
                    adresse: '43 bd du 11 novembre 1918, 17000 La Rochelle',
                    favorite: false
                }, {
                    nom: 'Demko',
                    prenom: 'Christophe',
                    telephone: '0612345600',
                    adresse: '45, bd du 11 novembre 1918 17000 La Rochelle',
                    favorite: false
                }]
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
