// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import HttpServer from '@/plugins/http.js';
import moment from 'moment'
import Mbread from '@/components/cuscom/mbread.vue'

import 'element-ui/lib/theme-chalk/index.css'
import '@/assets/css/reset.css'



Vue.config.productionTip = false

/*使用elementui*/
Vue.use(ElementUI);
Vue.use(HttpServer)


Vue.filter('fmtdate',(v)=>{
  return moment(v).format('YYYY-MM-DD')
})


//全局组件
Vue.component(Mbread.name,Mbread)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
