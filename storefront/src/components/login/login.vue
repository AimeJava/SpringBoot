<template>
    <div>
        <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" class="demo-ruleForm">
            <el-form-item label="账号" prop="user">
                <el-input type="text" v-model="ruleForm2.user" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pwd">
                <el-input type="password" v-model="ruleForm2.pwd" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
                <!--<el-button @click="resetForm('ruleForm2')">重置</el-button>-->
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            //定义验证规则
            var checkUser = (rule, value, callback) => {
                if (value === '' || value === null) {
                    return callback(new Error('用户名不能为空'));
                } else {
                    callback();
                }

            };
            var checkPass = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('请输入密码'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm2: {
                    user: '',
                    pwd: '',
                    userInfo: ''

                },
                rules2: {
                    user: [
                        {validator: checkUser, trigger: 'blur'}
                    ],
                    pwd: [
                        {validator: checkPass, trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let userInfo = {"userName": this.ruleForm2.user, "userPwd": this.ruleForm2.pwd};
                        this.axios.post('http://localhost:8888/user/login', userInfo)
                            .then(rep => rep)
                            .then(
                                console.log(sessionStorage.getItem("userInfo"))
                            )

                        // fetch('http://localhost:8888/user/login', {
                        //     method: 'POST',
                        //     headers: {
                        //         'Content-Type': 'application/json'
                        //     },
                        //      credentials: 'include',
                        //     body: JSON.stringify(userInfo)
                        // }).then(response => response.json())
                        //     .then(resp => {
                        //        if (resp.data !== null) {
                        //            sessionStorage.setItem('user',resp.data);
                        //            this.$emit('show',false);
                        //        }
                        //
                        //     })
                    } else {

                        return false;
                    }
                });
            }
            // resetForm(formName) {
            //     this.$refs[formName].resetFields();
            // }
        }


    }
</script>

<style scoped>

</style>