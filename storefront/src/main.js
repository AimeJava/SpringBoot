import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import './plugins/element.js'
import './plugins/iview.js'
import router from './router'
import './assets/iconfont/iconfont.css'


Vue.config.productionTip = false;
//this.axios.defaults.withCredentials=true;//让ajax携带cookie
router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = to.meta.title
    }
    if(to.path === '/login'){
        sessionStorage.removeItem("userInfo")
    }
    if (to.matched.some(record => record.meta.requiresAuth)){  // 判断该路由是否需要登录权限

        if (sessionStorage.getItem('userInfo')) {  // 判断当前用户的登录信息loginInfo是否存在
          //  console.log("已登陆");
            next();
        } else {
        //    console.log("未登陆");
            next({
                path: '/login'
            })
        }
    }
        next();

});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');
