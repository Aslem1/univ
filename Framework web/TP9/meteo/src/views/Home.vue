<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <Meteo :ville="ville1"/>
    <Meteo :ville="ville2"/>
    <Meteo ville="Axel je t'aime plus que tout"/>
    <Meteo ville="465634"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Meteo from '@/components/Meteo.vue'

export default {
  name: 'Home',
  components : {
    Meteo
  },
  data() {
    return {
      // Ville 1
      ville1 : 'La Rochelle',
      countryCode1 : '33',

      // Ville 2
      ville2 : 'Rochefort'
    }
  },


}
</script>
