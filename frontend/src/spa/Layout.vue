<template>
  <div id="layout">
    <my-header></my-header>
    <router-view></router-view>
  </div>
</template>

<script>
import MyHeader from '../shared-components/my-header.vue'

export default {
  components: {
    MyHeader
  }
}
</script>
