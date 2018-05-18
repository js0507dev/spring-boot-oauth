<template>
</template>

<script>
  import Vue from 'vue'

  export const eventbus = new Vue();

  export default {
    name: "token",
    data: function() {
      return {
        auth_server_url: '',
        auth_endpoint: '/oauth/authorize',
        cookie_name: 'jsExchange/AccessToken',
      }
    },
    created() {
      eventbus.$on('readAccessToken', this.readAccessToken);
      eventbus.$on('writeCookie', this.writeCookie);
      eventbus.$on('issuedAccessToken', this.issuedAccessToken);
    },
    methods: {
      readCookie: function (name) {
        alert("readCookie ! ")
        let value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
        return value ? value[2] : '';
      },
      readAccessToken: function () {
        alert("readAccessToken ! ")
        return this.readCookie('access_token');
      },
      writeCookie: function (name, value, expire) {
        alert("writeCookie ! ")
        let date = new Date();
        date.setSeconds(expire);
        document.cookie = name + '=' + value + ';expire=' + date.toUTCString() + ';path=/';
      },
      issuedAccessToken: function (payload) {
        alert("issuedAccessToken ! ")
        const authEndpoint = this.auth_server_url + this.auth_endpoint;
        console.log("GO!");
        let params = "?response_type="+payload.responseType
          + "&client_id="+payload.clientId
          + "&redirect_uri="+payload.redirectUri
          + "&scope="+payload.scope;
        window.location.href = authEndpoint + params;
      }
    }
  }
</script>

<style scoped>
</style>
