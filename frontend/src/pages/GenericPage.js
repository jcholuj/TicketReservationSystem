import React, { Fragment } from "react";
import { Helmet } from "react-helmet";
import AppTopHeader from "../components/general/AppTopHeader";
import AppFooter from "../components/general/AppFooter";
import { Layout } from "antd";
import "../styles/general/base.less";

const GenericPage = ({ children, ...props }) => {
	return (
		<Fragment>
			<Helmet>
      	<title>Trainy - {props.title}</title>
    	</Helmet>
			<Layout className={props.className} style={props.topLayoutStyle}>
				<AppTopHeader selectedKey={props.headerActiveTab} />
				{children}
				<AppFooter />
			</Layout>
		</Fragment>
	);
};

export default GenericPage;
