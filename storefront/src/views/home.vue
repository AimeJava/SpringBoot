<template>
    <div>
        <BackTop></BackTop>
        <el-container>
            <!--头部-->

            <el-header>
                <div class="layout-logo">凤雀茶楼</div>
                <el-input v-model="menuName" placeholder="请输入菜名"></el-input>
                <el-button @click="fuzzyQueryMenu">搜索</el-button>
                <el-button @click="login()" v-if="loginBut">登陆</el-button>
                <v-user v-if="!loginBut"></v-user>
            </el-header>
            <el-container>
                <!--侧边 待组件化-->
                <el-aside width="200px" style="">
                    <el-menu class="el-menu-vertical-demo">
                        <el-menu-item index="1" v-for="type in types" :key="type.typeId" :id="type.typeId"
                                      @click="typeSelect">
                            <span>{{type.typeName}}</span>
                        </el-menu-item>
                    </el-menu>
                </el-aside>
                <!--主要内容 `待组件化-->
                <el-main>
                    <el-col v-for="menu in menuInfo" :key="menu.menuId">
                        <el-card :body-style="{ padding: '0px' }">
                            <img :src="'http://localhost:8888/images/'+menu.menuImage" class="image">
                            <span style="display:block; height: 50px;line-height:50px;position: relative;">{{menu.menuName}}</span>
                            <div class="bottom clearfix">
                                <i class="normal icon-el-anonymous-iconfont1" style="float: left;">
                                    <span style="font-size: 2em;">{{menu.menuPrice}}</span></i>
                                <el-rate
                                        v-model="value"
                                        disabled
                                        show-score
                                        text-color="#ff9900"
                                        score-template="{value}">
                                </el-rate>
                                <el-button type="text" class="button" @click="addCart(menu)">添加购物车</el-button>
                            </div>
                        </el-card>
                    </el-col>
                </el-main>
            </el-container>
            <el-footer>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="totals"
                        @current-change="current">
                </el-pagination>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    //import Login from "../components/login/login3.vue"
    import user from '../components/user/user.vue'

    export default {
        data() {
            return {
                currentDate: "2019-01-14",
                menuInfo: [],
                types: [],
                value: 2.4,
                totals: 0,
                id: 0,
                menuName: "",
                loginBut: sessionStorage.getItem('userInfo') == null
            }
        },
        created: function () {
            //页面加载时
            fetch('http://localhost:8888/menu/allMenu?num=1')
                .then(response => response.json())
                .then(resp => {
                    // 获取菜单
                    this.menuInfo = resp.data;
                    //获取分页总数
                    this.totals = resp.count;
                });
            fetch('http://localhost:8888/type/allTypes')
                .then(response => response.json())
                .then(data => {
                    // 获取类型
                    this.types = data.data;
                    //   console.log(data.data);
                });

        },
        methods: {
            login() {
                this.$router.push({path: '/login'});
            },
            current(ev) { // 页数发生变化
                let total = this.totals;
                if (total > 150) {
                    fetch('http://localhost:8888/menu/allMenu?num=' + ev)
                        .then(response => response.json())
                        .then(resp => {
                            this.menuInfo = resp.data;
                            this.totals = resp.count;
                        })
                } else {
                    fetch('http://localhost:8888/menu/getTypeId?id=' + this.id + '&num=' + ev)
                        .then(response => response.json())
                        .then(resp => {
                            // 获取菜单
                            this.menuInfo = resp.data;
                            this.totals = resp.count;

                        })
                }
            },
            typeSelect() {//根据类别获取菜单
                let id = this.id = event.target['id'];
                // alert(id)
                fetch('http://localhost:8888/menu/getTypeId?id=' + id + '&num=1')
                    .then(response => response.json())
                    .then(resp => {
                        // 获取菜单
                        this.menuInfo = resp.data;
                        this.totals = resp.count;

                    })
            },
            addCart(value) { //添加到购物车
                if (sessionStorage.getItem("userInfo") == null) {
                    this.login();
                } else {

                    var item = JSON.parse(sessionStorage.getItem("userInfo"));
                    let cart = {'userId': item.userId, 'menuInfo': value, 'menuNumber':1, 'menuSubtotal': value.menuPrice};

                    fetch('http://localhost:8888/cart',{
                        method:'POST',
                        headers: new Headers({
                            'Content-Type': 'application/json'
                        }),
                        body:JSON.stringify(cart)
                    })
                        .then(response => response.json())
                        .then(resp => {
                            console.log(resp.code);
                            if (resp.code === 200) {
                                this.$message.success("添加成功");
                            } else {
                                this.$message.error("添加失败");
                            }
                        });
                }

            },
            fuzzyQueryMenu() {
                let name = this.menuName;
                if (name == null || name === "") {
                    fetch('http://localhost:8888/menu/allMenu?num=1')
                        .then(response => response.json())
                        .then(resp => {
                            // 获取菜单
                            this.menuInfo = resp.data;
                            this.totals = resp.count;

                        });
                } else {

                    fetch('http://localhost:8888/menu/fuzzyQueryMenu?menuName=' + name)
                        .then(response => response.json())
                        .then(resp => {
                            // 获取菜单
                            this.menuInfo = resp;
                            this.totals = resp;

                        });
                }
            }
        },
        components: {
            "v-user": user
        }
    }
</script>

<style src="../css/main.css">

</style>
