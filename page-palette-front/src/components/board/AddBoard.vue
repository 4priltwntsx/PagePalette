<template>
    <Modal>
      <div slot="header">
        <h2>
          Create new board
          <a href="" class="modal-default-button" 
            @click.prevent="SET_IS_ADD_BOARD(false)">&times;</a>
        </h2>
      </div>
      <div slot="body">
        <form id="add-board-form" 
          @submit.prevent="addBoard">
          <input class="form-control" type="text" v-model="input" ref="input">
        </form>
      </div>
      <div slot="footer">
        <button class="btn" :class="{'btn-success': valid}" type="submit" 
          form="add-board-form" :disabled="!valid">
          Create Board</button>
      </div>
    </Modal>
  </template>
  
  <script>
  import Modal from '../common/Modal.vue'
  import { mapActions, mapMutations } from "vuex"

  export default {
    components: {
      Modal
    },
    data() {
      return {
        input: '',
        valid: false
      }
    },
    watch: {
      input(v) {
        this.valid = v.trim().length > 0
      }
    },
    mounted() {
      this.$refs.input.focus() // 부모 컨포넌트에 마운트 되었을 때, 포커스를 입력 포커스로 옮기기 위한 코드
    },
    methods: {
      ...mapMutations([
        'SET_IS_ADD_BOARD'
      ]),
      ...mapActions([
        'ADD_BOARD',
        'FETCH_BOARDS'
      ]),
      addBoard() {
        this.SET_IS_ADD_BOARD(false)
        
        this.ADD_BOARD({title: this.input})
        .then((data)=>{
          console.log(data)
          this.$router.push(`/b/${data}`)

        })
      }
    }
  }
  </script>
  
  <style>
  
  </style>