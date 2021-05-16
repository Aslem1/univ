import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from "../views/HomeView";
import ChevlasView from "../views/ChevlasView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/chevals',
    name: 'Chevals',
    component: ChevlasView
  }
]

const router = new VueRouter({
  routes
})

export default router
