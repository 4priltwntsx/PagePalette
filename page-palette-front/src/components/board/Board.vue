<template>
  <div>
    <div class="board-wrapper">
      <div class="board">
        <div class="board-header">
          <input class="form-control" v-if="isEditTitle" type="text" v-model="inputTitle"
           ref="inputTitle" @blur="onSubmitTitle" @keyup.enter="onSubmitTitle">
          <span v-else class="board-title" @click=onClickTitle>{{board.title}}</span>
          <a class="board-header-btn show-menu" href="" @click.prevent="onShowSettings">
            ... Show Menu
          </a>
        </div>
        <div class="list-section-wrapper">
          <div class="list-section">

            <div class="list-wrapper" v-for="l in list" :key="l.pos">
                <List :data="l" />
              </div>
              <div class="list-wrapper">
                <!-- <AddList/> -->
                  <div class="add-list">
    <a href="" @click.prevent="SET_IS_ADD_LIST(true)">
      &plus; Create new List
    </a>
  </div>
  <AddList v-if="isAddList"></AddList>
              </div>
          </div>
        </div>
      </div>
    </div>
    <BoardSettings v-if="isShowBoardSettings"/>
    <router-view></router-view>
  </div>
</template>
<script>
import {mapActions, mapMutations, mapState} from 'vuex'
import List from '../list/List.vue' 
import AddList from '../list/AddList.vue'
import dragger from '../../utils/dragger.js'
import BoardSettings from "./BoardSettings.vue"

export default {
  components:{
    List,
    AddList, 
    BoardSettings,
  },
  data() {
    return {
      bid: 0,
      loading: true,
      cDragger: null,
      isEditTitle: false,
      inputTitle: '',
    };
  },
  computed:{
    ...mapState({
      board: 'board',
      list: 'list',
      card: 'card', 
      isShowBoardSettings:'isShowBoardSettings',
      isAddList:'isAddList'
    })
  },
  created() {
    this.fetchData().then(()=>{
      this.inputTitle = this.board.title
      this.SET_THEME('#' + this.board.bgColor)
      this.SET_IS_SHOW_BOARD_SETTINGS(false)
      this.SET_IS_ADD_LIST(false)
    })
  },
  updated() {
    this.setCardDragabble()
  },
  
  methods:{
    ...mapMutations([
      'SET_THEME',
      'SET_IS_SHOW_BOARD_SETTINGS',
      'SET_IS_ADD_LIST',
      
    ]),
    ...mapActions([
      'FETCH_BOARD',
      'FETCH_LIST',
      'UPDATE_CARD_POS',
      'UPDATE_BOARD'
    ]),
    fetchData(){
        this.loading = true

        return this.FETCH_BOARD({id: this.$route.params.bid})
        .then(()=>{ 
          this.loading = false
          this.FETCH_LIST({boardId:this.$route.params.bid})
        })
        
        
    },
    setCardDragabble() {
      if (this.cDragger) this.cDragger.destroy()
    
      this.cDragger = dragger.init(Array.from(this.$el.querySelectorAll('.card-list')))
      this.cDragger.on('drop', (el, wrapper, target, silblings) => {
        const targetCard = {
          cardId: el.dataset.cardId * 1, 
          pos: 65535,
        }
        const {prev, next} = dragger.sibling({
          el, 
          wrapper, 
          candidates: Array.from(wrapper.querySelectorAll('.card-item')), 
          type: 'card'
        })  
        
        if (!prev && next) targetCard.pos = next.pos / 2
        else if (!next && prev) targetCard.pos = prev.pos * 2
        else if (next && prev) targetCard.pos = (prev.pos + next.pos) / 2
        this.UPDATE_CARD_POS(targetCard)
      })
    },
    onShowSettings(){
      this.SET_IS_SHOW_BOARD_SETTINGS(true)
    },
    onClickTitle(){
      this.isEditTitle = true;
      this.$nextTick(()=>this.$refs.inputTitle.focus())
    },
    onSubmitTitle(){
      this.isEditTitle = false;

      // this.inputTitle = this.inputTilte.trim()
      if(!this.inputTitle) return

      const id = this.board.boardId
      const title = this.inputTitle
      if(title===this.board.tilte) return

      this.UPDATE_BOARD({id, title, bgColor: this.board.bgColor})
    }
  }
}
</script>

<style>
.board-wrapper {
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
}
.board {
  display: flex;
  flex-direction: column;
  height: 100%;
}
.board-header {
  flex: none;
  padding: 8px 4px 8px 8px;
  margin: 0;
  height: 32px;
  line-height: 32px;
} 
.board-header input[type=text] {
  width: 200px;
}
.board-header-btn {
  border-radius: 4px;
  padding: 2px 10px;
  height: 30px;
  margin-bottom: 15px;
  display: inline-block;
  color: #fff;
}
.board-header-btn:hover,
.board-header-btn:focus {
  background-color: rgba(0,0,0,.15);
  cursor: pointer;
}
.board-title {
  font-weight: 700;
  font-size: 18px;
}
.show-menu {
  font-size: 14px;
  position: absolute;
  right: 15px;
}
.list-section-wrapper {
  flex-grow: 1;
  position: relative;
}
.list-section {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  overflow-x: auto;
  overflow-y: hidden;
  white-space: nowrap;
  padding: 0 10px;
}
.list-wrapper {
  display: inline-block;
  height: 100%;
  width: 272px;
  vertical-align: top;
  margin-right: 5px;
}
.card-item.gu-transit {
  background-color: #555 !important;
}
.card-item.gu-mirror {
  opacity: 1 !important;
  background-color: #fff !important;
  transform: rotate(3deg) !important;
}

.add-list {
  background-color: rgba(0,0,0, .1);
  padding: 12px;
  color: #ddd;
  transition: all .3s;
}
.add-list a {
    text-decoration: none;
    color: white;
    font-weight: 600;
}
.add-list:hover,
.add-list:focus {
  background-color: rgba(0,0,0, .3);
  cursor: pointer;
}
</style>
