// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './config'

//import '../node_modules/zepto/dist/zepto.js'

import './assets/vendor/bootstrap/css/bootstrap.css'
import './assets/vendor/bootstrap-social/bootstrap-social.css'

//import './assets/js/sb-admin-2.js'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
