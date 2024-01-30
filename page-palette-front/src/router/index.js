import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Login from '../components/Login.vue'
import NotFound from '../components/NotFound.vue'
import Board from '../components/Board.vue'

Vue.use(VueRouter)


const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      component:Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path:'/b/:bid', component:Board
  },
    {
      path: '*',
      component: NotFound
      }
  ]
})

export default router // 사용할 수 있도록 router export
