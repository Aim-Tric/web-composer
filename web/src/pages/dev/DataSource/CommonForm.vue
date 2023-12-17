<template>
  <q-form @submit="submit">
    <q-input v-model="props.value.name" label="名称" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <q-input v-model="props.value.ipaddr" label="数据库IP地址" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <q-input v-model="props.value.port" label="数据库端口" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <q-input v-model="props.value.username" label="用户名" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <q-input v-model="props.value.password" label="密码" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <q-input v-model="props.value.dialet" label="数据库方言" lazy-rules
      :rules="[val => val && val.length > 0 || 'Please type something']" />
    <div>
      <q-btn label="提交" type="submit" color="primary" />
    </div>
  </q-form>
</template>

<script setup lang="ts">
import { DataSource } from '.';

const props = defineProps<{
  value: DataSource
}>()

const emit = defineEmits(['update:value', 'submit'])

const submit = () => {
  emit('submit')
}

</script>
