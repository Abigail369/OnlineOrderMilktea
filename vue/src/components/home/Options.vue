<template>
  <div>
    <div class="options">
    	<div class="orderto">
        <button type="button" class="btn btn-default btn-lg btn-up" @click="chooseShop">自助点单</button>

        <button type="button" class="btn-center btn-list">
          <span class="glyphicon glyphicon-time list-left"></span>
          <p>限时拼团</p>
          <span class="glyphicon glyphicon-chevron-right list-right"></span>
        </button>

        <button type="button" class="btn-down btn-list">
          <span class="glyphicon glyphicon-camera list-left"></span>
          <p>在线影院</p>
          <span class="glyphicon glyphicon-chevron-right list-right"></span>
        </button>
      </div>
    </div>
    <img src="@/assets/img/ad.png" class="advertisement">
  </div>

</template>

<script>
export default {
  name: 'Options',
  methods: {
    chooseShop(){
      this.$router.push('/chooseshop');
    }
  }
}
</script>

<style>
  .options {
    display: flex;
    justify-content: center;
    position: relative;
    bottom: 90px;
  }
	.orderto {
    width: 60%;
  }
  .orderto .btn-up {
    width: 100%;
    border-style:solid;
    border-width:1px;
    border-color:#ffb872;
    color: #ffb872;
    display: inline-block;
    margin-bottom: 15px;
  }
  .list-option span {
    margin: 10px;
  }

  .btn-list {
    background: transparent;
    border: none;
    width: 130%;
    position: relative;
    right: 16%;
    margin-bottom: 10px;
    box-shadow: 0px 1px 1px rgba(100,100,100,0.1);
  }
  .btn-list span {
    color: #ffb872;
    font-size: 20px;
  }
  .btn-list p {
    display: inline;
    position: relative;
    right: 29%;
    font-size: 15px;
    font-weight: lighter;
  }
  .list-left {
    position: relative;
    right: 30%;
  }
  .list-right {
    position: relative;
    left: 30%;
  }
  .advertisement {
    width: 100%;
    height: 100%;
    position: relative;
    bottom: 80px;
  }
</style>
