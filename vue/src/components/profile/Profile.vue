<template>
  <div>
    <NavBar>
  		<div slot="nav-text"><p>我的</p></div>
  	</NavBar>
  	<!-- <button v-on:click="getMsg">获取</button> -->
  	<div class="logo">
      <img src="@/assets/img/logo/logo1.jpg"/>
    </div>
    <div class="name">
      <p>username</p>
    </div>
  
    <div class="list">
      <ul class="list-group">
        <router-link v-bind:to="'/mydiscount'">
          <li class="list-group-item">
            <span class="el-icon-c-scale-to-original left"></span>
            <span class="center">我的优惠</span>
            <span class="el-icon-arrow-right right"></span>
          </li>
        </router-link>

        <router-link v-bind:to="'/history'">
          <li class="list-group-item">
            <span class="el-icon-notebook-1 left"></span>
            <span class="center">历史订单</span>
            <span class="el-icon-arrow-right right"></span>
          </li>
        </router-link>

        <router-link v-bind:to="'/userinfo'">
          <li class="list-group-item">
            <span class="el-icon-user left"></span>
            <span class="center">个人信息</span>
            <span class="el-icon-arrow-right right"></span>
          </li>
        </router-link>

        <router-link v-bind:to="'/howuse'">
          <li class="list-group-item">
            <span class="el-icon-warning-outline left"></span>
            <span class="center">平台须知</span>
            <span class="el-icon-arrow-right right"></span>
          </li>
        </router-link>
        <button type="button" class="btn btn-warning quit" @click="quit">退出登录</button>
      </ul>
    </div>
    <TabBar></TabBar>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import TabBar from '@/components/tabbar/TabBar'



export default {
  name: 'Profile',
  data(){
  	return {
  		user:{
        
      }
  	}
  },
  methods: {
  	getsserinfo(){
      // getUserInfo(phone).then(res=>{
      //   console.log(res);
      // })
    },
    quit(){
      localStorage.removeItem("phone");
      localStorage.removeItem("userID");
      this.$router.push('/login');
    }
  },
  created(){
    
  },
  computed: {
    phone(){
      //通过计算属性获取phone的值
      return localStorage.getItem("phone");
    }
  },
  components: {
  	NavBar,
    TabBar
  }
}
</script>

<style scoped>
	.logo {
    width: 100%;
    display: flex;
    justify-content: center;
    position: relative;
    top: 40px;
  }
  .logo img {
    width: 35%;
    height: 35%;
    border-radius: 50%;
  }
  .name {
    font-size: 20px;
    margin: 0 auto;
    text-align: center;
    position: relative;
    top: 40px;
  }
  
  ul {
    width: 90%;
    margin: 0 auto;
    position: relative;
    top: 50px;
  }
  .left {
    font-size: 20px;
    margin-right: 5px;
    color: #ffb872;
    font-weight: bold;
  }
  .center {
    color: #000;
  }
  .right {
    font-size: 20px;
    color: #ffb872;
    font-weight: bold;
    position: relative;
    left: 65%;
  }

  .quit {
    width: 50%;
    position: relative;
    left: 25%;
    margin-top: 60px;
  }
</style>
