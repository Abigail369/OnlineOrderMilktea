<template>
  <div>
  	<div class="rollpic">
      <el-carousel :interval="3000" type="card" height="200px">
        <el-carousel-item v-for="item in imgbox" :key="item.id">
          <img :src="item.src" alt="" class="imgbox">
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>

export default {
  name: 'IndexSwipe',
  data() {
    return {
      imgbox: [
        {
          id: 1,
          src: '~@/../static/images/bc1.jpg'
        },
        {
          id: 2,
          src: '~@/../static/images/bc3.jpg'
        },
        {
          id: 3,
          src: '~@/../static/images/bc4.jpg'
        },
        {
          id: 4,
          src: '~@/../static/images/bc5.jpg'
        }
      ]
    }
  },
  components: {
  	
  }
}
</script>

<style scoped>
	/*轮播图*/
  .rollpic {
    width: 75%;
    position: relative;
    float: right;
    margin-right: 25px;
    margin-top: 20px;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .imgbox {
    width: 100%;
  }
</style>
