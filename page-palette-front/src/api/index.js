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
    }
}

export const auth = {
    login(email, password){
        return request('post', '/user/login', {email, password});
    }
}