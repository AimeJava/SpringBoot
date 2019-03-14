<template>
    <Table :columns="columns10" :data="data">
        <template slot-scope="{ row, index }" slot="action">
            <Button type="primary" size="small" style="margin-right: 5px" @click="show(index)">详情订单</Button>
            <Button type="error" size="small" @click="remove(index)">删除</Button>
        </template>
    </Table>
</template>
<script>
    import expandRow from './table-expand.vue';
    export default {
        components: { expandRow },
        data () {
            return {
                columns10: [
                    {
                        type: 'expand',
                        width: 50,
                        render: (h, params) => {
                            return h(expandRow, {
                                props: {
                                    row: params.row
                                }
                            })
                        }
                    },
                    {
                        title: '订单号',
                        key: 'orderNumber'
                    },
                    {
                        title: '订单状态',
                        key: 'orderState'
                    },
                    {
                        title: '订单生成时间',
                        key: 'orderTime'
                    },
                    {
                        title: '订单支付状态',
                        key: 'orderPayState'
                    },
                    {
                        title: '操作',
                        slot: 'action',
                        width: 150,
                        align: 'center'
                    }
                ],
                data: [

                ]
            }
        },
        created (){

            this.$axios("http://localhost:8888//historyOrder")
            .then(resp => {
                this.data = resp.data;
                //  this.user = resp.data[1].userInfo.userName;
                //  console.log(this.data)
                // console.log(resp.data[0].userInfo.userName);
            })
        }
        ,
        methods: {
            show (index) {
                this.$Modal.info({
                    title: '订单细节',
                    // content: `Name：${this.data6[index].orderNumber}<br>Age：${this.data6[index].orderState}<br>Address：${this.data6[index].orderRemark}`
                    content:`用户：`+this.data[index].userInfo.userName+'<br>地址：'+this.data[index].address.addressInfo+
                        '<br>菜名：'+this.data[index].detailList[0].menuName+'&nbsp数量：'+this.data[index].detailList[0].menuCounts


                })
            },
            remove (index) {
                this.data.splice(index, 1);
            }
        }
    }
</script>