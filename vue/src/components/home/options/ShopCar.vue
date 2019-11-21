<template>
  <div class="shopcar">
    <div class="caritems">
      <span class="glyphicon glyphicon-shopping-cart">
        <p class="p-nogoods"> 购物车是空的</p>
        <p class="p-havegoods"> {{totalmoney}}</p>
      </span>
    </div>
    <div class="gotopay">
      <span class="span-nogoods">去结算 ></span>
      <span class="span-havegoods">去结算 ></span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ShopCar',
  data() {
    return {
      shopcar:[],
      totalmoney:100
    }
  },
  methods:{

  }
}
</script>

<style>
  .shopcar {
    display: flex;
    position: fixed;
    bottom: 0;
    background-color: white;
    width: 100%;
    height: 40px;
    font-size: 17px;
    /*color: #ffb872;*/
  }
	.caritems {
    width: 80%;
    margin-top: 10px;
    margin-left: 10px;
  }
  .caritems p {
    display: inline-block;
  }
  .gotopay {
    width: 20%;
    margin-top: 10px;
    margin-right: 10px;
  }
  .span-nogoods {
    color: grey;
  }
  .span-havegoods {
    color: #ffb872;
  }
</style>
