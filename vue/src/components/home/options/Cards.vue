<template>
  <div class="cards">
    <div class="shop-info" @click="showAllView">
      <span class="glyphicon glyphicon-map-marker shop-name">
        <slot name="shopName"></slot>
      </span>
      <span class="shop-dist">
        <slot name="shopDist"></slot>
      </span>
    </div>
    
    <div class="shop-local" @click="showAllView">
      <slot name="shopLocation"></slot>
    </div>

    <div v-show="ifshow">
      <div class="buynow">
        <div class="radio">
          <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked> 现在，支付成功后在<span class="getmethod">店内</span>取单
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">稍后，预约稍晚时间<span class="getmethod">到店</span>取单
          </label>
          <span class="shopmessage">门店详情 ></span>
          <!-- <span class="glyphicon glyphicon-heart-empty starshop" @click="starShop"></span> -->
          <slot name="ifstar" @click="starShop"></slot>
        </div>
      </div>

      <div class="choose-div">
        <button type="button" class="btn btn-default btn-md btn-choose" @click="chooseGoods">选择饮品</button>
      </div>
    </div>

  </div>
</template>

<script>

export default {
  name: 'Cards',
  data(){
    return {
      ifshow: false
    }
  },
  methods: {
    starShop(){

    },
    showAllView(){
      this.ifshow = !this.ifshow;
    },
    chooseGoods(){
      this.$router.push('/choosegood');
    }
  }
}
</script>

<style>
  .cards {
    margin-top: 30px;
    box-shadow: 0px 1px 0px 0px rgba(100,100,100,0.1);
  }
  .choose-div {
    width: 100%;
    display: flex;
    justify-content: center;
  }
	.btn-choose {
    width: 75%;
    background: #ffb872;
    border: 0;
    color: white;
    font-size: 16px;
    margin-bottom: 10px;
  }
  
  .shop-info {
    width: 90%;
    margin: 0 auto;
  }
  .shop-info span {
    display: inline-block;
  }
  .shop-name {
    float: left;
  }
  .shop-dist {
    float: right;
  }
  .shop-local {
    clear: both;
    margin: 0 auto;
    width: 90%;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    color: #000;
    font-weight: lighter;
    position: relative;
    top: 2px;
  }

  .buynow {
    width: 90%;
    margin: 0 auto;
    color: #808080;
    font-weight: lighter;
  }
  .getmethod {
    color: #ffb872;
  }
  .shopmessage {
    position: relative;
    bottom: 30px;
    left: 50px;
    color: #ffb872;
  }
  .starshop {
    position: relative;
    font-size: 19px;
  }
  .radio span {
    color: #ffb872;
  }
</style>
