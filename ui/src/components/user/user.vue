<template>
  <el-card class="box-card">

    <!--面包屑-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!--搜索-->
    <el-row class="searchRow">
      <el-col>
        <el-input placeholder="请输入内容" v-model="query" class="inputSeach">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <el-button type="success">添加用户</el-button>
      </el-col>
    </el-row>


    <!--表格-->
    <el-table :data="tableData"style="width: 100%">
      <el-table-column type="index" label="序号"   width="60">   </el-table-column>
      <el-table-column   prop="name"     label="姓名"  width="180">  </el-table-column>
      <el-table-column   prop="gende"  label="性别">

        <template slot-scope="obj">
          {{obj.row.gende=='1'? '男':'女'}}

        </template>

      </el-table-column>
      <el-table-column   prop="age"  label="年龄"> </el-table-column>
      <el-table-column   prop="moblie"  label="手机"> </el-table-column>
      <el-table-column   prop="createtime"  label="创建时间">
        <template slot-scope="tableData">
          {{tableData.row.createtime | fmtdate}}
        </template>
      </el-table-column>


     <!-- <el-table-column   prop="address"  label="用户状态">
      </el-table-column>
      -->
      <el-table-column   prop="" label="操作">

        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit"></el-button>
          <el-button type="danger" icon="el-icon-delete"></el-button>
        </template>
      </el-table-column>
    </el-table>


    <!--分页-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagenum"
      :page-sizes="[100, 200, 300, 400]"
      :page-size="pagesize"
      background
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>

  </el-card>
</template>

<script>
    export default {
        data(){
          return{
            query:'',
            tableData :[],
            total:-1,
            pagenum:1,
            pagesize:2
          }

        },

        created() {
            this.getList()

        },

        methods: {

            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },

            async getList(){
                const AUTH_TOKEN =localStorage.getItem('token');
                this.$http.defaults.headers.common['AUTH_TOKEN'] =AUTH_TOKEN;
                const res = await this.$http.get('/user/list');
                console.log('xxxxxxxx',res)
                const {msg,code,data} =res.data;
                if(code ==='ok'){
                  this.tableData=data;
                 /* this.total=total;*/
                  //this.$message.success(msg)
                }else {
                  this.$message.warning(msg)
                }
            }


        }
    }
</script>

<style >
.box-card{
  height: 100%;

}
.inputSeach{
  width: 300px;
}

  .searchRow{
    margin-top: 20px;
  }
</style>
