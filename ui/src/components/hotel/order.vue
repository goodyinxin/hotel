<template>
  <el-card class="box-card">

    <!--面包屑-->
    <!--<el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>-->
    <m-bread level1="酒店管理" level2="酒店订单"></m-bread>
    <!--搜索-->
    <el-row class="searchRow">
      <el-col>
        <el-input placeholder="请输入内容" v-model="page.query" @clear="reload" clearable class="inputSeach">
          <el-button slot="append" icon="el-icon-search" @click="queryList"></el-button>
        </el-input>
       <!-- <el-button type="success" @click="showDia">添加房间</el-button>-->
      </el-col>
    </el-row>


    <!--表格-->
    <el-table :data="tableData"style="width: 100%" class="Eltable">
      <el-table-column   type="index" label="序号"   width="60">   </el-table-column>
      <el-table-column   prop="orderCode"  label="流水号"  width="250">  </el-table-column>
      <el-table-column   prop="orderName"  label="订单名称"> </el-table-column>
      <el-table-column   prop="orderMoblie"  label="手机号"> </el-table-column>
      <el-table-column   prop="orderGender"  label="性别"></el-table-column>
      <el-table-column   prop="orderAge"  label="年龄"></el-table-column>
      <el-table-column   prop="orderCheckdate"  label="入住时间">
        <template slot-scope="tableData">
          {{tableData.row.orderCheckdate | fmtdate}}
        </template>
      </el-table-column>
      <el-table-column   prop="orderState"  label="订单状态"></el-table-column>

      <el-table-column   prop="" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="success" @click="open(scope.row.orderId)" icon="el-icon-edit"></el-button>
          <!--<el-button size="mini" type="danger" @click="remove(scope.row.orderId)" icon="el-icon-delete"></el-button>
          <el-button size="mini" type="success" @click="role(scope.row)" icon="el-icon-user"></el-button>-->
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


    <el-dialog  :title="title" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="form">
        <el-form-item label="流水号" label-width="80px">
          <el-input v-model="form.orderCode" autocomplete="off"></el-input>
        </el-form-item>

          <el-form-item label="订单名称" label-width="80px">
          <el-input v-model="form.orderName" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="手机号" label-width="80px">
          <el-input v-model="form.orderMoblie" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="身份证" label-width="80px">
          <el-input v-model="form.orderIdcard" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="性别" label-width="80px">
          <el-input v-model="form.orderGender" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄" label-width="80px">
          <el-input v-model="form.orderAge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="入住时间" label-width="80px">
          <el-input v-model="form.orderCheckdate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="订单状态" label-width="80px">
          <el-input v-model="form.orderState" autocomplete="off"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>


    <!--权限-->

    <el-dialog title="分配角色" :visible.sync="dialogFormRole" width="30%">
      <el-form :model="form">
        <el-form-item label="用户名" label-width="100px">
          {{roleName}}
        </el-form-item>
        <el-form-item label="角色" label-width="100px">
          <el-select v-model="form.adminRole" placeholder="请选择角色">
            <el-option label="请选择" :value="-1"></el-option>
            <el-option v-for="(item,i) in roleList" :key="i" :label="item.roleName" :value="item.roleId"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormRole = false">取 消</el-button>
        <el-button type="primary" @click="setRole">确 定</el-button>
      </div>
    </el-dialog>

  </el-card>
</template>

<script>
    export default {
        data(){
          return{
            title:'',
            tableData :[],
            total:0,
            page:{pagenum:1,pagesize:10,query:''},
            dialogFormVisible:false,
            dialogFormRole:false,

            form:{
                orderId:"",
                orderCode:"",
                orderState:"",
                createman:"",
                modifyman:"",
                createtime:"",
                modifytime:"",
                orderName:"",
                orderMoblie:"",
                orderIdcard:"",
                orderGender:"",
                orderAge:"",
                orderCheckdate:""
            },
              currnadminId:-1,
              currnaroleId:-1,
              roleName:'',
              roleList:[]
          }

        },

        created() {
            this.getList()

        },

        methods: {

            open(id){
                this.title='修改'
                this.$http.get('order/load/'+id)
                    .then(res=>{
                       const {data,msg,code} = res.data;
                      console.log("======",res)
                       this.dialogFormVisible=true;
                       this.form=data[0];
                }).catch(res => {

                });
            },



            remove(id){
                console.log(id)
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$http.delete('/order/remove/'+id).then(res=>{
                        const {msg,code,data} =res.data;
                        if(code ==='ok'){
                            //this.page.pagenum=1;
                            this.getList()
                            this.$message({
                                type: 'success',
                                message: msg
                            });
                        }
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },



          /*添加用户*/
            async  save(){
              this.dialogFormVisible=false;
              const res = await this.$http.post('/order/save',this.form);
              const {msg,code,data} =res.data;
                if(code ==='ok'){
                    this.getList()
                    this.form={}
                }else {
                    this.$message.warning(msg)
                }
            },

            success(){
                this.dialogFormRole=true
            },
            role(obj){
                this.currnadminId=obj.adminId
                this.dialogFormRole=true
                this.roleName=obj.adminNickname;
                this.form.adminRole=obj.adminRole
                this.$http.get('/order/select').then(res=>{
                   const {msg,data,code}=res.data
                   this.roleList=data

                });

            },

            setRole(){
                this.$http.get('/order/setrole/'+this.currnadminId+'/'+this.form.adminRole).then(res=>{
                    const {msg,data,code}=res.data
                });
                this.dialogFormRole=false
                this.getList()
            },


          showDia(){
              this.title='添加'
              this.dialogFormVisible=true
              this.form={};
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

                const res = await this.$http.post('/order/list',this.page);
                const {msg,code,data} =res.data;
                var obj = data[0];
                console.log(obj)
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
     padding: 3px 0!important;

  }

.Eltable td{
  padding: 3px 0!important;

}
</style>
