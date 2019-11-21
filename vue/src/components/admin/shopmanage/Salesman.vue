<template>
  <div class="shopinfo">
  	<NavBar></NavBar>
		<Header><p slot="hname">店员信息</p></Header>
		
		<div class="salesman">
      <el-table
        :data="salesinfo"
        style="width: 100%">
        <el-table-column
          prop="waiterid"
          label="编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="waiterName"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" circle @click="edit(scope.row)"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="deleteinfo(scope.row)"></el-button>
          </template>
          
        </el-table-column>
      </el-table>

			<el-dialog title="编辑店员信息" :visible.sync="dialogFormVisible">
			  <el-form :model="form">
			    <el-form-item label="编号" :label-width="formLabelWidth">
			      <el-input v-model="sid" autocomplete="off" disabled></el-input>
			    </el-form-item>
			    <el-form-item label="姓名" :label-width="formLabelWidth">
			      <el-input v-model="sname" autocomplete="off"></el-input>
			    </el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer">
			    <el-button @click="dialogFormVisible = false">取 消</el-button>
			    <el-button type="primary" @click="editsubmit">确 定</el-button>
			  </div>
			</el-dialog>
		</div>

  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'

import {getWaiterInfo} from '@/network/http'
import {deleteWaiter} from '@/network/http'
import {editWaiter} from '@/network/http'

export default {
  name: 'Salesman',
  data() {
  	return {
  		salesinfo:[
  			
  		],
  		sid:'',
  		sname:'',
      temp:'',

  		dialogFormVisible: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
  	}
  },
  methods: {
    getwaiterinfo(){
      getWaiterInfo().then(res=>{
        //console.log(res);
        this.salesinfo = res;
      }).catch(err=>{
        console.log(err);
      })
    },
  	edit(sale){
  		this.dialogFormVisible = true;
  		this.sid = sale.waiterid;
  		this.sname = sale.waiterName;

      this.temp = sale;
  	},
  	editsubmit(){
  		this.dialogFormVisible = false;

      let k = this.salesinfo.indexOf(this.temp);
      //!!!!!!!!此处到dai修改


      //
  		//this.sid + this.sname 上传到数据库

      editWaiter(this.sid, this.sname).then(res=>{
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })

      this.getwaiterinfo();

  		this.open1();
  	},
  	//提示消息
  	open1() {
      this.$notify({
        title: '成功',
        message: '修改成功',
        type: 'success'
      });
    },
    //删除选定的内容
    deleteinfo(sale) {
    	//删除询问框
      this.$confirm('此操作将永久删除该内容, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
      	//确定删除，在显示中删除，然后从数据库中删除
      	let k = this.salesinfo.indexOf(sale);
      	this.salesinfo.splice(k, 1);
      	//........数据库删除
        deleteWaiter(sale.waiterid);
        this.$notify({
          title: '成功',
	        message: '删除成功',
	        type: 'success'
        });
      }).catch(() => {
      	this.$notify.error({
          title: '取消',
          message: '已取消删除'
        });        
      });
    }
  },
  created(){
    this.getwaiterinfo();
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.salesman {
		width: 70%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-right: 5%;
		margin-top: 20px;
	}

	/*.el-button {
		font-size: 7px;
	}
	.el-button > icon {
		font-size: 10px;
	}*/
</style>
