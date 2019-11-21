<template>
  <div>
    <NavBar></NavBar>
    <Header><p slot="hname">额外信息管理</p></Header>
    
    <div class="extrainfo">
      <div class="showcard">
        <img src="@/assets/img/logo/extra1.png" alt="" class="imgclass">
        <el-card class="box-card">
          <div slot="header" class="clearfix title">
            <span class="titlename">小料</span>
            <span class="el-icon-plus" @click="dialogVisible = true"></span>
          </div>
          <div class="text item" v-for="food in foodsinfo">
            <span class="itemname">{{food.chargeName}}</span>
            <span class="itemprice">￥{{food.price}}</span>
            <span>
              <span class="el-icon-edit" @click="editfood(food)"> </span>
              <span class="el-icon-delete" @click="removefood(food)">  </span>
            </span>
          </div>
        </el-card>
      </div>

      <div class="showcard">
        <img src="@/assets/img/logo/extra3.png" alt="" class="imgclass">
        <el-card class="box-card">
          <div slot="header" class="clearfix title">
            <span class="titlename">可选温度</span>
          </div>
          <div class="text item">
            <span>热 / 温 / 常规冰 / 多冰 / 少冰 / 去冰 </span>
          </div>
        </el-card>
      </div>

      <div class="showcard">
        <img src="@/assets/img/logo/extra2.png" alt="" class="imgclass">
        <el-card class="box-card">
          <div slot="header" class="clearfix title">
            <span class="titlename">可选甜度</span>
          </div>
          <div class="text item">
            <span>常规糖 / 半糖 / 微糖 / 无糖 </span>
          </div>
        </el-card>
      </div>
    
      <!-- 增加小料框 -->
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"
        >
        <el-input
          placeholder="请输入小料名称"
          prefix-icon="el-icon-orange"
          v-model="addinfo.chargeName">
        </el-input>
        <el-input
          placeholder="请输入价格"
          prefix-icon="el-icon-coin"
          v-model="addinfo.price">
        </el-input>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitAdd">确 定</el-button>
        </span>
      </el-dialog>

      <!-- 编辑小料框 -->
      <el-dialog
        title="编辑"
        :visible.sync="dialogVisible1"
        width="30%"
        >
        <el-input
          prefix-icon="el-icon-star-off"
          v-model="selectinfo.chargeId" disabled>
        </el-input>
        <el-input
          prefix-icon="el-icon-orange"
          v-model="selectinfo.chargeName">
        </el-input>
        <el-input
          prefix-icon="el-icon-coin"
          v-model="selectinfo.price">
        </el-input>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="submitEdit">确 定</el-button>
        </span>
      </el-dialog>

    </div>

  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'

import {extraInfos} from '@/network/http'
import {addFoodInfos} from '@/network/http'
import {removeInfos} from '@/network/http'

export default {
  name: 'ExtraInfo',
  data() {
    return {
      foodsinfo:[
        
      ],
      dialogVisible: false,
      dialogVisible1: false,
      selectinfo:"",
      addinfo:{
        "chargeId": "",
        "chargeName": "",
        "price": 0
      }
    }
  },
  methods:{
    getextrainfo(){
      extraInfos().then(res=>{
        //console.log(res);
        this.foodsinfo = res;
      }).catch(err=>{
        console.log(err);
      })
    },
    removefood(food){
      this.$confirm('确定删除吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          //删除小料
          let k = this.foodsinfo.indexOf(food);
          this.foodsinfo.splice(k,1);
          //上传到数据库。
          removeInfos(food.chargeId);
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
    },
    submitAdd(){
      this.foodsinfo.push(this.addinfo);
      //添加新增信息到数据库
      addFoodInfos(this.addinfo);
      this.dialogVisible = false;
    },
    editfood(food){
      this.selectinfo = food;
      console.log(this.selectinfo);
      this.dialogVisible1 = true;
    },
    submitEdit(){
      this.dialogVisible1 = false;
      //提交对小料的修改到数据库
      addFoodInfos(this.selectinfo);
    }
  },
  created(){
    this.getextrainfo();
  },
  components: {
    NavBar,
    Header
  }
}
</script>

<style scoped>
  .extrainfo {
    width: 70%;
    float: right;
    position: relative;
    bottom: 900px;
    margin-right: 5%;
    margin-top: 20px;
  }
  
  .showcard{
    width: 60%;
    margin-left: 60px;
    margin-top: -50px;
    margin-bottom: 10px;
  }
  .imgclass {
    width: 14%;
    position: relative;
    top: 60px;
    left: -8%;
  }
  .text {
    font-size: 14px;
  }
  .item {
    padding: 5px 0;
    overflow: hidden;
    display: flex;
    justify-content: space-between;
  }
  .box-card {
    width: 100%;
  }
  .title {
    position: relative;
    left: 80%;
  }
  .titlename {
    margin-right: 40px;
  }

  .itemname {
    
  }
  .itemprice {
   
  }

  .footerimg {
    width: 40%;
    position: relative;
    top: -200px;
    left: 60%;
  }

  .el-icon-edit {
    margin-right: 10px;
    color: #0088cc;
  }
  .el-icon-delete {
    color: #ff5b33;
  }
  
  .el-input {
    margin-bottom: 10px;
  }
</style>
