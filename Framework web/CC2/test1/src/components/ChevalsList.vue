<template>
  <article>
    <ul>
      <li v-for="cheval in chevals" v-bind:key=cheval.nom>
        <cheval :nom=cheval.nom :age=cheval.age :race=cheval.race :vivant=cheval.vivant />
      </li>
    </ul>
    <p>---------------------------------------</p>
    <input type="button" @click="changeEtatVoulu">
    <ul>
      <li v-for="cheval in chevalsParEtat" v-bind:key=cheval.race>
        <cheval :nom=cheval.nom :age=cheval.age :race=cheval.race :vivant=cheval.vivant />
      </li>
    </ul>
  </article>
</template>

<script>
import Cheval from "./Cheval";

export default {
  name: "ChevalsList",
  components : {
    Cheval
  },
  computed : {
    chevals() {
      return this.$store.state.poneys
    },
    chevalsParEtat() {
      return this.$store.getters.getByEtat
    }
  },
  methods : {
    changeEtatVoulu() {
      this.$store.state.etatVoulu = !this.$store.state.etatVoulu // met non etat voulu
    }
  }
}
</script>

<style scoped>

</style>