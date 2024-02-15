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
@import '../../public/fonts/fonts.css'; /* fonts.css 파일 가져오기 */

body{
    font-family: 'RIDIBatang', sans-serif; /* 사용할 폰트 설정 */

}
.book-item{
    width:40%;
        font-family: 'RIDIBatang', sans-serif; /* 사용할 폰트 설정 */

}
.book-item a {
  text-decoration: none;
  color: rgba(0, 0, 0, 0.705);
  font-weight: 600;
      font-family: 'RIDIBatang', sans-serif; /* 사용할 폰트 설정 */

}
.selected-book {
  background-color: yellow; /* 선택된 책의 배경색을 변경할 수 있습니다. */
}
</style>

