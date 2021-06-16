import React from 'react';

import { Menu } from 'antd';
import { UserOutlined, IdcardOutlined } from '@ant-design/icons';

const { SubMenu } = Menu;

const menuOptions = {
	1: {
		title: 'Your data',
		tooltip: 'Secured customer profile',
	},
	2: {
		title: 'Preferences',
		tooltip: 'App customization options',
	},
	3: {
		title: 'Related passengers',
		tooltip: 'Your trip companions or relatives',
	},
	4: {
		title: 'Tickets',
		tooltip: 'List of all previously made purchases',
	},
};

const SideMenu = (props) => {
	return (
		<Menu
			defaultSelectedKeys={['1']}
			defaultOpenKeys={['sub1']}
			mode='inline'
			onSelect={({ key }) => {
				props.selectHandler(key, menuOptions[key]);
			}}
		>
			<SubMenu key='sub1' icon={<UserOutlined />} title='My Account'>
				<Menu.Item key='1'>{menuOptions['1'].title}</Menu.Item>
				<Menu.Item key='2'>{menuOptions['2'].title}</Menu.Item>
				<Menu.Item key='3'>{menuOptions['3'].title}</Menu.Item>
			</SubMenu>
			<Menu.Item icon={<IdcardOutlined />} key='4'>
				{menuOptions['4'].title}
			</Menu.Item>
		</Menu>
	);
};

export default SideMenu;
