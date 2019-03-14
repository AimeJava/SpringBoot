<template>
    <div>
        <el-dialog
                :visible.sync="dialogVisible">
            <el-tabs v-model="activeName">
                <el-tab-pane label="登陆" name="first">
                    <v-login @show="parentShow($event)"></v-login>
                </el-tab-pane>
                <el-tab-pane label="注册" name="second">
                    <v-register></v-register>
                </el-tab-pane>
            </el-tabs>
        </el-dialog>
    </div>
</template>


<script>
    import login from './login/login.vue'
    import register from './login/enroll.vue'

    export default {
        data() {
            return {
                dialogVisible: false,
                activeName: 'first'
            };
        },
        methods: {
            parentHandleclick2() {
                this.dialogVisible = true;
            },
            parentShow(e){
                this.dialogVisible = e;
            }
        },
        components: {
            "v-login": login,
            "v-register": register
        }
    };
</script>