<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Galeries msg="Bienvenue, Добро пожаловать, 欢迎光临, Benvenuto "/>
  </div>
</template>

<script>
import Galeries from './components/Galeries'

export default {
  name: 'App',
  components: {
    Galeries
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
