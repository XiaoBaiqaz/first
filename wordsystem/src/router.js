import Vue from 'vue'
import VueRouter from 'vue-router'
import Foo from './components/Foo.vue'
import ShouYe from '@/components/ShouYe'
import Ct from "@/components/Ct"
import SearchRoot from '@/components/SearchRoot'
import CiGen_Three from '@/components/CiGen_Three'
import Editor from '@/components/Editor'
Vue.use(VueRouter);
const router=new VueRouter({
    routes:[
       {path:'/',component:ShouYe},
        {path:'/shouye',component:ShouYe},
        { path: '/foo',component:Foo},
        {path:'/ct',component:Ct},
        {path:'/sr',component:SearchRoot},
        {path:'/cg',component:CiGen_Three},
        {path:'/edit',component:Editor}
       
        
    
      ]})


/*   const router = new VueRouter({
    routes // (缩写) 相当于 routes: routes
  }) */

export default router


