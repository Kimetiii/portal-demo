<template>
  <div>
    <div style="display: inline-block">
      <el-card class="box-card" style="width: 300px;display: inline-block;margin-left: 50px;margin-top: 30px">
        <div style="margin-left: 100px">今日使用次数</div>
        <div><h1 style="margin-left: 100px">{{todayCount}}</h1></div>
      </el-card>
      <el-card class="box-card" style="width: 300px;display: inline-block;margin-left: 50px;margin-top: 30px">
        <div style="margin-left: 100px">7日使用次数</div>
        <div><h1 style="margin-left: 100px">{{weekendCount}}</h1></div>
      </el-card>
      <el-card class="box-card" style="width: 300px;display: inline-block;margin-left: 50px;margin-top: 30px">
        <div style="margin-left: 100px">15日使用次数</div>
        <div><h1 style="margin-left: 100px">{{halfMonthCount}}</h1></div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'home.vue',
  data() {
    return {
      todayCount: '3',
      weekendCount: '7',
      halfMonthCount: '23'
    }
  },
  mounted() {
  },
  created() {
  },
  methods: {

  }
}
</script>

<style scoped>
</style>
