<template>
  <div>
    <div @click="itemclick">
    	<slot v-if="!isActive" name="item-img"></slot>
    	<slot v-else name="item-active-img"></slot>
    	<div v-bind:class="{active: isActive}"><slot name="item-text"></slot></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TabBaritem',
  props:{
  	path: String
  },
  data(){
  	return {
  		
  	}
  },
  computed: {
  	isActive() {
  		return (this.$route.path.indexOf(this.path) != -1);
  	}
  },
  methods: {
  	itemclick(){
  		if(this.$route.path.indexOf(this.path) != -1) {
  			return;
  		}
  		this.$router.push(this.path);
  	}
  }
}
</script>

<style scoped>
	.active {
		color: #ffb872;
	}
</style>
