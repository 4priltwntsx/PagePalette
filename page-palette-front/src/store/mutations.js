// import {setAuthInHeader} from '../api'

const mutations = {
    SET_IS_ADD_BOARD(state, toggle){
        state.isAddBoard = toggle
    }, 
    SET_BOARDS (state, board){
        state.boards = board
    },
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
    },
}

export default mutations