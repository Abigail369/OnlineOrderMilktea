<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">优惠券信息</p></Header>
		
		<div class="shopdiscount">
			
		</div>

  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'
export default {
  name: 'ShopDiscount',
  data() {
  	return {
  	
    }
  },
  methods: {
  	
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.shopdiscount {
		width: 70%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-right: 5%;
		margin-top: 20px;
	}

</style>
