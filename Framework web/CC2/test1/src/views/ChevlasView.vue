<template>
  <div class="home-view">
    <img alt="Vue logo" src="../assets/logo.png">
    <ChevalsList/>
  </div>
</template>

<script>
// @ is an alias to /src
import ChevalsList from '@/components/ChevalsList.vue'

export default {
  name: 'ChevalsView', //nom du composant en cours (la page actuellement ouverte quoi)
  components: {
    ChevalsList
  }
}
</script>
