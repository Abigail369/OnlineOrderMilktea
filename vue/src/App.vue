<template>
  <div id="app">
  	
  		<router-view></router-view>
    <!-- <TabBar></TabBar> -->
  </div>
</template>

<script>
import TabBar from '@/components/tabbar/TabBar'
export default {
  name: 'App',
  components: {
  	TabBar
  }
}
</script>

<style>
	
</style>
