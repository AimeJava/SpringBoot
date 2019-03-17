<template>
    <div>
        <el-button @click="go">继续购买</el-button>
        <template>
            <h2>请选择送货地址</h2>
            <el-radio v-model="radio" label="1">北京路33号六楼</el-radio>
            <br/>
            <el-radio v-model="radio" label="2">南昌路23号33楼</el-radio>
            <br/>
            <el-radio v-model="radio" label="3">广州上下九24号</el-radio>
            <br/>
        </template>
        <el-table
                :data="tableData"
                style="width: 100%"
                @selection-change="selected">
            <el-table-column
                    type="selection"
                    width="50">
            </el-table-column>
            <el-table-column
                    label="商品名称"
                    width="450">
                <template scope="scope">
                    <div style="">
                        <img :src="'http://localhost:8888/images/'+scope.row.menuInfo.menuImage" style="height: 50px;width: 50px">
                        <span style="font-size: 20px;padding-left: 100px;">{{scope.row.menuInfo.menuName}}</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column
                    label="单价"
                    width="150"
            prop="menuInfo.menuPrice">
            </el-table-column>
            <el-table-column
                    label="数量"
                    width="350">
                <template scope="scope">
                    <div>
                        <el-input @keyup.enter.native="handleClick"
                                v-model="scope.row.menuNumber"  @change="handleInput(scope.row)">
                            <el-button slot="prepend" @click="del(scope.row)"><i class="el-icon-minus"></i></el-button>
                            <el-button slot="append" @click="add(scope.row)"><i class="el-icon-plus"></i></el-button>
                        </el-input>
                    </div>
                </template>
            </el-table-column>
            <el-table-column
                    label="小计"
                    width="150"
                  prop="menuSubtotal" >

            </el-table-column>
            <el-table-column label="操作">
                <template scope="scope">
                    <el-button type="danger" @click="handleDelete(scope.$index, scope.row)">
                        删除<i class="el-icon-delete2 el-icon--right"></i>
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <br>
        <el-button type="info" style="float: right">{{"商品总额：" + moneyTotal}}</el-button>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {
                radio: '1',
                tableData: [],
                moneyTotal: 0,
                multipleSelection: [],
            }
        },
        created () {
            var parse = JSON.parse(sessionStorage.getItem('userInfo'));
            fetch('http://localhost:8888/cart?userId='+ parse.userId)
                .then(response => response.json())
                .then(resp => {
                    //console.log(resp.data.menuInfo);
                   // console.log(resp.data.menuInfo.menuImage);
                    this.tableData = resp.data;
                    //alert(sessionStorage.getItem("userInfo"));
                });
        },
        methods: {
            go() {
                this.$router.push('/')
            },
            handleClick() {
                this.num = this.num.replace(/[^\w]/g, '');
            },
            handleDelete(index) {
                this.$confirm('确定删除该商品？', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    //删除数组中指定的元素
                    this.tableData.splice(index, 1);
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            handleInput (value) {
                if (null == value.menuNumber || value.menuNumber === "") {
                    value.menuNumber = 1;
                }
                value.menuSubtotal = (value.menuNumber * value.menuInfo.menuPrice).toFixed(2);//保留两位小数
                //增加商品数量也需要重新计算商品总价
                this.selected(this.multipleSelection);
            },
            add (addGood) {
                //输入框输入值变化时会变为字符串格式返回到js
                //此处要用v-model，实现双向数据绑定
               // alert(addGood.number);
               //  if (typeof addGood.menuNumber === 'string') {
               //      addGood.menuNumber = parseInt(addGood.menuNumber);
               //  }
                addGood.menuNumber += 1;
                addGood.menuSubtotal = (addGood.menuNumber * addGood.menuInfo.menuPrice).toFixed(2);//保留两位小数
                if (typeof addGood.menuSubtotal === 'string') {
                    addGood.menuSubtotal = parseInt(addGood.menuSubtotal);

                  //  this.moneyTotal = addGood.menuSubtotal;
                }

            },
            del (delGood) {

                if (delGood.menuNumber > 1) {
                    delGood.menuNumber -= 1;
                    delGood.menuSubtotal = (delGood.menuNumber * delGood.menuInfo.menuPrice).toFixed(2);//保留两位小数

                    if (typeof delGood.menuSubtotal === 'string') {
                        delGood.menuSubtotal = parseInt(delGood.menuSubtotal);
                        this.moneyTotal -= delGood.menuSubtotal;
                    }
                }
            },
            //返回的参数为选中行对应的对象
            selected (selection) {
                this.multipleSelection = selection;
                this.moneyTotal = 0;
                //console.log(selection[1].menuNumber);
             //   console.log(selection[0].menuInfo.menuPrice);
                //此处不支持forEach循环，只能用原始方法了
                for (var i = 0; i < selection.length; i++) {
                    //判断返回的值是否是字符串
                   //  if (typeof selection[i].menuInfo.menuPrice === 'string') {
                         selection[i].menuInfo.menuPrice = parseInt(selection[i].menuInfo.menuPrice);
                    // console.log( selection[i].menuInfo.menuPrice);
               //     console.log( selection[i].menuSubtotal);
                    // }
                    this.moneyTotal += selection[i].menuSubtotal;
                }
            },

        },
    }
</script>

<style>
</style>
