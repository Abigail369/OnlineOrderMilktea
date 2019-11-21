<template>
  <div>
  	<NavBar>
  		<div slot="nav-text"><p>CoCo 都可</p></div>
  	</NavBar>
    <Swipe></Swipe>
    <Options></Options>
    <TabBar></TabBar>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import Swipe from '@/components/home/Swipe'
import Options from '@/components/home/Options'
import TabBar from '@/components/tabbar/TabBar'
export default {
  name: 'Home',
  components: {
  	NavBar,
    Swipe,
    Options,
    TabBar
  }
}
</script>

<style>
	
</style>
