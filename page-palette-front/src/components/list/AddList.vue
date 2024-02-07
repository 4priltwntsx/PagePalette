<template>
  <!-- <div class="add-list">
    <input class="form-control" v-if="isAddList" type="text" ref="inputTitle" 
      v-model="inputTitle" @keyup.enter="onSubmitTitle" @blur="restore">
    <a v-else @click="onAddList">&plus; Add another list</a>
  </div> -->

  <!-- <div class="add-list">
    <a href="" @click.prevent="addList">
      &plus; Create new List
    </a>
  </div> -->

    <Modal>
      <div slot="header">
        <h2>
          new List of your Book
          <a href="" class="modal-default-button" 
            @click.prevent="SET_IS_ADD_LIST(false)">&times;</a>
        </h2>
      </div>
      <div slot="body">
        <form id="add-board-form" 
          @submit.prevent="searchBook">
          <input class="form-control" type="text" v-model="input" ref="input">
          
        </form>
          <!-- 수정된 부분 시작 -->

      <!-- 수정된 부분 끝 -->
      </div>
      <div slot="footer">
        <button class="btn" :class="{'btn-success': valid}" type="submit" 
          form="add-board-form" :disabled="!valid">
          Create List</button>
      </div>
    </Modal>
</template>

<script>
import {mapState, mapMutations, mapActions} from 'vuex'
import Modal from '../common/Modal.vue'

export default {
  components:{
    Modal
  },
  data() {
    return {
      isAddList: false,
      inputTitle: '',
      input:'',
      valid: false,
      bs:[],
    }
  },
  watch:{
    input(v){
      this.valid=v.trim().length>0
    },
    books(){
      console.log(this.$store.state.books)
    }

  },
  computed: {
    ...mapState({
      board: 'board',
      list: 'list',
      books: [],
    })
  },
  mounted(){
    this.$refs.input.focus()
  },
  methods: {
    ...mapMutations([
      'SET_IS_ADD_LIST',
      'SET_BOOKS'
    ]),
    ...mapActions([
      'ADD_LIST',
      'FETCH_BOOK',
    ]),
    async searchBook(){
      console.log("!!= 들어간다!!!!" + this.input)
      this.bs = await this.FETCH_BOOK({title: this.input})
      console.log( this.bs.bookList) 
      this.SET_BOOKS(this.bs.bookList)
    }, 
    addList() {
      console.log(this.input)
      this.isAddList = true
      this.$nextTick(_=> this.$refs.inputTitle.focus())

      this.SET_IS_ADD_LIST(false)
    },
    onSubmitTitle() {
      this.inputTitle = this.inputTitle.trim()
      if (!this.inputTitle) return this.resotre()

      const title = this.inputTitle
      const curList = this.$store.state.list
      const lastList = curList[curList.length - 1]
    //   const pos = lastList ? lastList.pos * 2 : 65535
    const bookIsbn = "9791168473690"
      const boardId = this.$store.state.board.boardId
      this.ADD_LIST({bookTitle: title, bookIsbn, boardId}).then(_ => this.restore())
    },
    restore() {
      this.isAddList = false
      this.inputTitle = ''
    },
  }
}
</script>

<style>
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