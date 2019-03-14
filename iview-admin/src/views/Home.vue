<style scoped>
    .layout {
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
    }

    .layout-header-bar {
        background: #fff;
        box-shadow: 0 1px 1px rgba(0, 0, 0, .1);
    }

    /*logo样式*/
    .logo {
        width: auto;
        height: 64px;
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: flex-start;
        cursor: pointer;
        border-bottom: 1px solid #363e4f;
        position: relative;
        padding-left: 20px;
        background: #70b7de;}

    .logo-saiqu {
        display: flex;
        align-items: center;
        justify-content: flex-start;
        position: relative;}

    .user-name {
        color: #fff;
        font-size: 16px;
        margin-left: 15px;
    }
    /*顶部样式*/
    .layout-header-bar {
        background: #fff;
        padding: 0;
        position: relative;
        display: flex;
        flex-direction: column;
        z-index: 20;
        width: 100%;
    }

    .layout-header-bar .header-wapper {
        display: flex;
        align-tems: center;
        justify-content: space-between;
        position: relative;
        z-index: 1;
        box-shadow: 0 2px 1px 1px rgba(100, 100, 100, 0.1);
        background: #70b7de;
        color: #fff;
    }

    .header-left {
        display: flex;
        align-items: center;
    }

    .header-title {
        font-size: 18px;
        font-weight: bold
    }

    .header-right {
        margin-right: 20px;
    }

    .header-right.btn-blue {
        color: #fff;
        font-size: 16px;
    }
    .demo-badge{
        width: 42px;
        height: 42px;
        background: #eee;
        border-radius: 6px;
        display: inline-block;
    }

</style>
<template>
    <div class="layout">
        <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
            <div class="logo">
                <div class="xfind-line" >
                    <div class="line-h"></div>
                </div>
                <div  class="logo-saiqu">
                    <Avatar icon="ios-person" size="large"/>
                    <span class="user-name">Admin</span>
                </div>
            </div>
            <Menu active-name="1-2" theme="dark" width="auto" :open-names="['1']">
                <MenuItem name="1" to="home">
                    <Icon type="md-document" />
                    首页
                </MenuItem>
                <Submenu name="2">
                    <template slot="title">
                        <Icon type="ios-navigate"></Icon>
                        订单管理
                    </template>

                    <MenuItem name="2-1" to="realTimeOrder">
                        <Badge :count="3"  :offset="[0, -10]">实时订单
                    </Badge>
                    </MenuItem>

                    <MenuItem name="2-2" to="historyOrder">历史订单</MenuItem>
                </Submenu>
                <Submenu name="3">
                    <template slot="title">
                        <Icon type="ios-keypad"></Icon>
                        菜单管理
                    </template>
                    <MenuItem name="3-1" to="updataMenu">修改菜单</MenuItem>
                    <MenuItem name="3-2" to="addMenu">新增菜单</MenuItem>
                </Submenu>
                <Submenu name="4">
                    <template slot="title">
                        <Icon type="ios-analytics"></Icon>
                        类别管理
                    </template>
                    <MenuItem name="4-1">修改类别</MenuItem>
                    <MenuItem name="4-2">新增类别</MenuItem>
                </Submenu>

                <Submenu name="5">
                    <template slot="title">
                        <Icon type="ios-analytics"></Icon>
                        信息统计
                    </template>
                    <MenuItem name="5-1">用户评论</MenuItem>
                    <MenuItem name="5-2">处理事件</MenuItem>
                </Submenu>
                <MenuItem name="6" >
                    <Icon type="md-document" />
                    权限管理
                </MenuItem>
            </Menu>
        </Sider>
        <Layout :style="{marginLeft: '200px'}">
            <Header class="layout-header-bar" >
                <div class="header-wapper">
                    <div class="header-left">
                        <span class="header-title" style="margin-left: 20px">后台管理系统</span>
                    </div>
                    <div class="header-right" >
                        <Button @click="login" type="text" icon="md-exit" class="btn-blue" size="large" >退出系统</Button>
                    </div>
                </div>
            </Header>
            <Content >
                <Breadcrumb :style="{margin: '16px 0'}">
                </Breadcrumb>
                <Card>
                    <div style="">
                        <router-view></router-view>
                    </div>
                </Card>
            </Content>
        </Layout>
    </div>
</template>
<script>

    export default {
        data() {
            return {

            }
        },
        methods: {
            login(){
                if (confirm("是否退出系统")) {
                    this.$axios.delete('http://localhost:8888/admin')
                        .then(resp => {
                            if (resp.data.code === 200) {
                                this.$router.push("/login");
                            } else {
                                alert("退出失败")
                            }
                        })
                }
            }
        },
    }
</script>
