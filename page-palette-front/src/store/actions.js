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
    LOGIN({commit}, {email, password}){
        localStorage.setItem('email', email)
        return api.auth.login(email, password)
        // .then(({accessToken}) => commit('LOGIN', accessToken))
        .then(({email}) => commit('LOGIN', email))
    }
}

export default actions