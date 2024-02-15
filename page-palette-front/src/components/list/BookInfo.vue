<template>
  <Modal class="modal-card" v-if="bookDetail!=null">
    <div slot="header" class="modal-card-header">
      <div class="modal-card-header-title">
        <h2>{{bookDetail.bookTitle}}</h2>
      </div>
      <a class="modal-close-btn" href="" @click.prevent="onClose">&times;</a>
    </div>
    <div slot="body" style="display:flex; gap:20px;">
      <img :src="bookDetail.bookImage" style="width: 30%"><div style="font-size:18px"><div style="line-height:1.5"><b>저자</b><br/>{{bookDetail.authorName}}<br/><br/></div>
      <div ><b>책 설명</b><br/>{{bookDetail.bookDescription}}</div>
      </div>
    </div>
    <div slot="footer"></div>
  </Modal>
</template>

<script>
import Modal from '../common/Modal.vue'
import {mapActions, mapState} from 'vuex'

export default {
  data(){
    return {
      toggleTitle: false,
      toggleDesc: false
    }
  },    
  components: {Modal},
    computed: {
    ...mapState({
      bookDetail:'bookDetail',
      board: 'board'
    })
    },
    created(){
    const bookIsbn = this.$route.params.bookIsbn
    this.fetchBook(bookIsbn);
  },
  methods:{
      ...mapActions([ 
        'FETCH_BOOKDETAIL'
      ]) ,
    onClose() {
      this.$router.push(`/b/${this.board.boardId}`)
    },   
    fetchBook(bookIsbn){
        this.FETCH_BOOKDETAIL({bookIsbn});
        console.log(this.bookImage+ "이거야????????")
    }
  }
}
</script>

<style>
@import '../../public/fonts/fonts.css'; /* fonts.css 파일 가져오기 */

body{
    font-family: 'RIDIBatang', sans-serif; /* 사용할 폰트 설정 */

}
.modal-card .modal-container {
  min-width: 300px;
  max-width: 800px;
  width: 60%;
}
.modal-card-header-title {
  padding-right: 30px;  
}
.modal-close-btn {
  position: absolute;
  top: 0px;
  right: 0px;
  font-size: 24px;
  text-decoration: none;
}
.modal-card-header {
  position: relative;
}
</style>