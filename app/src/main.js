import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/components/element/element.js'
import '@/components/svgIcon/index'
import util from '@/components/utils/util.js';
import constant from '@/components/utils/constant.js';
import Directives from '@/components/directives';

Vue.prototype.util = util;
Vue.prototype.constant = constant;
Vue.use(Directives)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
