<template>
  <div>
  	<NavBar>
  		<div slot="nav-text" class="chos-nav"><span @click="backTo" class="glyphicon glyphicon-chevron-left">  </span><p>定位</p></div>
  	</NavBar>
    <div class="cards-item">
      <ul id="myTab" class="nav nav-tabs">
        <li class="active">
          <a href="#location" data-toggle="tab">定位附近门店 <span class="glyphicon glyphicon-search"></span></a>
        </li>
        <li>
          <a href="#star" data-toggle="tab">收藏的门店 <span class="glyphicon glyphicon-star-empty"></span></a>
        </li>
      </ul>

      <div id="myTabContent" class="tab-content">
        
        <div class="tab-pane fade in active" id="location">
          <Cards>
           <span slot="shopName">CoCo都可(水晶街店)</span>
           <span slot="shopDist">2.1KM</span>
           <p slot="shopLocation">山东省淄博市张店区人民路与重庆路交汇处水晶街山东理工大学校区</p>
           <span class="glyphicon glyphicon-heart-empty starshop" slot="ifstar"></span>
          </Cards>

          <Cards>
            <span slot="shopName">CoCo都可(小商品城店)</span>
            <span slot="shopDist">2.1KM</span>
            <p slot="shopLocation">山东省淄博市张店区华光路义乌小商品城</p>
            <span class="glyphicon glyphicon-heart-empty starshop" slot="ifstar"></span>
          </Cards>

          <Cards>
            <span slot="shopName">CoCo都可(小商品城店)</span>
            <span slot="shopDist">2.1KM</span>
            <p slot="shopLocation">山东省淄博市张店区华光路义乌小商品城</p>
            <span class="glyphicon glyphicon-heart-empty starshop" slot="ifstar"></span>
          </Cards>

          <Cards>
            <span slot="shopName">CoCo都可(小商品城店)</span>
            <span slot="shopDist">2.1KM</span>
            <p slot="shopLocation">山东省淄博市张店区华光路义乌小商品城</p>
            <span class="glyphicon glyphicon-heart-empty starshop" slot="ifstar"></span>
          </Cards>

          <Cards>
            <span slot="shopName">CoCo都可(小商品城店)</span>
            <span slot="shopDist">2.1KM</span>
            <p slot="shopLocation">山东省淄博市张店区华光路义乌小商品城</p>
            <span class="glyphicon glyphicon-heart-empty starshop" slot="ifstar"></span>
          </Cards>
        </div>

        <div class="tab-pane fade" id="star">
          <div>
            <Cards>
              <span slot="shopName">CoCo都可(水晶街店)</span>
              <span slot="shopDist">2.1KM</span>
              <p slot="shopLocation">山东省淄博市张店区人民路与重庆路交汇处水晶街山东理工大学校区</p>
              <span class="glyphicon glyphicon glyphicon-heart starshop" slot="ifstar"></span>
            </Cards>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import NavBar from '@/components/common/NavBar'
import Cards from '@/components/home/options/Cards'

export default {
  name: 'ChooseShop',
  data(){
    return {

    }
  },
  methods: {
    backTo() {
      this.$router.go(-1);
    }
  },
  components: {
  	NavBar,
    Cards
  }
}
</script>

<style scoped>
	.chos-nav span{
    display: inline-block;
    font-size: 20px;
    margin-left: 10px;
    margin-right: 5px;
  }
  .chos-nav p {
    display: inline-block;
  }

  .cards-item {
    width: 100%;
  }

  #myTab li {
    width: 50%;
  }
  #myTab a {
    text-align: center;
  }
  .chooseActive {
    color: #ffb872;
  }

  a:link {
    color: grey;
  }


</style>
