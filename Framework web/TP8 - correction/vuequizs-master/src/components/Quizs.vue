<template>
  <div class="container">
    <b-card header="Choisissez un quiz" header-tag="header">
      <b-list-group>
        <b-list-group-item
                button
                v-for="(item, index) in quizs"
                :key="index"
                @click="action(index)">
          {{ item.nom }}
        </b-list-group-item>
      </b-list-group>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'quizs',
  methods: {
      action(index) {
          this.$router.push({ name: 'quiz', params: { id: index }})
      }
  },
  computed: {
      quizs () {
           return this.$store.state.quizs
      }
  },
  created() {
      // API
      this.$store.dispatch('getData')
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
