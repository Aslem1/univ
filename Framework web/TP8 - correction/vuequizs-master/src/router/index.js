import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Quiz from '../components/Quiz.vue'

Vue.use(Router)

export default new Router({
  //mode:'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/quiz/:id',
      name: 'quiz',
      component: Quiz
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})
