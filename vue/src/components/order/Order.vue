<template>
  <div>
    <NavBar>
  		<div slot="nav-text"><p>我的订单</p></div>
  	</NavBar>
    <div v-show="!haveorder">
      <div class="panel panel-default myorder">
        <div class="panel-body">
          <p class="noinfo">暂无订单信息</p>
        </div>
      </div>
      <div class="back">
        <el-button class="backbtn" @click="goshop">开始点单</el-button>
      </div>
    </div>

    <br>
    <div>
      <!-- 有订单信息 -->
      <div class="panel panel-default myorder" v-show="haveorder">
        <div class="panel-body">
          <div class="div1">
            <p class="otime">下单时间 {{order.time}}</p>
            <p class="making">制作中</p>
          </div>
          <div class="clear"> </div>
          <div class="div1">
            <p class="otime">取单时间 {{}}</p>
            <p class="making">取单号 {{}}</p>
          </div>
          <div class="div2">
            <p class="otime">￥</p>
            <button class="btn btn-warning" type="button">查看详情</button>
          </div>
        </div>
      </div>
    </div>

    <TabBar></TabBar>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import TabBar from '@/components/tabbar/TabBar'

import { getHistoryOrder } from '@/network/http'

export default {
  name: 'Order',
  data(){
    return {
      order:[],
      temp:[],
      id:'',
      haveorder: false
    }
  },
  methods: {
    goshop(){
      this.$router.push('/chooseshop');
    },
    getorderinfo(){
      this.id = localStorage.getItem("userID");
      getHistoryOrder(this.id).then(res=>{
        this.temp = res;
        for(let i = 0; i < this.temp.length; i++){
          if(this.temp[i].status == '未完成'){
            this.order.push(this.temp[i]);
            this.haveorder = true;
            break;
          }
        }
      }).catch(err=>{
        console.log(err);
      })
    }
  },
  computed: {
    phone(){
      return localStorage.getItem("phone");
    }
  },
  created(){
    this.getorderinfo();
  },
  components: {
  	NavBar,
    TabBar
  }
}
</script>

<style>
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
  .myorder {
    width: 90%;
    margin: 0 auto;
    margin-bottom: 20px;
  }
  .noinfo {
    width: 100%;
    text-align: center;
  }

  .otime {
    float: left;
  }
  .making {
    float: right;
    color: #ffb123;
  }

  .div1 {
    overflow: hidden;
  }
  
  .div2 p {
    font-size: 18px;
    color: #ffb123;
  }
  .div2 button {
    float: right;
  }
</style>
