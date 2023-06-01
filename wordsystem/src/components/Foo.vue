<template>
    <div>
    <el-table class="table" :data="worddata"  size="medium" style="width: 80%;left: 150px;">
    <el-table-column  col="40" align="center" header-align="center" label="word" prop="id"></el-table-column>
    <el-table-column  align="center" header-align="center" label="mean" prop="mean"></el-table-column>
    <el-table-column  align="center" header-align="center">
      <template slot-scope="sp"><el-button type="primary" @click="changeStatue(sp.row.id)">移除</el-button></template>
    </el-table-column>
  </el-table>

  <el-pagination
  background
  layout="sizes, prev, pager, next, jumper,total"
  :page-size="pagesize"
  :page-sizes="[10,20,30,40]"
  @current-change="getPageNum"
  @size-change="getPageSize"

  class="mypage"

  :total="total"
  >
</el-pagination>



</div>
  

</template>




<script>
import axios from 'axios'
export default {
  data(){

    return {
      worddata:[],
      pagesize:10,
      pagenum:1,
      total:0
    }

  },
  /* proxyTable: {
      "/api":{
        target: 'http://localhost:8080/',      //后端接口的根目录
        changeOrigin: true,                    //是否跨域
        pathRewrite: {
            '^/api': '/'
        }
      }
    }, */

  mounted:function(){
    axios.get("http://localhost:8081/findeasy/"+this.pagenum+"/"+this.pagesize).then((res)=>{
      console.log(res);this.worddata=res.data[0].data;
      this.total=res.data[1].total;
      console.log(this.worddata)
    })
    
  },
  methods:{
    changeStatue(val){
      /* alert(val) */
      axios.get("http://localhost:8081/sc/"+val).then(this.getInitial);
    },
    getPageNum(val){

      console.log(val);
      this.pagenum=val;
      console.log(this.pagesize);
      this.getInitial()
    },
    getPageSize(val){
      this.pagesize=val;
      this.getInitial()
    },

    getInitial(){
      axios.get("http://localhost:8081/findeasy/"+this.pagenum+"/"+this.pagesize).then((res)=>{
      console.log("res===>"+res);this.worddata=res.data[0].data;this.total=res.data[1].total;
      console.log("this.worddata===>"+this.worddata);
      console.log("thistotal===>"+this.total)
    })

    }
    
  },
  }

</script>

<style>

.mypage{
  margin-left: 25%;
  margin-top: 1%;
}

.table{
  border: 10px;
}



</style>