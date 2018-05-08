import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/spa/Home'
import Signup from '@/spa/Member/Signup'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/member/signup',
      component: Signup,
    }
  ]
})
