<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">今日营业额</p></Header>
		
		<div class="todaysell">
      <el-table :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)" 
                height="360" 
                border 
                stripe
      >
        <el-table-column prop="id" label="商品编号">
        </el-table-column>
        <el-table-column prop="name" label="商品名称">
        </el-table-column>
        <el-table-column prop="sell" label="售出数量">
        </el-table-column>

      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[1, 3, 5, 8]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalNum">
      </el-pagination>



      <hr>
      <div class="total">
        <span class="el-icon-data-board"></span>
        <p>今日营业额: {{totalmoney}}</p>
      </div>
      <div class="total">
        <span class="el-icon-medal-1"></span>
        <p>今日最佳: {{thebest[1]}} / {{thebest[0]}} 杯</p>
      </div>
    </div>


  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'
export default {
  name: 'TodaySell',
  data() {
  	return {
  	  tableData: [
        {id:1,name:"珍珠奶茶",sell:20,price:12},
        {id:2,name:"布丁奶茶",sell:30,price:12},
        {id:3,name:"椰果奶茶",sell:11,price:12},
        {id:4,name:"红豆奶茶",sell:40,price:12},
        {id:5,name:"黑糖奶茶",sell:8,price:12},
        {id:1,name:"珍珠奶茶",sell:20,price:12},
        {id:2,name:"布丁奶茶",sell:30,price:12},
        {id:3,name:"椰果奶茶",sell:11,price:12},
        {id:4,name:"红豆奶茶",sell:40,price:12},
        {id:5,name:"黑糖奶茶",sell:8,price:12}
      ], //数据
      currentPage: 1,//默认显示第一页
      pageSize:10,//默认每页显示10条
      totalNum: 1000 //总页数
    }
  },
  methods: {
    handleSizeChange(val) {
      //console.log(`每页 ${val} 条`);
      this.pageSize = val;    //动态改变
    },
    handleCurrentChange(val) {
      //console.log(`当前页: ${val}`);
      this.currentPage = val;    //动态改变
    },
    
  },
  created(){
    this.totalNum=this.tableData.length;
  },
  computed: {
    totalmoney(){
      let money = 0;
      for(let i = 0; i < this.tableData.length; i++) {
        money += this.tableData[i].price*this.tableData[i].sell;
      }
      return money;
    },
    thebest(){
      let best = 0;
      let name = "";
      for(let i = 0; i < this.tableData.length; i++) {
        if(best <= this.tableData[i].sell) {
          best = this.tableData[i].sell;
          name = this.tableData[i].name;
        }
      }
      return [best,name];
    }
  },

  watch: {
    currentPage(oldV, newV) {
      console.log(oldV, newV);
      this.exchangeCurrentPage();
    }
  },
  components: {
  	NavBar,
  	Header
  }
}
</script>

<style scoped>
	.todaysell {
		width: 70%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-right: 5%;
		margin-top: 20px;
	}
  
  .total {
    margin-top: 40px;
    margin-bottom: -33px;
  }
  .total span {
    display: inline;
    color: #ffb123;
    font-size: 20px;
  }
  .total p {
    display: inline;
    font-size: 16px;
    font-weight: bold;
  }
</style>
