<template>
  <div style="overflow:hidden;">
    <Row :gutter="20">
      <i-col :xs="12" :md="8" :lg="4" v-for="(infor, i) in inforCardData" :key="`infor-${i}`" style="height: 120px;padding-bottom: 10px;">
        <infor-card shadow :color="infor.color" :icon="infor.icon" :icon-size="36">
          <count-to :end="infor.count" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <sc-visit></sc-visit>
    <sc-salesVolume></sc-salesVolume>
  </div>
</template>

<script>
  import visit from '../../components/schart/visit'
  import salesVolume from '../../components/schart/salesVolume'
  import InforCard from '../../components/info-card'
  import CountTo from '../../components/count-to'
    export default {
        name: 'home',
        data () {
            return {
                inforCardData: [
                    { title: '新增用户', icon: 'md-person-add', count: 203, color: '#2d8cf0' },
                    { title: '累计点击', icon: 'md-locate', count: 332, color: '#19be6b' },
                    { title: '新增问答', icon: 'md-help-circle', count: 102, color: '#ff9900' },
                    { title: '分享统计', icon: 'md-share', count: 57, color: '#ed3f14' },
                    { title: '新增互动', icon: 'md-chatbubbles', count: 10, color: '#E46CBB' },
                    { title: '新增订单', icon: 'md-map', count: 3, color: '#9A66E4' }
                ]
            }
        },
        mounted () {
            //
        },
        components: {
            'sc-visit':visit,
            'sc-salesVolume':salesVolume,
            'infor-card':InforCard,
            'count-to':CountTo
        }
    }
</script>

<style lang="less">
  .count-style{
    font-size: 50px;
  }
</style>
