<template>
  <div>
    <div class="tabBar">
  		<TabBaritem path="/home">
  			<img src="@/assets/img/gift.svg" alt="" slot="item-img">
  			<img src="@/assets/img/gift1.svg" alt="" slot="item-active-img" class="active-img">
  			<div slot="item-text">首页</div>
  		</TabBaritem>
  		<TabBaritem path="/order">
  			<img src="@/assets/img/od.svg" alt="" slot="item-img">
  			<img src="@/assets/img/od1.svg" alt="" slot="item-active-img" class="active-img">
  			<div slot="item-text">订单</div>
  		</TabBaritem>
  		<TabBaritem path="/profile">
  			<img src="@/assets/img/my.svg" alt="" slot="item-img">
  			<img src="@/assets/img/my1.svg" alt="" slot="item-active-img" class="active-img">
  			<div slot="item-text">我的</div>
  		</TabBaritem>
    </div>
  </div>
</template>

<script>
import TabBaritem from './TabBaritem'
export default {
  name: 'TabBar',
  components:{
  	TabBaritem
  }
}
</script>

<style>
	@import "../../assets/css/base.css";
	.tabBar {
		display: flex;
		justify-content: space-around;
		position: fixed;
		left: 0;
		right: 0;
		bottom: 0;
		height: 49px;
		font-size: 16px;
    box-shadow: 0px 1px 1px rgba(100,100,100,0.1);
    background-color: #fff;
	}

	img {
		margin-bottom: 3px;
		height: 24px;
		height: 24px;
	}
  .active-img {
    margin-top: -5px;
    height: 32px;
    width: 32px;
  }
</style>
