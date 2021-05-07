<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <Meteo :ville="ville1"/>
    <Meteo :ville="ville2"/>
    <Meteo :ville="ville3"/>
    <Meteo :ville="ville4"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Meteo from '@/components/Meteo.vue'

export default {
  name: 'Home',
  components: {
    Meteo
  },
  data() {
    return {
      info: null,
      loading: true,
      erreur: false,

      // Ville 1
      ville1: 'La Rochelle',

      // Ville 2
      ville2: 'Cholet',

      // Ville 3
      ville3: 'Montpellier',

      // Ville 4
      ville4: 'Genève'
    }
  },

}
</script>
