<template>
  <div>
  	<div class="logo">
      <img src="@/assets/img/logo/logo.jpg"/>
    </div>
    <div class="input-content">
      <el-input placeholder="请输入手机号" prefix-icon="el-icon-mobile" v-model="phone"></el-input>
      <el-input placeholder="请输入密码" prefix-icon="el-icon-key" v-model="password" show-password></el-input>
      <el-button class="regbutton" @click="login">登录</el-button>
    </div>
    <div class="goreg">
      <span>没有账号，</span>
      <router-link v-bind:to="'/register'">去注册 ></router-link>
    </div>  
  </div>
</template>

<script>

import {getUserInfo} from '@/network/http'

export default {
  name: 'Login',
  data(){
    return {
      password: '',
      phone: '',
      userid: '',
      userName: '',
      registerTime: ''
    }
  },
  methods: {
    login(){
      //getUserInfo 通过手机号 获取用户id并存储在userID中使用
      getUserInfo(this.phone).then(res=>{
       if(res.password == this.password){
        console.log(res);
        //账号密码正确
        //存储手机号和id
        localStorage.setItem("phone",this.phone);
        this.userid = res.userId;
        localStorage.setItem("userID",this.userid);
        this.userName = res.userName;
        localStorage.setItem("userName",this.userName);
        //RegistrationTime
        this.registerTime = res.registrationTime;
        console.log(this.registerTime);
        localStorage.setItem("registerTime",this.registerTime);
        
        this.$message({
          message: '登录成功',
          type: 'success'
        });
        this.$router.push('/home');
       }else {
        alert('密码错误');
       }
      }).catch(err=>{
        console.log(err);
      })
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

  .goreg {
    width: 100%;
    display: flex;
    justify-content: center;
    position: relative;
    top: 330px;
  }
</style>
