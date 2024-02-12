<template>
    <div class="book-item">
        <li><a href=""  @click="onSubmitTitle">{{ book.bookTitle }}</a></li>
    </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex'

export default {
    props: ['book'],

    data() {
    return {
      isSelected: false

    }
  },
  methods:{
    ...mapActions([
      'ADD_LIST',
      'FETCH_BOOK',
    ]),
    selectBook(book){
      console.log(book)
    },
    handleBookClick() {
      this.isSelected = !this.isSelected;
    },
    onSubmitTitle() {
      const boardId = this.$store.state.board.boardId
      this.ADD_LIST({ bookTitle: this.book.bookTitle, bookIsbn: this.book.bookIsbn, boardId })
    },
  }
}
</script>

<style>
.book-item{
    width:40%;
}
.book-item a {
  text-decoration: none;
  color: rgba(0, 0, 0, 0.705);
  font-weight: 600;
}
.selected-book {
  background-color: yellow; /* 선택된 책의 배경색을 변경할 수 있습니다. */
}
</style>

