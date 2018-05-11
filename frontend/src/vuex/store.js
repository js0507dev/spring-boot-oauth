import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

// 기억안날꺼같으니 사용법도 적어놓음..
export const store = new Vuex.Store({
  // this.$store.state.name;
  state: {
    auth_server_url: '',
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
      const makeTokenUrl = state.auth_server_url + state.make_token_endpoint;
      axios.get(makeTokenUrl, {
        params: {
          response_type: 'token',
          client_id: payload.clientId,
          redirect_uri: payload.redirectUri,
          scope: payload.scope
        }
      })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  },
  // this.$store.dispatch('name', {key:value});
  // 
  // actions에서 payload 사용법
  // payload.key;
  actions: {
  }
});
