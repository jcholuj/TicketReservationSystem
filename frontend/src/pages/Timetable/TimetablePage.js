import { SearchOutlined } from '@ant-design/icons';
import { Button, Col, DatePicker, Divider, Layout, Row } from 'antd';
import React, { Component } from 'react';
import AppBreadcrumb from '../../components/general/AppBreadcrumb';
import ConnectionList from '../../components/Timetable/ConnectionList';
import Topheader from '../../components/Timetable/TopHeader';
import GenericPage from '../GenericPage';

import '../../styles/Timetable/TimetablePage.less';

const { Header, Content } = Layout;

class TimetablePage extends Component {
	state = {};
	render() {
		return (
			<GenericPage
				title='Timetable'
				className='timetable-page'
				headerActiveTab='1'
			>
				<Layout className='app-content'>
					<Topheader />
					<Layout className='timetable-wrapper'>
						<Header className='timetable-list-header'>
							<Row justify='space-between' align='top'>
								<Col>
									<AppBreadcrumb
										page={{ name: 'Timetable', link: '/timetable' }}
									/>
								</Col>
								<Col>
									<Button
										size='small'
										shape='round'
										type='link'
										icon={<SearchOutlined />}
										style={{ display: 'block' }}
									>
										New search
									</Button>
								</Col>
								<Col>
									<DatePicker style={{ display: 'flex' }} size='large' />
								</Col>
							</Row>
							<Row>
								<Col></Col>
							</Row>
							<Divider />
						</Header>
						<Content className='timetable-inner'>
							<ConnectionList />
						</Content>
					</Layout>
				</Layout>
			</GenericPage>
		);
	}
}

export default TimetablePage;
