<template>
  <q-table class="web-composer-header-table" :rows="tableModel.rows" selection="multiple"
    v-model:selected="dialog.selected" :card-style="{ backgroundColor: '#ffffff' }" :columns="tableModel.displayColumns"
    row-key="name" flat bordered>
    <template v-slot:top="props">
      <div class="column">
        <div class="row justify-between">
          <div class="web-composer-header-table-title">{{ tableModel.title }}</div>
          <q-space />
          <q-btn v-if="tableModel.settings.fullscreen" flat round dense icon="miscellaneous_services" />
          <q-btn v-if="tableModel.settings.fullscreen" flat round dense
            :icon="props.inFullscreen ? 'fullscreen_exit' : 'fullscreen'" @click="props.toggleFullscreen" />
        </div>
        <div class="row justify-between">
          <q-btn-group flat>
            <q-btn label="新增" icon="add" @click="() => multiOpAddOrEdit(false)" />
            <q-btn v-if="tableModel.settings.multiEditMode" label="编辑" icon="edit"
              @click="() => multiOpAddOrEdit(true)" />
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

    <template v-slot:header-selection="scope">
      <q-checkbox v-model="scope.selected" />
    </template>

    <template v-slot:header="props">
      <q-tr :props="props">
        <q-th auto-width>
          <q-checkbox v-model="props.selected" />
        </q-th>
        <q-th v-for="col in props.cols" :key="col.name" :props="props">
          {{ col.label }}
        </q-th>
        <q-th auto-width>
          操作
        </q-th>
      </q-tr>
    </template>

    <template v-slot:body-selection="scope">
    </template>

    <template v-slot:body="props">
      <q-tr :props="props">
        <q-td auto-width>
          <q-checkbox v-model="props.selected" />
        </q-td>
        <q-td v-for="col in props.cols" :key="col.name" :props="props">
          {{ col.value }}
        </q-td>
        <q-td auto-width>
          <q-btn size="sm" color="primary" round dense @click="() => singleOpEdit(props.row)" icon="add"
            class="q-mr-xs" />
          <q-btn size="sm" color="deep-orange" round dense @click="() => singleOpRemove(props.row)" icon="remove"
            class="q-mr-xs" />
        </q-td>
      </q-tr>
    </template>
  </q-table>
  <!-- 新增弹框 -->
  <q-dialog v-model="dialog.showOpAddOrEdit">
    <q-card class="q-p-xs" :style="{ minWidth: '500px' }">
      <q-card-section>
        <div class="text-h6">{{ dialog.value.id ? '编辑' : '新增' }}数据源</div>
      </q-card-section>
      <q-card-section>
        <common-form :value="dialog.value" @submit="addOrEdit"></common-form>
      </q-card-section>
    </q-card>
  </q-dialog>
  <!-- 删除弹框 -->
  <q-dialog v-model="dialog.showOpDelete">
    <q-card class="q-p-xs" :style="{ minWidth: '500px' }">
      <q-card-section>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { DataSource } from '.';
import { ComposeDataTableOption } from 'components/ComposeDataTable/index'

import CommonForm from './CommonForm.vue';


// 表格数据配置区域
const tableModel = reactive<ComposeDataTableOption<DataSource>>({
  title: '数据源管理',
  columns: [
    {
      name: 'id',
      label: '编号',
      align: 'center',
      field: 'id'
    }, {
      name: 'name',
      label: '名称',
      align: 'center',
      field: 'name'
    }, {
      name: 'ipaddr',
      label: '数据库IP地址',
      align: 'center',
      field: 'ipaddr'
    }, {
      name: 'port',
      label: '数据库端口',
      align: 'center',
      field: 'port'
    }, {
      name: 'username',
      label: '用户名',
      align: 'center',
      field: 'username'
    }, {
      name: 'password',
      label: '密码',
      align: 'center',
      field: 'password'
    }, {
      name: 'dialet',
      label: '数据库方言',
      align: 'center',
      field: 'dialet'
    }
  ],
  displayColumns: [
    {
      name: 'id',
      label: '编号',
      align: 'center',
      field: 'id'
    }, {
      name: 'name',
      label: '名称',
      align: 'center',
      field: 'name'
    }, {
      name: 'ipaddr',
      label: '数据库IP地址',
      align: 'center',
      field: 'ipaddr'
    }, {
      name: 'port',
      label: '数据库端口',
      align: 'center',
      field: 'port'
    }, {
      name: 'username',
      label: '用户名',
      align: 'center',
      field: 'username'
    }, {
      name: 'password',
      label: '密码',
      align: 'center',
      field: 'password'
    }, {
      name: 'dialet',
      label: '数据库方言',
      align: 'center',
      field: 'dialet'
    }
  ],
  rows: [
    {
      id: '111111111',
      name: '默认',
      ipaddr: 'localhost',
      username: 'root',
      password: 'root',
      dialet: 'mysql'
    }
  ],
  settings: {
    selection: 2,
    multiEditMode: false,
    fullscreen: true,
    columnsSelection: true,
    pagination: true,
    searchable: true,
    operation: []
  }
})

// 操作代码区域
const dialog = reactive<{
  showOpAddOrEdit: boolean,
  showOpDelete: boolean,
  selected: DataSource[],
  value: DataSource
}>({
  showOpAddOrEdit: false,
  showOpDelete: false,
  selected: [],
  value: {}
})

// 添加与编辑操作
const multiOpAddOrEdit = (isEdit: boolean) => {
  if (isEdit) {

  }
  dialog.showOpAddOrEdit = true
}
const singleOpEdit = (value: DataSource) => {
  dialog.value = value
  dialog.showOpAddOrEdit = true
}
const addOrEdit = () => { }

// 删除操作
const opDelete = () => {
  dialog.showOpDelete = true
}

const singleOpRemove = (value: DataSource) => {

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
