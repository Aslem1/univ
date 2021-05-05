<template>
  <div id="app">
    <nav class="teal lighten-2">
      <div class="nav-wrapper container teal lighten-2">
        <a href="#" class="brand-logo">VueJS TP7</a>
        <ul id="nav-mobile" class="right">
          <li><router-link to="/">Accueil</router-link></li>
          <li><router-link :to="{name: 'about'}">À propos</router-link></li>
        </ul>
      </div>
    </nav>
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'App',
  }
</script>

<style>
  .composant {
    color: #4db6ac;
    font-weight: bold;
    text-align: right;
    text-decoration: underline darkcyan;
  }
  .bloccomposant {
    border: 1px dashed black;
    margin: 8px;
  }
</style>
