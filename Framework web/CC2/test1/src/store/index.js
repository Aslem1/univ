import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    poneys: [{ //poneys = nom du tableau
      nom : "Petit tonerre",
      age : 15,
      race : "Mustang",
      vivant : true
    }, {
      nom : "Magic",
      age : 19,
      race : "Trotteur français",
      vivant : true
    }, {
      nom : "Quinoa",
      age : 16,
      race : "Fjord",
      vivant : true
    }, {
      nom : "Snowman",
      age : 26,
      race : "ONC",
      vivant : false
    }],
    etatVoulu: true
  },
  //getters
  getters: {
    getByNom: (state,nom) => {
      return state.poneys.filter(elem => elem.nom === nom)
    },
    getByNom2: (state,nom) => {
      let resultat = [] // création d'un tableau "resultat"
      state.poneys.forEach(elem => { // for each sur poneys chaque poney s'appelle elem
        if (elem.nom === nom) { // si le nom du poney est bien égal à nom
          resultat.push(elem) // alors on met le poney dans le tableau resultat
        }
      })
      return resultat // on retourne le resultat
    },
    getByEtat: (state) => {
      return state.poneys.filter(elem => elem.vivant === state.etatVoulu)
    },
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
