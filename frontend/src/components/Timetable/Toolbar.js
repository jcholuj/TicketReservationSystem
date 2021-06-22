import { DownOutlined } from '@ant-design/icons';
import { Dropdown, Menu, Radio, Select, Space, Typography } from 'antd';
import React, { useState } from 'react';

const { Option } = Select;
const { Link } = Typography;

const menu = (
	<Menu>
		<Menu.Item key='0'>1st menu item</Menu.Item>
		<Menu.Item key='1'>2nd menu item</Menu.Item>
	</Menu>
);

const Toolbar = () => {
	const handleChange = (value) => {
		console.log(`selected ${value}`);
	};

	return (
		<Space className='timetable-toolbar' align='center' size='large'>
			<Radio.Group defaultValue='depart' size='small' buttonStyle='solid'>
				<Radio.Button value='depart'>Depart at</Radio.Button>
				<Radio.Button value='arrive'>Arrive by</Radio.Button>
			</Radio.Group>
			<Select
				mode='multiple'
				allowClear
				placeholder='Max number of stops:'
				size='small'
				onChange={handleChange}
			>
				<Option key='0'>Non-stop</Option>
				<Option key='1'>1 stop</Option>
				<Option key='2'>2 stops</Option>
			</Select>
			<Dropdown overlay={menu}>
				<Link className='dropdown'>
					Options <DownOutlined />
				</Link>
			</Dropdown>
		</Space>
	);
};

export default Toolbar;
