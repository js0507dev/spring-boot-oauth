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
	</ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
}
</script>

<style>
</style>
