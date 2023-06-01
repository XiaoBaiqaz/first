<template>
    <div>
      
      <el-input class="input" v-model.trim="search_by" placeholder="输入框" style="width: 300px;"></el-input>
      <el-button class="search" icon="el-icon-search"  type="primary" @click="getInitial()">搜索</el-button>
    <el-table class="table" :data="worddata"  size="medium" style="width: 80%;left: 150px;">
    <el-table-column  col="40" align="center" header-align="center" label="word" prop="id"></el-table-column>
    <el-table-column  align="center" header-align="center" label="mean" prop="mean"></el-table-column>
    <el-table-column  align="center" >
      <template slot-scope="sp">
        <el-button type="warning" icon="el-icon-star-off" v-if="!(sp.row.rate%2)" circle @click="changeStatue(sp.row.id)"></el-button>
        <el-button type="primary" icon="el-icon-edit" circle @click="changedialog(sp.row.id,sp.row.mean)"></el-button>
        <el-button  type="danger" icon="el-icon-delete" circle @click="deleteData(sp.row.id)"></el-button>
        <el-dialog title="编辑" :visible.sync="dialogVisible" width="30%">
          <el-form :modle="editform"  inline="true" ref="editform">
            <el-form-item label="root" prop="reid">
              <el-input v-model="editform.reid" ></el-input>
            </el-form-item>
            <el-form-item label="mean" prop="remean">
              <el-input v-model=" editform.remean"></el-input>
            </el-form-item>
          </el-form>
          <span>
            <el-button type="primary" @click="dialogVisible=!dialogVisible">取消</el-button>
            <el-button type="primary" @click="changeedit()">提交</el-button>
          </span>
        
        </el-dialog>

      </template>
    </el-table-column>

  </el-table>

  <!-- <el-button   slot="aa">
    <CiGen_Three icon="el-icon-plus"></CiGen_Three>
  </el-button> -->
  <CiGen_Three></CiGen_Three>
 
  
 <!--  <h1>{{ dialogVisible }}</h1> -->
  <el-pagination
  background
  layout="sizes, prev, pager, next, jumper,total"
  :page-size="pagesize"
  :page-sizes="[10]"
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
import CiGen_Three from './CiGen_Three.vue';


export default {
  data(){

    
    

    return {
      dialogVisible:false,
      worddata:[],
      pagesize:10,
      pagenum:1,
      total:0,
      search_by:'',
      reid:'',
      editform:{reid:'',remean:''}
      
    }

  },
  components:{
    CiGen_Three,
   
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

  /* mounted:function(){
    axios.get("http://localhost:8081/all/"+this.pagenum+"/"+this.pagesize).then((res)=>{
      console.log(res);this.worddata=res.data[0].data;
      this.total=res.data[1].total;
      console.log(this.worddata)
    })
    
  }, */
  methods:{

    changeedit(){
      axios.put("http://localhost:8081/eddata",{"neid":this.editform.reid,"nemean":this.editform.remean,"oldid":this.oldid}).then(
        (res)=>{alert(res.data); 
          this.editform.reid='';
          this.editform.remean='';
          this.dialogVisible=!this.dialogVisible;
        }
      );

      this.$router.go(0);
      
      

    },
    

    changedialog(val1,val2){
      this.dialogVisible=true;
      /* console.log("v1===>"+val1,"v2===>"+val2) */
      this.editform.reid=val1;
      this.editform.remean=val2;
      this.oldid=val1;
    },

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
      if(this.search_by.replace(/\s+/g,"")){
        axios.get("http://localhost:8081/searchroot/"+this.pagenum+"/"+this.pagesize+"/"+this.search_by).then((res)=>{
      console.log("res===>"+res);
      this.worddata=res.data[0].data;
      this.total=res.data[1].total;
      console.log("this.worddata===>"+this.worddata);
      console.log("thistotal===>"+this.total)
    })
      }else{
        alert("输入框不能为空!")
      }
      
   
    },
    deleteData(val){
        axios.post("http://localhost:8081/delroot/",{"id":val}).then(this.getInitial)
          
        

    },


   
    
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
.input{
margin-left: 60px;
}
.search{
margin-left: 20px;
}

</style>