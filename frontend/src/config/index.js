import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'layout',
      component: Vue.component('Layout', require('../spa/Layout.vue')),
	  children: [
		{
			path: 'home',
			name: 'home',
			component: Vue.component('Home', require('../spa/Home.vue'))
		}
	  ]
    }
  ]
})
