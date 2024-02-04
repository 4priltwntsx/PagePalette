import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home.vue";
import Login from "../components/Login.vue";
import NotFound from "../components/NotFound.vue";
import Board from "../components/Board.vue";
import Card from "../components/Card.vue";
import store from '../store'

Vue.use(VueRouter);

// const requireAuth = (to, from, next) => {
//   const isAuth = localStorage.getItem('token') // 로그인했는지 안했는지 확인
//   const loginPath = `/login?rPath=${encodeURIComponent(to.path)}`
//   isAuth ? next() : next(loginPath)
// }

// // 임시
const requireAuth = (to, from, next) => {
    const loginPath = `/login?rPath=${encodeURIComponent(to.path)}`
    store.getters.isAuth ? next() : next(loginPath)
  }
  


const router = new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      component: Home,
      beforeEnter: requireAuth // 라우터 바뀔때마다
      
    },
    {
      path: "/login",
      component: Login,
    },
    {
      path: "/b/:bid",
      component: Board,
      children: [
        {
          path: "c/:cid",
          component: Card,
        }
      ],
    },
    {
      path: "*",
      component: NotFound,
    },
  ],
});

export default router; // 사용할 수 있도록 router export
