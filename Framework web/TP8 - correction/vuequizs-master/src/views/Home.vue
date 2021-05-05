<template>
  <div class="home">
    <img alt="Quiz" src="../assets/quiz.png">
    <Quizs />
  </div>
</template>

<script>

import Quizs from "../components/Quizs";

export default {
  name: 'home',
  components: {
      Quizs,
  }
}
</script>
