<template>
  <nav class="navbar navbar-default">
    <div class="containerfluid">
      <div class="navbar-header">
        <button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle" />
        <router-link to="/" class="navbar-brand">JS Exchange</router-link>
      </div>
      <div id="navbar" class="navbar-collapse">
        <ul class="nav navbar-nav">
          <li><router-link to="/trade">거래</router-link></li>
          <li><router-link to="/quote">시세확인</router-link></li>
          <li><router-link to="/account">계좌관리</router-link></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#" @click="login">로그인</a></li>
          <li><router-link to="/logout">로그아웃</router-link></li>
          <li @click="checkToken">토큰확인</li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
  import {eventbus} from '../shared-component/Token.vue'
  export default {
    data: function() {
      return {
        token: '',
      }
    },
    mounted: function() {
      this.token = this.getAccessToken();
    },
    methods: {
      checkToken: function () {
        console.log(this.getAccessToken());
        debugger;
      },
      getAccessToken: function () {
        console.log("tttt")
        return eventbus.$emit('readAccessToken');
      },
      login: function () {
        let access_token = this.getAccessToken();
        debugger;
        alert(access_token);
        if(access_token == '') {
          eventbus.$emit('issuedAccessToken', {
            responseType: 'token',
            clientId: 'cli',
            redirectUri: '/auth/callback',
            scope: 'read'
          });
        }
      }
    }
  }
</script>

<style>
</style>
