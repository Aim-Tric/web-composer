<template>
  <q-table class="my-sticky-header-table" :title="tableModel.title" :rows="tableModel.rows" selection="multiple"
    :columns="tableModel.displayColumns" row-key="name" flat bordered>
    <template v-slot:top="props">
      <q-btn v-if="tableModel.setting.fullscreen" flat round dense
        :icon="props.inFullscreen ? 'fullscreen_exit' : 'fullscreen'" @click="props.toggleFullscreen" class="q-ml-md" />
    </template>
  </q-table>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
const tableModel = reactive({
  title: '',
  columns: [],
  displayColumns: [],
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
    // {
    //   create: {allow: true, auth: '{module|role|spec}:{typeValue}:name'},
    //   update: {allow: true, auth: '{module|role|spec}:{typeValue}:name'},
    //   delete: {allow: true, auth: '{module|role|spec}:{typeValue}:name'},
    // }, // 数据管理按钮
  }
})
</script>

<style lang="sass">
.my-sticky-header-table
  /* height or max-height is important */
  height: 310px

  .q-table__top,
  .q-table__bottom,
  thead tr:first-child th
    /* bg color is important for th; just specify one */
    background-color: #c1f4cd

  thead tr th
    position: sticky
    z-index: 1
  thead tr:first-child th
    top: 0

  /* this is when the loading indicator appears */
  &.q-table--loading thead tr:last-child th
    /* height of all previous header rows */
    top: 48px
</style>
