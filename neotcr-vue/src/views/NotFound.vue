<template>
  <div>
      <el-card class="box-card" >
        <el-container>
          <el-main>
            <h1 style="text-align:center;">404</h1>
            <h1 style="text-align:center;">Page Not Found</h1>
            <p style="text-align:center;">The page you are looking for does not exist.How you got here is mystery.</p>
            <p style="text-align:center;">But you can click the button below to go back to the homepage.</p>
            <el-button type="primary" plain @click="gohome" style="display:block;margin:0 auto">GoHome</el-button>
          </el-main>
        </el-container>
</el-card>

  </div>
</template>

<script>
export default {
    name: 'notfound',
    methods: {
      gohome(){
        this.$router.push('/home')
      }
    }
}

</script>
<style scoped>
.box-card {
    width: 680px;
    height: 360px;
    margin: 100px auto;
  }
</style>