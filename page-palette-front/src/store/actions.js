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
    DELETE_BOARD(_, {id}){
        return api.board.destroyBoard(id)
    },
    UPDATE_BOARD({dispatch, state}, {id, title, bgColor}){
        return api.board.update({title, bgColor, userEmail:localStorage.getItem("email"), id })
        .then(()=> dispatch('FETCH_BOARD', {id: state.board.boardId}))
    },


    FETCH_LIST({commit}, {boardId}){
        return api.list.fetchList(boardId).then(data=>{
        commit('SET_LIST', data)
       })
    },
    ADD_LIST({dispatch, state}, {boardId, bookTitle, bookIsbn}){
        return api.list.create({boardId, bookTitle, bookIsbn})
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))
    },
    DELETE_LIST ({ state, dispatch }, {listId}) {
        return api.list.destroyList(listId)
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))
      },

    FETCH_BOOK({commit}, {title}){
        return api.book.search(title)
    },
    FETCH_BOOKDETAIL({commit}, {bookIsbn}){
        return api.book.fetchBook(bookIsbn).then(data=>{
            console.log("actions----"+ bookIsbn)
            commit('SET_BOOK', data)
            console.log(data)
        })
    },
// -------------      CARD      -------------
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
    UPDATE_CARD_POS({dispatch, state}, {cardId, pos}){
        return api.card.updateCardPos({cardId, pos})
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))
    },
    DELETE_CARD({dispatch, state}, {cardId}){
        return api.card.destroyCard(cardId)
        .then(_ => dispatch('FETCH_LIST', {boardId: state.board.boardId}))
    },

// ---------------         user          ---------------------

    LOGIN({commit}, {email, password}){
        localStorage.setItem('email', email)
        return api.auth.login(email, password)
        // .then(({accessToken}) => commit('LOGIN', accessToken))
        .then(({email}) => commit('LOGIN', email))
    },

}

export default actions