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
	  <li v-if="!user"><router-link to="/login">로그인</router-link></li>
	  <li v-if="!user"><router-link to="/member/signup">회원가입</router-link></li>
    <li v-if="user"><router-link to="/logout">로그아웃</router-link></li>
    <li><a href="#" @click="siteTokenCheck">TEST</a></li>
	</ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  mounted: function() {
    this.siteTokenCheck();
  },
  methods: {
    siteTokenCheck: function () {
      let fragment = location.hash.replace('#', '');
      if(fragment == '' && this.$store.getters.siteAccessToken == '') {
        this.$store.commit('makeAccessToken', {
          responseType: 'token',
          clientId: 'cli',
          redirectUri: '/',
          scope: 'read'
        });
      } else {
        let arrFragment = fragment.split('&');
        let token = arrFragment[0].substring(arrFragment[0].indexOf('=')+1, arrFragment[0].length);
        let token_type = arrFragment[1].substring(arrFragment[1].indexOf('=')+1, arrFragment[1].length);
        let expire = arrFragment[2].substring(arrFragment[2].indexOf('=')+1, arrFragment[2].length);
        this.$store.state.site_access_token = token;
        this.$store.state.site_access_token_type = token_type;
        this.$store.state.site_access_token_expire = expire * 1;
        console.log("frag=\'"+fragment+"\'");
        console.log("token=\'"+this.$store.state.site_access_token+"\'");
        console.log("token_type=\'"+this.$store.state.site_access_token_type+"\'");
        console.log("token_expire=\'"+this.$store.state.site_access_token_expire+"\'");
      }
    }
  }
}
</script>

<style>
</style>
