<template>
    <div>
        <el-dialog
                title="注册"
                :visible.sync="dialogVisible"
                width="30%"
        >
            <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="手机号" prop="user">
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
            <span slot="footer" class="dialog-footer">
    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <!--<el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
  </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data() {

            // var TEL_REGEXP = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
            //定义验证规则
            var checkUser = (rule, value, callback) => {

                if (!value) {
                    return callback(new Error('手机号不能为空'));
                } else {
                    const reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
                    if (reg.test(value)) {
                        fetch('http://localhost:8888/user/getTel?userTel='+value).then(resp => resp.json())
                            .then(resp => {
                                if (resp.code === 200) {
                                    return callback(new Error('此手机号已注册'));
                                } else {
                                    callback();
                                }
                            });

                    } else {
                        return callback(new Error('请输入正确的手机号'));
                    }
                }
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
                dialogVisible: false,
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
                        let userInfo = {"userTel": this.ruleForm2.user, "userPwd": this.ruleForm2.pass};

                        fetch("http://localhost:8888/user/insert", {
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
            },
            cut() {
                this.dialogVisible = true;
            }

        }
    }
</script>