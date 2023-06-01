<template>
  
<div>
  

<el-container>
  <el-aside width="200px">
    <el-menu :default-openeds="[1]">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message" ></i>词根</template>
        
       
        
          <el-menu-item index="1-1">
            <router-link class="a" to="/shouye">词根一览</router-link>
          </el-menu-item>
          <el-menu-item index="1-2">
            <router-link class="a" to="/foo">易遗忘词根</router-link>
          </el-menu-item>
          <el-menu-item index="1-3">
            <router-link class="a" to="/ct">高频易忘</router-link>
          </el-menu-item>
          <!-- <router-link to="/foo">Go to Foo</router-link> -->
          <!-- <el-menu-item index="1-4-1">选项4-1</el-menu-item> -->
          <el-menu-item index="1-4">
            <router-link class="a" to="/sr">词根搜索</router-link>
          </el-menu-item>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>单词</template>
        <el-menu-item-group>
         
          <el-menu-item index="2-1">
            <router-link class="a" to="/cg">弹框test</router-link>
          </el-menu-item>
          <el-menu-item index="2-2">
            <router-link class="a" to="/edit">弹框edit</router-link>
          </el-menu-item>
        </el-menu-item-group>
        
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>设置</template>
        <el-menu-item-group>
         
          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
  <el-container>
    <el-header>
      词根管理系统
    </el-header>
    <el-main>
    <router-view></router-view>
    </el-main>

    <el-footer class="gy">
      乐知、求是
    </el-footer>

  </el-container>
</el-container>
</div>

</template>
<style>


.a{
  text-decoration: none;
}




.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 50px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }



</style>

<script>
import axios from 'axios'
import ShouYe from './ShouYe.vue';

export default {
  components:{
    ShouYe,
   
  }
  
    
  }
  

</script>


