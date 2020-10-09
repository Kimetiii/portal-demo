<template>
  <div>
    <H1 style="margin-left: 10px">变量管理</H1>
  </div>
</template>

<script>

import {getRules} from '@/api/rule'
  export default {
    name: 'variable.vue',

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
