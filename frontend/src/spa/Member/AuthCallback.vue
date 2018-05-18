<template>
  <div><a hrref="/">test</a></div>
</template>

<script>
import {eventbus} from '../../shared-component/Token.vue'

export default {
  mounted: function() {
    let accessToken = this.getAccessToken();
    let tokenType = this.getAccessTokenType();
    let expire = this.getAccessTokenExpire();
    let tokenValue = tokenType + ' ' + accessToken;
    eventbus.$emit('writeCookie', this.getTokenCookieName(), tokenValue, expire);

    this.$router.push('/');
  },
  methods: {
    getParameterByName: function (name) {
      let match = RegExp('[#&]' + name + '=([^&]*)').exec(window.location.hash);
      console.log("test[" + name + "] = " + (match && decodeURIComponent(match[1].replace(/\+/g, ' '))));
      return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
    },
    getAccessToken: function () {
      return this.getParameterByName('access_token');
    },
    getAccessTokenType: function () {
      return this.getParameterByName('token_type');
    },
    getAccessTokenExpire: function () {
      return this.getParameterByName('expire');
    }
  }
}
</script>

<style>
</style>
