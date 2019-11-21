<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">已完成订单</p></Header>
		
		<div class="finishorder">
      
      <el-table
        :data="finishorder"
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
        <!-- <el-table-column
          label="操作"
          prop="orderdao">
          <template scope="scope">
            <el-button type="danger" icon="el-icon-delete" size="small" circle @click="deleteorder(scope.row)"></el-button>
          </template>
        </el-table-column> -->
      </el-table>

    </div>


  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'
import {getFinishOrder} from '@/network/http'


import {getAllOrders} from '@/network/http'
export default {
  name: 'FinishOrder',
  data() {
  	return {
  	 finishorder:[
      //存储所有wacnehng订单信息
     ],
     activeName: '1'
    }
  },
  methods: {
    aa(){
      getAllOrders().then(res=>{
        console.log(res);
      })
    },
    getfinish(){

      getFinishOrder().then(res=>{
        console.log(res);
        this.finishorder = res;
      }).catch(err=>{
        console.log(err);
      })
    },
  	deleteorder(message){
      //删除订单信息
      this.$confirm('是否删除该订单?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let k = this.finishorder.indexOf(message);
        this.finishorder.splice(k,1);
        //向数据库传递，删除订单
        //.........数据库语句
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
    //开局动态获取finishorder
    this.getfinish();
    this.aa();
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.finishorder {
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
