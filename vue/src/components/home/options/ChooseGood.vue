<template>
  <div>
  	<div class="nav-bar-posi">
     <NavBar>
       <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>CoCo</p></div>
      </NavBar> 
    </div>
    
    <el-tabs :tab-position="tabPosition">
      <el-tab-pane :label="index" v-for="(index,sort) in goodsort" class="navbaritem">
        <div v-for="good in goods" v-show="good.attribute == index" class="goodcards">
          <div class="imgdiv">
            <img src="@/assets/img/goods/tea1.jpg" alt="" class="good-img">
          </div>
          <div class="infodiv">
            <p class="good-name">{{good.teaName}}</p>
            <p class="typecup">{{good.cupType}}</p>
            <p class="good-price"><span>￥{{good.price}}</span>起</p>
          </div>
          <div class="daodiv">
            <span class="glyphicon glyphicon-minus-sign removegood" @click="alert(good)"></span>
            <span class="nowcount">{{good.count}}</span>
            <span class="glyphicon glyphicon-plus-sign" @click="add(good)" data-toggle="modal" data-target="#myModal2"></span>
          </div>
        </div>
      </el-tab-pane>
    </el-tabs>

    <!-- 加小料模态框 -->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
              &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
              {{nowgood.teaName}}
            </h4>
          </div>
          <div class="modal-body addoptions">
            <div>
              <p>加料</p>
              <el-radio-group v-model="charge">
                <el-radio-button :label="city.chargeName" v-for="city in addfood"></el-radio-button>
              </el-radio-group>
            </div>
            <div>
              <p>温度</p>
              <el-radio-group v-model="temperature">
                <el-radio-button :label="city" v-for="city in warm"></el-radio-button>
              </el-radio-group>
            </div>
            <div>
              <p>糖度</p>
              <el-radio-group v-model="sugar">
                <el-radio-button :label="city" v-for="city in candy"></el-radio-button>
              </el-radio-group>
            </div>
          </div>
          <div class="modal-footer">
            <el-button class="addfoodtocar" @click="addtoMyar">
              加入购物车
            </el-button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div>
    
    <!-- 购物车 -->
    <div class="showthecar">
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h5 class="modal-title" id="myModalLabel">
                已选商品
              </h5>
            </div>
            <div class="modal-body">
              <div v-for="item in goodscar" class="item-info">
                <div>
                  <p class="item-name">{{item.teaName}}</p>
                  <p class="item-add">{{item.charge.toString()}} {{item.temperature}} {{item.sugar}}</p>
                </div>
                <p class="item-price">￥{{item.price}}</p>
                
                <div class="item-edit">
                  <span class="glyphicon glyphicon-minus-sign removeitem"  @click="remove(item)"></span>
                  <span class="nowcount">{{item.count}}</span>
                  <span class="glyphicon glyphicon-plus-sign additem" @click="addsame(item)"></span>
                </div>
                
              </div>
            </div>
            <div class="modal-footer">
              <span class="glyphicon glyphicon-trash removeall"></span>
              <span class="removetext" @click="removeallevent">清除全部</span>
              <span v-if="totalmoney!=0" class="allmoney">￥{{totalmoney}}</span>
              <!-- <span @click="submitorder">去结算 ></span> -->
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal -->
      </div>
    </div>

    <div class="shopcar">
      <div class="caritems" data-toggle="modal" data-target="#myModal">
        <span class="glyphicon glyphicon-shopping-cart span-nogoods" v-if="totalmoney==0">
        </span>
        <span class="glyphicon glyphicon-shopping-cart span-havegoods" v-if="totalmoney!=0">
        </span>
        <p class="p-nogoods span-nogoods" v-if="totalmoney==0">  购物车是空的</p>
        <p class="p-havegoods" v-if="totalmoney!=0">￥{{totalmoney}}</p>
      </div>
      <div class="gotopay">
        <span class="span-nogoods" v-if="totalmoney==0">去结算 ></span>
        <span class="span-havegoods" v-if="totalmoney!=0" @click="submitorder">去结算 ></span>
      </div>
    </div>
    

    <!-- 提示框 -->
    <div class="toast" v-show="toastShow">
      {{toastText}}
    </div>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import Toast from '@/components/common/Toast'

import { getGoodsort } from '@/network/http'
import { getAllGoods } from '@/network/http'
import { getAddinfos } from '@/network/http'


export default {
  name: 'ChooseGood',
  data() {
    return {
      goodsort:[
        //奶茶分类
      ],
      goods:[
        //所有奶茶
      ],
      goodscar:[],
      //购物车存储的信息 总价 商品名称，商品价格，商品数量,小料，温度，甜度
      totalmoney: 0,
      toastShow: false,
      toastText: '',
      ifshowthecar: false,
      tabPosition: 'left',
      addfood:[
        
      ],//小料 getaddinfos函数获取
      charge:[],//选择的小料，根据用户选择获取
      warm:['热','温','常规冰','多冰','少冰','去冰'],//温度
      temperature:'',
      candy:['常规','半糖','微糖','无糖'],//甜度
      sugar:'',
      nowgood:''
    }
  },
  methods: {
    getgoodsort(){
      //获取所有的分类名，渲染左侧的列表
      getGoodsort().then(res=>{
        this.goodsort = res;
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
    },
    getallgoods(){
      //获取所有奶茶信息
      getAllGoods().then(res=>{
        this.goods = res;
      })
    },
    getaddinfos(){
      //获取小料信息
      getAddinfos().then(res=>{
        this.addfood = res;
        console.log(res);
      })
    },
    backTo() {
      this.$router.go(-1);
    },
    alert(good) {
      if(good.count != 0) {
        this.toast("请在购物车修改");
        return;
      }
      if(good.count == 0) {
        this.toast("不能再减少了");
        return;
      }
    },
    remove(item){
      if(item.count == 1) {
        //只有一份
        let id = this.goodscar.indexOf(item);
        //alert(id);
        this.totalmoney -= item.price;
        this.goodscar.splice(id, 1);

        //显示也要减1
        for(let i = 0; i < this.goods.length; i++) {
          if(this.goods[i].teaName == item.teaName) {
            this.goods[i].count--;
          }
        }
        return;
      }
      //不止一份 只减数量
      let id = this.goodscar.indexOf(item);
      this.totalmoney -= item.price;
      this.goodscar[id].count--;
      for(let i = 0; i < this.goods.length; i++) {
        if(this.goods[i].teaName == item.teaName) {
          this.goods[i].count--;
        }
      }
    },
    add(good){
      this.nowgood = good;
      //现在被选中的商品,弹出小料的模态框
      if(good.count == 10) {
        this.toast("每份限购10份");
        return;
      }
    },
    addsame(item){
      //在购物车中添加同样的商品只需数量加一 钱数加1
      let id = this.goodscar.indexOf(item);

      //alert(id);
      this.goodscar[id].count++;
      this.totalmoney += item.price;

      //显示也要加一
      for(let i = 0; i < this.goods.length; i++) {
        if(item.teaName == this.goods[i].teaName) {
          this.goods[i].count++;
        }
      }
    },
    addtoMyar() {
      if(this.nowgood.count == 10) {
        this.toast("每份限购10份");
        return;
      }
      let temp = {};
      temp.teaId = this.nowgood.teaId;
      temp.teaName = this.nowgood.teaName;
      temp.cupType = this.nowgood.cupType;

      let addmoney = 0;
      for(let i = 0; i < this.addfood.length; i++){
        if(this.charge == this.addfood[i].chargeName){
          addmoney = this.addfood[i].price;
        }
      }

      temp.price =  addmoney + this.nowgood.price;
      temp.count = 1;
      temp.charge  = this.charge;
      temp.temperature = this.temperature;
      temp.sugar = this.sugar;
      temp.id = "";
      temp.number = temp.count;
      temp.orderId = "";

      this.totalmoney += temp.price;

      //显示数量也加一
      for(let i = 0; i < this.goods.length; i++) {
        if(temp.teaName == this.goods[i].teaName) {
          this.goods[i].count++;
        }
      }

      
      let k = 0;
      let id = -1;
      for(let i = 0; i < this.goodscar.length; i++) {
        if(temp.teaName == this.goodscar[i].teaName) {
          //商品名字一样，同时加的小料、温度、甜度都一样
          if(temp.charge == this.goodscar[i].charge && temp.temperature == this.goodscar[i].temperature && temp.sugar == this.goodscar[i].sugar) {
            k = 1;
            id = i;
          }
        }
      }
      if(k == 1) {
        //全都一样，只加个数
        this.goodscar[id].count++;
      }
      else {
        //有一项不一样，就是一个新的物品
        this.goodscar.push(temp);
      }

      this.toast("加购成功");
    },
    removeallevent(){
      this.goodscar = [];
      for(let i = 0; i < this.goods.length; i++) {
        this.goods[i].count = 0;
      }
      this.totalmoney = 0;
    },
    toast (str) {
      let v = this
      v.toastText = str
      v.toastShow = true
      setTimeout(function(){
        v.toastShow = false
      }, 1500)
    },
    submitorder(){
      this.$router.push({
        path: '/submitorder',
        query: {
          goodscar: this.goodscar,
          totalmoney: this.totalmoney
        }
      })
    },
    clone(obj) { 
      //深拷贝
      if(obj === null) return null 
      if(typeof obj !== 'object') return obj;
      if(obj.constructor===Date) return new Date(obj); 
      if(obj.constructor === RegExp) return new RegExp(obj);
      var newObj = new obj.constructor ();  //保持继承链
      for (var key in obj) {
        if (obj.hasOwnProperty(key)) {   //不遍历其原型链上的属性
          var val = obj[key];
            newObj[key] = typeof val === 'object' ? arguments.callee(val) : val; // 使用arguments.callee解除与函数名的耦合
        }
      }  
      return newObj;  
    },
  },
  created() {
   this.getgoodsort();
   this.getallgoods();
   this.getaddinfos();
  },
  components: {
  	NavBar,
    Toast
  }
}
</script>

<style scoped>
  /*导航栏*/
  .chos-nav p {
    display: inline-block;
  }
  .chos-nav span {
    display: inline-block;
    margin-left: 5px;
    font-size: 20px;
  }
  
  
  /*每个商品卡片*/
  .goodcards {
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin-bottom: 5px;
  }
  .imgdiv {
    width: 30%;
  }
  .good-img {
    width: 100%;
  }
  .infodiv {
    width: 30%;
  }
  .good-name {
    font-size: 15px;
    font-weight: lighter;
    position: relative;
    top: 8%;
    left: 20%;
  }
  .typecup {
    position: relative;
    left: 20%;
    font-weight: lighter;
  }
  .good-price {
    color: #ffb663;
    font-size: 10px;
    font-weight: bold;
    position: relative;
    top: 1%;
    left: 20%;
  }
  .good-price span {
    font-size: 16px;
  }
  .daodiv {
    width: 40%;
    position: relative;
    left: 16%;
    top: 55px;
    font-size: 16px;
    color: #ffb872;
  }
  .removegood {
    color: #ccc;
  }
  .nowcount {
    color: #555;
  }

  /*购物车*/
  .shopcar {
    display: flex;
    position: fixed;
    bottom: 0;
    background-color: white;
    width: 100%;
    height: 50px;
    font-size: 17px;
    /*color: #ffb872;*/
    box-shadow: 10px 0 0 0 grey;
  }
  .glyphicon-shopping-cart {
    font-size: 22px;
    margin-left: 4px;
    margin-right: 5px;
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
    margin-top: 16px;
    margin-right: 10px;
  }
  .span-nogoods {
    color: grey;
  }
  .span-havegoods {
    color: #ffb872;
  }

  /*提示框*/
  .toast {
    position: fixed;
    z-index: 2000;
    left: 50%;
    top:45%;
    transition:all .5s;
    -webkit-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -ms-transform: translateX(-50%) translateY(-50%);
    -o-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    text-align: center;
    border-radius: 5px;
    color:#FFF;
    background: rgba(17, 17, 17, 0.7);
    height: 45px;
    line-height: 45px;
    padding: 0 15px;
    max-width: 150px;
  }
   
   /*弹出的购物车物品*/
  .showthecar {
    background-color: yellow;
    width: 100%;
    position: relative;
    bottom: 70px;
  }
  .modal-dialog {
    width: 101%;
    position: fixed;
    margin-left: -1px;
    bottom: -10px;
  }
  .item-info {
    width: 100%;
    display: flex;
    justify-content: space-between;
  }
  .item-name {
    width: 100%;
  }
  .item-add {
    font-size: 10px;
    font-weight: lighter;
    color: #000;
  }
  .item-price {
    width: 30%;
  }
  .item-edit {
    font-size: 17px;
  }
  .removeitem {
    color: #b3b3b3;
  }
  .additem {
    color: #ffb872;
  }
  .removeall {
    float: left;
    margin-top: 2px;
    margin-left: 1px;
    margin-right: 3px;
  }
  .removetext {
    float: left;
  }
  .allmoney {
    margin-right: 25%;
    font-weight: bold;
  }

  /*加小料框*/
  .addfoodtocar {
    background-color: #ff6600;
    color: #fff;
    font-weight: lighter;
    width: 100%;
  }
  .addoptions {
    
  }
</style>
