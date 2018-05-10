import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

// 기억안날꺼같으니 사용법도 적어놓음..
export const store = new Vuex.Store({
  // this.$store.state.name;
  state: {
    auth_server_url: 'http://localhost:8080',
    access_token: '',
    make_token_endpoint: '/oauth/authorize',
    client_id: 'cli' // 추후 변경해야함.
  },
  // this.getters.name;
  getters: {
  },
  // this.$store.commit('name', payload);
  // this.$store.commit('name', {
  //   valueA: 1,
  //   valueB: 'B',
  //   valueArr: ['A','B','C']
  // });
  // 
  // mutations에서 payload 사용법
  // payload.key;
  mutations: {
    makeAccessToken: function(state, payload) {
    }
  },
  // this.$store.dispatch('name', {key:value});
  // 
  // actions에서 payload 사용법
  // payload.key;
  actions: {
  }
});
