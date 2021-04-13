<template>
  <section>
    <ul>
        <li v-for="p in this.photos" :key="p.mini">
          <a href="#" :title="p.titre"><img :src="imageUrl(p.mini)" alt="p.titre" @mouseenter="changePhoto(p)"></a>
        </li>
    </ul>
    <ImageView v-bind:image="image" v-bind:titre="titre"></ImageView>
  </section>
</template>

<script>
import ImageView from "./ImageView"
export default {
  name: "Galerie",
  props: {
    photos: Array
  },
  components : {
    ImageView
  },
  methods: {
    changePhoto(p) {
      this.image=p.lien
      this.titre=p.titre
    },
    imageUrl(p) {
      // permet de placer les images dans le dossier assets et que cela fonctionne qu’elle que soit la route…
      return require('@/assets/' + p)
    }
  },
  data() {
    return {
      image: 'images/photo1.jpg',
      titre: 'Pieuvre',
    }
  }
}
</script>

<style scoped>

</style>