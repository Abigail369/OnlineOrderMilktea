<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">待处理订单</p></Header>
		
		<div class="waitingorder">
      
      <el-table
        :data="waitingorderinfo"
        style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="下单时间">
                <span>{{ props.row.time }}</span>
              </el-form-item>
              <el-form-item label="完成时间">
                <span>{{ props.row.endTime }}</span>
              </el-form-item>
              <el-form-item label="取单号">
                <span>{{ props.row.waiterId }}</span>
              </el-form-item>
              <el-form-item label="订单金额">
                <span>￥{{ props.row.allprice }}</span>
              </el-form-item>
              <el-form-item label="包含商品">
                <div>
                  <p v-for="item in props.row.auxxes">
                    {{item.teaName}}{{item.cupType}} / {{item.number}} {{item.charge}} {{item.sugar}} {{item.temperature}} / ￥{{item.price}}
                  </p>
                </div>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          label="订单编号"
          prop="orderId">
        </el-table-column>
        <el-table-column
          label="订单状态"
          prop="status">

          <template scope="scope">
            <span v-if="scope.row.status == '完成'" style="color: green">{{ scope.row.status }}</span>
            <span v-else style="color: red">{{ scope.row.status }}</span>
          </template>

        </el-table-column>
        <el-table-column
          label="用户编号"
          prop="userId">
        </el-table-column>
        <el-table-column
          label="操作"
          prop="orderdao">
          <template scope="scope">
            <el-button type="danger" icon="el-icon-delete" size="small" circle @click="deleteorder(scope.row)"></el-button>
            <el-button v-if="scope.row.status != '完成' && scope.row.status != '取消' " type="success" icon="el-icon-check" size="small" circle @click="dealorder(scope.row)"></el-button>
            <el-button v-if="scope.row.status != '完成'  && scope.row.status != '取消' " type="primary" icon="el-icon-edit" size="small" @click="editwaitinginfo(scope.row)" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
      
        
      <!-- 未完成订单的编辑框 -->
      <el-dialog
        title="订单信息"
        :visible.sync="dialogVisible"
        width="50%" class="editwaiting">
        <el-input
          prefix-icon="el-icon-paperclip"
          v-model="selectinfo.oid" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-time
"
          v-model="selectinfo.otime" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-pie-chart"
          v-model="selectinfo.ostatus" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-coffee-cup"
          v-model="selectinfo.oinfo.name" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-edit-outline"
          v-model="selectinfo.oinfo.count" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-search"
          v-model="selectinfo.oinfo.price" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-watermelon"
          v-model="selectinfo.oinfo.whatfood" disabled size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-sunrise
"
          v-model="selectinfo.oinfo.whatwarm" size="small">
        </el-input>
        <el-input
          prefix-icon="el-icon-coffee"
          v-model="selectinfo.oinfo.whatcandy" size="small">
        </el-input>

        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitEditWait()">确 定</el-button>
        </span>
      </el-dialog>

    </div>
    
   
  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'

import {getWaitingOrder} from '@/network/http'
import {completeOrder} from '@/network/http'
import {cancelOrder} from '@/network/http'

export default {
  name: 'AllOrder',
  data() {
  	return {
  	 waitingorderinfo:[
      //存储待处理订单信息
     ],
     activeName: '1',
     dialogVisible: false,
     selectinfo:{
      "oid":"",
      "otime":"",
      "ostatus":"",
      "oinfo":{
        "name":"",
        "count":"",
        "price":"",
        "whatfood":[],
        "whatwarm":"",
        "whatcandy":""
      }
     }
    }
  },
  methods: {
    getwaiting(){
      getWaitingOrder().then(res=>{
        console.log(res);
        this.waitingorderinfo = res;
      }).catch(err=>{
        console.log(err);
      })
    },
  	dealorder(message){
      //点击对号，完成该订单，将这个order传过来，修改order的ostatus
      this.$confirm('该订单是否已完成?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        message.status = '完成';
        //向数据库传递，修改状态
        completeOrder(message.orderId).then(res=>{

        }).catch(err=>{
          console.log(err);
        });
        this.$notify({
          title: '成功',
          message: '操作成功',
          type: 'success'
        })
      }).catch(() => {
        this.$notify({
          title: '取消',
          message: '操作取消',
          type: 'warning'
        });
      });
    },
    deleteorder(message){
      //删除订单信息
      this.$confirm('是否取消该订单?(该订单记录不会被删除)', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let k = this.waitingorderinfo.indexOf(message);
        //this.waitingorderinfo.splice(k,1);
        this.waitingorderinfo[k].status = "取消";
        //向数据库传递，quxiao订单
        cancelOrder(message.orderId).catch(err=>{
          console.log(err);
        });
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success'
        })
      }).catch(() => {
        this.$notify({
          title: '取消',
          message: '操作取消',
          type: 'warning'
        });
      });
    },
    editwaitinginfo(message){
      //准备修改未完成的订单
      this.selectinfo = message;
      this.dialogVisible = true;
    },
    submitEditWait(){
      //提交对未完成订单的修改
      this.$confirm('确定修改吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        //替换selectinfo到显示，再提交到数据库
        let k = -1;
        for(let i = 0; i < this.waitingorderinfo; i++) {
          if(this.waitingorderinfo[i].oid == this.selectinfo.oid) {
            k = i;
          }
        }
        this.waitingorderinfo[k] = this.selectinfo;
        //.........数据库语句
        //..................
        this.dialogVisible = false;
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success'
        })
      }).catch(() => {
        this.dialogVisible = false;
        this.$notify({
          title: '取消',
          message: '操作取消',
          type: 'warning'
        });
      });
    }
  },
  created(){
    this.getwaiting();
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.waitingorder {
		width: 70%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-right: 5%;
		margin-top: 20px;
	}

  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }

  .editwaiting .el-input{
    margin-bottom: 10px;
  }
</style>
