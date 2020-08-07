<template>
  <div class="dashboard-container">
    <div class="dashboard-text">欢迎用户: {{ name }}</div>
    <!--暂时注释掉富文本编辑器的调试标签-->
    <!--    <EditorBar v-model="detail" :isClear="isClear" @change="change"></EditorBar>
        <el-button type="primary" @click="submit">提交</el-button>-->

  </div>

</template>

<script>
  import {mapGetters} from 'vuex'
  import EditorBar from '@/components/wangEditor/wangEditor.vue'

  export default {
    components: {EditorBar},
    name: 'Dashboard',

    computed: {
      ...mapGetters([
        'name'
      ])
    },
    data() {
      return {
        isClear: false,
        detail: ""
      }
    },
    methods: {
      change(val) {
        console.log(val)
      },
      submit() {

      }
    }
  }
</script>

<style lang="scss" scoped>
  .dashboard {
    &-container {
      margin: 30px;
    }

    .box-card {
      width: 100px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
