<template>
  <div>
  	<div class="navbars">
  		<el-menu
	      default-active="2"
	      class="el-menu-vertical-demo"
	      
	      background-color="#ffa54d"
	      text-color="#fff"
	      active-text-color="#663300">
	      <el-submenu index="1">
	        <template slot="title">
	          <i class="el-icon-location"></i>
	          <span>店铺管理</span>
	        </template>
	        <el-menu-item-group>
	          <!-- <template slot="title">分组一</template> -->
	          <router-link to="/shopinfo">
	          	<el-menu-item index="1-1">店铺信息</el-menu-item>
	        	</router-link>
	        	<router-link to="/salesman">
	          	<el-menu-item index="1-2">店员信息</el-menu-item>
	          </router-link>
	          <!-- <router-link to="/shopdiscount">
	          	<el-menu-item index="1-3">优惠券</el-menu-item>
	          </router-link> -->
	        </el-menu-item-group>
      	</el-submenu>

	      <el-submenu index="2">
	        <template slot="title">
	          <i class="el-icon-location"></i>
	          <span>商品管理</span>
	        </template>
	        <el-submenu index="2-1">
	          <template slot="title">商品信息管理</template>
	          <!-- <el-menu-item index="2-1-1">上架商品</el-menu-item>
	          <el-menu-item index="2-1-2">下架商品</el-menu-item> -->
	          <router-link to="/allgoods">
		          <el-menu-item index="2-1-3">查询编辑商品</el-menu-item>
		        </router-link>
	        </el-submenu>
	        <el-submenu index="2-2">
	          <template slot="title">商品规格管理</template>
	          <router-link to="/extrainfo">
		          <el-menu-item index="2-2-1">商品分类</el-menu-item>
		        </router-link>
		       	<router-link to="/extrainfo">
		          <el-menu-item index="2-2-2">温度档位</el-menu-item>
		        </router-link>
		        <router-link to="/extrainfo">
		          <el-menu-item index="2-2-3">甜度档位</el-menu-item>
		        </router-link>
	        </el-submenu>
	      </el-submenu>

	      <el-submenu index="3">
	        <template slot="title">
	          <i class="el-icon-location"></i>
	          <span>订单管理</span>
	        </template>
	        <router-link to="/allorder">
	        	<el-menu-item index="3-1">所有订单</el-menu-item>
	        </router-link>
	        <router-link to="/waitingorder">
	        	<el-menu-item index="3-2">待处理订单</el-menu-item>
	        </router-link>
	        <router-link to="/finishorder">
	        	<el-menu-item index="3-3">已完成订单</el-menu-item>
	        </router-link>
	      </el-submenu>

	      <el-submenu index="4">
	        <template slot="title">
	          <i class="el-icon-location"></i>
	          <span>售出统计</span>
	        </template>
	        <router-link to="/todaysell">
		        <el-menu-item index="4-1">今日统计</el-menu-item>
		      </router-link>
	         <!-- <el-menu-item index="4-2">更多统计</el-menu-item> -->
	      </el-submenu>

    	</el-menu>
  	</div>
  </div>
</template>

<script>

export default {
  name: 'NavBar',
  data(){
  	return {
  		isCollapse: true,
  	}
  },
  components: {
  	
  }
}
</script>

<style scoped>
	.navbars {
		width: 20%;
		background-color: #ffa54d;
		height: 900px;
  }
  .navbars i {
  	color: #fff;
  }

</style>
