<template>
    <div id="mySales" :style="{width: '500px', height: '400px',float: 'left',marginLeft:'12em',marginTop:'50px'}"></div>
</template>
<script>
    export default {
        data() {
            return {
                title:''
            }
        },
        mounted() {
            this.drawLine();
        },
        methods: {
            drawLine() {
                //this.title = '坐标轴刻度与标签对齐';

                // 基于准备好的dom，初始化echarts实例
                let mySales = this.$echarts.init(document.getElementById('mySales'))

                mySales.setOption({
                    title:{
                        text: '各类销售量',
                        subtext: '',
                        x: 'center'
                    },
                    color: ['#3398DB'],
                    tooltip : {
                        trigger: 'axis',
                        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '0%',
                        right: '0%',
                        bottom: '0%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : ['家常菜', '私家菜', '凉菜', '海鲜','汤粥', '素食', '甜品点心', '糕点主食'],
                            axisTick: {
                                alignWithLabel: false
                            }
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'直接访问',
                            type:'bar',
                            barWidth: '90%',
                            data:[242, 132, 42, 134, 130, 32, 185,52]
                        }
                    ]

                })
            }
        }
    }
</script>