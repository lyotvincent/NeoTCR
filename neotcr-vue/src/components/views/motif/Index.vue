<template>
  <div>
      <h1>Motif</h1>
      <search_card></search_card>
      <result_card></result_card>
  </div>
</template>

<script>
import search_card from './search/Index'
import result_card from './result/Index'

export default {
    name: "motif",
    components: {
      search_card,
      result_card
    }
}

</script>
<style scoped>
</style>