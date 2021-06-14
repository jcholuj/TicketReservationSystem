import React from 'react';
import { Layout, Tag, Divider } from 'antd';
import { GithubOutlined } from '@ant-design/icons';

const { Footer } = Layout;
const dividerStyle = { borderLeftColor: 'rgba(0, 0, 0, 0.2)' };

const AppFooter = () => {
	return (
		<Footer style={{ textAlign: 'center', padding: '15px 50px' }}>
			Trainy App ©
			<Divider style={dividerStyle} type='vertical' />
			2021 - Politechnika Wrocławska
			<Divider style={dividerStyle} type='vertical' />
			<Tag icon={<GithubOutlined />} color='#333'>
				<a href='https://github.com/jcholuj/TicketReservationSystem/tree/develop'>
					Github repo
				</a>
			</Tag>
		</Footer>
	);
};

export default AppFooter;
