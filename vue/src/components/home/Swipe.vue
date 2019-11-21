<template>
  <div class="wrapper">
    <swiper :options="swiperOption">
      <!-- slides -->
      <swiper-slide><img src="@/assets/img/swipe/swipe1.jpg" alt=""></swiper-slide>
      <swiper-slide><img src="@/assets/img/swipe/swipe5.jpg" alt=""></swiper-slide>
      <swiper-slide><img src="@/assets/img/swipe/swipe3.jpg" alt=""></swiper-slide>
      <swiper-slide><img src="@/assets/img/swipe/swipe4.jpg" alt=""></swiper-slide>
      <!-- Optional controls -->
      <div class="swiper-pagination"  slot="pagination"></div>
      <!-- <div class="swiper-button-prev" slot="button-prev"></div>
      <div class="swiper-button-next" slot="button-next"></div> -->
      <div class="swiper-scrollbar"   slot="scrollbar"></div>
    </swiper>
  </div>
</template>

<script>

export default {
  name: 'Swipe',
  data(){
    return {
      swiperOption: {
        notNextTick: true,
        // swiper configs 所有的配置同swiper官方api配置
        autoplay: true,
        speed:800,
        setWrapperSize: true,
        autoHeight: true,
        pagination: ".swiper-pagination",
        paginationClickable: true,
        mousewheelControl: true,
        observeParents: true,
        // 如果自行设计了插件，那么插件的一些配置相关参数，也应该出现在这个对象中，如下debugger
        debugger: true,
        loop : true,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true
        }
      }
    }
  }
}
</script>

<style>
	.wrapper {
    overflow: hidden;
    width: 100%;
    height: 50%;
    padding-bottom: 31.25%;
    margin-top: -18px;
  }

  .wrapper img {
    width: 100%;
    height: 100%;
  }
</style>
