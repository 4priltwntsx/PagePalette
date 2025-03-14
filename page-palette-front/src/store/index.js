import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import getters from './getters'
import mutations from "./mutations"
import actions from "./actions"

Vue.use(Vuex)

const store = new Vuex.Store({
    state,
    getters,
    mutations,
    actions
})

// const {token} = localStorage
// store.commit('LOGIN', token)
const {email} = localStorage
store.commit('LOGIN', email)


export default store 