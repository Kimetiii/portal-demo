<template>
  <div>
    <div id="container" style="width:95%;margin-left: 20px;margin-top: 40px;border-radius: 0px">
      <el-form :inline="true" :model="listConfig" class="demo-form-inline" style="width:1500px;padding-top: 10px;border-radius: 30px">
        <div style="margin-left:140px;">
          <el-form-item style="margin-left: 10px" label="客户来源" prop="channelSource">
            <el-select v-model="listConfig.channelSource" placeholder="活动区域">
              <el-option label="" value=""></el-option>
              <el-option label="渠道" value="channel"></el-option>
              <el-option label="客户经理" value="Manager"></el-option>
              <el-option label="本人" value="self"></el-option>
              <el-option label="客户转介" value="referral"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="客户姓名" prop="name">
            <el-input v-model="listConfig.name" placeholder="请输入" auto-complete="off"></el-input>
          </el-form-item>
          <el-button type="text" @click="foldChange">{{foldStatus}}</el-button>
          <el-form-item class="margin" v-if="foldCode===0">
            <el-button type="primary"  @click="search()" style="margin-left: 20px">查询</el-button>
            <el-button type="success" onclick="location='http://dut.portal.com:8080/#/ListManagement/clientAdd'">新增</el-button>
            <el-button class="button" @click="resetForm">重置</el-button>
          </el-form-item>
        </div>
        <el-form :inline="true" :model="listConfig" v-if="foldCode==1"  class="demo-form-inline" style="padding-top: 10px;margin-left: 150px">
          <el-form-item label="证件号码" prop="idNumber">
            <el-input v-model="listConfig.idNumber" placeholder="请输入" style="width: 150px"></el-input>
          </el-form-item>
          <el-form-item style="margin-left: 20px" label="客户号" prop="id">
            <el-input v-model="listConfig.id" placeholder="请输入"></el-input>
          </el-form-item>
          <el-form-item label="经办客户经理" prop="responsible">
            <el-select v-model="listConfig.responsible" placeholder="请选择">
              <el-option label="" value=""></el-option>
              <el-option label="张三" value="张三"></el-option>
              <el-option label="李四" value="李四"></el-option>
              <el-option label="王五" value="王五"></el-option>
              <el-option label="赵六" value="赵六"></el-option>
            </el-select>
          </el-form-item>
          <el-button type="primary"  @click="search()" style="margin-left: 20px" trigger="click">查询</el-button>
          <el-button type="success" onclick="location='http://dut.portal.com:8080/#/ListManagement/clientAdd'">新增</el-button>
          <el-button class="button" @click="resetForm">重置</el-button>
        </el-form>
      </el-form>
      <div>
        <el-dialog :visible.sync="dialogFormVisible" width="60%">
          <div style="font-size: 16px;color: cornflowerblue;margin: 0 auto" >用户:{{this.customerInfo.name}}</div>
          <el-form :model="customerInfo" aria-readonly="true" >
            <el-tabs style="margin-left: 20px;margin-top: 40px">
              <el-tab-pane label="基本信息">
                <h2 style="font-size: 16px;color: cornflowerblue">基本信息</h2>
                <el-form-item label="客户号" prop="id" >
                  <el-input v-model="customerInfo.id" autocomplete="off" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="渠道来源" prop="channelSource">
                  <el-input v-model="customerInfo.channelSource" autocomplete="off" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                  <el-input v-model="customerInfo.name" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="曾用名" prop="fomerName">
                  <el-input v-model="customerInfo.formerName" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="idNumber">
                  <el-input v-model="customerInfo.idNumber" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                  <el-input v-model="customerInfo.sex" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="手机号" prop="phone">
                  <el-input v-model="customerInfo.phone" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="学历情况" prop="educational">
                  <el-input v-model="customerInfo.educational" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="户籍地址" prop="residenceAddress">
                  <el-input v-model="customerInfo.residenceAddress" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="健康状况" prop="healthStatus">
                  <el-input v-model="customerInfo.healthStatus" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="户口性质" prop="accountNature">
                  <el-input v-model="customerInfo.accountNature" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="客户标签" prop="customerLabel">
                  <el-input v-model="customerInfo.customerLabel" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="经办客户经理" prop="responsible">
                  <el-input v-model="customerInfo.responsible" readonly="readonly"></el-input>
                </el-form-item>
              </el-tab-pane>
              <el-tab-pane label="家庭信息">
                <h2 style="font-size: 16px;color: cornflowerblue">家庭信息</h2>
                <el-form-item label="婚姻状况">
                  <el-radio-group v-model="customerInfo.maritalStatus" v-bind:disabled="editCode">
                    <el-radio label="未婚"></el-radio>
                    <el-radio label="已婚"></el-radio>
                    <el-radio label="离异"></el-radio>
                    <el-radio label="丧偶"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="家庭人数" prop="familySize">
                  <el-input v-model="customerInfo.familySize" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="家庭情况概况" prop="summaryOfFamilyStatus">
                  <el-input type="textarea" v-model="customerInfo.summaryOfFamilyStatus" readonly="readonly"></el-input>
                </el-form-item>
              </el-tab-pane>
              <el-tab-pane label="居住信息">
                <h2 style="font-size: 16px;color: cornflowerblue">居住信息</h2>
                <el-form-item label="居住地址" prop="residentialAddress">
                  <el-input v-model="customerInfo.residentialAddress" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="详细地址" prop="address">
                  <el-input v-model="customerInfo.address" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="居住状态" prop="residentialStatus">
                  <el-input v-model="customerInfo.residentialStatus" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="居住年限" prop="lengthOfResidence">
                  <el-input-number v-model="customerInfo.lengthOfResidence" v-bind:disabled="editCode" controls-position="right" :min="1"></el-input-number>
                </el-form-item>
              </el-tab-pane>
              <el-tab-pane label="就业信息">
                <h2 style="font-size: 16px;color: cornflowerblue">就业信息</h2>
                <el-form-item label="单位名称" prop="companyName">
                  <el-input v-model="customerInfo.companyName" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="单位电话" prop="workPhone">
                  <el-input v-model="customerInfo.workPhone"readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="单位地址" prop="unitAddress">
                  <el-input v-model="customerInfo.unitAddress" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="详细地址" prop="unitDetailAddress">
                  <el-input v-model="customerInfo.unitDetailAddress" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="行业类型" prop="industryType" size="120px">
                  <el-input v-model="customerInfo.industryType"  readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="职业" prop="profession" >
                  <el-input v-model="customerInfo.profession" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="职务" prop="position" >
                  <el-input v-model="customerInfo.position" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="工作年限" prop="workingYears">
                  <el-input-number v-model="customerInfo.workingYears" v-bind:disabled="editCode" controls-position="right" :min="0"></el-input-number>
                </el-form-item>
                <el-form-item label="年薪" prop="annualSalary">
                  <el-input v-model="customerInfo.annualSalary" readonly="readonly">
                    <i slot="suffix" style="font-style:normal;margin-right: 20px;">万元</i>
                  </el-input>
                </el-form-item>
              </el-tab-pane>
              <el-tab-pane label="经济状况">
                <h2 style="font-size: 16px;color: cornflowerblue">经济状况</h2>
                <el-form-item label="家庭月收入" prop="familyMonthlyIncome">
                  <el-input v-model="customerInfo.familyMonthlyIncome" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="抚养人数" prop="numberOfDependents">
                  <el-input v-model="customerInfo.numberOfDependents" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="资产与负债比" prop="assetsToLiabilitiesRatio">
                  <el-input v-model="customerInfo.assetsToLiabilitiesRatio" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="收入还贷比" prop="LoanToIncomeRatio">
                  <el-input v-model="customerInfo.LoanToIncomeRatio" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="个人年平均收入" prop="averagePersonalIncome">
                  <el-input v-model="customerInfo.familyMonthlyIncome" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="月还款额与月可支配收入比值" prop="repaymentToIncomeRatio">
                  <el-input v-model="customerInfo.repaymentToIncomeRatio" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="家庭财产评估值" prop="familyPropertyAssessment">
                  <el-input v-model="customerInfo.familyPropertyAssessment" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="债务覆盖率" prop="debtCoverageRatio">
                  <el-input v-model="customerInfo.debtCoverageRatio" readonly="readonly"></el-input>
                </el-form-item>
              </el-tab-pane>
              <el-tab-pane label="信用状况">
                <h2 style="font-size: 16px;color: cornflowerblue">信用状况</h2>
                <el-form-item label="还款记录" prop="repaymentRecord">
                  <el-input v-model="customerInfo.repaymentRecord" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="个人贷款或信用卡记录和年限" prop="recordsAndYears">
                  <el-input v-model="customerInfo.recordsAndYears" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="违约情况" prop="breachOfContract">
                  <el-input v-model="customerInfo.breachOfContract" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="信用卡透支情况等方面的详细调查" prop="overdraftSituation">
                  <el-input v-model="customerInfo.overdraftSituation" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="银行卡持有情况及银行账户情况" prop="bankCardSituation" >
                  <el-input v-model="customerInfo.bankCardSituation" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="个人贷款或信用卡违约情况" prop="creditCardDefault">
                  <el-input v-model="customerInfo.creditCardDefault" readonly="readonly"></el-input>
                </el-form-item>
                <el-form-item label="公安司法的不良记录" prop="judicialRecords">
                  <el-input v-model="customerInfo.judicialRecords" readonly="readonly" ></el-input>
                </el-form-item>
                <el-form-item label="个人信用度评分" prop="creditScore">
                  <el-input v-model="customerInfo.creditScore" readonly="readonly"></el-input>
                </el-form-item>
              </el-tab-pane>
            </el-tabs>
          </el-form>
          <div>
            <el-button type="danger"  style="margin-left: 950px" @click.native.prevent="dialogFormVisible=false">退出</el-button>
          </div>
        </el-dialog>
      </div>
      <el-table
        :data="partOfData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        border
        v-loading.fullscreen.lock="fullscreenLoading"
        element-loading-text="拼命加载中"
        element-loading-spinner="el-icon-loading"
        style="margin-left:100px;margin-top: 20px;width: 1200px">
        <el-table-column prop="channelSource" align="center" label="客戶來源" width="200px">
          <template slot-scope="scope">
            {{ scope.row.channelSource }}
          </template>
        </el-table-column>
        <el-table-column align="center" prop="name" label="姓名" width="200px">
          <template slot-scope="scope">
            {{ scope.row.name }}
          </template>
        </el-table-column>
        <el-table-column align="center" prop="idNumber" label="证件号码" width="200px">
          <template slot-scope="scope">
            {{ scope.row.idNumber }}
          </template>
        </el-table-column>
        <el-table-column prop="phone" align="center" label="手机号" width="300px">
          <template slot-scope="scope">
            {{ scope.row.phone }}
          </template>
        </el-table-column>
        <el-table-column
          prop="control"
          align="center"
          label="操作"
          width="298px">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click.native="$router.push({name:'clientEdit',params:{'id':scope.row.id}})">编辑</el-button>
            <el-button @click.native.prevent="check(scope.row.id)" type="success" size="small">查看</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="block" style="margin-top:15px">
        <el-pagination   @current-change="handleCurrentChange"
             :current-page="currentPage"
             :page-size="pageSize"
             layout="total, prev, pager, next, jumper"
             :total="partOfData.length"
             style="margin-left: 500px">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
  import VDistpicker from 'v-distpicker';
  import {findAll} from "@/api/customer";
  import {getCustomerById} from "@/api/customer";
  import {searchCustomerList} from "@/api/customer";

  export default {
    components: { VDistpicker },
  data() {
    return {
      listConfig: {
        channelSource: '',
        name: '',
        idNumber: '',
        id: '',
        responsible: ''
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
        responsible: '',
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
      foldCode: 0,
      readonly: true,
      editCode: true,
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
      pageSize: 10,// 每页的数据条数
      fullscreenLoading: true
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
          this.partOfData = res.data.data
          this.listLoading = false
            this.fullscreenLoading = false
        })
      },
      search:function() {
        var searchParams = {customerName: this.listConfig.name,
          customerId:this.listConfig.id,
          idNumber:this.listConfig.idNumber,
          channelSource:this.listConfig.channelSource,
          responsible:this.listConfig.responsible};
        searchCustomerList(searchParams).then((res)=>
        {
          if(res.data.data.length==0){
            alert("未找到指定信息！")
            return
          }
          else {
            this.partOfData = res.data.data
          }

        })
      },
      check:function (params) {
         this.dialogFormVisible=true
        getCustomerById(params).then((res)=>{
          this.customerInfo = res.data.data
        })
      },
    // handleSizeChange(val) {
    //   console.log(`每页 ${val} 条`)
    //   this.currentPage = 1
    //   this.pageSize = val
    // },
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
    foldChange() {
      if (this.foldCode == 0) {
        this.foldCode = 1
        this.foldStatus = '收起'
      } else {
        this.foldCode = 0
        this.foldStatus = '展开'
      }
    },
    editChange(){
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
