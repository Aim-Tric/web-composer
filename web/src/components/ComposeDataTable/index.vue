<template>
  <q-table class="web-composer-header-table" :rows="hook.tableModel.rows" selection="multiple"
    :card-style="{ backgroundColor: '#ffffff' }" :columns="hook.tableModel.displayColumns" row-key="name" flat bordered>
    <template v-slot:top="props">
      <div class="column">
        <div class="row justify-between">
          <div class="web-composer-header-table-title">{{ hook.tableModel.title }}</div>
          <q-space />
          <q-btn v-if="option.settings.fullscreen" flat round dense icon="miscellaneous_services" class="q-ml-md" />
          <q-btn v-if="option.settings.fullscreen" flat round dense
            :icon="props.inFullscreen ? 'fullscreen_exit' : 'fullscreen'" @click="props.toggleFullscreen"
            class="q-ml-md" />
        </div>
        <div class="row justify-between">
          <q-btn-group flat>
            <q-btn label="新增" icon="add" />
            <q-btn label="编辑" icon="edit" />
            <q-btn label="删除" icon="remove" />
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
</template>

<script setup lang="ts" generic="T">
import { reactive } from 'vue'
import { ComposeDataTableOption, ComposeDataTableHook } from './index'

const props = defineProps<{
  option: ComposeDataTableOption<T>
}>()

const option = props.option
const hook: ComposeDataTableHook<T> = {
  tableModel: reactive({
    title: option.title,
    columns: option.columns,
    displayColumns: option.displayColumns,
    rows: option.rows
  })
}

const useSearch = () => {

}

const usePagination = () => {

}

const useFullscreen = () => {

}

const useColumnsSelection = () => {

}

const useSelection = () => {

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
