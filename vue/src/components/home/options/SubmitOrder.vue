<template>
  <div>
  	<NavBar>
     <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>提交订单</p></div>
    </NavBar> 

    <ul class="list-group getime">
      <li class="list-group-item">
        <p>取单时间</p>
        <el-time-select
          v-model="timevalue"
          :picker-options="{
            start: '10:00',
            step: '00:30',
            end: '21:00'
          }"
          placeholder="选择时间" class="timepicker">
        </el-time-select>
      </li>
      <li class="list-group-item">
        <p>取单地址</p>
        <span class="address">山东省淄博市张店区人民路与重庆路交汇处水晶街项目F商铺水晶街铺</span>
      </li>
    </ul>
   
    <ul class="list-group order-info">
      <p>订单详情</p>
      <li v-for="item in order" class="list-group-item listyle">
        <div>
          <span class="el-icon-coffee-cup"></span>
          <p class="item-name">{{item.teaName}}{{item.cupType}}</p>
          <div class="item-add">
            <p>{{item.charge}} {{item.temperature}} {{item.sugar}}</p>
          </div>
        </div>
        <p class="item-price">￥{{item.price}}</p>
        <p class="item-count">x{{item.count}}</p>
      </li>
      <p class="order-money">￥{{totalmoney}}</p>
    </ul>
    
    <!-- 优惠券 -->
    <span class="el-icon-s-ticket mydiscount"> 查看我的优惠券</span>
    
    <!-- 备注 -->
    <el-input
      type="text"
      placeholder="请输入备注"
      v-model="remarks"
      maxlength="30"
      show-word-limit
      class="remarks"
    >
    </el-input>

    <el-button type="warning" plain icon="el-icon-finished" class="topay" @click="gotopay">去支付</el-button>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import {SubmitShopCar} from '@/network/http'
export default {
  name: 'Home',
  data(){
    return {
      order:[], //订单内容
      totalmoney: 0, //总金额
      timevalue: '',//取单时间
      remarks:'', //备注
      auxiliarylist:'',
      finalorder:{

      }
    }
  },
  methods: {
    backTo() {
      this.$router.back();
    },
    getOrder(){
      //接受上个页面传来的订单信息
      this.order = this.$route.query.goodscar;
      this.totalmoney = this.$route.query.totalmoney;

      console.log(this.order);
    },
    getfinal(){
      this.auxiliarylist = this.order;
      console.log("kksioshcio");
      console.log(this.auxiliarylist);

      this.finalorder.allprice = this.totalmoney;
      this.finalorder.endtime = "---";
      this.finalorder.orderid = "";
      this.finalorder.status = "未完成"
      this.finalorder.time = 0;
      this.finalorder.userid = localStorage.getItem("userID");
      this.finalorder.waiterid = "001";
      this.finalorder.auxiliarylist = this.auxiliarylist;
      console.log(this.finalorder);

      SubmitShopCar(this.finalorder);
    },
    gotopay(){
      //去支付
      //将订单信息传给数据库，包括
      //{用户id，订单包含内容(奶茶id，奶茶名，奶茶数量，奶茶价格，小料，温度，甜度),取单时间，订单备注}

      this.$router.push({
        path: '/paysuccess',
        query: {
          order: this.order,
          totalmoney: this.totalmoney,
          timevalue: this.timevalue,
          remarks: this.remarks
        }
      })
    }
  },
  updated(){
    
  },
  created(){
    this.getOrder();
    
    this.getfinal();
  },
  components: {
  	NavBar
  }
}
</script>

<style>
  body {
    margin: 5px;
  }
  /*导航栏*/
  .chos-nav p {
    display: inline-block;
  }
  .chos-nav span {
    display: inline-block;
    margin-left: 5px;
    font-size: 20px;
  }
  
  /*取单*/
  .getime li {

  }
  .getime p {
    display: inline-block;
    font-size: 16px;

  }
  .timepicker {
    position: relative;
    left: 17%;
  }
  .address {
    display: inline-block;
    font-size: 14px;
    font-weight: lighter;
    color: grey;
    width: 70%;
    position: relative;
    left: 13%;
    top: 10px;
  }

  /*订单详情*/
  .listyle {
    display: flex;
    justify-content: space-around;
    height: 70px;
  }
  .el-icon-coffee-cup {
    position: relative;
    right: 40%;
    color: #ff9933;
    font-size: 17px;
  }
  .item-name {
    position: relative;
    bottom: 20px;
  }
  .item-add {
    position: relative;
    bottom: 20px;
    display: inline-block;
  }
  .order-money {
    float: right;
    margin-top: 5px;
    margin-right: 32px;
    font-size: 17px;
    font-weight: bold;
  }

  /*优惠券*/
  .mydiscount {
    height: 90%;
    font-size: 17px;
    margin-bottom: 30px;
    margin-left: 20px;
    color: #ff9933;
  }

  /*备注*/
  .remarks {
    margin-bottom: 100px;
  }

  .topay {
    width: 100%;
    position: fixed;
    bottom: 0;
    font-size: 20px;
  }
</style>
