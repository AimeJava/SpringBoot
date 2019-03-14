<template>
    <div>
        <BackTop></BackTop>
        <Input search enter-button placeholder="输入菜名" />
            <Table :loading="loading" :columns="columns" :data="data">
                <template slot-scope="{ row, index }" slot="name">
                    <Input type="text" v-model="editName" v-if="editIndex === index" />
                    <span v-else>{{ row.menuName }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="type">
                    <Input type="text" v-model="editType" v-if="editIndex === index" />
                    <span v-else>{{ row.type.typeName }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="price">
                    <Input type="text" v-model="editPrice" v-if="editIndex === index" />
                    <span v-else>{{ row.menuPrice }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="image">
                    <Input type="text" v-model="editImage" v-if="editIndex === index" />
                    <!--<span v-else>{{ row.menuImage }}</span>-->
                    <img v-else :src="'http://localhost:8888/images/'+row.menuImage" class="image" style="width: 50px; height: 50px;">
                </template>
                <template slot-scope="{ row, index }" slot="remark">
                    <Input type="text" v-model="editRemark" v-if="editIndex === index" />
                    <span v-else>{{ row.menuRemark }}</span>
                </template>
                <template slot-scope="{ row, index }" slot="discounts">
                    <Input type="text" v-model="editDiscounts" v-if="editIndex === index" />
                    <span v-else>{{ row.menuDiscounts  }}</span>
                </template>

                <template slot-scope="{ row, index }" slot="action">
                    <div v-if="editIndex === index">
                        <Button @click="handleSave(index)">保存</Button>
                        <Button @click="editIndex = -1">取消</Button>
                    </div>
                    <div v-else>
                        <Button @click="handleEdit(row, index)">操作</Button>
                    </div>
                </template>
            </Table>

    </div>
</template>
<script>
    export default {
        data () {
            return {
                loading:true,
                columns: [
                    {
                        title: '菜名',
                        slot: 'name'
                    },
                    {
                        title: '类别',
                        slot: 'type'
                    },
                    {
                        title: '价格',
                        slot: 'price',
                        sortable: true
                    },
                    {
                        title: '图片',
                        slot: 'image'
                    },
                    {
                        title: '详情',
                        slot: 'remark'
                    },
                    {
                        title: '折扣',
                        slot: 'discounts'
                    },
                    {
                        title: '操作',
                        slot: 'action'
                    }
                ],
                data: [],
                editIndex: -1,  // 当前聚焦的输入框的行数
                editName: '',  // 第一列输入框，当然聚焦的输入框的输入内容，与 data 分离避免重构的闪烁
                editType: '',  // 第二列输入框
                editPrice: '',  // 第三列输入框
                editImage: '',  // 第四列输入框
                editRemark: '',  // 第五列输入框
                editDiscounts: '',  // 第六列输入框
            }
        },
        methods: {
            handleEdit (row, index) {
                this.editName = row.menuName;
                this.editType = row.type.typeName;
                this.editPrice = row.menuPrice;
                this.editImage = row.menuImage;
                this.editRemark = row.menuRemark;
                this.editDiscounts = row.menuDiscounts;
                this.editIndex = index;
            },
            handleSave (index) {
                this.data[index].menuName = this.editName;
                this.data[index].type.typeName = this.editType;
                this.data[index].menuPrice = this.editPrice;
                this.data[index].menuImage = this.editImage;
                this.data[index].menuRemark = this.editRemark;
                this.data[index].menuDiscounts = this.editDiscounts;
                this.editIndex = -1;
            },
            getBirthday (birthday) {
                const date = new Date(parseInt(birthday));
                const year = date.getFullYear();
                const month = date.getMonth() + 1;
                const day = date.getDate();
                return `${year}-${month}-${day}`;
            }
        },
        created: function () {
            this.$axios.get("http://localhost:8888/menu/all")
                .then(resp => {
                    this.data = resp.data.data;
                    //console.log(this.data[0].menuName);
                    this.loading = false;
                })
        }
    }
</script>

<style scoped>

</style>