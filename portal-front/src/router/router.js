import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
import Layout from '@/layout'

Vue.use(Router)

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [

  //登录
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/dashboard'),
      meta: {title: '风控引擎管理平台', icon: 'dashboard'}
    }]
  },


  // 信息查询
  {
    path: '/search',
    component: Layout,
    redirect: '/search',
    name: 'Search',
    meta: {title: '信息查询', icon: 'eye-open'},//页面名称
    children: [
      {
        path: '/search/home',
        name: 'Home',
        component: () => import('@/views/search/home'),
        meta: {title: '首页'} //页面名称
      },
      {
        path: '/search/information',
        name: 'Information',
        component: () => import('@/views/search/information'),
        meta: {title: '查询'} //页面名称
      },
      {
        path: '/search/searchList',
        name: 'SearchList',
        component: () => import('@/views/search/searchList'),
        meta: {title: '查询列表'} //页面名称
      }

    ]
  },

  // 数据管理
  {
    path: '/dataSource',
    component: Layout,
    redirect: '/dataSource',
    name: 'DataSource',
    meta: {title: '数据管理', icon: 'data-view'}, //页面名称

    children: [
      {
        path: '/dataSource/apiList',
        name: 'apiList',
        component: () => import('@/views/dataSource/apiList'),
        meta: {title: '接口管理'} //页面名称
      },
      {
        path: '/dataSource/keyList',
        name: 'keyList',
        component: () => import('@/views/dataSource/keyList'),
        meta: {title: '字段管理'} //页面名称
      },
      {
        path: '/dataSource/dataManagement',
        name: 'dataManagement',
        component: () => import('@/views/dataSource/dataManagement'),
        meta: {title: '数据源管理'} //页面名称
      }

    ]
  },

  // 名单管理
  {
    path: '/listmanagement',
    component: Layout,
    redirect: '/listmanagement',
    name: 'ListManagement',
    meta: {title: '名单管理', icon: 'image-text'}, //页面名称

    children: [
      {
        path: '/ListManagement/blackList',
        name: 'blackList',
        component: () => import('@/views/listmanagement/blackList'),
        meta: {title: '黑名单管理'} //页面名称
      },
      {
        path: '/ListManagement/whiteList',
        name: 'whiteList',
        component: () => import('@/views/listmanagement/whiteList'),
        meta: {title: '白名单管理'} //页面名称
      },
      {
        path: '/ListManagement/listConfig',
        name: 'listConfig',
        component: () => import('@/views/listmanagement/listConfig'),
        meta: {title: '名单配置'} //页面名称
      },
      {
        path: '/ListManagement/clientAdd',
        name: 'clientAdd',
        component: () => import('@/views/listmanagement/addCustomer'),
        // meta: {title: '新增客户'}
      },
      {
        path: '/ListManagement/clientEdit',
        name: 'clientEdit',
        component: () => import('@/views/listmanagement/clientEdit'),
      }
    ]
  },

  // 规则管理
  {
    path: '/rulemanagement',
    component: Layout,
    redirect: '/rulemanagement',
    name: 'Rulemanagement',
    meta: {title: '规则管理', icon: 'explain'}, //页面名称

    children: [
      {
        path: '/rulemanagement/variable',
        name: 'variable',
        component: () => import('@/views/rulemanagement/variable'),
        meta: {title: '变量管理'} //页面名称
      },
      {
        path: '/rulemanagement/policy',
        name: 'policy',
        component: () => import('@/views/rulemanagement/policy'),
        meta: {title: '决策管理'} //页面名称
      },
    ]
  },


  // 统计分析
  {
    path: '/statistical',
    component: Layout,
    redirect: '/statistical',
    name: 'Statistical',
    meta: {title: '统计分析', icon: 'chart-bar'}, //页面名称

    children: [
      {
        path: '/statistical/modelUsing',
        name: 'modelUsing',
        component: () => import('@/views/statistical/modelUsing'),
        meta: {title: '模型使用报表'} //页面名称
      },
      {
        path: '/statistical/apiUsing',
        name: 'apiUsing',
        component: () => import('@/views/statistical/apiUsing'),
        meta: {title: '接口调用报表'} //页面名称
      },
      {
        path: '/statistical/display',
        name: 'display',
        component: () => import('@/views/statistical/display'),
        meta: {title: '大屏展示'} //页面名称
      },
      {
        path: '/statistical/scoreCardCompare',
        name: 'scoreCardCompare',
        component: () => import('@/views/statistical/scoreCardCompare'),
        meta: {title: '评分卡对比分析'} //页面名称
      },
      {
        path: '/statistical/decisionListCompare',
        name: 'decisionListCompare',
        component: () => import('@/views/statistical/decisionListCompare'),
        meta: {title: '决策集对比分析'} //页面名称
      },
      {
        path: '/statistical/decisionTreeCompare',
        name: 'decisionTreeCompare',
        component: () => import('@/views/statistical/decisionTreeCompare'),
        meta: {title: '决策树对比分析'} //页面名称
      },
      {
        path: '/statistical/decisionTableCompare',
        name: 'decisionTableCompare',
        component: () => import('@/views/statistical/decisionTableCompare'),
        meta: {title: '决策表对比分析'} //页面名称
      }
    ]
  },
  //成员
  {
    path: '/member',
    component: Layout,
    redirect: '/member',
    name: 'Member',
    meta: {title: '成员', icon: 'organization'},//页面名称

    children: [
      {
        path: '/member/people',
        name: 'People',
        component: () => import('@/views/member/people'),
        meta: {title: '成员'}//页面名称
      },
      {
        path: '/member/organization',
        name: 'Organization',
        component: () => import('@/views/member/organization'),
        meta: {title: '组织'}//页面名称
      }

    ]
  },

  // 收据 业务无关 前台注释
  /*{
    path: '/ledger',
    component: Layout,
    redirect: '/ledger',
    name: 'Ledger',
    meta: {title: '收据', icon: 'ledger'},//页面名称

    children: [
      {
        path: '/ledger/index',
        name: 'Ledger',
        component: () => import('@/views/ledger/index'),
        meta: {title: '收据'}//页面名称
      }
    ]
  },*/
  {
    path: '/sys',
    component: Layout,
    redirect: '/sys',
    name: 'Sys',
    meta: {title: '系统', icon: 'admin'},//页面名称
    children: [
      {
        path: '/sys/index',
        name: 'Sys',
        component: () => import('@/views/sys/index'),
        meta: {title: '系统'}//页面名称
      }
    ]
  },

  // 404 page must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
