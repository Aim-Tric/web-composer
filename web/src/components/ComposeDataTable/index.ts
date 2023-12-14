import { UnwrapNestedRefs } from 'vue'

export interface ComposeDataTableColumn {
  name: string
  label: string
  field: string
}

export enum ComposeDataTableSelectionSetting {
  CLOSE = 0,
  SINGLE = 1,
  MULTIPLE = 2
}

export interface ComposeDataTableOperation {
  label: string
  color: string
  type: string
  auth: string
  allow: boolean
  callback: string
  order: number
}

export interface ComposeDataTableSettings {
  // 0-关闭 1-开启单选 2-开启多选
  selection: ComposeDataTableSelectionSetting
  // 是否开启全屏按钮
  fullscreen: boolean,
  // 是否允许表头字段选择
  columnsSelection: boolean,
  // 是否开启分页
  pagination: boolean,
  // 是否开启搜索
  searchable: boolean,
  // 操作按钮：预设按钮、自定义按钮
  operation: ComposeDataTableOperation[]
}

export interface ComposeDataTableOption<T> {
  title: string
  columns: ComposeDataTableColumn[]
  displayColumns: ComposeDataTableColumn[]
  rows: T[]
  settings: ComposeDataTableSettings
}

export interface ComposeDataTableHook<T> {
  tableModel: UnwrapNestedRefs<{
    title: string
    columns: ComposeDataTableColumn[]
    displayColumns: ComposeDataTableColumn[]
    rows: T[]
  }>
  useSearch?: () => void
  usePagination?: () => void
  useFullscreen?: () => void
  useColumnsSelection?: () => void
  useSelection?: () => void
}
