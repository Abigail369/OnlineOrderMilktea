<template>
  <div class="cards">
  	<div class="good-img">
  		<!-- <img src="@/assets/img/goods/tea1.jpg" alt=""> -->
  		<slot name="good-img"></slot>
  	</div>
		<div class="good-info">
			<!-- <p>珍珠奶茶/大杯</p> -->
			<slot name="good-name"></slot>
			<!-- <span>￥11.0<p>起</p></span> -->
			<slot name="good-price"></slot>
			<!-- <span class="glyphicon glyphicon-minus-sign addtocar"></span>
			<span class="glyphicon glyphicon-plus-sign addtocar" @click="addgood"></span> -->
		</div>
  </div>
</template>

<script>
export default {
  name: 'GoodCard',
  data(){
  	return {
  		
  	}
  },
  methods: {
  	addgood(){
  		
  	}
  }
}
</script>

<style>
	.cards {
		width: 100%;
		/*background-color: red;*/
		margin-bottom: 20px;
	}
	.good-img img{
		width: 18%;
		display: inline-block;
		position: relative;
		left: 27%;
	}
	.good-info {
		/*background-color: yellow;*/
		float: right;
		position: relative;
		right: 27%;
		bottom: 60px;
	}
	.good-info span p {
		display: inline-block;
	}
	.good-info span{
		color: #ffb872;
	}
	.addtocar {
		position: relative;
		left: 90%;
		font-size: 20px;
	}
</style>
