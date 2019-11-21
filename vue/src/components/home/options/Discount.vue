<template>
  <div>
  	<NavBar>
  		<div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>我的优惠券</p></div>
  	</NavBar>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'

export default {
  name: 'Discount',
  components: {
  	NavBar
  }
}
</script>

<style>
	
</style>
