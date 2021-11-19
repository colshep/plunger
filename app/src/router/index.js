import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    //配置默认的路径
    {path: '', redirect: '/index'},
    //主页
    {path: '/index', component: () => import('@/views/index')},
]

const router = new VueRouter({
    // mode: 'history', //后端支持可开
    base: process.env.VUE_APP_URL,
    scrollBehavior: () => ({y: 0}),
    routes: routes //指定路由列表
})

const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(to) {
    return VueRouterPush.call(this, to).catch(err => err)
}

export default router
