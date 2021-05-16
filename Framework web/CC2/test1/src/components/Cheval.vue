<template>
  <article>
    <p>Nom : {{nom}}</p>
    <p>Age : {{age}}</p>
    <p>Race : {{race}}</p>
    <p>{{isAlive()}}</p> // méthode isAlive
  </article>
</template>

<script>
export default {
  name: "Cheval",
  props : {
    nom : String,
    age : Number,
    race : String,
    vivant : Boolean
  },
  methods : {
    isAlive() {
      // si vivant alors renvoyer "vivant"
      if (this.vivant) {
        return "Vivant"
      } else { // sinon renvoyer "mort"
        return "Mort"
      }
    }
  }
}
</script>

<style scoped>

</style>