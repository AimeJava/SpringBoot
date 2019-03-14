<template>
    <div class="bg-wrap" :style="login_img">
        <el-form label-position="left" label-width="0px"
                 class="demo-ruleForm login-container"
                 :model="userForm" :rules="ruleCustom" ref="ruleForm" status-icon>
            <h3 class="title">用户登录</h3>
            <el-form-item prop="username">
                <el-input class="input" type="text" v-model="userForm.username" auto-complete="off" placeholder="手机号"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input class="input" type="password" v-model="userForm.password" auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-checkbox checked class="remember">记住密码</el-checkbox>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="btn_login(userForm)">登录
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                login_img: {
                    backgroundImage: "url(" + require("../assets/002.jpeg") + ")",
                },
                userForm: {
                    username: '',
                    password: ''
                },
                ruleCustom: {
                    username: [
                        {required: true, message: '用户名不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            btn_login(form) {

                let userInfo = {userTel: form.username, userPwd: form.password};
                //  console.log(userInfo)
                fetch('http://localhost:8888/user/login', {
                    method: 'POST',
                    headers: {
                        'content-type': 'application/json'
                    },
                    body: JSON.stringify(userInfo),
                    credentials: "include"
                })
                    .then(response => response.json())
                    .then(resp => {
                        //console.log(resp.code);
                        if (resp.code === 200) {

                            sessionStorage.setItem('userInfo', JSON.stringify(resp.data));
                            this.$router.push('/')
                        } else {

                            this.$message.error(resp.error);
                        }


                    });
                // console.log(this.userForm)
                //this.$router.push('/')
            }
        }
    }

</script>

<style lang="scss" scoped>
    .login-container {
        /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
        -webkit-border-radius: 5px;
        border-radius: 5px;
        -moz-border-radius: 5px;
        background-clip: padding-box;
        margin: 100px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #8e6f52;
        border: 1px solid #e4ca97;
        box-shadow: 0 0 25px #f6eabe;
        //opacity: 0.9;
        .title {
            margin: 0 auto 40px auto;
            text-align: center;
            color: #f6eabe;
        }
        .remember {
            margin: 0 0 35px 0;
        }
        .input {
            text-align: center;
            width: 100%;
        }
    }

    .bg-wrap {
        width: 100%;
        height: 100%;
        background-size: cover;
        background-position: center;
        position: absolute;
        /*border: 10px solid;*/

    }

</style>