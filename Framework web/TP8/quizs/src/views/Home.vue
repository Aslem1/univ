<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <Quizs msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Quizs from '@/components/Quizs.vue'

export default {
  name: 'Home',
  components: {
    Quizs
  }
}
</script>
