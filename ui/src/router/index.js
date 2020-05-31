import Vue from 'vue'
import Router from 'vue-router'
import  Login from '@/components/login/login.vue'
import  Home from '@/components/home/home.vue'
import  User from '@/components/user/user.vue'
import  Right from '@/components/rights/right.vue'
import  Role from '@/components/rights/role.vue'
import  Room from '@/components/hotel/room.vue'
import  Order from '@/components/hotel/order.vue'
import  Day from '@/components/hotel/day.vue'


import {from} from "bootstrap-vue/esm/utils/array";


Vue.use(Router)

const router = new Router({
  routes: [
    {
      name: 'login',
      path: '/login',
      component:Login
    },



    {
      name: 'home',
      path: '/',
      component:Home,
      children:[{
           name:'user',
           path:'/user',
           component:User
         },
        {
          name:'right',
          path:'/right',
          component:Right
        },
        {
          name:'role',
          path:'/role',
          component:Role
        },
        {
          name:'room',
          path:'/room',
          component:Room
        },
        {
          name:'order',
          path:'/order',
          component:Order
        },
        {
          name:'day',
          path:'/day',
          component:Day
        },

      ]
    }

  ]
})


//在路由配置生效之前 统一判断token
//路由导航  守卫
//to 是去的路由
//from是当前的路由
router.beforeEach((to,from,next) =>{
    if(to.path==='/login'){
      next()
    }else{
      const token = localStorage.getItem('token')
      if(!token){
        router.push({name:'login'})
        return
      }
      next()
    }

})

export default  router
