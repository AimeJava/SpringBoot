<template>
    <el-row>
        <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card :body-style="{ padding: '0px' }">
                <img src="/static/2002.jpg" class="image">
                <div style="padding: 0px;">
                    <span>好吃的汉堡</span>
                    <div class="bottom clearfix">
                        <time class="time">{{ currentDate }}</time>
                        <el-button type="text" class="button">操作按钮</el-button>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "main",
        data() {
            return{
            }
        }
    }
</script>

<style scoped>

</style>