<template>
  <div class="app-container">
    <div class="filter-container">
      <el-select v-model="pageQuery.selectKey" placeholder="请选择" clearable style="width: 120px">
        <el-option label="id" value="id"/>
        <el-option label="username" value="username"/>
      </el-select>
      <el-input v-model="pageQuery.selectValue" placeholder="请输入" style="width: 200px;"
                @keyup.enter.native="handleFilter"/>
      <el-button type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
        Add
      </el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      row-key="id"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column align="center" label="No" width="60" type="index">
        <template slot-scope="scope">
          <span>{{scope.$index}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Avatar" width="100">
        <template slot-scope="scope">
          <img :src="scope.row.avatar" style="height: 50px;width: 50px">
        </template>
      </el-table-column>
      <el-table-column align="center" label="Id" width="400">
        <template slot-scope="scope">
          <span>{{scope.row.id}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Username" width="200">
        <template slot-scope="scope">
          <span>{{scope.row.username}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Sex" width="90">
        <template slot-scope="scope">
          <span>{{scope.row.sex}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Age" width="90">
        <template slot-scope="scope">
          <span>{{scope.row.age}}</span>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :model="temp" label-position="left" label-width="100px"
               style="width: 400px; margin-left:50px;">

        <el-form-item label="Username" prop="username">
          <el-input v-model="temp.username"/>
        </el-form-item>
        <el-form-item label="Sex">
          <el-select v-model="temp.sex" placeholder="Please select">
            <el-option v-for="item in sexTypeOptions" :key="item.key" :label="item.display_name"
                       :value="item.key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="Age" prop="age">
          <el-input v-model="temp.age"/>
        </el-form-item>
      </el-form>

    </el-dialog>

  </div>
</template>

<script>
  import { pagePeople } from '@/api/people'

  const sexTypeOptions = [
    { key: '男', display_name: '男' },
    { key: '女', display_name: '女' }
  ]

  export default {
    name: 'people.vue',

    data() {
      return {
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
