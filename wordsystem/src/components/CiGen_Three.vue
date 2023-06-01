
<template>
    <div>
      <el-button type="primary"   @click="dialogVisible = true" icon="el-icon-plus"></el-button>
   
      <el-dialog title="添加词根" :visible.sync="dialogVisible" width="30%">
        <el-form ref="form" :model="form"   label-width="80px">
          <el-form-item label="root" prop="id" :rules="[{required:true,message:'词根不能为空'}]">
            <el-input v-model.trim="form.id" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="mean" prop="mean" :rules="[{required:true,message:'含义不能为空'}]">
            <el-input v-model.trim="form.mean" auto-complete="off"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button  @click="submit()">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </template>
   
  <script>
import axios from 'axios';
    export default {
      data() {
        return {
          dialogVisible:false,
          form: {
            id: '',
            mean:'',
            rate:1
          }
        };
      },
     
      methods:{
        submit(){
            console.log("id====>"+this.form.id)
            axios.post("http://localhost:8081/insertcg",{"id":this.form.id,"mean":this.form.mean,"rate":this.form.rate}).then((res)=>{alert(res.data)});
            this.$refs['form'].resetFields()
          

        }
      }
    };
  </script>