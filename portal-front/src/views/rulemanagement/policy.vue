<template>
  <div>
    <H2>这里可以设计一下 管理模型变量的页面</H2>
  </div>
</template>

<script>

import {getRules} from '@/api/rule'
  export default {
    name: 'policy.vue',

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
