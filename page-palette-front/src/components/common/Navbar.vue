<template>
    <nav class="header">
      <div class="header-logo">
        <router-link to="/"><img src="../../img/PPalette_logo.png" style="width:130px;" alt="PPalette"></router-link>
      </div>
      <div class="header-auth">
        <a href="" v-if="isAuth" @click.prevent="logout">Logout</a>
        <router-link v-else to="/login">Login</router-link>
      </div>
    </nav>
  </template>
  
  <script>
  import {mapState, mapGetters, mapMutations} from 'vuex'

  export default {
    computed: {
      ...mapState({
        navbarColor: 'navbarColor',
        bodyColor: 'bodyColor'
      }),
      ...mapGetters([
        'isAuth'
      ])
    },
    watch:{
      'bodyColor':'updateTheme'
    },
    mounted(){
      this.updateTheme()
    },
    methods: {
      ...mapMutations([
        'LOGOUT'
      ]),
      logout() {
        this.LOGOUT()
        this.$router.push('/login')
      },
      updateTheme(){
        this.$el.style.backgroundColor = this.navbarColor

        const body = document.querySelector('body')
        const container = document.querySelector('.container')
        if(body) body.style.backgroundColor = this.bodyColor
        if(container) container.style.backgroundColor = this.bodyColor
      }
    }
  }
  </script>
  
  <style>
  .header {
    flex: none;
    background-color: rgba(0,0,0,.15);
    height: 32px;
    padding: 4px;
  }
  .header a {
    display: block;
    height: 30px;
    line-height: 30px;
    text-decoration: none;
    color: rgba(255,255,255,.5);
  }
  .header-logo {
    text-align: center;
  }
  .header-logo img {
  max-width: 100%; /* 이미지의 크기를 최대 너비로 지정 */
  height: auto; /* 이미지의 비율 유지 */
  vertical-align: middle; /* 이미지를 수직 가운데 정렬하기 위해 추가 */
}
  .header-logo a:hover,
  .header-logo a:focus {
    color: rgba(255,255,255,.9);
  }
  .header-auth {
    position: absolute;
    right: 15px;
    top: 5px;
  }
  .header-auth a {
    border-radius: 2px;
    padding: 0 10px;
    background-color: rgba(255,255,255, .5);
    color: white;
    transition: all .3s;
  }
  .header-auth a:hover,
  .header-auth a:focus {
    background-color: rgba(255,255,255, .3);
  }
  </style>