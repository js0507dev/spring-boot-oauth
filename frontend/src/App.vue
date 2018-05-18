<template>
  <div id="app">
    <Token></Token>
    <MyHeader></MyHeader>
    <router-view/>
  </div>
</template>

<script>
import MyHeader from './spa/MyHeader.vue'
import Token from './shared-component/Token.vue'

export default {
  name: 'App',
  components: {
    MyHeader,
    Token
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 15px;
}
</style>
