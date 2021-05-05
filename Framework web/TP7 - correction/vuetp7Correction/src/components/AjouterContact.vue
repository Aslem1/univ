<template>
    <div class="bloccomposant">
        <p class="composant">Composant AjouterContact</p>
        <h3>Ajouter un contact</h3>
        <p><label for="nom">Nom</label><input id="nom" type="text" v-model="nom" class="validate"></p>
        <p><label for="prenom">Prénom</label><input id ="prenom" type="text" v-model="prenom" class="validate"></p>
        <p><label for="adresse">Adresse</label><input id="adresse" type="text" v-model="adresse" class="validate"></p>
        <p><label for="telephone">Téléphone</label><input id="telephone" type="tel" v-model="telephone" class="validate"></p>
        <p><label for="fav"><input type="checkbox" v-model="favorite" id="fav"><span>Favori</span></label></p>
        <button class="btn waves-effect waves-light" @click="ajouterContact">Ajouter<i class="material-icons right">send</i></button>

    </div>
</template>

<script>
    export default {
        name: "AjouterContact",
        data() {
            return {
                nom: '',
                prenom: '',
                adresse: '',
                telephone: '',
                favorite: false,
            }
        },
        methods: {
            ajouterContact() {
                this.$emit('ajouterContact', {
                    'nom' : this.nom,
                    'prenom' : this.prenom,
                    'adresse' : this.adresse,
                    'telephone' : this.telephone,
                    'favorite' : this.favorite
                })
            }
        }
    }
</script>

<style scoped>

</style>