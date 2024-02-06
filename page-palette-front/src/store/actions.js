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
    FETCH_CARD({commit}, {cardId}){
        return api.card.fetchCard(cardId).then(data=>{
            commit('SET_CARDS', data)
        })
    },
    UPDATE_CARD({dispatch, state}, {cardId, title, description, pos, bgColor}){
        return api.card.update({cardId, title, description, pos, bgColor})
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))
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