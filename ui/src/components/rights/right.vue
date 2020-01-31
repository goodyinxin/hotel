<template>

  <el-card>
  <!--面包屑-->

    <m-bread level1="权限管理" level2="权限列表"></m-bread>



    <el-table class="table"  height="400px" :data="tableData" border  style="width: 100%">
      <el-table-column type="index" label="序号"   width="60">   </el-table-column>
      <el-table-column prop="promiseName"  label="权限名"  width="180"> </el-table-column>
      <el-table-column prop="promisePath"  label="路径"  width="180"> </el-table-column>
      <el-table-column prop="promiseLevel"  label="权限层级"  width="180">
        <template slot-scope="scope">
          <span v-if="scope.row.promiseLevel ===1">一级</span>
          <span v-if="scope.row.promiseLevel ===2">二级</span>
          <span v-if="scope.row.promiseLevel ===3">三级</span>
        </template>
      </el-table-column>
      <el-table-column prop="createtime"  label="创建时间">
        <template slot-scope="tableData">
          {{tableData.row.createtime | fmtdate}}
        </template>
      </el-table-column>
    </el-table>

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
            }
        },
          created() {
              this.getList()
          },


          methods:{

              async getList(){
                  const res = await this.$http.post('/promise/list',this.page);
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

  .table{
    margin-top: 20px;
  }

</style>
