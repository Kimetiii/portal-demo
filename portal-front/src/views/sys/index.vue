<template>
  <div class="app-container">
    <el-table
      :key="pageKey"
      v-loading="pageListLoading"
      :data="pageList"
      row-key="id"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      @selection-change="handleSelectionChange"
      style="width: 100%"
    >
      <el-table-column :reserve-selection="true" align="center" type="selection"/>
      <el-table-column align="center" label="No" width="60" type="index">
        <template slot-scope="scope">
          <span>{{(pageQuery.pageNo - 1) * pageQuery.pageSize + scope.$index + 1}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Id" width="300">
        <template slot-scope="scope">
          <span>{{scope.row.id}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Avatar" width="50">
        <template slot-scope="scope">
          <img :src="scope.row.avatar" class="user-avatar" width="30">
        </template>
      </el-table-column>
      <el-table-column align="center" label="Username" width="100">
        <template slot-scope="scope">
          <span>{{scope.row.username}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Phone" width="200">
        <template slot-scope="scope">
          <span>{{scope.row.phone}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Enabled" width="90">
        <template slot-scope="scope">
          <span>{{scope.row.enabled}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="LoginTime" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{parseTime(scope.row.loginTime)}}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import { page } from '@/api/sys'
  import Pagination from '@/components/Pagination/pagination' // secondary package based on el-pagination
  import waves from '@/directive/waves' // waves directive
  import { parseTime } from '@/utils/index'

  export default {
    name: 'index',
    components: { Pagination },
    directives: { waves },

    data() {
      return {
        pageKey: 0,
        pageTotal: 0,
        pageList: [],
        pageListLoading: true,
        multipleSelection: [],
        pageQuery: {
          pageNo: 1,
          pageSize: 10,
          filters: [
            {
              name: 'username',
              value: ''
            }
          ],
          sorts: [
            {
              name: 'loginTime',
              value: 'DESC'
            }
          ]
        }
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.pageListLoading = true
        page(this.pageQuery).then(response => {
          console.log(response)
          this.pageList = response.data.data.content
          this.pageTotal = response.data.data.totalElements
          this.pageListLoading = false
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection = val
      },
      parseTime(time) {
        return parseTime(time, null)
      }
    }

  }
</script>

<style scoped>

</style>
