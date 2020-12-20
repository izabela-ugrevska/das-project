import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Restaurants from '../views/Restaurants.vue'
import Cafes from '../views/Cafes.vue'
import Markets from '../views/Markets.vue'
import Other from '../views/Other.vue'
import Object from '../views/Object.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/restaurants',
    name: 'Restaurants',
    component: Restaurants
  },
  {
    path: '/cafes',
    name: 'Cafes',
    component: Cafes
  },
  {
    path: '/markets',
    name: 'Markets',
    component: Markets
  },
  {
    path: '/other',
    name: 'Other',
    component: Other
  },
  {
    path: '/objects/:category/:id',
    name: 'Object',
    component: Object
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
