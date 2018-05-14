import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

// 기억안날꺼같으니 사용법도 적어놓음..
export const store = new Vuex.Store({
  // this.$store.state.name;
  state: {
    auth_server_url: '',
    make_token_endpoint: '/oauth/authorize',
    site_access_token: '',
    site_access_token_type: '',
    site_access_token_expire: '',
  },
  // this.getters.name;
  getters: {
    siteAccessToken: state => {
      return state.site_access_token;
    }
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
      let params = "?response_type="+payload.responseType
          + "&client_id="+payload.clientId
          + "&redirect_uri="+payload.redirectUri
          + "&scope="+payload.scope;
      window.location.href = makeTokenUrl + params;
    },
    checkSiteToken: function(state) {
      let expire = state.site_access_token_expire;
      if(expire != '') {
        let td = new Date();
        console.log("td["+ td.toLocaleString() +"]");
        td.setTime(expire * 1000);
        console.log("expire["+ td.toLocaleString() +"]");
      }
    }
  },
  // this.$store.dispatch('name', {key:value});
  // 
  // actions에서 payload 사용법
  // payload.key;
  actions: {
  }
});
