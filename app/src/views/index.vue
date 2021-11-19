<template>
  <el-container>
    <el-header class="header">
      <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-menu-item index="1">首页</el-menu-item>
        <el-menu-item index="2">财富中心</el-menu-item>
      </el-menu>
    </el-header>
    <el-main class="main" style="">
      <div style="">
        <el-image
            style="height: calc(100vh - 120px)"
            :src="require('@/assets/img/sky.png')"
            fit="scale-down"></el-image>
      </div>

    </el-main>
  </el-container>
</template>

<script>

export default {
  name: 'index',
  components: {},
  data() {
    return {
      activeIndex: "1"
    }
  },
  methods: {
    handleSelect() {

    }
  }
}
</script>

<style>

</style>
