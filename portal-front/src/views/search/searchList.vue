<template>
  <div class="app-container">
    <el-form ref="form" :model="sizeForm" label-width="100px" size="mini">
      <el-form-item label="客户姓名：" style="width: 100px;display: inline-block">
        <el-input v-model="humanInfo.name" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="身份证号：" style="margin-left:200px;width: 100px;display: inline-block">
        <el-input v-model="humanInfo.name" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="所属模型：" style="margin-left:200px;width: 100px;display: inline-block">
        <el-select v-model="value" placeholder="请选择" style="width: 200px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属机构：" style="margin-left:200px;width: 100px;display: inline-block">
        <el-select v-model="value" placeholder="请选择" style="width: 200px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <div style="display: block;margin-left: 20px">
        <el-button type="primary">查询</el-button>
        <el-button>清空</el-button>
      </div>

      <el-table
        :data="humanInfoData"
        style="width: 100%">

        <el-table-column
          type="index"
          width="50">
        </el-table-column>
        <el-table-column
          prop="num"
          label="流水号"
          width="300">
        </el-table-column>
        <el-table-column
          prop="name"
          label="客户姓名"
          width="120">
        </el-table-column>
        <el-table-column
          prop="cardId"
          label="身份证号"
          width="170">
        </el-table-column>
        <el-table-column
          prop="group"
          label="所属机构"
          width="150">
        </el-table-column>
        <el-table-column
          prop="model"
          label="所属模型"
          width="170">
        </el-table-column>
        <el-table-column
          prop="project"
          label="所属项目"
          width="150">
        </el-table-column>
        <el-table-column
          prop="principal"
          label="责任人"
          width="150">
        </el-table-column>
      </el-table>
    </el-form>
  </div>
</template>

<script>
  import {pagePeople} from '@/api/people'

  const sexTypeOptions = [
    {key: '男', display_name: '男'},
    {key: '女', display_name: '女'}
  ]

  export default {
    name: 'people.vue',

    data() {
      return {
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        humanInfoData: [{
          num: 'FTRM20200804111416VG0C8AONMTSVIC',
          name: '王二麻',
          cardId: '210282199508072132',
          group: '汇丰银行',
          model: 'HSBC抵押纯企业决策',
          principal: '张三',
          project: '汇丰抵贷'
        }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }
          , {
            num: 'FTRM20200804111416VG0C8AONMTSVIC',
            name: '王二麻',
            cardId: '210282199508072132',
            group: '汇丰银行',
            model: 'HSBC抵押纯企业决策',
            principal: '张三',
            project: '汇丰抵贷'
          }

        ],
        sizeForm: {},
        humanInfo: {
          name: '',
          age: '',
        },
        list: [],
        listLoading: true,
        dialogFormVisible: false,
        sexTypeOptions,
        dialogStatus: '',
        textMap: {
          update: 'Edit',
          create: 'Create'
        },
        temp: {
          id: '',
          username: '',
          age: 18,
          sex: '男',
          avatar: ''
        },
        pageQuery: {
          pageNo: 0,
          pageSize: 5,
          sortKey: 'age',
          selectKey: undefined,
          selectValue: undefined
        }
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.listLoading = true
        pagePeople(this.pageQuery).then(response => {
          this.list = response.data.data.content
          this.listLoading = false
        })
      },
      handleFilter() {
        this.pageQuery.pageNo = 0
        this.fetchData()

      },
      handleCreate() {
        this.dialogStatus = 'create'
        this.dialogFormVisible = true
      }
    }
  }
</script>

<style scoped>
</style>
