<template>
  <div class="meteo">
    <a href="#" :title="ville" @click="getData(ville)">{{ville}}</a>
  </div>
</template>

<script>
export default {
  name: 'Meteo',
  props: {
    ville: String
  },
  methods : {
    getData(v) {
      alert(this.$store.state.urlMeteo)
      alert(v)
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
