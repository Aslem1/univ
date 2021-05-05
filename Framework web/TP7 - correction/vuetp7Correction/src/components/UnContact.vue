<template>
    <li class="bloccomposant">
        <p class="composant">Composant UnContact</p>
        <h4 class='label'>{{ contact.nom }} {{ contact.prenom }} : </h4>
        <p class='desc'>{{ contact.adresse }}</p>
        <p>{{ contact.telephone }}</p>
    </li>
</template>

<script>
    export default {
        name: "UnContact",
        props: {
            contact: Object
        }
    }
</script>

<style scoped>

</style>