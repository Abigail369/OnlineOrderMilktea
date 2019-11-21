<template>
  <div>
  	<NavBar>
  		<div slot="nav-text"><p>支付成功</p></div>
  	</NavBar>
    
    <div class="panel panel-default orderdoing">
      <div class="panel-body">
        <p class="up">制作中</p>
        <div class="center">
          <div class="doingimg">
            <img src="@/assets/img/logo/doing.png" alt="">
          </div>
          <div class="doingtext">
            <span>取单号</span>
            <p>{{personnum}}</p>
          </div>
        </div>
        <p class="down">饮品现场制作中，请稍后。</p>
      </div>
    </div>
    
    <div class="panel panel-default">
      <div class="panel-body order-info">
        <ul class="list-group">
          <li class="list-group-item item-info" v-for="item in order">
            <span class="itemname">{{item.name}}</span>
            <span class="itemname">￥{{item.price}}</span>
            <span class="itemname">x{{item.count}}</span>
          </li>
          <li class="list-group-item item-money">
            <span class="itemone">
              <p>商品总价</p>
              <p>￥{{totalmoney}}</p>
            </span>
            <span class="itemone">
              <p>优惠</p>
              <p>￥{{discount}}</p>
            </span>
            <span class="finalmoney">
              <p>订单总额</p>
              <p>￥{{totalmoney}}</p>
            </span>
          </li>
        </ul>
      </div>
    </div>

    <div class="panel panel-default caddress">
      <div class="panel-body">
        <span>
          <p class="cleft">订单编号</p>
          <p class="cright">{{ordernum}}</p>
        </span>
        <span>
          <p class="cleft">下单时间</p>
          <p class="cright">2019年11月8日21:19:13</p>
        </span>
        <span>
          <p class="cleft">门店地址</p>
          <p class="cright">山东省淄博市张店区人民路与重庆路交汇处水晶街</p>
        </span>
      </div>
    </div>

    <div class="back">
      <el-button class="backbtn" @click="backtohome">返回首页</el-button>
    </div>

  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'

export default {
  name: 'PaySuccess',
  data() {
    return {
      order:[], //订单内容
      totalmoney: 0, //总金额
      timevalue: '',//取单时间
      remarks:'', //备注,
      ordernum: '7479070398248892',//订单编号
      personnum: '067',//取餐号
      discount: 0
    }
  },
  methods: {
    getOrder(){
      //接受上个页面传来的订单信息
      this.order = this.$route.query.order;
      this.totalmoney = this.$route.query.totalmoney;
      this.timevalue = this.$route.query.timevalue;
      this.remarks = this.$route.query.remarks;
    },
    backtohome(){
      this.$router.push('/home');
    }
  },
  created() {
    this.getOrder();
  },
  components: {
  	NavBar
  }
}
</script>

<style>
  .panel {
    width: 90%;
    margin: 0 auto;
    margin-bottom: 20px;
  }
  .orderdoing {
    display: flex;
    justify-content: center;
    text-align: center;
  }

  .up {
    color: grey;
  }
  .center {
    display: flex;
    justify-content: space-around;
    margin-bottom: 7px;
  }
  .doingimg img {
    width: 55%;
  }
  .doingtext {
    margin-top: 8px;
  }
  .doingtext span {
    color: grey;
  }
  .doingtext p {
    color: #ffb123;
    font-size: 20px;
    font-weight: bold;
  }
  .down {
    color: #ffb123;
  }
  .item-info {
    display: flex;
    justify-content: space-between;
  }
  .item-info span {
    
  }
  .itemname {
    color: #101;
    font-size: 14px;
  }
  .order-info li {
    border: 0;
  }
  .item-money span {
    display: flex;
    justify-content: space-between;
  }
  .itemone {
    font-size: 12px;
    font-weight: lighter;
    color: grey;
  }
  .finalmoney {
    color: #000;
    font-size: 20px;
  }
  
  .caddress span {
    color: grey;
    font-size: 14px;
  }
  .cleft {
    float: left;
    margin-right: 6%;
  }

  .back {
    clear: both;
    width: 100%;
    display: flex;
    justify-content: center;
  }
  .back button{
    background-color: #ffb123;
    width: 80%;
    color: #fff;
    font-weight: lighter;
  }
</style>
