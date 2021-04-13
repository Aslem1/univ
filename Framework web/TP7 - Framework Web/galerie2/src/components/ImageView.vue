<template>
  <section class="photo">
    <h2>{{ titre }}</h2>
    <p><img :src="require('@/assets/' + image)" :alt="titre" /></p>
  </section>
</template>

<script>
export default {
  name: "ImageView",
  props: {
    image: String,
    titre: String,
  }
}
</script>

<style scoped>

</style>