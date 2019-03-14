import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            redirect: '/home',
            component: Home,
            meta: {
                title: '后台管理系统',
                requiresAuth: true // 是否需要判断是否登录
            },
            children: [
                {//首页
                    path: 'home', name: 'home', meta: { title: '后台管理系统' },
                    component: () => import('./views/subpage/subpage')
                }, {//实时订单
                    path: 'realTimeOrder', name: 'realTimeOrder',
                    component: () => import('./components/order/realTimeOrder')
                }, {//历史订单
                    path: 'historyOrder', name: 'historyOrder',
                    component: () => import('./components/order/historyOrder')
                }, {//添加菜单
                    path: 'addMenu', name: 'addMenu',
                    component: () => import('./components/menu/addMenu')
                }, {//修改菜单
                    path: 'updataMenu', name: 'updataMenu',
                    component: () => import('./components/menu/updataMenu')
                }, {
                    path: 'typeManage', name: 'typeManage',
                    component: () => import('./components/typeManage')
                }, {
                    path: 'clientMsg', name: 'clientMsg',
                    component: () => import('./components/clientMsg')
                }, {
                    path: 'jurisdiction', name: 'jurisdiction',
                    component: () => import('./components/jurisdiction')
                }
            ]
        }, {
            path: '/login',
            name: 'login',
            component: () => import('./views/login/login.vue'),

        }
    ],

})
