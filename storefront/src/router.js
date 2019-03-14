import Vue from 'vue'
import Router from 'vue-router'
import login from './views/Login.vue'
import home from './views/home.vue'
import cart from './components/cart/cart'

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/login',
            name: 'login',
            component: login
        },
        {
            path: '/',
            name: 'home',
            component: home,
            meta: {
                title: '凤雀茶楼',
                // requiresAuth: true // 是否需要判断是否登录 因为可以游客访问
            }
        },
        {
            path: '/cart',
            name: 'cart',
            component: cart,
            meta: {
                title: '购物车',
                requiresAuth: true // 是否需要判断是否登录
            }
        }
    ]
})
