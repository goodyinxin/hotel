<template>

  <div class="login-wrap">
    <el-form class="login-form" label-position="top" label-width="80px" :model="formdata">

      <h2>登录</h2>
      <el-form-item label="用户名">
        <el-input class="xx" v-model="formdata.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formdata.password"></el-input>
      </el-form-item>
      <el-button @click.prevent="login" class="login-btn" type="primary">登录</el-button>
    </el-form>
  </div>

</template>

<script>
    export default {
       data(){
           return{
               formdata:{username:'',password:''}
           }
       },


        methods:{

         async  login(){
                const res   = await this.$http.post('/user/login',this.formdata)
                 const {data,msg,code}=res.data
                 if(code ==='ok'){
                     this.$router.push({name:'home'})
                     this.$message.success(msg)
                 }else {
                     this.$message.error(msg)
                 }


               /*this.$http.post('/user/login',this.formdata).then(res =>{
                       const {data,msg,code}=res.data
                       if(code ==='ok'){
                           this.$router.push({name:'home'})
                           this.$message.success(msg)
                       }else {
                           this.$message.error(msg)
                       }
                   })*/
           }
        }
    }
</script>

<style>

  .login-wrap{
    height: 100%;
    background:url('../../assets/img/background.png')no-repeat top;
    background-size:cover;
    background-attachment: fixed;
    display: flex;
    align-items: center;
    justify-content: center;

  }
  .login-wrap .login-form{
    width: 400px;
    background-color: #fff;
    border-radius: 5px;
    padding: 30px;

  }
  .login-wrap .login-btn{
     width: 100%;
  }


</style>
