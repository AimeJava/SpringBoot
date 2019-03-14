<template>
    <div>
        <el-dropdown @command="handleCommand">
  <span class="el-dropdown-link">
    <img src="../../assets/59.jpg"/>
      <!--<i class="el-icon-arrow-down el-icon--right"></i>-->
  </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="1">个人信息</el-dropdown-item>
                <el-dropdown-item command="2">购物车</el-dropdown-item>
                <el-dropdown-item command="3">注销</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
</template>

<script>
    export default {
        data() {
            return {}
        },
        methods: {
            handleCommand(comd) {
                if (comd === '2') {
                    this.$router.push('/cart');
                }
                if (comd === '3') {
                    sessionStorage.removeItem("userInfo");
                    this.$router.go(0);
                }
            }
        }

    }
</script>

<style scoped>

</style>