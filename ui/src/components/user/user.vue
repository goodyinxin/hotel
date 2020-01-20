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
        <el-input placeholder="请输入内容" v-model="page.query" @clear="reload" clearable class="inputSeach">
          <el-button slot="append" icon="el-icon-search" @click="queryList"></el-button>
        </el-input>
        <el-button type="success" @click="showDia">添加用户</el-button>
      </el-col>
    </el-row>


    <!--表格-->
    <el-table :data="tableData"style="width: 100%" class="Eltable">
      <el-table-column type="index" label="序号"   width="60">   </el-table-column>
      <el-table-column   prop="adminNickname"     label="姓名"  width="180">  </el-table-column>
      <el-table-column   prop="adminGende"  label="性别">

        <template slot-scope="obj">
          {{obj.row.adminGende=='1'? '男':'女'}}

        </template>

      </el-table-column>
      <el-table-column   prop="adminAge"  label="年龄"> </el-table-column>
      <el-table-column   prop="adminMoblie"  label="手机"> </el-table-column>
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
      :current-page="page.pagenum"
      :page-sizes="[5, 10, 20]"
      :page-size="page.pagesize"
      background
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>


    <!--对话框-->
    <!--添加的对话框-->

    <el-dialog title="添加用户" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="用户名" label-width="80px">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>

          <el-form-item label="密码" label-width="80px">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="邮箱" label-width="80px">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="手机" label-width="80px">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
       <!-- <el-form-item label="活动区域" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>

  </el-card>
</template>

<script>
    export default {
        data(){
          return{
            tableData :[],
            total:0,
            page:{pagenum:1,pagesize:10,query:''},
            dialogFormVisible:false,
            form:''

          }

        },

        created() {
            this.getList()

        },

        methods: {

          showDia(){
            this.dialogFormVisible=true
          },

          reload(){
            //重新加载数据
            this.getList();
          },

            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.page.pagesize=val;
                this.getList()
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                this.page.pagenum=val;
                this.getList()
            },

          queryList(){
            this.getList()
          },

            async getList(){
                const AUTH_TOKEN =localStorage.getItem('token');
                this.$http.defaults.headers.common['AUTH_TOKEN'] =AUTH_TOKEN;
                const res = await this.$http.post('/user/list',this.page);
                const {msg,code,data} =res.data;
                var obj = data[0];
                if(code ==='ok'){
                  this.tableData=obj.records;
                  this.total=obj.total;
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


  .Eltable th{
     padding: 0px 0!important;

  }

.Eltable td{
  padding: 0px 0!important;

}
</style>
