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
      <a href="" class="modal-default-button" @click="closeModal">&times;</a>
    </h2>
  </div>
  <div slot="body">
    <form id="add-list" @submit.prevent="searchBook">
      <input class="form-control" type="text" v-model="input" ref="input">
    </form>
    <div v-if="isBooks" style="overflow-y: auto;">
      <ul class="finded-books">
        <BookItems v-for="(book, i) in books.bookList" :key="i" :book="book"/>
      </ul>
    </div>
  </div>
  <div slot="footer">
    <button class="btn" :class="{ 'btn-success': valid }" type="submit" form="add-list" :disabled="!valid">
      Create List
    </button>
  </div>
</Modal>
  
</template>
<script>
import { mapState, mapMutations, mapActions } from 'vuex'
import Modal from '../common/Modal.vue'
import BookItems from './BookItems.vue'

export default {
  components: {
    Modal, BookItems
  },
  data() {
    return {
      isAddList: false,
      inputTitle: '',
      input: '',
      valid: false,
      books: [],
      selectedBook: null,
      isBooks: true,
    }
  },
  watch: {
    input(v) {
      this.valid = v.trim().length > 0
    },

  },
  computed: {
    ...mapState({
      board: 'board',
      list: 'list',
    })
  },
  mounted() {
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
    async searchBook() {
      console.log("!!= 들어간다!!!!" + this.input)
      this.books = await this.FETCH_BOOK({ title: this.input })
      console.log(this.books.bookList)
      this.SET_BOOKS(this.books.bookList)
    },
    addList() {
      console.log(this.input)
      this.isAddList = true
      this.$nextTick(_ => this.$refs.inputTitle.focus())

      this.SET_IS_ADD_LIST(false)
    },
    onSubmitTitle() {
      this.inputTitle = this.inputTitle.trim()
      if (!this.inputTitle) return this.resotre()

      const title = this.inputTitle
      const curList = this.$store.state.list
      // const lastList = curList[curList.length - 1]
      //   const pos = lastList ? lastList.pos * 2 : 65535
      const bookIsbn = "9791168473690"
      const boardId = this.$store.state.board.boardId
      this.ADD_LIST({ bookTitle: title, bookIsbn, boardId }).then(_ => this.restore())
    },
    restore() {
      this.isAddList = false
      this.inputTitle = ''
    },
    closeModal() {
    this.SET_IS_ADD_LIST(false);
  },
  selectBook(book) {
    this.input = book.bookTitle;
  },
  }
}
</script>

<style>
.add-list {
  background-color: rgba(0, 0, 0, .1);
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
  background-color: rgba(0, 0, 0, .3);
  cursor: pointer;
}

.finded-books{
    width: 60%;
    max-height: 400;
}
</style>