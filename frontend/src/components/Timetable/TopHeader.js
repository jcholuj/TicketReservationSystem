import { Col, Layout, Row, Typography } from 'antd';
import React, { useState } from 'react';

import arrow from '../../static/arrow.svg';

const { Header } = Layout;
const { Title } = Typography;

const Topheader = () => {
	return (
		<Header className='timetable-top-header'>
			<Row align='bottom'>
				<Col
					className='station-header-title'
					span={8}
					style={{ textAlign: 'right' }}
				>
					<Title level={2}>Totenham Court</Title>
				</Col>
				<Col style={{ padding: '50px 0 5px' }} flex='auto'>
					<hr />
					<img src={arrow} alt='header arrow' />
				</Col>
				<Col className='station-header-title' span={8}>
					<Title level={2}>Shepherd's Bush</Title>
				</Col>
			</Row>
			<Row justify='center'>
				<Col>
					<Title level={4}>DEPARTING ON 21.05.2021 AT 15:20</Title>
				</Col>
			</Row>
		</Header>
	);
};

export default Topheader;
