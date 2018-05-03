// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import config from './config'

Vue.config.productionTip = false

Vue.component('my-header', require('./shared-components/my-header.vue'))

/* eslint-disable no-new */
new Vue({
  el: '#app',
  config,
  components: { App },
  template: '<App/>'
})
