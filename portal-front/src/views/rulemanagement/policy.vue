<template>
  <div>
    <H2 style="margin-left: 30px"> 编辑drools规则模型</H2>
    <el-card v-for="o in ruleList" class="box-card" style="margin-left: 30px;margin-top: 10px">
      <div slot="header" class="clearfix">
        <span style="font-family:'微软雅黑',serif;font-weight: bold">模型名称：</span>
        <span v-if='!o.isChange'>{{ o.ruleName }}</span>
        <el-input v-model=o.ruleName
                  v-else
                  style="width: 600px"><
        </el-input>
        <el-button type="success"
                   style="float:right"
                   @click="changeRule(o.id)"
                   v-if='!o.isChange'>修改
        </el-button>
        <el-button v-show='o.isChange'
                   v-else
                   type="primary"
                   style="float:right;margin-bottom: 10px"
                   @click="saveRule(o.id)">保存
        </el-button>
      </div>
      <div>
        <span style="font-family:'微软雅黑',serif;font-weight: bold">
          规则条件：
        </span>
        <span v-if='!o.isChange'> {{ o.ruleValue }}</span>
        <el-input v-model="o.ruleValue" style="width: 600px" v-else>
        </el-input>
      </div>
      <div style="margin-top: 10px">
        <span style="font-family:'微软雅黑',serif;font-weight: bold">
          规则分数：</span>
        <span v-if='!o.isChange'>{{ o.score }}</span>
        <el-input-number style="margin-left: 5px"
                         v-else
                         v-model="o.score"></el-input-number>
      </div>
      <div>
        <el-button v-show='o.isChange'
                   type="danger"
                   style="float:right;margin-bottom: 10px"
                   @click="deleteRule4Page(o.id)">删除
        </el-button>
        <el-button v-show='o.isChange'
                   type="info"
                   style="float:right;margin-bottom: 10px;margin-right: 10px"
                   @click="cancel4Page(o.id)">取消
        </el-button>
      </div>
    </el-card>
    <el-button style="margin-left: 30px;width: 800px;margin-top: 20px;font-family:'微软雅黑',serif;font-weight: bold"
               type="primary"
               @click="addNewRule">新建规则文件
    </el-button>
  </div>
</template>

<script>

import {addRule, deleteRuleById, getRules} from '@/api/rule'
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
      if (flag) {
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
          this.getRules4Page()
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
    },
    deleteRule4Page(ruleId) {
      deleteRuleById(ruleId)
        .then(res => {
          if (res.data.msg === 'success') {
            Message.success('删除成功！');
          } else {
            Message.error('删除失败！');
          }
          this.getRules4Page()
        })

    },
    cancel4Page(id) {
      this.ruleList.forEach(res => {
        if (id === '') {
          this.getRules4Page();
        }
        if (id === res.id) {
          res.isChange = false;
        }
      })
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
