<template>
    <div class="bloccomposant">
        <p class="composant">Composant ListeContacts</p>
        <ul>
            <un-contact v-for="(c, index) in contactsFavoris" :key="index" :contact="c"></un-contact>
        </ul>
        <a class="btn-floating btn-large waves-effect waves-light red" @click="ajouterContact"><i class="material-icons">{{ add }}</i></a>
        <transition name="addcontact">
        <ajouter-contact @ajouterContact="ajout" v-if="visible"></ajouter-contact>
        </transition>
    </div>
</template>

<script>
    import UnContact from './UnContact.vue'
    import AjouterContact from './AjouterContact.vue'
    export default {
        data() {
          return {
              visible: false,
              add: 'add'
          }
        },
        name: "ListeContacts",
        props: {
            'contacts': Array
        },
        components: {
            UnContact,
            AjouterContact
        },
        computed: {
            contactsFavoris() {
                return this.contacts.filter(contact => contact.favorite)
            }
        },
        methods: {
            ajout(contact) {
                this.contacts.push(contact)
            },
            ajouterContact() {
                if (this.add == 'add') {
                    this.visible = true
                    this.add = 'remove'
                } else {
                    this.visible = false
                    this.add = 'add'
                }

            }
        }

    }
</script>

<style scoped>
    .addcontact-enter-active, .addcontact-leave-active {
        transition: opacity 1s;
    }
    .addcontact-enter, .addcontact-leave-to  {
        opacity: 0;
    }

</style>