<template>
  <div>
    <NavBar>
      <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>我的优惠券</p></div>
    </NavBar>
    <div class="panel panel-default">
      <div class="panel-body">
        <p>暂无优惠信息</p>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
export default {
  name: 'MyDiscount',
  data(){
  	return {
  		
  	}
  },
  computed: {
  	
  },
  methods: {
  	backTo() {
      this.$router.go(-1);
    }
  },
  components: {
    NavBar
  }
}
</script>

<style scoped>
  .panel {
    width: 90%;
    margin: 0 auto;
  }
	.panel p {
    text-align: center;
  }
</style>
