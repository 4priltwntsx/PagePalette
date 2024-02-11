<template>
    <div class="book-item">
        <a href="" @click="AddList">{{ book.bookTitle }}</a>
    </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex'

export default {
    props: ['book'],

    data() {
    return {
      isAddList: false,
      inputTitle: '',
      input: '',
      valid: false,
      books: [],
      isBooks: true,
    }
  },
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
</style>

