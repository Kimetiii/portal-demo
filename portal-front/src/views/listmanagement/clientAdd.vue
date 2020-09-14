<template>
  <div>
    <div id="container" style="width:1600px;margin-left: 50px;margin-top: 40px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
      <el-tabs :tab-position="left" style="margin-left: 20px;margin-top: 40px">
        <el-tab-pane label="借款人基本信息">
          <span>借款人基本信息</span>
          <el-form :model="basicInfo" :rules="rules" ref="ruleForm" label-position="right" style="width:800px;height:800px;margin-left: 100px;padding-top: 10px" label-width="100px" class="demo-ruleForm" lable="借款人基本信息">
            <el-form-item label="渠道来源" prop="resources">
              <el-select v-model="basicInfo.resources" placeholder="请选择渠道来源">
                <el-option label="渠道" value="channel"></el-option>
                <el-option label="客户经理" value="Manager"></el-option>
                <el-option label="本人" value="self"></el-option>
                <el-option label="客户转介" value="referral"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="姓名" prop="name">
              <el-input v-model="basicInfo.name"></el-input>
            </el-form-item>
            <el-form-item label="曾用名" prop="fomerName">
              <el-input v-model="basicInfo.fomerName"></el-input>
            </el-form-item>
            <el-form-item label="身份证号" prop="ID">
              <el-input v-model="basicInfo.ID"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="gender">
              <el-select v-model="basicInfo.gender" placeholder="请选择性别">
                <el-option label="男" value="male"></el-option>
                <el-option label="女" value="female"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="手机号" prop="tele">
              <el-input v-model="basicInfo.tele"></el-input>
            </el-form-item>
            <el-form-item label="学历情况" prop="education">
              <el-select v-model="basicInfo.education" placeholder="请选择学历">
                <el-option label="博士研究生毕业" value="doctoral"></el-option>
                <el-option label="硕士研究生毕业" value="master"></el-option>
                <el-option label="大学本科生毕业" value="bachelor"></el-option>
                <el-option label="大学专科生毕业" value="juniorCollege"></el-option>
                <el-option label="中等职业教育" value="vocational"></el-option>
                <el-option label="普通高级中学毕业" value="general"></el-option>
                <el-option label="初级中学教育" value="junior"></el-option>
                <el-option label="小学教育" value="primary"></el-option>
                <el-option label="其他" value="others"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="居住地址" prop="residenceAdress">
              <v-distpicker province="" city="" area="" v-model="basicInfo.residenceAdress"></v-distpicker>
            </el-form-item>
            <el-form-item label="健康状况" prop="physicalCondition">
              <el-input v-model="basicInfo.physicalCondition"></el-input>
            </el-form-item>
            <el-form-item label="户口性质" prop="residenceType">
              <el-select v-model="basicInfo.residenceType" placeholder="请选择户口性质">
                <el-option label="农户" value="rural"></el-option>
                <el-option label="非农户" value="NOrural"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="客户标签" prop="clientTag">
              <el-select v-model="basicInfo.clientTag" placeholder="请选择客户标签">
                <el-option label="资源户" value="resource"></el-option>
                <el-option label="非资源户" value="NOresource"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="家庭信息">
          <span>家庭信息</span>
          <el-form :model="familyInfo" :rules="rules" ref="ruleForm" label-position="right" style="width:800px;height:800px;margin-left: 100px;padding-top: 10px" label-width="100px" class="demo-ruleForm" lable="家庭信息">
            <el-form-item label="婚姻状况">
              <el-radio-group v-model="familyInfo.maritalStatus">
                <el-radio label="未婚"></el-radio>
                <el-radio label="已婚"></el-radio>
                <el-radio label="离异"></el-radio>
                <el-radio label="丧偶"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="家庭人数" prop="familySize">
              <el-input v-model="familyInfo.familySize" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="家庭情况概况" prop="familyCondition">
              <el-input type="textarea" v-model="familyInfo.familyCondition" placeholder="请简要描述家庭情况"></el-input>
            </el-form-item>
            <el-form-item label="家庭成员" prop="familyMembers" style="width: 800px">
              <el-table
                :data="familyInfo.tableData"
                border
                style="width: 100%;margin-bottom: 20px;margin-right: 20px;">
                <el-table-column
                  prop="relationship"
                  label="关系"
                  align="center"
                  width="120">
                  <template slot-scope="scope">
                    <el-form-item v-if="scope.row.edit" :prop="'tableData.' + scope.$index + '.relationship'" :rules='rules.relationship'>
                      <el-select v-model="scope.row.relationship" placeholder="请选择">
                        <el-option label="配偶" value="partner">配偶</el-option>
                        <el-option label="父母" value="parents">父母</el-option>
                        <el-option label="子女" value="child">子女</el-option>
                        <el-option label="亲戚" value="relative">亲戚</el-option>
                        <el-option label="朋友" value="feiends">朋友</el-option>
                        <el-option label="同事" value="colleague">同事</el-option>
                      </el-select>
                    </el-form-item>
                    <span v-else>
                      <p v-if="scope.row.relationship==partner">配偶</p>
                      <p v-if="scope.row.relationship==parents">父母</p>
                      <p v-if="scope.row.relationship==child">子女</p>
                      <p v-if="scope.row.relationship==relative">亲戚</p>
                      <p v-if="scope.row.relationship==feiends">朋友</p>
                      <p v-if="scope.row.relationship==colleague">同事</p>
                    </span>
                  </template>
                </el-table-column>
                <el-table-column
                  prop="name"
                  label="姓名"
                  align="center"
                  width="120">
                  <template slot-scope="scope">
                    <el-form-item v-if="scope.row.edit" :prop="'tableData.' + scope.$index + '.name'" :rules='rules.name'>
                      <el-input v-model="scope.row.name" placeholder="姓名"></el-input>
                    </el-form-item>
                    <span v-else>{{scope.row.name}}</span>
                  </template>
                </el-table-column>
                <el-table-column
                  prop="occupation"
                  label="职业"
                  align="center"
                  width="120">
                  <template slot-scope="scope">
                    <el-form-item v-if="scope.row.edit" :prop="'tableData.' + scope.$index + '.occupation'" :rules='rules.occupation'>
                      <el-select v-model="scope.row.occupation" placeholder="请选择">
                        <el-option label="办事人员和有关人员" value="handler"></el-option>
                        <el-option label="社会生产服务和生活服务人员" value="serviceStaff"></el-option>
                        <el-option label="军人" value="soldier"></el-option>
                        <el-option label="党的机关、国家机关、群众团体和社会组织、企业单位负责人" value="leader"></el-option>
                        <el-option label="农、林、牧、渔业生产及辅助人员" value="farmer"></el-option>
                        <el-option label="专业技术人员" value="technicalPersonnel"></el-option>
                        <el-option label="生产制造及有关人员" value="manufacturingPersonnel"></el-option>
                        <el-option label="其他不便分类的工作人员" value="others"></el-option>
                      </el-select>
                    </el-form-item>
                    <span v-else>
                      <p v-if="scope.row.occupation==partner">办事人员和有关人员</p>
                      <p v-if="scope.row.occupation==serviceStaff">社会生产服务和生活服务人员</p>
                      <p v-if="scope.row.occupation==soldier">军人</p>
                      <p v-if="scope.row.occupation==leader">党的机关、国家机关、群众团体和社会组织、企业单位负责人</p>
                      <p v-if="scope.row.occupation==farmer">农、林、牧、渔业生产及辅助人员</p>
                      <p v-if="scope.row.occupation==technicalPersonnel">专业技术人员</p>
                      <p v-if="scope.row.occupation==manufacturingPersonnel">生产制造及有关人员</p>
                      <p v-if="scope.row.occupation==others">其他不便分类的工作人员</p>
                    </span>
                  </template>
                </el-table-column>
                <el-table-column
                  label="健康状况"
                  align="center"
                  width="100">
                </el-table-column>
                <el-table-column
                  label="手机号码"
                  align="center"
                  width="180">
                </el-table-column>
                <el-table-column
                  label="操作"
                  align="center"
                  width="58">
                </el-table-column>
              </el-table>
              <el-button type="success" @click="addFamilyMenbers" size="mini">添加家庭成员</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="居住信息">
          <span>居住信息</span>
          <el-form :model="residenceInfo" :rules="rules" ref="ruleForm" label-position="right" style="width:800px;height:800px;margin-left: 100px;padding-top: 10px" label-width="100px" class="demo-ruleForm" lable="居住信息">
            <el-form-item label="居住地址" prop="residenceAdress">
              <v-distpicker province="" city="" area="" v-model="residenceInfo.residenceAdress"></v-distpicker>
            </el-form-item>
            <el-form-item label="详细地址" prop="detailedAddress">
              <el-input v-model="residenceInfo.detailedAddress" placeholder="请具体到街道小区/村组"></el-input>
            </el-form-item>
            <el-form-item label="居住状态" prop="residentialStatus">
              <el-select v-model="residenceInfo.residentialStatus" placeholder="请选择">
                <el-option label="自购无贷" value="Noloan"></el-option>
                <el-option label="自购按揭" value="mortgage"></el-option>
                <el-option label="集体宿舍" value="dormitory"></el-option>
                <el-option label="租房" value="Renting"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="居住年限" prop="residentialLength">
              <el-input-number v-model="residenceInfo.residentialLength" controls-position="right" @change="handleChange" :min="1"></el-input-number>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="就业信息">
          <span>就业信息</span>
          <el-form :model="employ" :rules="rules" ref="ruleForm" label-position="right" style="width:800px;height:800px;margin-left: 100px;padding-top: 10px" label-width="100px" class="demo-ruleForm" lable="就业信息">
            <el-form-item label="单位名称" prop="name">
              <el-input v-model="employ.name" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="单位电话" prop="tele">
              <el-input v-model="employ.tele" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="单位地址" prop="adress">
              <v-distpicker province="" city="" area="" v-model="employ.address"></v-distpicker>
            </el-form-item>
            <el-form-item label="详细地址" prop="detailedAddress">
              <el-input v-model="employ.detailedAddress" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="行业类型" prop="businessType" size="120px">
              <el-select v-model="employ.businessType" placeholder="请选择" >
                <el-option label="农、林、牧、渔业" value="agriculture"></el-option>
                <el-option label="采矿业" value="mining"></el-option>
                <el-option label="制造业" value="manufacturing"></el-option>
                <el-option label="电力、热力、燃气以及水生产和供效应" value="power"></el-option>
                <el-option label="建筑业" value="construction"></el-option>
                <el-option label="信息传输、软件和信息技术服务业" value="infomation"></el-option>
                <el-option label="金融业" value="finance"></el-option>
                <el-option label="房地产业" value="realEstate "></el-option>
                <el-option label="租赁和商务服务业" value="leasing"></el-option>
                <el-option label="科学研究和技术服务业" value="scientificResearch"></el-option>
                <el-option label="水利、环境和公共设施管理业" value="waterConservancy"></el-option>
                <el-option label="居民服务、修理和其他服务业" value="residentServices"></el-option>
                <el-option label="教育" value="education"></el-option>
                <el-option label="卫生和社会工作" value="hygienism"></el-option>
                <el-option label="文化、体育和娱乐业" value="culture"></el-option>
                <el-option label="公共管理、社会保障和社会组织" value="publicManagement"></el-option>
                <el-option label="国际组织" value="internationalOrganization"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="职业" prop="employ" >
              <el-select v-model="employ.occupation" placeholder="请选择">
                <el-option label="办事人员和有关人员" value="handler"></el-option>
                <el-option label="社会生产服务和生活服务人员" value="serviceStaff"></el-option>
                <el-option label="军人" value="soldier"></el-option>
                <el-option label="党的机关、国家机关、群众团体和社会组织、企业单位负责人" value="leader"></el-option>
                <el-option label="农、林、牧、渔业生产及辅助人员" value="famer"></el-option>
                <el-option label="专业技术人员" value="technicalPersonnel"></el-option>
                <el-option label="生产制造及有关人员" value="manufacturingPersonnel"></el-option>
                <el-option label="其他不便分类的工作人员" value="others"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="职务" prop="employ" >
              <el-select v-model="employ.post" placeholder="请选择">
                <el-option label="一般员工" value="generalStaff"></el-option>
                <el-option label="中层领导" value="middleLeaders"></el-option>
                <el-option label="高层领导" value="senioreaders"></el-option>
                <el-option label="企业主" value="businessOwners"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="工作年限" prop="employ">
              <el-input-number v-model="employ.workingLength" controls-position="right" @change="handleChange" :min="0"></el-input-number>
            </el-form-item>
            <el-form-item label="年薪" prop="yearlySalarye">
              <el-input v-model="employ.yearlySalary" placeholder="请输入">
                <i slot="suffix" style="font-style:normal;margin-right: 20px;">万元</i>
              </el-input>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="公司信息">
          <span>公司信息</span>
          <el-form :model="company" :rules="rules" ref="ruleForm" label-position="right" style="width:800px;height:1500px;margin-left: 100px;padding-top: 10px" label-width="140px" class="demo-ruleForm" lable="公司信息">
            <el-form-item label="公司名称" prop="name">
              <el-input v-model="company.name" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="法人代表" prop="juridicalPerson">
              <el-input v-model="company.juridicalPerson" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="注册时间" prop="registrationDate">
              <div class="block">
                <el-date-picker
                  v-model="company.registrationDate"
                  type="datetime"
                  placeholder="选择日期时间">
                </el-date-picker>
              </div>
            </el-form-item>
            <el-form-item label="统一社会信用代码" prop="creditCode">
              <el-input v-model="company.creditCode" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="注册资金" prop="registeredCapital">
              <el-input v-model="company.registeredCapital" placeholder="请输入">
                <i slot="suffix" style="font-style:normal;margin-right: 20px;">元</i>
              </el-input>
            </el-form-item>
            <el-form-item label="行业类型" prop="businessType" size="120px">
              <el-select v-model="company.businessType" placeholder="请选择" >
                <el-option label="农、林、牧、渔业" value="agriculture"></el-option>
                <el-option label="采矿业" value="mining"></el-option>
                <el-option label="制造业" value="manufacturing"></el-option>
                <el-option label="电力、热力、燃气以及水生产和供效应" value="power"></el-option>
                <el-option label="建筑业" value="construction"></el-option>
                <el-option label="信息传输、软件和信息技术服务业" value="infomation"></el-option>
                <el-option label="金融业" value="finance"></el-option>
                <el-option label="房地产业" value="realEstate "></el-option>
                <el-option label="租赁和商务服务业" value="leasing"></el-option>
                <el-option label="科学研究和技术服务业" value="scientificResearch"></el-option>
                <el-option label="水利、环境和公共设施管理业" value="waterConservancy"></el-option>
                <el-option label="居民服务、修理和其他服务业" value="residentServices"></el-option>
                <el-option label="教育" value="education"></el-option>
                <el-option label="卫生和社会工作" value="hygienism"></el-option>
                <el-option label="文化、体育和娱乐业" value="culture"></el-option>
                <el-option label="公共管理、社会保障和社会组织" value="publicManagement"></el-option>
                <el-option label="国际组织" value="internationalOrganization"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="主营业务" prop="mainBusiness">
              <el-input v-model="company.mainBusiness" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="经营性质" prop="natureOfOperation" size="120px">
              <el-select v-model="company.natureOfOperation" placeholder="请选择" >
                <el-option label="国有企业" value="stateEnterprise"></el-option>
                <el-option label="集体企业" value="collectiveEnterprise"></el-option>
                <el-option label="联营企业" value="JointVenture"></el-option>
                <el-option label="股份合作制企业" value="jointStockCooperativeEnterprise"></el-option>
                <el-option label="个体户" value="selfEmployed"></el-option>
                <el-option label="合伙企业" value="partnership"></el-option>
                <el-option label="责任有限公司" value="limitedLiabilityCompany"></el-option>
                <el-option label="股份有限公司" value="limitedCompany"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="经营年限" prop="yearsOfOperation">
              <el-input v-model="company.yearsOfOperation" placeholder="请输入">
                <i slot="suffix" style="font-style:normal;margin-right: 20px;">年</i>
              </el-input>
            </el-form-item>
            <el-form-item label="经营面积" prop="businessArea">
              <el-input v-model="company.businessArea" placeholder="请输入">
                <i slot="suffix" style="font-style:normal;margin-right: 20px;">m²</i>
              </el-input>
            </el-form-item>
            <el-form-item label="经营场所类型" prop="businessPlaceType" size="120px">
              <el-select v-model="company.businessPlaceType" placeholder="请选择" >
                <el-option label="租赁" value="lease"></el-option>
                <el-option label="自建" value="buildByOneself"></el-option>
                <el-option label="自置" value="owned"></el-option>
                <el-option label="合租" value="jointTenancy"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="其他经营" prop="otherBusiness">
              <el-input v-model="company.otherBusiness" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="注册地址" prop="residenceAdress">
              <v-distpicker province="" city="" area="" v-model="company.registeredAddress"></v-distpicker>
            </el-form-item>
            <el-form-item label="注册详细地址" prop="registeredDetailedAddress">
              <el-input v-model="company.registeredDetailedAddress" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="办公地址" prop="officeAddress">
              <v-distpicker province="" city="" area="" v-model="company.officeAddress"></v-distpicker>
            </el-form-item>
            <el-form-item label="办公详细地址" prop="officeDetailedAddress">
              <el-input v-model="company.officeDetailedAddress" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="邮编" prop="postcode">
              <el-input v-model="company.postcode" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="联系人" prop="contact">
              <el-input v-model="company.contact" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item label="联系电话" prop="contactNumber">
              <el-input v-model="company.contactNumber" placeholder="请输入"></el-input>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import VDistpicker from 'v-distpicker'
export default {
  components: { VDistpicker },
  name:  'clientAdd',
  data() {
    return {
      basicInfo: {
        name: '',
        resources: '',
        fomerName: '',
        ID: '',
        gender: '',
        tele: [],
        education: '',
        residenceAdress: '',
        physicalCondition: '',
        residenceType: '',
        clientTag: ''
      },
      familyInfo: {
        maritalStatus: '',
        familySize: '',
        familyMembers: '',
        familyCondition: '',
        tableData: []
      },
      residenceInfo: {
        residentialAddress: '',
        detailedAddress: '',
        residentialStatus: '',
        residentialLength: '1'
      },
      employ: {
        name: '',
        tele: '',
        address: '',
        detailedAddress: '',
        businessType: '',
        occupation: '',
        post: '',
        workingLength: '',
        yearlySalary: '',
        contact: ''
      },
      company: {
        name: '',
        juridicalPerson: '',
        registrationDate: '',
        creditCode: '',
        registeredCapital: '',
        businessType: '',
        mainBusiness: '',
        natureOfOperation: '',
        yearsOfOperation: '',
        businessArea: '',
        businessPlaceType: '',
        otherBusiness: '',
        registeredAddress: '',
        registeredDetailedAddress: '',
        officeAddress: '',
        officeDetailedAddress: '',
        postcode: '',
        contact: '',
        contactNumber: '',
        shareholderInformation: ''
      },

      rules: {
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
<style scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
   margin-bottom: 0;
 }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.bg-white{
  background: white;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.box-card {
  width: 480px;
}
</style>
