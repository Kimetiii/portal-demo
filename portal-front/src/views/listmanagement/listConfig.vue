<template>
  <div>
    <div id="container" style="width:100%;height:850px;margin-left: 20px;margin-top: 40px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
      <el-form :inline="true" :model="listConfig" class="demo-form-inline" style="width:1500px;margin-left: 10px;padding-top: 10px">
        <el-form-item style="margin-left: 20px" label="客户来源">
          <el-select v-model="listConfig.clientResouces" placeholder="活动区域">
            <el-option label="渠道" value="channel"></el-option>
            <el-option label="客户经理" value="Manager"></el-option>
            <el-option label="本人" value="self"></el-option>
            <el-option label="客户转介" value="referral"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户姓名">
          <el-input v-model="listConfig.clientName" placeholder="请输入"></el-input>
        </el-form-item>
        <el-form-item label="证件号码" v-if="foldCode==1">
          <el-input v-model="listConfig.clientID" placeholder="请输入" style="width: 150px"></el-input>
        </el-form-item>
        <el-button type="text" @click="flodchange">{{foldStatus}}</el-button>
        <el-form :inline="true" :model="listConfig" v-if="foldCode==1"  class="demo-form-inline" style="margin-left: 10px;padding-top: 10px">
          <el-form-item style="margin-left: 20px" label="客户号">
            <el-input v-model="listConfig.clientNumber" placeholder="请输入"></el-input>
          </el-form-item>
          <el-form-item label="起止时间">
            <div class="block">
              <!--<span class="demonstration">起止时间</span>-->
              <el-date-picker
                v-model="listConfig.settingTime"
                type="daterange"
                align="right"
                unlink-panels
                range-separator="~"
                start-placeholder="startime"
                end-placeholder="endtime"
                :picker-options="pickerOptions">
              </el-date-picker>
            </div>
          </el-form-item>
          <el-form-item label="经办客户经理">
            <el-select v-model="listConfig.Manager" placeholder="请选择">
              <el-option label="张三" value="shanghai"></el-option>
              <el-option label="李四" value="beijing"></el-option>
              <el-option label="王五" value="beijing"></el-option>
              <el-option label="赵六" value="beijing"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <el-form-item class="margin">
          <el-button type="primary" @click="onSubmit" style="margin-left: 20px">查询</el-button>
          <el-button class="button" @click="resetForm">重置</el-button>
          <el-button type="success">
            <span onclick="location='http://dut.portal.com:8080/#/ListManagement/clientAdd'">新增</span>
          </el-button>
        </el-form-item>
      </el-form>
      <el-table
        :data="tableData"
        height="550"
        border
        style="width: 100%;margin-left: 20px;margin-bottom: 20px;margin-right: 20px;">
        <el-table-column
          prop="clientSource"
          label="客戶來源"
          width="200">
        </el-table-column>
        <el-table-column
          prop="clientName"
          label="姓名"
          width="200">
        </el-table-column>
        <el-table-column
          prop="clientID"
          label="证件号码"
          width="400">
        </el-table-column>
        <el-table-column
          prop="teleNumber"
          label="手机号"
          width="300">
        </el-table-column>
        <el-table-column
          prop="setingTime"
          label="创建时间"
          width="250">
        </el-table-column>
        <el-table-column
          prop="control"
          label="操作"
          width="350">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      listConfig: {
        clientResouces: '',
        client: '',
        clientName: '',
        clientNumber: '',
        clientID: '',
        settingTime: '',
        Manager: ''
      },
      fold: '',
      foldCode: '0',
      foldStatus: '展开',
      activeNames: ['1'],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      value1: '',
      value2: '',
      tableData: [{
        clientSource: '本人',
        clientName: '张三',
        clientID: '421123195002135221',
        teleNumber: '13345642251',
        setingTime: '2020-01-02'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      },
      {
        clientSource: '渠道',
        clientName: '李四',
        clientID: '421123195002135321',
        teleNumber: '15622234456',
        setingTime: '2010-03-13'
      }
      ]
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!')
    },
    handleChange(val) {
      console.log(val);
    },
    open() {
      this.$alert('借款人基本信息', {
        confirmButtonText: '确定',
        callback: action => {
          this.$message({
            type: 'info',
            message: `action: ${ action }`
          })
        }
      })
    },
    flodchange(){
      if ( this.foldCode == 0 ) {
        this.foldCode = 1
        this.foldStatus = '收起'
      } else {
        this.foldCode = 0
        this.foldStatus = '展开'
      }
    },
    resetForm() {
      this.listConfig.clientResouces = ''
      this.listConfig.client = ''
      this.listConfig.clientName = ''
      this.listConfig.clientNumber = ''
      this.listConfig.clientID = ''
      this.listConfig.settingTime = ''
      this.listConfig.Manager = ''
    }
  }
}
</script>
<style scoped>
</style>
