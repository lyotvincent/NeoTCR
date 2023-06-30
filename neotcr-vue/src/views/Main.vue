<template>
<div>
  <el-row class="head">
  <h1 class="logo-h1">NeoTCR</h1>
  
  <el-menu :default-active="this.$route.path" router class="el-menu-demo main-menu" mode="horizontal" @select="handleSelect">
    <el-menu-item v-for="(item,i) in navItem" :key="i" :index='item.name'>
      <template slot="title">
        <i v-bind:class='item.icon'></i>
        <span>{{item.value}}</span>
      </template>
    </el-menu-item>
  </el-menu>
  </el-row>

  <router-view></router-view>
</div>
</template>

<script>
export default {
    name: "main",
    data () {
        return {
            activeIndex: '1',
            navItem:[{name:'/home',value:'Home',icon:"el-icon-s-home"},{name:'/browse',value:'Browse',icon:'el-icon-search'},{name:'/annotation',value:'Analyze',icon:'el-icon-data-analysis'},{name:'/help',value:'Help',icon:'el-icon-s-help'}]
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            if(key=='1'){
              this.$router.push('/home')
            }
            else if(key=='3'){
              this.$router.push('/browse')
            }
            else if(key=='4'){
              this.$router.push('/annotation')
            }
            else if(key=='5'){
              this.$router.push('/help')
            }
        }
    }
}

</script>
<style scoped>
.head{
  /* background: #76787a; */
  /* content: none; */
  height: 2%;
  padding-right: 1%;
  padding-left: 1%;
}

.logo-h1{
  /* width: 40%; */
  /* margin: 0 0 0 20; */
  /* padding: 10 10 10 10;  */
  /* height: 55px; */
  height: 2%;
	line-height: 100px;
  display:inline-block;
  font-size:50px;
  font-weight: 700 !important;
  color:rgb(81, 81, 81);
}
.main-menu{
  float: right;
  height: 2%;
  
}
/* ::v-deep .el-menu-demo{
  float: right;
  height: 100px;
} */
</style>