<template>
  <div class="meteo">
    <p>|{{ville}}|</p>
    <p>{{temps}} : {{temperature}}°C</p>
    <p>latitude : {{latitude}} | longitude : {{longitude}}</p>
    <p> -------------------- </p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Meteo',
  props: {
    ville: String,
    temps: String,
    temperature: Number,
    latitude:Number,
    longitude:Number,
  },

  mounted : function () {
    axios
        .get(this.$store.state.urlMeteo + this.ville + "&appid=" + this.$store.state.cle)
        .then(response => {
          console.log(response)

          this.temps = response.data.weather[0].description;
          this.temperature = response.data.main.temp;
          this.latitude = response.data.coord.lat;
          this.longitude = response.data.coord.lon;
        })
        .catch(error => {
          console.log(error)
        })
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
