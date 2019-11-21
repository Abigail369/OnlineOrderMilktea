<template>
  <div>
    <NavBar>
      <div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>平台须知</p></div>
    </NavBar>
    平台须知界面，填写使用说明的内容。
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
export default {
  name: 'Howuse',
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

<style>
	
</style>
