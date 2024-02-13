// import {setAuthInHeader} from '../api'

const mutations = {
    SET_IS_ADD_BOARD(state, toggle){
        state.isAddBoard = toggle
    }, 
    SET_BOARDS (state, board){
        state.boards = board
    },
    SET_BOARD(state, board){
        state.board = board
    },
    SET_IS_ADD_LIST(state, toggle){
        state.isAddList = toggle;
    },
    SET_BOOKS(state, books){
        state.books = books
    },
    SET_LIST(state, list){
        state.list = list
    },
    
    SET_CARDS(state, card){
        state.card = card;
    },
    SET_THEME(state, color){
        state.bodyColor = color || '#ffffff'
        state.navbarColor = color ? 'rgba(0,0,0,.15)' : '#EEE8AA'
    },
    SET_IS_SHOW_BOARD_SETTINGS(state, toggle){
        state.isShowBoardSettings = toggle;
    },
    SET_BOOK(state, bookDetail){
        console.log("state here----" + bookDetail)
        state.bookDetail = bookDetail;
    },
// -------------------------------------------------------

    LOGIN(state, token){
        if(!token) return
        state.token = token
        // localStorage.setItem('token', token)
        // api.setAuthInHeader(token) 리퀘스트 헤더 설정
        
        // 임시
        localStorage.setItem('email', token)
    },
    LOGOUT(state){
        // state.token = null
        state.token = null
        // delete localStorage.token
        delete localStorage.email
        // api.setAuthInHeader(null)
        state.bodyColor = '#ffffff'
        state.navbarColor = '#EEE8AA'
    },
}

export default mutations