import Vue from 'vue'
import Router from 'vue-router'

const Home = () => import('@/components/home/Home')
const Order = () => import('@/components/order/Order')
const Profile = () => import('@/components/profile/Profile')
//购物有关的组件
const ChooseShop = () => import('@/components/home/options/ChooseShop')
const ChooseGood = () => import('@/components/home/options/ChooseGood')
const SubmitOrder = () => import('@/components/home/options/SubmitOrder')
const Discount = () => import('@/components/home/options/Discount')
const PaySuccess = () => import('@/components/home/options/PaySuccess')
//用户登录注册
const Register = () => import('@/components/userdao/Register')
const Login = () => import('@/components/userdao/Login')
//用户首页
const MyDiscount = () => import('@/components/profile/MyDiscount')
const History = () => import('@/components/profile/History')
const Userinfo = () => import('@/components/profile/Userinfo')
const Howuse = () => import('@/components/profile/Howuse')
// 管理员界面
const Admin = () => import('@/components/admin/Admin')
const Index = () => import('@/components/admin/Index')
//店铺管理
const ShopInfo = () => import('@/components/admin/shopmanage/ShopInfo')
const Salesman = () => import('@/components/admin/shopmanage/Salesman')
const ShopDiscount = () => import('@/components/admin/shopmanage/ShopDiscount')
//商品信息管理
const AllGoods = () => import('@/components/admin/goodmanage/AllGoods')
const ExtraInfo = () => import('@/components/admin/goodmanage/ExtraInfo')

//订单管理
const AllOrder = () => import('@/components/admin/ordermanage/AllOrder')
const WaitingOrder = () => import('@/components/admin/ordermanage/WaitingOrder')
const FinishOrder = () => import('@/components/admin/ordermanage/FinishOrder')
//售出统计
const TodaySell = ()=> import('@/components/admin/operations/TodaySell')
Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
  	{
  		path: '/',
  		redirect: '/login'
  	},
    {
    	path: '/home',
    	component: Home
    },
    {
    	path: '/order',
    	component: Order
    },
    {
    	path: '/profile',
    	component: Profile
    },
    {
      path: '/chooseshop',
      component: ChooseShop
    },
    {
      path: '/choosegood',
      component: ChooseGood,
      meta: {
        keepAlive: true // 需要缓存
      }
    },
    {
      path: '/submitorder',
      component: SubmitOrder
    },
    {
      path: '/discount',
      component: Discount
    },
    {
      path: '/paysuccess',
      component: PaySuccess
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/mydiscount',
      component: MyDiscount
    },
    {
      path: '/history',
      component: History
    },
    {
      path: '/userinfo',
      component: Userinfo
    },
    {
      path: '/howuse',
      component: Howuse
    },
    //管理员界面
    {
      path: '/admin',
      component: Admin
    },
    {
      path: '/index',
      component: Index
    },
    {
      path: '/shopinfo',
      component: ShopInfo
    },
    {
      path: '/salesman',
      component: Salesman
    },
    {
      path: '/shopdiscount',
      component: ShopDiscount
    },
    {
      path: '/allgoods',
      component: AllGoods
    },
    {
      path: '/extrainfo',
      component: ExtraInfo
    },
    {
      path: '/allorder',
      component: AllOrder
    },
    {
      path: '/waitingorder',
      component: WaitingOrder
    },
    {
      path: '/finishorder',
      component: FinishOrder
    },
    {
      path: '/todaysell',
      component: TodaySell
    }
  ]
})
