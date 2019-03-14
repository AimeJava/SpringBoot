<style scoped>
    .expand-row{
        margin-bottom: 26px;
    }
</style>
<template>
    <div>
        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">订单号: </span>
                <span class="expand-value">{{ row.orderNumber }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">订单状态: </span>
                <span class="expand-value">{{ row.orderState }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">订单生成时间: </span>
                <span class="expand-value">{{ row.orderTime }}</span>
            </Col>
        </Row>
        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">订单支付状态: </span>
                <span class="expand-value">{{ row.orderPayState }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">用户: </span>
                <span class="expand-value">{{ row.userInfo.userName }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">用户电话: </span>
                <span class="expand-value">{{ row.userInfo.userTel }}</span>
            </Col>
        </Row>
        <Row >
            <Col span="8">
                <span class="expand-key">地址: </span>
                <span class="expand-value">{{ row.address.addressInfo }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">订单留言: </span>
                <span class="expand-value">{{ row.orderRemark }}</span>
            </Col>
        </Row>
    </div>
</template>
<script>
    export default {
        props: {
            row: Object
        }
    };
</script>