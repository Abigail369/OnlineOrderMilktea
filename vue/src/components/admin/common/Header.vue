<template>
  <div class="header">
  	<div class="abc">
  		<el-breadcrumb separator="/" class="contents">
		  <el-breadcrumb-item :to="{ path: '/index' }"><span class="el-icon-arrow-left iconback"></span> 首页 </el-breadcrumb-item>
		  <el-breadcrumb-item>
	  		<slot name="hname">
	  			<!-- <span>活动管理</span> -->
	  		</slot>
			</el-breadcrumb-item>
		</el-breadcrumb>
	
  	</div>

  </div>
</template>

<script>

export default {
  name: 'Header',
  components: {
  	
  }
}
</script>

<style scoped>
	.header {
		width: 100%;
	}
	.abc {
		width: 100%;
	}
	.contents {
		width: 80%;
		float: right;
		position: relative;
		bottom: 900px;
		margin-top: 9px;
	}
	.iconback {
		margin-left: 10px;
	}
</style>
