<template>
  <div class="list">
    <div class="list-header">
      <div class="list-header-title">{{data.bookTitle}}</div>
    </div>
    <div class="card-list" :data-list-id="data.listId">

      <CardItem v-for="card in data.cards" :key="`${card.cardId}`" :data="card"/>
    </div>
    
    <div v-if="isAddCard">
      <AddCard :list-id="data.listId" @close="isAddCard=false"/>
    </div>
    <div v-else>
      <p class="add-card-btn" @click.prevent="isAddCard=true">
        &plus; Add a card...
      </p>
    </div>
  </div>
</template>

<script>
import AddCard from '../card/AddCard.vue'
import CardItem from '../card/CardItem.vue'
export default {
  components: {AddCard, CardItem},
  props: ['data'],
  data() {
    return {
      isAddCard: false
    }
  },
  computed:{

  },
  created() {
    this.fetchData()
  },

  methods:{

    fetchData(){
        console.log("이거이거" + this.data.listId)
    }
}

}
</script>

<style>
.list {
  background-color: #e2e4e6;
  border-radius: 3px;
  margin-right: 10px;
  display: flex;
  flex-direction: column;
  vertical-align: top;
  width: 100%;
  max-height: 100%;
}
.list-header {
  flex: 0 0 auto;
  height: 30px;
  padding: 10px 8px 8px;
  position: relative;
}
.list-header-title {
  font-size: 16px;
  font-weight: 700;
  padding-left: 8px;
  line-height: 30px;
}
.input-title {
  width: 90%;
}
.delete-list-btn {
  position: absolute;
  right: 10px;
  top: 8px;
  text-decoration: none;
  color: #aaa;
  font-size: 24px;
}
.card-list {
  flex: 1 1 auto;
  overflow-y: scroll;
}
.empty-card-item   {
  height: 10px;
  width: 100%;
  background-color: rgba(0,0,0, 0);
}
.add-card-btn {
  flex: 0 0 auto;
  display: block;
  padding: 8px 10px;
  color: #8c8c8c;
  text-decoration: none;
}
.add-card-btn:focus,
.add-card-btn:hover {
  background-color: rgba(0,0,0, .1);
}
</style>