import axios from 'axios'
import router from '../router'


const DOMAIN = 'http://localhost:9090'
const UNAUTHORIZED = 401;
const onUnauthorized = ()=>{
    router.push('login')
}
const request = (method, url, data) =>{ 
    return axios({
        method,
        url:DOMAIN + url,
        data
    }).then(result=>result.data)
    .catch(
        result=>{
        // const {status} = result.response
        // if(status === UNAUTHORIZED) return onUnauthorized()
        // throw Error(result)
    })
    
}

// export const setAuthInHeader = token => {
//     axios.defaults.headers.common['Authorization'] = token ? `Bearer ${token}` : null;
// }




export const board = {
    fetch(email) {
        return request('get', `/board/${email}`)
    },
    fetchOne(id){
        return request('get', `/board/detail/${id}`)
    },

    create(title, bgColor, userEmail){
        return request('post', '/board', {title, bgColor, userEmail});
    }

}
export const list = {
    fetchList(boardId){
        return request('get', `/list/${boardId}`)
    }
}

export const card = {
    create(title, listId, pos, bgColor, description){
        return request('post', '/card', {title, listId, pos, bgColor, description})
    },
    fetchCard(cardId){
        return request('get', `/card/detail/${cardId}`)
    },
    update(payload){
        return request('put', `/card`, payload)
    },
    updateCardPos(payload){
        return request('put', `/card/position`, payload)
    }

}

export const auth = {
    login(email, password){
        return request('post', '/user/login', {email, password});
    }
}
