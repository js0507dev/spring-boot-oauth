import Vue from 'vue'
import Vuex from 'vuex'
import tokenModule from './token/token'

Vue.use(Vuex);

// 기억안날꺼같으니 사용법도 적어놓음..
export const store = new Vuex.Store({
  modules: {
    token: tokenModule
  }
  // this.$store.state.name;
  // this.getters.name;
  //getters: {
  //},
  //
  // this.$store.commit('name', payload);
  // this.$store.commit('name', {
  //   valueA: 1,
  //   valueB: 'B',
  //   valueArr: ['A','B','C']
  // });
  //
  // mutations에서 payload 사용법
  // payload.key;
  // mutations: {
  // },
  //
  // this.$store.dispatch('name', {key:value});
  //
  // actions에서 payload 사용법
  // payload.key;
  // actions: {
  // }
});
