import axios from 'axios';
import {token} from '../public/login.html'

const _axios = axios.create({
    baseURL: 'http://localhost:8080',
    withCredentials: true
})

// 请求拦截器
_axios.interceptors.request.use(
    (config) => {
        alert(token)
        config.headers.Authorization = token;
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
)

export default _axios;