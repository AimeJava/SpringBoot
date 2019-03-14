<template>
    <div>
        <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px"
                 class="demo-ruleForm">
            <el-form-item label="用户名" prop="user">
                <el-input type="text" v-model="ruleForm2.user" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
                <el-input type="password" v-model="ruleForm2.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
                <el-button @click="resetForm('ruleForm2')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            //定义验证规则
            var checkUser = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('用户名不能为空'));
                }
                setTimeout(() => {
                    if (Number.isInteger(value)) {
                        callback(new Error('请输入尊称'));
                    } else {
                        callback();
                    }
                });
            };
            //定义验证规则
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm2.checkPass !== '') {
                        this.$refs.ruleForm2.validateField('checkPass');
                    }
                    callback();
                }
            };
            //定义验证规则
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm2.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm2: {
                    user: '',
                    pass: '',
                    checkPass: '',
                    age: '',

                },
                rules2: {
                    user: [
                        {validator: checkUser, trigger: 'change'}
                    ],
                    pass: [
                        {validator: validatePass, trigger: 'change'}
                    ],
                    checkPass: [
                        {validator: validatePass2, trigger: 'blur'}
                    ]
                },
                dialogFormVisible: false
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {

                    if (valid) {
                        let userInfo = {"userName": this.ruleForm2.user, "userPwd": this.ruleForm2.pass};

                        fetch("http://localhost:8888/insertUser", {
                            method: 'POST',
                            headers: new Headers({
                                'Content-Type': 'application/json'
                            }),
                            body: JSON.stringify(userInfo),

                        }).catch(error => alert(error))
                            .then(alert("注册成功"));
                    } else {
                        alert('输入有误');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>