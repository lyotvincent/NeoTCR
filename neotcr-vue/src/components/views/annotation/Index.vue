<template>
  <div>
      <annotationView></annotationView>
  </div>
</template>

<script>
import annotationView from './views/Upload'
export default {
    name: "annotation",
    components:{
      annotationView
    }
}

</script>
<style scoped>
.box-card{
    margin: 2%;

}
</style>