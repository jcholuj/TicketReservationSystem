import React from "react";
import { Breadcrumb } from "antd";
import { Link } from "react-router-dom";

const AppBreadcrumb = ({ children, ...props }) => {
	return (
		<Breadcrumb>
			<Breadcrumb.Item>
				<Link to='/'>Home</Link>
			</Breadcrumb.Item>
			<Breadcrumb.Item>
				<Link to={props.page.link}>{props.page.name}</Link>
			</Breadcrumb.Item>
		</Breadcrumb>
	);
};

export default AppBreadcrumb;
