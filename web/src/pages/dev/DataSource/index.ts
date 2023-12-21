import { reactive } from 'vue'
import { ComposeDataTableOption } from 'components/ComposeDataTable/index'

export interface DataSource {
  id?: string
  name?: string
  ipaddr?: string
  port?: string
  username?: string
  password?: string
  dialect?: string
}


