<template>
  <div>
    <NavBar>
      <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>历史订单</p></div>
    </NavBar>
    <div>
    <ul class="list-group hisorder">
      <li class="list-group-item" v-for="order in historyinfo">
        <div>
          <p>订单编号 {{order.orderId}}</p>
          <p>下单时间 {{order.time}}</p>
          <p>订单金额 {{order.allprice}}</p>
          <p>包含商品</p>
          <div v-for="item in order.auxxes">
            <span>商品名称：{{item.teaName}}{{item.cupType}}</span>
            <span>数量：{{item.number}}杯</span>
            <span>价格：￥{{item.price}}</span>
            <div>
              <span>商品详情</span>
              <span>{{item.charge}} / {{item.temperature}} / {{item.sugar}}</span>
            </div>
          </div>
        </div>
      </li>
    </ul>
    </div>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'

import {getHistoryOrder} from '@/network/http'

export default {
  name: 'History',
  data(){
  	return {
  		historyinfo:[],
      id: ''
  	}
  },
  computed: {
  	
  },
  methods: {
  	backTo() {
      this.$router.go(-1);
    },
    gethistoryorder(){
      this.id = localStorage.getItem("userID");
      
      getHistoryOrder(this.id).then(res=>{
        this.historyinfo = res;
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
    }
  },
  created(){
    this.gethistoryorder();
  },
  components: {
    NavBar
  }
}
</script>

<style scoped>
	.hisorder {
    width: 90%;
    margin: 0 auto;
  }
</style>
