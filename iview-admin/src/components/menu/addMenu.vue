<template>
    <div>
        <i-form :model="formValidate" :rules="ruleValidate" :label-width="80">
                <Form-item label="菜名" prop="name">
                    <i-input :value.sync="formValidate.name" placeholder="请输入菜名"></i-input>
                </Form-item>
                <Form-item label="类别" prop="mail">
                    <i-select :model.sync="formValidate.type" placeholder="请选择类别">
                        <i-option value="beijing">家常菜</i-option>
                        <i-option value="shanghai">私家菜</i-option>
                        <i-option value="shenzhen">...</i-option>
                    </i-select>
                </Form-item>
                <Form-item label="菜价格" prop="city">
                    <i-input :value.sync="formValidate.price" placeholder="请输入价格"></i-input>
                </Form-item>
                <Form-item label="菜图片">
                    <Row>
                        <i-col span="11">
                            <Upload action="//jsonplaceholder.typicode.com/posts/" >
                                <i-button type="ghost" icon="ios-cloud-upload-outline">上传文件</i-button>
                            </Upload>
                        </i-col>
                    </Row>
                </Form-item>
                <Form-item label="菜详情" prop="gender">
                    <i-input type="textarea" placeholder="请输入..."></i-input>
                </Form-item>
                <Form-item label="折扣/优惠" prop="interest">
                    <RadioGroup >
                        <Radio label="8">8折</Radio>
                        <Radio label="8.5">8.5折</Radio>
                        <Radio label="9">9折</Radio>
                        <Radio label="9.5">9.5折</Radio>
                    </RadioGroup>
                </Form-item>
                <Form-item>
                    <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                    <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
                </Form-item>
            </i-form>
    </div>
</template>

<script>
    /*

    * */
    export default {
        data () {
            return {
                formValidate: {
                    name: '',
                    type: '',
                    price: '',
                    image: '',
                    remark: '',
                    discounts: '',
                },
                ruleValidate: {
                    name: [
                        { required: true, message: '菜名不能为空', trigger: 'blur' }
                    ],
                    type: [
                        { required: true, message: '请选择类别', trigger: 'change' }
                    ],
                    price: [
                        { required: true, message: '价格不能为空', trigger: 'change' }
                    ],
                    image: [
                        { required: true, message: '请选择图片', trigger: 'change' }
                    ]
                }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功!');
                    } else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>