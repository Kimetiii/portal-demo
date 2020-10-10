<template>
  <div>
    <H2 style="margin-left: 30px"> 编辑drools规则模型</H2>
    <el-card v-for="o in ruleList" class="box-card" style="margin-left: 30px;margin-top: 10px">
      <div slot="header" class="clearfix">
        <span style="font-family:'微软雅黑';font-weight: bold">模型名称：</span>
        <span v-if='!o.isChange'>{{ o.ruleName }}</span>
        <el-input v-model=o.ruleName v-else style="width: 600px"><</el-input>
        <el-button type="success" style="float:right" @click="changeRule(o.id)" v-if='!o.isChange'>修改</el-button>
        <el-button v-show='o.isChange'
                   v-else
                   type="primary"
                   style="float:right;margin-bottom: 10px"
                   @click="saveRule(o.id)">保存
        </el-button>
      </div>
      <div>
        <span style="font-family:'微软雅黑';font-weight: bold">
          规则条件：
        </span>
        <span v-if='!o.isChange'> {{ o.ruleValue }}</span>
        <el-input v-model="o.ruleValue" style="width: 600px" v-else>
        </el-input>
      </div>
      <div style="margin-top: 10px">
        <span style="font-family:'微软雅黑';font-weight: bold">
          规则分数：</span><span v-if='!o.isChange'>{{ o.score }}</span>
        <el-input-number style="margin-left: 5px" v-else v-model="o.score"></el-input-number>
      </div>

    </el-card>
    <el-button style="margin-left: 30px;width: 800px;margin-top: 20px"
               type="primary"
               @click="addNewRule">新建规则文件
    </el-button>
  </div>
</template>

<script>

import {addRule, getRules} from '@/api/rule'
import Message from "element-ui/packages/message/src/main";

export default {
  name: 'policy.vue',
  data() {
    return {
      ruleModel: {
        id: '',
        ruleName: '',
        awardeeType: '',
        createBy: '',
        createTime: '',
        event: '',
        isDelete: '',
        isSmsNotice: '',
        priority: '',
        ruleValue: '',
        score: '',
        sendAwardTimes: '',
        taskId: '',
        updateBy: '',
        updateTime: ''
      },
      isChange: false,
      ruleList: []
    }
  },
  mounted() {
    this.getRules4Page()
  },
  created() {
  },
  methods: {
    getRules4Page() {
      getRules()
        .then(res => {
          this.ruleList = res.data.data
          this.ruleList.forEach(tt => {
            this.$set(tt, 'isChange', false)
          })
        })
    },
    changeRule(id) {
      let flag = true
      this.ruleList.forEach(res => {
        if (res.isChange === true) {
          Message.error('请先编辑并保存未保存的规则')
          flag = false;
        }
      })
      if(flag){
        this.ruleList.forEach(res => {
          if (res.id === id) {
            res.isChange = true;
          }
        })
      }
    },
    addRule4Page(param) {
      addRule(param)
        .then(res => {
          if (res.data.msg === 'success') {
            Message.success('保存成功！')
          }
        })
    },
    saveRule(id) {
      this.ruleList.forEach(res => {
        if (res.id === id) {
          res.isChange = false;
          this.ruleModel.id = id;
          this.ruleModel.ruleName = res.ruleName;
          this.ruleModel.awardeeType = res.awardeeType;
          this.ruleModel.createBy = res.createBy;
          this.ruleModel.createTime = res.createTime;
          this.ruleModel.event = res.event;
          this.ruleModel.isDelete = res.isDelete;
          this.ruleModel.isSmsNotice = res.isSmsNotice;
          this.ruleModel.priority = res.priority;
          this.ruleModel.ruleValue = res.ruleValue;
          this.ruleModel.score = res.score;
          this.ruleModel.sendAwardTimes = res.sendAwardTimes;
          this.ruleModel.taskId = res.taskId;
          this.ruleModel.updateBy = res.updateBy;
          this.ruleModel.updateTime = res.updateTime;
        }
      })
      this.addRule4Page(this.ruleModel)
    },
    addNewRule() {
      let flag = true
      this.ruleList.forEach(res => {
        if (res.id === '') {
          Message.error('请先编辑并保存未保存的规则')
          flag = false;
        }
      })
      if (flag) {
        this.ruleList.push(
          {
            id: '',
            ruleName: '',
            awardeeType: '',
            createBy: '',
            createTime: '',
            event: '',
            isDelete: '',
            isSmsNotice: '',
            priority: '',
            ruleValue: '',
            score: '',
            sendAwardTimes: '',
            taskId: '',
            updateBy: '',
            updateTime: '',
            isChange: true
          })
      }
    }
  }
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 800px;
}
</style>
