import * as types from './types';

const tokenModule = {
  state: {
    auth_server_url: '',
    auth_endpoint: '/oauth/authorize',
  },
  actions: {
    [types.GET_COOKIE] (state, payload) {
      let value = document.cookie.match('(^|;) ?' + payload.name + '=([^;]*)(;|$)');
      return value ? value[2] : null;
    },
    [types.GET_ACCESS_TOKEN] (context) {
      return context.actions.dispatch({name:'access_token'});
    }
  },
  mutations: {
    [types.SET_COOKIE] (state, payload) {
      let date = new Date();
      date.setSeconds(payload.expire);
      document.cookie = payload.name + '=' + payload.value + ';expire=' + date.toUTCString() + ';path=/';
    },
    [types.MAKE_ACCESS_TOKEN] (state, payload) {
      const authEndpoint = state.auth_server_url + state.auth_endpoint;
      let params = "?response_type="+payload.responseType
        + "&client_id="+payload.clientId
        + "&redirect_uri="+payload.redirectUri
        + "&scope="+payload.scope;
      window.location.href = authEndpoint + params;
    }
  }
};
