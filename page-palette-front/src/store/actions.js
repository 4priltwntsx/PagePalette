import * as api from '../api'

const actions = {
    ADD_BOARD(_, {title, bgColor, userEmail}){
        return api.board.create(title, "F08080", localStorage.getItem("email"))
        
    }, 
    FETCH_BOARDS({commit}){
        return api.board.fetch(localStorage.getItem("email")).then(data=>{
            commit('SET_BOARDS', data )
        })
    },
    FETCH_BOARD({commit}, {id}){
        return api.board.fetchOne(id).then(data=>{
            commit('SET_BOARD', data)
        })
    },
    FETCH_LIST({commit}, {boardId}){
        return api.list.fetchList(boardId).then(data=>{
        commit('SET_LIST', data)
       })
    },

//////////////////// CARD
    ADD_CARD({dispatch, state},  {title, listId, pos, bgColor, description}){
        return api.card.create(title, listId, pos, bgColor, description)
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))

    },
    FETCH_CARD({commit}, {listId}){
        return api.card.fetchCard(listId).then(data=>{
            commit('SET_CARDS', data)
        })
    },

    ////////////////// user
    LOGIN({commit}, {email, password}){
        localStorage.setItem('email', email)
        return api.auth.login(email, password)
        // .then(({accessToken}) => commit('LOGIN', accessToken))
        .then(({email}) => commit('LOGIN', email))
    },

}

export default actions