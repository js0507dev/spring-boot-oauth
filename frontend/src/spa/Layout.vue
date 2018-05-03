<template>
	<div id="app-layout">
		<my-header></my-header>
		<router-view></router-view>
	</div>
</template>

<script>
import MyHeader from '../shared-components/my-header.vue'

export default {
	components: {
		MyHeader,
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>
