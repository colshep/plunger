import axios from 'axios' //引入 axios
import router from './../router'

// 创建 axios 实例
const service = axios.create({
    baseURL: process.env.VUE_APP_BASEURL,
    timeout: 15000, // 请求超时时间
    withCredentials: true // 跨域时的允许携带cookie信息
});

// respone全局拦截器
service.interceptors.response.use(
    response => {
        const res = response.data
        if (res.code === 401) {
            // return Promise.reject('error')
            if (res.data && res.data.inner) {
                router.push('/inner/login');
            } else {
                router.push('/login');
            }
        } else {
            return response
        }
    },
    error => {
        console.log('err' + error);
        // 401错误时跳转登录页面
        if (error.response.status === 401) {
            router.push('/login');
        }
        return Promise.reject(error)
    }
)

function createToken() {
    let len = 32
    let $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'
    let maxPos = $chars.length
    let pwd = ''
    for (let i = 0; i < len; i++) {
        pwd += $chars.charAt(Math.floor(Math.random() * maxPos))
    }
    return pwd
}

export default service
