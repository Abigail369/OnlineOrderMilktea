<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">所有订单</p></Header>
		
		<div class="allorder">
      
      <el-table
        :data="allorderinfo"
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
            <el-button type="danger" icon="el-icon-delete" size="small" circle @click="deleteorder(scope.row)" v-if="scope.row.status != '完成' && scope.row.status != '取消' "></el-button>
            <el-button v-if="scope.row.status != '完成' && scope.row.status != '取消' " type="success" icon="el-icon-check" size="small" circle @click="dealorder(scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>

    </div>


  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'

import {getAllOrders} from '@/network/http'
import {completeOrder} from '@/network/http'
import {cancelOrder} from '@/network/http'

export default {
  name: 'AllOrder',
  data() {
  	return {
  	 allorderinfo:[
      //存储所有订单信息
     ],
     activeName: '1'
    }
  },
  methods: {
    getallorder(){
      getAllOrders().then(res=>{
        console.log(res);
        this.allorderinfo = res;
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
        })
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
      //取消未完成的订单信息
      this.$confirm('是否取消该订单?(该订单记录不会被删除)', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let k = this.allorderinfo.indexOf(message);
        this.allorderinfo[k].status = "取消";
        //this.allorderinfo.splice(k,1);
        //向数据库传递，取消订单
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
    }
  },
  created(){
    this.getallorder();
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.allorder {
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


</style>
