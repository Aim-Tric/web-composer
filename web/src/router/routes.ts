import { RouteRecordRaw } from 'vue-router';

/**
 * 开发路由
 * 应用管理、模块管理、权限管理、数据源管理、表单管理、布局管理、服务管理
 */
const devRoutes: RouteRecordRaw[] = [
  {
    path: '/dev/application',
    component: () => import('pages/dev/Application.vue'),
  },
  {
    path: '/dev/module',
    component: () => import('pages/dev/Application.vue'),
  },
  {
    path: '/dev/datasource',
    component: () => import('pages/dev/DataSource.vue'),
  },
  {
    path: '/dev/form',
    component: () => import('pages/dev/FormDesign.vue'),
  },
  {
    path: '/dev/layout',
    component: () => import('pages/dev/LayoutManager.vue'),
  },
  {
    path: '/dev/service',
    component: () => import('pages/dev/Service.vue'),
  },
]

const adminRoutes: RouteRecordRaw[] = [

]

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [{ path: '', component: () => import('pages/IndexPage.vue') }],
  },
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
