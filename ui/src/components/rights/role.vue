<template>


  <el-card>
  <m-bread level1="权限管理" level2="角色列表"></m-bread>

    <el-row class="addbtn">
      <el-col>
        <el-button type="info">添加角色</el-button>
      </el-col>
    </el-row>

    <el-table :data="tableData"style="width: 100%" class="Eltable">
      <el-table-column type="expand">

        <template slot-scope="scope">
            <el-row>

              <el-col :span="4">

                <el-tag closable type="success" >{{'XXX'}}</el-tag>
                <i class="el-icon-arrow-right" ></i>
              </el-col>
              <el-row>

              <el-col :span="20">

                <el-tag closable>{{'XXX'}}</el-tag>
                <el-tag closable>{{'XXX'}}</el-tag>
              </el-col>
              </el-row>

            </el-row>
        </template>
      </el-table-column>

      <el-table-column type="index" label="序号"   width="60">   </el-table-column>
      <el-table-column   prop="roleName"     label="姓名"  width="180">  </el-table-column>
      <el-table-column   prop="roleDesc"     label="姓名"  width="180">  </el-table-column>
      <el-table-column   prop="createtime"  label="创建时间">
        <template slot-scope="tableData">
          {{tableData.row.createtime | fmtdate}}
        </template>
      </el-table-column>

      <el-table-column   prop="" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="open(scope.row.roleId)" icon="el-icon-edit"></el-button>
          <el-button size="mini" type="danger" @click="remove(scope.row.roleId)" icon="el-icon-delete"></el-button>
          <el-button size="mini" type="success" @click="role(scope.row)" icon="el-icon-user"></el-button>
        </template>
      </el-table-column>
    </el-table>


    <!--对话框-->

    <el-dialog title="修改权限" :visible.sync="dialogFormVisible">

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
                tableData:[],
                page:{pagenum:1,pagesize:10,query:''},
                total:0,
                title:'',
                dialogFormVisible:false,
                form:{}
            }
        },

        created() {
            this.getList()
        },

        methods:{

            open(){

                this.dialogFormVisible=true

            },

            async getList(){
                const res = await this.$http.post('/role/list',this.page);
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

        },

    }
</script>

<style >
  .addbtn{
    margin-top: 20px;
  }

</style>
