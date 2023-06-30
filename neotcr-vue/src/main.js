import Vue from 'vue'
import App from './App'

import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/reset.css'
import axios from'axios'
import VueAxios from 'vue-axios'
import locale from 'element-ui/lib/locale/lang/en'

Vue.use(router)
Vue.use(ElementUI, {locale})
Vue.use(VueAxios,axios)
Vue.prototype.$EventBus = new Vue()

new Vue({
  el: '#app',
  router,
  render: h=>h(App)
})
