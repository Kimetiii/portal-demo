<template>
  <div>
    <el-button style="margin-left: 50px" @click="changeType" type="primary">click</el-button>
    <ve-chart
      :data="chartData"
      :settings="chartSettings"
      width="500px">
    </ve-chart>
  </div>
</template>

<script>

  import {getRules} from '@/api/rule'

  export default {
    name: 'baseRule.vue',
    chartSettings: {},
    index: 0,
    typeArr: ['line', 'histogram', 'pie'],
    data() {

      this.typeArr = ['line', 'histogram', 'pie']
      this.index = 0

      return {
        chartData: {
          columns: ['日期', '模型调用次数'],
          rows: [
            {'日期': '1月1日', '模型调用次数': 1523},
            {'日期': '1月2日', '模型调用次数': 1223},
            {'日期': '1月3日', '模型调用次数': 2123},
            {'日期': '1月4日', '模型调用次数': 4123},
            {'日期': '1月5日', '模型调用次数': 3123},
            {'日期': '1月6日', '模型调用次数': 7123}
          ]
        },
        chartSettings: {type: this.typeArr[this.index]}
      }
    },
    mounted() {
      this.getRules()
    },
    created() {
    },
    methods: {
      async getRules() {
        let res = await getRules()
      },
      changeType: function () {
        this.index++
        if (this.index >= this.typeArr.length) {
          this.index = 0
        }
        this.chartSettings = {type: this.typeArr[this.index]}
      }
    }
  }
</script>

<style scoped>
</style>
