<template>
  <div>
  	<div class="logo">
      <img src="@/assets/img/logo/logo.jpg"/>
    </div>
    <div class="input-content">
      <el-input placeholder="请输入昵称" prefix-icon="el-icon-user" v-model="user.userName"></el-input>
      <el-input placeholder="请输入密码" prefix-icon="el-icon-key" v-model="user.password" show-password></el-input>
      <el-input placeholder="请输入手机号" prefix-icon="el-icon-mobile" v-model="user.phone"></el-input>
      <el-button class="regbutton" @click="register">注册</el-button>
    </div>
  </div>
</template>

<script>
import { userRegister } from '@/network/http'

export default {
  name: 'Register',
  data(){
    return {
      user:{
        "userName": '',
        "password": '',
        "phone": '',

        "userId": '',
        "registrationTime": '0',
        "account": '0'
      }
    }
  },
  methods: {
    register(){
      if(this.user.userName!="" && this.user.password!="" && this.user.phone!="") {
        userRegister(this.user).then(res=>{
          if(res == 0){
            this.$message({
              message: '注册成功，跳转到登录页面',
              type: 'success'
            });
            this.$router.push('/login');
          } else {
            this.$message({
              message: '该用户已注册过',
              type: 'warning'
            });
          }
        })
        
      } else {
        this.$message('请输入所有项');
      }
    }
  },
  components: {
  	
  }
}
</script>

<style>
  .logo {
    width: 100%;
    display: flex;
    justify-content: center;
    position: relative;
    top: 100px;
  }
	.logo img {
    width: 40%;
    height: 40%;
    border-radius: 50%;
  }
  .input-content {
    width: 90%;
    margin: 0 auto;
    position: relative;
    top: 150px;
  }
  .input-content input {
    margin-bottom: 10px;
  }
  .regbutton {
    width: 60%;
    display: block;
    margin: 0 auto;
    background-color: #ff8c1a;
    color: #fff;
    font-weight: lighter;
    font-size: 17px;
  }
  .logbutton {
    width: 60%;
    display: block;
    margin: 0 auto;
    background-color: #ff8c1a;
    color: #fff;
    font-weight: lighter;
    font-size: 17px;
    position: relative;
    left: 17%;
  }

  .toast {
    width: 70px;
    position: relative;
    top: 220px;
    color: grey;
    font-weight: lighter;
    margin: 0 auto;
    background-color: rgba(230, 230, 230, 0.3);
  }
</style>
