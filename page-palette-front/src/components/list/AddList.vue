<template>
  <div class="add-list">
    <input class="form-control" v-if="isAddList" type="text" ref="inputTitle" 
      v-model="inputTitle" @keyup.enter="onSubmitTitle" @blur="restore">
    <a v-else @click="onAddList">&plus; Add another list</a>

  </div>

</template>

<script>
import {mapState, mapActions} from 'vuex'

export default {
  data() {
    return {
      isAddList: false,
      inputTitle: '',
    }
  },
  computed: {
    ...mapState({
      board: 'board',
      list: 'list'
    })
  },

  methods: {
    ...mapActions([
      'ADD_LIST',
    ]),
    onAddList() {
      this.isAddList = true
      this.$nextTick(_=> this.$refs.inputTitle.focus())
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
.add-list:hover,
.add-list:focus {
  background-color: rgba(0,0,0, .3);
  cursor: pointer;
}
</style>