<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <Galerie v-bind:photos="photos"></Galerie>
  </div>
</template>

<script>
import Galerie from "./Galerie";
export default {
  name: 'Galeries',
  components: {
    Galerie
  },
  props: {
    msg: String
  },
  data() {
    return {
      photos: [
        {
          lien: 'images/photo1.jpg',
          titre: 'Pieuvre',
          mini: 'images/minis/m_photo1.jpg'
        },
        {
          lien: 'images/photo2.jpg',
          titre: 'Feuille',
          mini: 'images/minis/m_photo2.jpg'
        },
        {
          lien: 'images/photo3.jpg',
          titre: 'Temple',
          mini: 'images/minis/m_photo3.jpg'
        },
        {
          lien: 'images/photo4.jpg',
          titre: 'Feu',
          mini: 'images/minis/m_photo4.jpg'
        },
        {
          lien: 'images/photo5.jpg',
          titre: 'Cascade',
          mini: 'images/minis/m_photo5.jpg'
        },
        {
          lien: 'images/photo6.jpg',
          titre: 'Monde',
          mini: 'images/minis/m_photo6.jpg'
        },
        {
          lien: 'images/photo7.jpg',
          titre: 'Tam Tam',
          mini: 'images/minis/m_photo7.jpg'
        },
      ],

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
