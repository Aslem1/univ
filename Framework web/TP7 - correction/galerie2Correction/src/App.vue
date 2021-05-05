<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Accueil</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link :to="{name: 'galeries'}">Galeries</router-link>
    </div>
    <router-view/>
  </div>
</template>
<style>
</style>
