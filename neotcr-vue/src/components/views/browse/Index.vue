<template>
  <div>
      <search_card></search_card>
      <result_card></result_card>
  </div>
</template>

<script>
import search_card from './search/Index'
import result_card from './result/Index'

export default {
    name: "browse",
    components: {
      search_card,
      result_card
    }
}

</script>
<style scoped>
</style>