<template>
  <q-table class="web-composer-header-table" :rows="tableModel.rows" selection="multiple"
    :card-style="{ backgroundColor: '#ffffff' }" :columns="tableModel.displayColumns" row-key="name" flat bordered>
    <template v-slot:top="props">
      <div class="column">
        <div class="row justify-between">
          <div class="web-composer-header-table-title">{{ tableModel.title }}</div>
          <q-space />
          <q-btn v-if="tableModel.setting.fullscreen" flat round dense icon="miscellaneous_services" class="q-ml-md" />
          <q-btn v-if="tableModel.setting.fullscreen" flat round dense
            :icon="props.inFullscreen ? 'fullscreen_exit' : 'fullscreen'" @click="props.toggleFullscreen"
            class="q-ml-md" />
        </div>
        <div class="row justify-between">
          <q-btn-group flat>
            <q-btn label="新增" icon="add" @click="opAdd" />
            <q-btn label="编辑" icon="edit" @click="opEdit" />
            <q-btn label="删除" icon="remove" @click="opDelete" />
          </q-btn-group>
          <q-input borderless dense label="搜索" debounce="300" color="primary" v-model="undefined">
            <template v-slot:append>
              <q-btn flat round dense icon="search" />
            </template>
          </q-input>
        </div>
      </div>
    </template>
  </q-table>
  <!-- 新增弹框 -->
  <q-dialog v-model="dialog.showOpAdd">
  </q-dialog>
  <!-- 编辑弹框 -->
  <q-dialog v-model="dialog.showOpEdit">
  </q-dialog>
  <!-- 删除弹框 -->
  <q-dialog v-model="dialog.showOpDelete">
  </q-dialog>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
const tableModel = reactive({
  title: '数据源管理',
  columns: [
    {
      name: 'id',
      label: '编号',
      field: 'id'
    }, {
      name: 'name',
      label: '名称',
      field: 'name'
    }, {
      name: 'ipaddr',
      label: '数据库IP地址',
      field: 'ipaddr'
    }, {
      name: 'username',
      label: '用户名',
      field: 'username'
    }, {
      name: 'password',
      label: '密码',
      field: 'password'
    }, {
      name: 'dialet',
      label: '数据库方言',
      field: 'dialet'
    }
  ],
  displayColumns: [
    {
      name: 'id',
      label: '编号',
      field: 'id'
    }, {
      name: 'name',
      label: '名称',
      field: 'name'
    }, {
      name: 'ipaddr',
      label: '数据库IP地址',
      field: 'ipaddr'
    }, {
      name: 'username',
      label: '用户名',
      field: 'username'
    }, {
      name: 'password',
      label: '密码',
      field: 'password'
    }, {
      name: 'dialet',
      label: '数据库方言',
      field: 'dialet'
    }
  ],
  rows: [],
  setting: {
    // 0-关闭 1-开启单选 2-开启多选
    selection: 0,
    // 是否开启全屏按钮
    fullscreen: true,
    // 是否允许表头字段选择
    columnsSelection: true,
    // 是否开启分页
    pagination: true,
    // 是否开启搜索
    searchable: true,
    // 操作按钮：预设按钮、自定义按钮
    operation: [
      { label: '添加', color: 'primary', type: 'preset', auth: '{module|role|spec}:{typeValue}:name', allow: true, callback: '', order: 0 },
      { label: '编辑', color: 'default', type: 'preset', auth: '{module|role|spec}:{typeValue}:name', allow: true, callback: '', order: 0 },
      { label: '删除', color: 'error', type: 'preset', auth: '{module|role|spec}:{typeValue}:name', allow: true, callback: '', order: 0 },
    ]
  }
})

const dialog = reactive({
  showOpAdd: false,
  showOpEdit: false,
  showOpDelete: false
})
const opAdd = () => {
  dialog.showOpAdd = true
}

const opEdit = () => {
  dialog.showOpEdit = true
}

const opDelete = () => {
  dialog.showOpDelete = true
}
</script>

<style lang="sass">
.web-composer-header-table
  min-height: 310px
  .q-table__top > .column
    width: 100%
  .web-composer-header-table-title
    font-size: 22px
    font-weight: bold
</style>
