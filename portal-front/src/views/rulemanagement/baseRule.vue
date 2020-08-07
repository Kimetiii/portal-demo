<template>
  <div>
    <H1>TODO......</H1>
  </div>
</template>

<script>

import {getRules} from '@/api/rule'
  export default {
    name: 'baseRule.vue',

    data() {
      return {}
    },
    mounted() {
       this.getRules()
    },
    created() {
    },
    methods: {
     async getRules(){
      let res= await getRules()
      }
    }
  }
</script>

<style scoped>
</style>
