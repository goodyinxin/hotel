<template>
  <el-container class="container">
    <el-header class="header">

    <el-row>
        <el-col :span="4">
        <div class="logo">
          <img src="../../assets/img/logo.png">

        </div>
          <h2>后台管理</h2>
        </el-col>
        <el-col :span="18" class="middle"> <h2>后台管理</h2></el-col>

        <el-col :span="2"><div class="grid-content bg-purple">
          <img src="../../assets/img/avatar.png" class='avatar' alt="">
          <a class="loginout" href="#" @click="handleSignout">退出</a>
        </div></el-col>
      </el-row>




    </el-header>
    <el-container>
      <el-aside class="aside" width="180px">
       <!--侧边栏-->
                <el-menu :unique-opened="true"
                 :router="true">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>用户管理</span>
            </template>
              <el-menu-item index="user">
                <i class="el-icon-location"></i>
                <span>用户列表</span>
              </el-menu-item>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>权限管理</span>
            </template>
            <el-menu-item index="right">
              <i class="el-icon-location"></i>
              <span>权限列表</span>
            </el-menu-item>
            <el-menu-item index="role">
              <i class="el-icon-location"></i>
              <span>角色列表</span>
            </el-menu-item>
            <el-menu-item index="1-1">
              <i class="el-icon-location"></i>
              <span>选项3</span>
            </el-menu-item>

          </el-submenu>
        </el-menu>




      </el-aside>
      <el-main class="main">

        <router-view></router-view>

      </el-main>
    </el-container>
  </el-container>
</template>

<script>
    export default {
      beforeCreate() {
        const token = localStorage.getItem('token')
        if(!token){
          this.$router.push({name:'login'})
        }

      },

      methods:{



        handleSignout(){
          localStorage.clear()
          this.$message.success('退出成功')
          this.$router.push({name:'login'})
        }


      }

    }
</script>

<style>
  .container{
    height: 100%;
  }

  .header{
    /*background: url('../../assets/img/topbar.png');*/
    background-color: ghostwhite;


  }

  .logo{
    line-height: 50px;
  }

  .aside{
    background-color: white;
  }

  .main{
    background-color: antiquewhite;
  }


  .middle{
    text-align: center;

  }
.loginout{
  text-decoration: none;
  line-height: 60px;
}

  .avatar{
    width: 40px;
    height: 40px;
    border-radius: 50%;
    vertical-align: middle;
    display: inline-block;
  }
  .header-logo {
    display: inline-block;
    vertical-align: middle;
  }

</style>
