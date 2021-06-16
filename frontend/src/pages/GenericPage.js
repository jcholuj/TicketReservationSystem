import React from 'react';
import { Helmet, HelmetProvider } from 'react-helmet-async';
import AppTopHeader from '../components/general/AppTopHeader';
import AppFooter from '../components/general/AppFooter';
import { Layout } from 'antd';
import '../styles/general/base.less';

const GenericPage = ({ children, ...props }) => {
	return (
		<HelmetProvider>
			<Helmet>
				<title>Trainy - {props.title}</title>
			</Helmet>
			<Layout className={props.className} style={props.topLayoutStyle}>
				<AppTopHeader selectedKey={props.headerActiveTab} />
				{children}
				<AppFooter />
			</Layout>
		</HelmetProvider>
	);
};

export default GenericPage;
