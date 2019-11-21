<template>
  <div>
    <NavBar>
      <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>个人信息</p></div>
    </NavBar>
    <div>
      <ul class="list-group userinfo">
        <li class="list-group-item showcon">
          <p>用户ID </p> <span> {{userid}}</span>
          <p>手机号 </p> <span> {{phone}}</span>
          <p>昵称 </p> <span> {{userName}}</span>
          <p>注册时间 </p> <span> {{rtime}}</span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'

import {getUserInfo} from '@/network/http'


export default {
  name: 'Userinfo',
  data(){
  	return {
  		userinfo: [],
      registerTime: ''
  	}
  },
  computed: {
  	phone(){
      return localStorage.getItem("phone");
    },
    userid(){
      return localStorage.getItem("userID");
    },
    userName(){
      return localStorage.getItem("userName");
    },
    rtime(){
      return localStorage.getItem("registerTime");
    }
  },
  methods: {
  	backTo() {
      this.$router.go(-1);
    },
    getuserinfo(){
      getUserInfo(phone).then(res=>{
        console.log(res);
      })
    }
  },
  created(){
    
  },
  components: {
    NavBar
  }
}
</script>

<style scoped>
	.userinfo {
    width: 90%;
    margin: 0 auto;
  }

  .showcon {

  }

  .showcon p{
    width: 60%;
    color: #ffb123;
    display: inline-block;

  }

  .showcon span {
    position: relative;
    right: 38%;
  }
</style>
