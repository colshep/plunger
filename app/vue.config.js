const webpack = require('webpack')

module.exports = {

    // app项目根目录
    publicPath: process.env.VUE_APP_URL,
    devServer: {
        // 项目运行时候的端口号
        port: process.env.VUE_APP_PORT
    },

    chainWebpack: config => {

        // 全局引入jquery
        config.plugin('provide').use(webpack.ProvidePlugin, [{
            $: 'jquery',
            jquery: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery'
        }])

        // svg-sprite-loader配置使用svg图标
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule
            .use("svg-sprite-loader")
            .loader("svg-sprite-loader")
            .options({
                symbolId: "icon-[name]"
            });

    }
}
