<template>
  <div class="shopinfo">
  	<NavBar></NavBar>
		<Header><p slot="hname">店铺信息</p></Header>
		
		<div class="shopcontent">
			<ul class="list-group">
	    	<li class="list-group-item">
	    		<span class="leftspan">店铺名称 </span>
	    		<p> {{shopname}}</p>
	    	</li>
	    	<li class="list-group-item">
	    		<span class="leftspan">营业时间 </span>
	    		<p> {{startTime}}-{{endTime}}</p>
	    	</li>
	    	<li class="list-group-item">
	    		<span class="leftspan">店铺描述 </span>
	    		<p> {{shopdisc}}</p>
	    	</li>
			</ul>
			<!-- <img src="http://d.lanrentuku.com/down/png/1712/24drinks-lifestyle/drinks-lifestyle-tea-enjoy-colored.png" alt="" class="footerimg"> -->
			<el-button class="btn" @click="dialogFormVisible = true"><span class="el-icon-edit"></span>修改</el-button>
			<el-dialog title="编辑店铺信息" :visible.sync="dialogFormVisible">
			  <el-form :model="form">
			    <el-form-item label="店铺名称" :label-width="formLabelWidth">
			      <el-input v-model="shopname" autocomplete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="营业时间" :label-width="formLabelWidth">
			      <el-time-select
					    placeholder="起始时间"
					    v-model="startTime"
					    :picker-options="{
					      start: '10:00',
					      step: '00:30',
					      end: '20:00'
					    }">
					  </el-time-select>
					  <el-time-select
					    placeholder="结束时间"
					    v-model="endTime"
					    :picker-options="{
					      start: '10:00',
					      step: '00:30',
					      end: '21:30',
					      minTime: startTime
					    }">
					  </el-time-select>
			    </el-form-item>
			    <el-form-item label="店铺描述" :label-width="formLabelWidth">
			      <el-input v-model="shopdisc" autocomplete="off"></el-input>
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

import {getShopInfo} from '@/network/http'
import {editShopInfo} from '@/network/http'

export default {
  name: 'ShopInfo',
  data() {
  	return {
  		shopname:'CoCo奶茶',
  		shopdisc: '哥谭市火绒路',
  		startTime: '10:00',
      endTime: '21:00',

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
  	editsubmit(){
  		this.dialogFormVisible = false;
  		//上传到数据库
  	},
  	getshopinfo(){
  		getShopInfo().then(res=>{
  			console.log(res);
  		}).catch(err=>{
  			console.log(err);
  		})
  	}
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.shopcontent {
		width: 70%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-right: 5%;
		margin-top: 20px;
	}

	.shopcontent li > span{
		display: inline-block;
	}
	.shopcontent li > p{
		display: inline-block;
	}
	.btn {
		float: right;
	}

	.footerimg {
		width: 20%;
		position: relative;
		left: 80%;
		top: 200px;
	}

	.leftspan {
		font-weight: bold;
		margin-right: 10px;
		color: #ff751a;
	}
</style>
