<template>
  <div>
    <div id="container" style="width:95%;margin-left: 20px;margin-top: 40px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
      <el-form :inline="true" :model="listConfig" class="demo-form-inline" style="width:1500px;margin-left: 10px;padding-top: 10px">
        <el-form-item style="margin-left: 10px" label="客户来源">
          <el-select v-model="listConfig.clientResources" placeholder="活动区域">
            <el-option label="渠道" value="channel"></el-option>
            <el-option label="客户经理" value="Manager"></el-option>
            <el-option label="本人" value="self"></el-option>
            <el-option label="客户转介" value="referral"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户姓名">
          <el-input v-model="listConfig.clientName" placeholder="请输入"></el-input>
        </el-form-item>
        <el-button type="text" @click="flodChange">{{foldStatus}}</el-button>
        <el-form :inline="true" :model="listConfig" v-if="foldCode==1"  class="demo-form-inline" style="margin-left: 10px;padding-top: 10px">
          <el-form-item label="证件号码">
            <el-input v-model="listConfig.clientID" placeholder="请输入" style="width: 150px"></el-input>
          </el-form-item>
          <el-form-item style="margin-left: 20px" label="客户号">
            <el-input v-model="listConfig.clientNumber" placeholder="请输入"></el-input>
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
          <el-button type="primary"  @click="searchCustomerList()" style="margin-left: 20px">查询</el-button>
          <el-button class="button" @click="resetForm">重置</el-button>
          <el-button type="success" onclick="location='http://dut.portal.com:8080/#/ListManagement/clientAdd'">新增</el-button>
        </el-form-item>
      </el-form>
      <div>
<!--        <el-dialog title="编辑" :visible.sync="dialogFormVisible" width="30%" :before-close="handleClose" append-to-body="true">-->
        <el-dialog title="编辑" :visible.sync="dialogFormVisible" width="80%" >
          <p>这是一个弹出框</p>
          <el-form :model="customerInfo" >
            <el-form-item label="客户号" style="width: 500px">
              <el-input v-model="customerInfo.id" autocomplete="off"></el-input>
            </el-form-item>

          </el-form>

          <div>
<!--            <el-button type="primary" @click.native.prevent="editSubForm" :loading="addLoading">确定</el-button>-->
            <el-button type="primary" >保存</el-button>
            <el-button @click.native.prevent="dialogFormVisible=false">退出</el-button>
          </div>
        </el-dialog>
      </div>
      <el-table
        :data="partOfData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        height="620px"
        border
        style="width: 1400px;height:640px;margin-left: 20px;margin-bottom: 20px;margin-right: 20px;">
        <el-table-column prop="channelSource" align="center" label="客戶來源" width="200">
          <template slot-scope="scope">
            {{ scope.row.channelSource }}
          </template>
        </el-table-column>
        <el-table-column prop="id" align="center" label="客戶号" width="200">
          <template slot-scope="scope">
            {{ scope.row.id }}
          </template>
        </el-table-column>
        <el-table-column align="center" prop="name" label="姓名" width="200">
          <template slot-scope="scope">
            {{ scope.row.name }}
          </template>
        </el-table-column>
        <el-table-column align="center" prop="idNumber" label="证件号码" width="200">
          <template slot-scope="scope">
            {{ scope.row.idNumber }}
          </template>
        </el-table-column>
        <el-table-column prop="phone" align="center" label="手机号" width="300">
          <template slot-scope="scope">
            {{ scope.row.phone }}
          </template>
        </el-table-column>
        <el-table-column
          prop="control"
          align="center"
          label="操作"
          width="290">
          <template slot-scope="scope">
            <el-button @click.native.prevent="queryByID(scope.row.id)" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="block" style="margin-top:15px;">
        <el-pagination  @size-change="handleSizeChange" @current-change="handleCurrentChange"
             :current-page="currentPage"
             :page-sizes="[10,15,20]"
             :page-size="pageSize"
             layout="total, sizes, prev, pager, next, jumper"
             :total="partOfData.length"
             style="margin-left: 500px">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
  import {findAll} from "@/api/customer";
  import {getCustomerById} from "@/api/customer";
  import {searchCustomerList} from "@/api/customer";

  export default {
  data() {
    return {
      listConfig: {
        clientResources: '',
        client: '',
        clientName: '',
        clientNumber: '',
        clientID: '',
        settingTime: '',
        Manager: ''
      },
      customerInfo:{
        id: '',
        name: '',
        channelSource: '',
        formerName: '无',
        idNumber: '',
        sex: '',
        phone: '',
        educational: '',
        residenceAddress: '',
        healthStatus: '',
        accountNature: '',
        customerLabel: '',
        maritalStatus: '',
        familySize: '',
        summaryOfFamilyStatus: '',
        // familyMembers: '',
        // partOfData: [],
        residentialAddress: '',
        address: '',
        residentialStatus: '',
        lengthOfResidence: '1',
        companyName: '',
        workPhone: '',
        unitAddress: '',
        unitDetailAddress: '',
        industryType: '',
        profession: '',
        position: '',
        workingYears: '',
        annualSalary: '',
        // contact: '',
        // partOfData: [],
        familyMonthlyIncome: '',
        numberOfDependents: '',
        assetsToLiabilitiesRatio: '',
        LoanToIncomeRatio: '',
        averagePersonalIncome: '',
        repaymentToIncomeRatio: '',
        familyPropertyAssessment: '',
        debtCoverageRatio: '',
        repaymentRecord: '',
        recordsAndYears: '',
        breachOfContract: '',
        overdraftSituation: '',
        bankCardSituation: '',
        creditCardDefault: '',
        judicialRecords: '',
        creditScore: ''
      },
      fold: '',
      foldCode: '0',
      foldStatus: '展开',
      activeNames: ['1'],
      dialogFormVisible: false,
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
      partOfData: [],
      currentPage: 1, // 当前页码
      total: '', // 总条数
      pageSize: 10 // 每页的数据条数
    }
  },
    mounted() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.listLoading = true
        findAll()
          .then(res => {
           console.log(res.data.data)
          this.partOfData = res.data.data
          this.listLoading = false
        })
      },
      searchCustomerList(para){
        console.log(para)
     getCustomerById(para).then((res)=>
        {
          console.log(res.data)
        })
      },
      queryByID:function (params) {
        console.log(params)
        // this.dialogFormVisible=true
        getCustomerById(params).then((res)=>{
          console.log(res.data)
        })
      },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
      this.currentPage = 1
      this.pageSize = val
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
      this.currentPage = val
    },
    onSubmit() {
      console.log('submit!')
    },
    handleChange(val) {
      console.log(val)
    },
    flodChange() {
      if (this.foldCode == 0) {
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
    },
    handleDelete() {
      this.partOfData.splice(index, 1)
    }
  }
}
</script>
<style scoped>
</style>
