<template>
  <div>
    <el-container>
            <el-main>
                <browse></browse>
                <analyse></analyse>
            </el-main>
    </el-container>
  </div>
</template>

<script>
import browse from './components/Browse.vue'
import analyse from './components/Analyse.vue'

export default {
    name:"help",
    components: {
        browse,
        analyse
    },

}

</script>
<style scoped>
</style>