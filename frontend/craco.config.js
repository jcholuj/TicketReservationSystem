module.exports = {
  devServer: {
    host: "localhost",
    port: 3000
  },
  plugins: [
    {
      plugin: require("craco-antd"),
      options: {},
    },
  ],
};
