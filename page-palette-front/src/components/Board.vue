<template>
  <div>
    Board
    <div v-if="loading">loading board...</div>
    <div v-else>
      <div>bid: {{ bid }}</div>
      <router-link :to="`/b/${bid}/c/1`">Card 1 </router-link>
      <router-link :to="`/b/${bid}/c/2`">Card 2 </router-link>
    </div>
    <hr />
    <router-view> </router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bid: 0,
      loading: true
    };
  },

  created() {
    this.fetchData()
  },

  methods:{
    fetchData(){
        this.loading = true
        setTimeout(()=>{ // 로딩 지연 시간 0.5초 정도, 초기 화면 로딩 때 loading board 출력 이후 fetchData, bid 세팅, loading - false
            this.bid = this.$route.params.bid;
            this.loading = false
        }, 500)
        
    }
  }
};
</script>

<style></style>
