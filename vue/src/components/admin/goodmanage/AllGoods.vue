<template>
  <div>
  	<NavBar></NavBar>
		<Header><p slot="hname">所有商品信息</p></Header>
		
		<div class="allgoods">
      <div class="twobtns">
        <el-button type="warning" icon="el-icon-plus" size="small" circle @click="dialogFormVisible2 = true"></el-button>
        <el-button type="info" icon="el-icon-search" size="small" circle @click="dialogFormVisible3 = true"></el-button>
        <el-button type="success" icon="el-icon-refresh" size="small" circle @click="refreshinfo"></el-button>
      </div>
      
      <el-table :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)" height="460" border stripe>
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="商品名称">
                <span>{{ props.row.teaName }}</span>
              </el-form-item>
              <el-form-item label="商品 ID">
                <span>{{ props.row.teaId }}</span>
              </el-form-item>
              <el-form-item label="商品规格">
                <span>{{ props.row.cupType }}</span>
              </el-form-item>
              <el-form-item label="商品种类">
                <span>{{ props.row.attribute }}</span>
                <span>
                  <span v-if="!props.row.discount">未打折</span>
                  <span v-else>打折中</span>
                </span>
              </el-form-item>
              <el-form-item label="" class="edit-class">
                <el-button type="warning" icon="el-icon-edit" size="small" round @click="showedit(props.row)">编辑</el-button>
                <el-button type="danger" icon="el-icon-delete" size="small" round @click="deletegood(props.row)">删除</el-button>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          label="商品 ID"
          prop="teaId">
        </el-table-column>
        <el-table-column
          label="商品名称"
          prop="teaName">
        </el-table-column>
        <el-table-column
          label="商品价格"
          prop="price">
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



      <!-- 编辑框 -->
      <el-dialog title="编辑商品信息" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="商品编号" :label-width="formLabelWidth">
            <el-input v-model="nowgood.teaId" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="商品名称" :label-width="formLabelWidth">
            <el-input v-model="nowgood.teaName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品价格" :label-width="formLabelWidth">
            <el-input v-model="nowgood.price" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品规格" :label-width="formLabelWidth">
            <el-input v-model="nowgood.cupType" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品种类" :label-width="formLabelWidth">
            <el-input v-model="nowgood.attribute" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="是否打折" :label-width="formLabelWidth">
            <el-select v-model="nowgood.discount" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="editsubmit">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 上架商品 -->
      <el-dialog title="上架商品" :visible.sync="dialogFormVisible2">
      <el-form :model="form2">
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input v-model="newgood.teaname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
          <el-input v-model="newgood.price" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品规格" :label-width="formLabelWidth">
          <el-input v-model="newgood.cuptype" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品分类" :label-width="formLabelWidth">
          <el-input v-model="newgood.attribute" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否打折" :label-width="formLabelWidth">
          <el-select v-model="newgood.discount" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
        <el-button type="primary" @click="addsubmit">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 搜索商品 -->
    <el-dialog title="搜索商品" :visible.sync="dialogFormVisible3">
      <el-form :model="form2">
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input v-model="search" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible3 = false">取 消</el-button>
        <el-button type="primary" @click="searchsubmit">搜索</el-button>
      </div>
    </el-dialog>

		</div>
  </div>
</template>

<script>
import NavBar from '@/components/admin/common/NavBar'
import Header from '@/components/admin/common/Header'

import {getAllGoods} from '@/network/http'
import {editGoods} from '@/network/http'
import {deleteGoods} from '@/network/http'
import {addGoods} from '@/network/http'

export default {
  name: 'AllGoods',
  data() {
  	return {
  	  tableData: [

      ],
      currentPage: 1,//默认显示第一页
      pageSize:100,//默认每页显示10条
      totalNum: 1000, //总页数
      nowgood:'',
      nowgood1:'',
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
      formLabelWidth: '120px',

      //选择框与是否
      options:[
        {value: 'true',label: '是'},
        {value: 'false',label: '否'}
      ],
      
      finalgood:{
        "attribute": "",
        "cuptype": "",
        "discount": true,
        "photo": "",
        "price": 0,
        "teaid": "",
        "teaname": ""
      },
      //上架
      goodname: '',
      goodprice: '',
      newgood:{
        "attribute": "",
        "cuptype": "",
        "discount": true,
        "photo": "---",
        "price": 0,
        "teaid": "",
        "teaname": ""
      },
      dialogFormVisible2: false,
      form2: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      //搜索
      search: '',
      dialogFormVisible3: false,
      searchresult: [],
      allgoodsinfo: ''
    }
  },
  methods: {
    //获取所有奶茶信息
    getallgoods(){
      getAllGoods().then(res=>{
        this.tableData = res;
        console.log(res);
      });

      this.totalNum=this.tableData.length;
    },
    handleSizeChange(val) {
      //console.log(`每页 ${val} 条`);
      this.pageSize = val;    //动态改变
    },
    handleCurrentChange(val) {
      //console.log(`当前页: ${val}`);
      this.currentPage = val;    //动态改变
    },
  	//显示编辑框
    showedit(nowgood){
      this.nowgood = nowgood;
      this.nowgood1 = nowgood;
      //console.log(nowgood);
      this.dialogFormVisible = true;
    },
    editsubmit(){
      //确认修改
      //1.显示修改
      let k = this.tableData.indexOf(this.nowgood1);
      this.tableData[k] = this.nowgood;
      this.dialogFormVisible = false;
      console.log(this.nowgood);

      this.finalgood.attribute = this.nowgood.attribute;
      this.finalgood.cuptype = this.nowgood.cupType;
      this.finalgood.discount = this.nowgood.discount;
      this.finalgood.photo = this.nowgood.photo;
      this.finalgood.price = this.nowgood.price;
      this.finalgood.teaid = this.nowgood.teaId;
      this.finalgood.teaname = this.nowgood.teaName;
      
      //2.提交到数据库修改
      editGoods(this.finalgood);
      this.open1();
    },
    deletegood(nowgood){
      this.nowgood = nowgood;
      console.log(this.nowgood.teaId);
      
      //删除询问框
      this.$confirm('此操作将永久删除该内容, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        //确定删除，在显示中删除，然后从数据库中删除
        let k = this.tableData.indexOf(this.nowgood);
        this.tableData.splice(k, 1);
        //数据库删除
        deleteGoods(this.nowgood.teaId).then(res=>{

        }).catch(err=>{
          console.log(err);
        });
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
    },
    //提示消息
    open1() {
      this.$notify({
        title: '成功',
        message: '修改成功',
        type: 'success'
      });
    },
    addsubmit(){
      //确认新增商品
      this.dialogFormVisible2 = false;

      console.log(this.newgood);
      this.tableData.push(this.newgood);
      //向数据库添加
      addGoods(this.newgood);
      this.$notify({
        title: '成功',
        message: '新增成功',
        type: 'success'
      });
    },
    searchsubmit(){
      alert(this.search);
      this.dialogFormVisible3 = false;
      //搜索商品
      // 向数据库请求
      //.........数据库请求语句
      this.allgoodsinfo = this.tableData;
      //临时保存所有商品表
      for(let i = 0; i < this.tableData.length; i++) {
        if(this.search == this.tableData[i].name) {
          this.searchresult.push(this.tableData[i]);
        }
      }

      this.tableData = this.searchresult;
      
    },
    refreshinfo(){
      //刷新表格
      //重新向数据库获取tableDATA 先写成刷新整个页面，后期再改
      this.$router.go(0);
    }
  },
  created(){
    this.getallgoods();
    
  },
  components: {
  	NavBar,
  	Header
  },
  watch: {
    currentPage(oldV, newV) {
      console.log(oldV, newV);
      this.exchangeCurrentPage();
    }
  }
}
</script>

<style scoped>
	.allgoods {
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

  .edit-class {
    position: relative;
    left: 34%;
  }
  .el-icon-plus {

  }

  .twobtns {
    margin-bottom: 20px;
  }
</style>
