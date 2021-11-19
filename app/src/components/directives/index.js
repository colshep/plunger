// 全局注册指令
import draggable from './draggable'
// 自定义指令
const directives = {
    draggable,
}

export default {
    install(Vue) {
        Object.keys(directives).forEach((key) => {
            Vue.directive(key, directives[key])
        })
    },
}
