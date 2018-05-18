import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/spa/Home'
import AuthCallback from '@/spa/Member/AuthCallback'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/auth/callback',
      component: AuthCallback,
    }
  ]
})
