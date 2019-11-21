<template>
  <div class="admin img1">
  	<div class="login">
      <img src="@/assets/admin/logo/logo1.png" alt="" class="loginlogo">
      <el-input placeholder="请输入账号" prefix-icon="el-icon-user" v-model="name">
      </el-input>
      <el-input placeholder="请输入密码" prefix-icon="el-icon-key" v-model="password" show-password></el-input>
      <el-button @click="check">登录</el-button>
    </div>
    <img src="@/assets/admin/logo/logo2.png" alt="" class="footerlogo">
  </div>
</template>

<script>

import {getAdminInfo} from '@/network/http'

export default {
  name: 'Admin',
  data() {
    return {
      name: '',
      password: ''
    }
  },
  methods: {
    check(){
      let correctPsw = "";
      getAdminInfo(this.name).then(res=>{
        correctPsw = res[0].apassword;
        if(this.name != "" && this.password != "" && this.password == correctPsw) {
          this.open1();
          this.$router.push('/index');
        } else {
          this.open2();
          this.name = "";
          this.password = "";
        }
      }).catch(err=>{
        
      })
    },
    open1() {
      this.$message({
        message: '登录成功',
        type: 'success'
      });
    },
    open2() {
      this.$message.error('账号或密码错误');
    }
  },
  components: {
  	
  }
}
</script>

<style scoped>
  .back {
    width: 100%;
    position: fixed;
  }
  .img1 {
    background-size: 100% 100%;
    background: url('~@/../static/images/bc2.jpg') center center no-repeat;
    height: 100%;
    position: fixed;
    width: 100%
  }
  
  .login {
    width: 30%;
    position: relative;
    top: 110px;
    left: 20%;
    text-align: center;
    padding: 20px;
    border-width: 5px;
    border-style: groove;
    border-color: #CCCCCC #EFEFF4;
  }
  .loginlogo {
    width: 30%;
    position: relative;
    bottom: 50px;
    right: 60%;
  }
  .el-input {
    margin-bottom: 10px;
  }

  .el-button {
    color: #ffb123;
    border-color: #ffb123;
    width: 30%;
  }

  .footerlogo {
    width: 12%;
    position: relative;
    left: 45%;
  }
</style>
