<template>
    <div>
        <el-dialog v-model="loginForm" title="登陆" status-icon :rules="rules1" :visible.sync="outerVisible">
            <el-form >
                <el-form-item prop="user">
                    <el-input type="text" v-model="loginForm.userName" auto-complete="off" placeholder="账号"></el-input>
                </el-form-item>
                <el-form-item prop="pwd">
                    <el-input type="password" v-model="loginForm.userPwd" auto-complete="off"
                              placeholder="密码"></el-input>
                </el-form-item>
                <el-form-item style="width:100%;">
                    <el-button type="primary" style="width:50%;" @click="submitLogin('loginForm')">登录
                    </el-button>
                </el-form-item>
            </el-form>
            <el-dialog
                    width="40%"
                    title="注册"
                    :visible.sync="innerVisible"
                    append-to-body>
                <v-register ref="myRegister"></v-register>
            </el-dialog>
            <div slot="footer" class="dialog-footer">
                <!--<el-button @click="outerVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="Visible">没有账号？注册一个</el-button>
            </div>

        </el-dialog>
    </div>
</template>

<script>

    import register from "./enroll.vue"

    export default {
        data() {
            let user = (rule, value, callback) => {
                if (value === '' || value === null) {
                    callback(new Error("请输入用户名"))
                } else {
                    callback()
                }
            };
            let pwd = (rule, value, callback) => {
                if (value === '' || value === null) {
                    callback(new Error("请输入密码"))
                } else {
                    callback()
                }
            };
            return {
                outerVisible: false,
                innerVisible: false,
                loginForm: {
                    userName: '',
                    userPwd: ''
                },
                rules1: {
                    name: [
                        {validator: user, trigger: "change"}
                    ],
                    pwd: [
                        {validator: pwd, trigger: "change"}
                    ]
                }
            }

        },
        methods: {
            parentHandleclick() {
                this.outerVisible = true;
            },
            Visible() {
                this.innerVisible = true;

            },
            submitLogin(form) {
                this.$refs[form].validator((valid) => {
                    if (valid) {
                      
												let userInfo = {"userName": this.ruleForm2.user, "userPwd": this.ruleForm2.pass,""};
												
											
											
												alert(userInfo)
                        // fetch("http://localhost:8888/insertUser", {
                        //     method: 'POST',
                        //     headers: new Headers({
                        //         'Content-Type': 'application/json'
                        //     }),
                        //     body: JSON.stringify(userInfo),
                        //
                        // }).catch(error => alert(error))
                        //     .then(alert("注册成功"));
                    } else {
                        // alert('输入有误');
                        return false;
                    }
                });
            }
        },
        components: {
            "v-register": register
        }
    }
</script>

<style scoped>

</style>