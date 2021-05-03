<template>
    <div>
        <ul>
            <li v-for="(p, index) in photos" :key="index">
                <a href="#" :title="p.titre"><img :src="imageUrl(p.mini)" :alt="p.titre" @mouseenter="changePhoto(p)"></a>
            </li>
        </ul>
    <image-view :titre="titre" :image="image"/>
    </div>
</template>

<script>
    import ImageView from '@/components/ImageView.vue'
    export default {
        name: "galerie",
        data() {
            return {
                titre: this.photos[0].titre,
                image: this.imageUrl(this.photos[0].lien)
            }
        },
        components: {
            ImageView
        },
        props: {
            photos: Array
        },
        methods: {
            changePhoto(p) {
                this.image=this.imageUrl(p.lien)
                this.titre=p.titre
            },
            imageUrl(p) {
                // permet de placer les images dans le dossier assets et que cela fonctionne qu'elle que soit la route...
                return require('@/assets/' + p)
            }
        }
    }
</script>

<style scoped>

</style>
