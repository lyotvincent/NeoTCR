<template>
  <div>
      <el-card class="box-card">
        <div slot="header">
            <span>cdr3</span>
        </div>
        <el-form :model="form" :label-suffix="':'">
          <el-row>
            <el-col :span="20">
              <el-form-item label="CDR3">
                <el-input v-model="form.cdr3" placeholder="请输入CDR3" class="cdr3_input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          
        </el-form>

      </el-card>

  </div>
</template>

<script>
export default {
    name: "search_card",
    data(){
      return{
        form:{
          cdr3: ""
        }
      }
    }
}

</script>
<style scoped>
.box-card{
    margin: 2%;
}
.cdr3_input{
  width: 300px;
}
</style>