import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/spa/Layout'
import Home from '@/spa/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'layout',
      component: Layout,
      children: [
        {
          path: '',
          component: Home
        }
      ]
    }
  ]
})
