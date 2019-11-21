<template>
  <div>
  	<div class="toast" v-show="toastShow">
	  	{{toastText}}
		</div>
  </div>
</template>

<script>

export default {
  name: 'Toast',
  props:["message"],
  data() {
    return {
      toastShow: false,
      toastText: ''
    }
	},
	methods: {
	  toast (str) {
	    let v = this
	    v.toastText = str
	    v.toastShow = true
	    setTimeout(function(){
	      v.toastShow = false
	    }, 1500)
	  },
	  ddd(){
	  	this.toast(this.message);
	  }
	}
}
</script>

<style>
	.toast {
      position: fixed;
      z-index: 2000;
      left: 50%;
      top:45%;
      transition:all .5s;
      -webkit-transform: translateX(-50%) translateY(-50%);
         -moz-transform: translateX(-50%) translateY(-50%);
          -ms-transform: translateX(-50%) translateY(-50%);
           -o-transform: translateX(-50%) translateY(-50%);
              transform: translateX(-50%) translateY(-50%);
      text-align: center;
      border-radius: 5px;
      color:#FFF;
      background: rgba(17, 17, 17, 0.7);
      height: 45px;
      line-height: 45px;
      padding: 0 15px;
      max-width: 150px;
  }

</style>
