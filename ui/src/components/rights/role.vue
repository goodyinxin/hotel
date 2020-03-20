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

    <el-dialog title="修改权限" :visible.sync="dialogFormVisible"   width="30%">

      <!--树形结构
      data -> 数据源[]
      show-checkbox ->选择框
      node-key 每个节点唯一标识，通常是data数据源中key的id值
      dedault-expanded-keys 默认展开[要展开的节点id]
      default-checked-keys [要选择节点的id]
      props配置项{label，children}
      label 节点的文字标题和children节点的子节点
      值都来源于data绑定的数据源中的该数据的key名‘label’和‘children’
        :default-expanded-keys="[2, 3]"
        :default-checked-keys="[5]"
      -->

      <el-tree
        ref="eltree"
        :data="tree"
        show-checkbox
        node-key="promiseId"
        :props="defaultProps"
        default-expand-all
        :default-checked-keys="arrayChecked"
       >
      </el-tree>


      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="subRole">确 定</el-button>
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
              form:{},
              defaultProps:{label:'promiseName',children:'promises'},
              tree: [],
              arrayChecked:[]
            }
        },

        created() {
            this.getList()
        },

        methods:{

          async role(){


            const res = await this.$http.get('/promise/role');
            const {msg,code,data} =res.data;
            this.tree=data[0];

            this.dialogFormVisible=true
            },


          subRole(){

            //全选
            let arr1 = this.$refs.eltree.getCheckedKeys();

            //半选
            let arr2 = this.$refs.eltree.getHalfCheckedKeys();
            let arr = [...arr1,...arr2];
            console.log("全选",arr)
            this.dialogFormVisible = false
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
