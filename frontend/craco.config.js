const path = require("path");

module.exports = {
	devServer: {
		host: "localhost",
		port: 3000,
	},
	plugins: [
		{
			plugin: require("craco-antd"),
			options: {
				customizeThemeLessPath: path.join(
					__dirname,
					"src/styles/general/theme.less"
				),
			},
		},
	],
};
