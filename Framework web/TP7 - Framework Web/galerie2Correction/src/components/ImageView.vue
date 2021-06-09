<template>
    <section class="photo">
        <h2>{{ titre }}</h2>
        <p><img :src="image" :alt="titre" /></p>
    </section>
</template>

<script>
    export default {
        name: 'ImageView',
        props: {
            titre: String,
            image: String
        }
    }
</script>
