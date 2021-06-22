import { ClockCircleOutlined, RightOutlined } from '@ant-design/icons';
import {
	Button,
	Col,
	List,
	Row,
	Skeleton,
	Space,
	Tag,
	Tooltip,
	Typography,
} from 'antd';
import React, { useState } from 'react';

import trainIcon from '../../static/train.svg';

const { Title, Text } = Typography;

const ConnectionEntry = (props) => {
	const item = props.item;

	return (
		<List.Item
			actions={[
				<Tooltip title='Buy'>
					<Button shape='circle' icon={<RightOutlined />} />
				</Tooltip>,
			]}
		>
			<Skeleton title={false} loading={item.loading} active>
				<Row style={{ width: '100%' }} align='middle'>
					<Col flex='auto'>
						<Space align='baseline'>
							<Title level={5}>18:34</Title>
							<Text className='entry-route'>
								Totenham Court - Shepherd's Bush
							</Text>
							<Title level={5}>20:00</Title>
						</Space>
					</Col>
					<Col span={4}>
						<Tag color='green'>Direct</Tag>
					</Col>
					<Col span={3}>
						<Space>
							<Text className='entry-duration'>4:35</Text>
							<ClockCircleOutlined />
						</Space>
					</Col>
					<Col span={6}>
						<Space className='entry-train-num'>
							<img src={trainIcon} alt='train icon' />
							<Text>TPK289448943</Text>
						</Space>
					</Col>
				</Row>
			</Skeleton>
		</List.Item>
	);
};

export default ConnectionEntry;
