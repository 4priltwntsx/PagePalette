<template>
  <div class="add-card">
    <form @submit.prevent="onSubmit">
      <input class="form-control" type="text" v-model="inputTitle" ref="inputText">
      <button class="btn btn-success" type="submit" :disabled="invalidInput">
        Add Card</button>

      <a class="cancel-add-btn" href="" @click.prevent="$emit('close')">&times;</a>
    </form>
  </div>
</template>

<script>
import {mapActions, mapState} from 'vuex'

export default {
  props: ['listId'],
  data() {
    return {
      inputTitle: ''
    }
  },
  computed: {
    invalidInput() {
      return !this.inputTitle.trim()
    },
    ...mapState({
      board: 'board',
      list: 'list',
    })
  },
  mounted() {
    this.$refs.inputText.focus()
    // this.setupClickOutside(this.$el)
  },
  methods: {
    ...mapActions([
      'ADD_CARD'
    ]),
    onSubmit() {
      if (this.invalidInput) return 
      const {inputTitle, listId} = this
      const pos = this.newCardPos()
      console.log(listId)
      this.ADD_CARD({title: inputTitle, listId, pos, description: inputTitle, bgColor:"008B8B"})
        
      .finally(()=> this.inputTitle = '')

    },
    newCardPos() {
      const curList = this.$store.state.list[0]
      if (!curList) return 65535
      if (!curList.cards.length) return 65535
      return curList.cards[curList.cards.length - 1].pos * 2
    },
    // setupClickOutside(el) {
    //   document.querySelector('body').addEventListener('click', e => {
    //     if (el.contains(e.target)) return 
    //     this.$emit('close')
    //   })
    // }
  }
}
</script>

<style>
.add-card {
  padding: 10px;
  display: block;
  position: relative;
}
.add-card .cancel-add-btn {
  display: inline-block;
  margin-left: 10px;
  vertical-align: middle;
  text-decoration: none;
  color: #888;
  font-size: 24px;
}
.add-card .cancel-add-btn:hover,
.add-card .cancel-add-btn:focus {
  color: #666;
}
</style>