<template>
  <div class="app-container">
    <div class="filter-container">
      <el-select v-model="pageQuery.filters[0].name" placeholder="请选择" clearable style="width: 140px">
        <el-option label="Id" value="id"/>
        <el-option label="Content" value="content"/>
        <el-option label="Subject" value="subject"/>
        <el-option label="RecordTime" value="recordTime"/>
      </el-select>
      <el-input v-model="pageQuery.filters[0].value" placeholder="请输入" style="width: 200px;"
                @keyup.enter.native="pageFilter"/>
      <el-button v-waves type="primary" icon="el-icon-search" @click="pageFilter">
        Search
      </el-button>
      <el-button style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="dialogCreate">
        Add
      </el-button>
      <el-button style="margin-left: 10px;" type="primary" icon="el-icon-upload" @click="dialogUpload">
        import
      </el-button>
      <el-button style="margin-bottom:20px" type="primary" icon="el-icon-document" @click="handleDownloadSelect">
        export
      </el-button>
      <el-button style="margin-bottom:20px" type="primary" icon="el-icon-share" @click="bindingGroup">
        binding
      </el-button>
      <el-button @click="handleDeleteSelect" icon="el-icon-delete" style="margin-left: 10px;" type="danger">
        Delete
      </el-button>
    </div>
    <p/>
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
      <el-table-column align="center" label="Content" width="500">
        <template slot-scope="scope">
          <span>{{scope.row.content}}</span>
        </template>
      </el-table-column>
      <el-table-column
        :filters="subjectTypeOptions"
        :filter-method="filterSubjectType"
        align="center" label="Subject" width="90">
        <template slot-scope="scope">
          <span>{{scope.row.subject}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="Amount" width="90">
        <template slot-scope="scope">
          <span>{{scope.row.amount}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="RecordTime" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{scope.row.recordTime}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="EditTime" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{getLastTime(scope.row)}}</span>
        </template>
      </el-table-column>
      <el-table-column label="Actions" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button :style="{display: scope.row.groupId !== null?'':'none'}" @click="dialogGroup(scope.row.groupId)"
                     circle
                     icon="el-icon-search" size="mini"
                     type="success"/>
          <el-button :style="{display: scope.row.groupId !== null?'':'none'}" @click="unbindingGroup(scope.row)"
                     circle
                     icon="el-icon-folder-remove" size="mini"
                     type="danger"/>
          <el-button size="mini" type="primary" icon="el-icon-edit" circle @click="dialogUpdate(scope.row)"/>
          <el-button size="mini" type="danger" icon="el-icon-delete" circle
                     @click="handleDelete(scope.row,scope.$index)"/>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="pageTotal>0" :total="pageTotal" :page.sync="pageQuery.pageNo" :limit.sync="pageQuery.pageSize"
                @pagination="fetchData"/>
    <div class="show-d">
      <el-tag>The Selection Count :</el-tag>
      {{ this.multipleSelection.flatMap(e => e.id).length }}
    </div>
    <div class="show-d">
      <el-tag>The Selection Ids :</el-tag>
      {{ this.multipleSelection.flatMap(e => e.id) }}
    </div>

    <el-dialog :title="textMap[dialogFormStatus]" :visible.sync="dialogFormVisible">
      <sapn :style="{display: this.dialogFormStatus === textMap.update?'none':''}">
        <el-table
          :data="tempList"
          border
          fit
          highlight-current-row
          style="width: 100%"
        >
          <el-table-column align="center" label="Content" width="400">
            <template slot-scope="scope">
              <span>{{scope.row.content}}</span>
            </template>
          </el-table-column>
          <el-table-column align="center" label="Subject" width="80">
            <template slot-scope="scope">
              <span>{{scope.row.subject}}</span>
            </template>
          </el-table-column>
          <el-table-column align="center" label="Amount" width="80">
            <template slot-scope="scope">
              <span>{{scope.row.amount}}</span>
            </template>
          </el-table-column>
          <el-table-column align="center" label="RecordTime" width="120">
            <template slot-scope="scope">
              <i class="el-icon-time"/>
              <span>{{scope.row.recordTime}}</span>
            </template>
          </el-table-column>
          <el-table-column label="Actions" align="center" width="100" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button type="primary" size="mini" icon="el-icon-edit" @click="editInCreated(scope.row)" circle/>
              <el-button type="danger" size="mini" icon="el-icon-delete" @click="deleteInCreated(scope.$index)" circle/>
            </template>
          </el-table-column>
        </el-table>
      </sapn>
      <p/>
      <el-form ref="dataForm" :model="temp" label-position="left" label-width="100px"
               style="width: 400px; margin-left:50px;">
        <el-form-item label="Content" prop="content">
          <el-input type="textarea" v-model="temp.content"/>
        </el-form-item>
        <el-form-item label="Subject">
          <el-select v-model="temp.subject" placeholder="Please select">
            <el-option v-for="item in subjectTypeOptions" :key="item.key" :label="item.display_name"
                       :value="item.key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="Amount(￥)" prop="amount">
          <el-input v-model="temp.amount"/>
        </el-form-item>
        <el-form-item label="RecordTime" prop="recordTime">
          <el-date-picker
            v-model="temp.recordTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择记录时间"
            style="width: 100%">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button @click="addRowInCreated()" type="primary">增加一条</el-button>
          <el-button @click="dialogFormStatus===textMap.create?createLedger():updateLedger()" type="primary">确定
          </el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="Import" :visible.sync="dialogImportVisible">
      <el-upload
        ref="upload"
        action=""
        multiple
        :http-request="uploadFile"
        :file-list="fileList"
        :auto-upload="false"
      >
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
      </el-upload>
    </el-dialog>
    <el-dialog width="60%" title="Groups" :visible.sync="dialogGroupsVisible">
      <el-table
        :data="groupList"
        border
        fit
        highlight-current-row
        style="width: 100%">
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
        <el-table-column align="center" label="Content" width="400">
          <template slot-scope="scope">
            <span>{{scope.row.content}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="Subject" width="80">
          <template slot-scope="scope">
            <span>{{scope.row.subject}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="Amount" width="80">
          <template slot-scope="scope">
            <span>{{scope.row.amount}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="RecordTime" width="120">
          <template slot-scope="scope">
            <i class="el-icon-time"/>
            <span>{{scope.row.recordTime}}</span>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
  import {
    getLedgersByGroupId,
    create4SameGroup,
    deleteOne,
    deleteSelect,
    download,
    downloadSelect,
    edit,
    page,
    upload,
    bindingGroupIds,
    unbindingGroupId
  } from '@/api/ledger'
  import Pagination from '@/components/Pagination/pagination' // secondary package based on el-pagination
  import waves from '@/directive/waves' // waves directive
  import { downloadUrl } from '@/utils/download'
  import { parseTime } from '@/utils/index'

  const subjectTypeOptions = [
    { text: '福利', value: '福利' },
    { text: '后勤', value: '后勤' },
    { text: '工资', value: '工资' },
    { text: '其他', value: '其他' },
    { text: '通讯', value: '通讯' },
    { text: '住房', value: '住房' }

  ]

  export default {
    name: 'index',
    components: { Pagination },
    directives: { waves },

    data() {
      return {
        pageKey: 0,
        pageTotal: 0,
        pageList: [],
        fileList: [],
        groupList: [],
        multipleSelection: [],
        pageListLoading: true,
        dialogFormVisible: false,
        dialogImportVisible: false,
        dialogGroupsVisible: false,
        subjectTypeOptions,
        dialogFormStatus: '',
        textMap: {
          update: 'update',
          create: 'create'
        },
        temp: {
          id: undefined,
          content: '',
          subject: '其他',
          amount: '',
          recordTime: ''
        },
        tempList: [],
        pageQuery: {
          pageNo: 1,
          pageSize: 10,
          filters: [
            {
              name: 'content',
              value: ''
            }
          ],
          sorts: [
            {
              name: 'content',
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
      resetTemp() {
        this.temp = {
          id: undefined,
          content: '',
          subject: '其他',
          amount: '',
          recordTime: ''
        }
      },
      fetchData() {
        this.pageListLoading = true
        page(this.pageQuery)
          .then(response => {
          this.pageList = response.data.data.content
          this.pageTotal = response.data.data.totalElements
          this.pageListLoading = false
        })
      },
      dialogUpdate(scope) {
        this.temp = Object.assign({}, scope) // copy obj
        this.dialogFormStatus = this.textMap.update
        this.dialogFormVisible = true
      },
      handleDelete(scope, index) {
        deleteOne(scope.id).then(res => {
          this.pageList.splice(index, 1)
          this.$notify({
            title: 'Success',
            message: 'Delete Successfully',
            type: 'success',
            duration: 2000
          })
        })
      },
      pageFilter() {
        this.pageQuery.pageNo = 1
        this.fetchData()
      },
      dialogCreate() {
        this.resetTemp()
        this.tempList = []
        this.dialogFormStatus = this.textMap.create
        this.dialogFormVisible = true
      },
      handleDeleteSelect() {
        let idSelection = this.multipleSelection.flatMap(selection => selection.id)
        if (idSelection.length > 0) {
          let formData = new FormData()
          formData.append('ids', idSelection)
          deleteSelect(formData).then(res => {
            this.$notify({
              title: 'Success',
              message: 'Delete Successfully',
              type: 'success',
              duration: 2000
            })
            this.fetchData()
          })
        }
      },
      bindingGroup() {
        let idSelection = this.multipleSelection.flatMap(selection => selection.id)
        if (idSelection.length > 0 && idSelection.length < 4) {
          let formData = new FormData()
          formData.append('ids', idSelection)
          bindingGroupIds(formData).then(res => {
            this.$notify({
              title: 'Success',
              message: 'binding Successfully',
              type: 'success',
              duration: 2000
            })
            this.fetchData()
          })
        } else {
          this.$notify({
            title: 'Error',
            message: '请选择1~3之间',
            type: 'error',
            duration: 3000
          })
        }
      },
      unbindingGroup(item) {
        unbindingGroupId(item.id).then(res => {
          this.pageList.filter(e => e.id === item.id).forEach(item => {
            item.groupId = null
          })
        })
      },
      dialogUpload() {
        this.dialogImportVisible = true
      },
      submitUpload() {
        this.$refs.upload.submit()
      },
      uploadFile(item) {
        let formData = new FormData()
        formData.append('file', item.file)
        upload(formData).then(res => {
          this.dialogImportVisible = false
          this.$notify({
            title: 'Success',
            message: item.file.name + 'Import Successfully',
            type: 'success',
            duration: 2000
          })
          this.fetchData()
        })
      },
      createLedger() {
        if (this.tempList.length > 0 && this.tempList.length < 3) {
          create4SameGroup(this.tempList).then(res => {
            this.dialogFormVisible = false
            this.tempList = []
            this.$notify({
              title: 'Success',
              message: 'Created Successfully',
              type: 'success',
              duration: 2000
            })
            this.fetchData()
          })
        } else {
          this.$notify({
            title: 'Error',
            message: '不能为空or不能大于3',
            type: 'error',
            duration: 2000
          })
        }
      },
      updateLedger() {
        edit(this.temp).then(res => {
          this.temp = Object.assign({}, res.data.data) // copy obj
          this.$notify({
            title: 'Success',
            message: 'Upload Successfully',
            type: 'success',
            duration: 2000
          })
          this.fetchData()
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection = val
      },
      handleDownloadSelect() {
        if (this.multipleSelection.length) {
          if (this.multipleSelection.length === 1) {
            let selection = this.multipleSelection.pop()
            download(selection.id).then(res => {
              downloadUrl(res.data, selection.id + '.xlsx', 'application/vnd.ms-excel')
            })
          } else {
            let ids = this.multipleSelection.flatMap(selection => selection.id)
            let formData = new FormData()
            formData.append('ids', ids)
            downloadSelect(formData).then(res => {
              downloadUrl(res.data, 'receipt.xlsx', 'application/vnd.ms-excel')
            })
          }
        }
      },
      getLastTime(row) {
        let time
        if (row.updateTime !== null) {
          time = row.updateTime
        } else {
          time = row.createTime
        }
        return parseTime(time, null)
      },
      addRowInCreated() {
        let hasSameOne = this.tempList.filter(temp => temp.content === this.temp.content)
        if (hasSameOne.length > 0) {
          this.$notify({
            title: 'Error',
            message: '不允许存在相同的Content',
            type: 'error',
            duration: 2000
          })
        } else {
          this.tempList.push(this.temp)
          this.resetTemp()
        }
      },
      deleteInCreated(index) {
        this.tempList.splice(index, 1)
      },
      editInCreated(scope) {
        this.temp = Object.assign({}, scope) // copy obj
      },
      dialogGroup(groupId) {
        this.dialogGroupsVisible = true
        getLedgersByGroupId(groupId).then(res => {
          this.groupList = res.data.data
        })
      },
      filterSubjectType(value, row) {
        return row.subject === value
      }
    }
  }
</script>

<style scoped>

</style>
