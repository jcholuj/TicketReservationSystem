import { SearchOutlined } from '@ant-design/icons';
import { Button, Col, DatePicker, Divider, Layout, Popover, Row } from 'antd';
import React, { Component } from 'react';
import AppBreadcrumb from '../../components/general/AppBreadcrumb';
import ConnectionList from '../../components/Timetable/ConnectionList';
import Topheader from '../../components/Timetable/TopHeader';
import GenericPage from '../GenericPage';

import '../../styles/Timetable/TimetablePage.less';
import Toolbar from '../../components/Timetable/Toolbar';
import NewSearchForm from '../../components/Timetable/NewSearchForm';

const { Header, Content } = Layout;
const dateTimeFormat = 'DD.MM.YYYY';

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
									<Popover
										placement='bottom'
										content={<NewSearchForm />}
										trigger='click'
									>
										<Button
											size='small'
											shape='round'
											type='link'
											icon={<SearchOutlined />}
											style={{ display: 'block' }}
										>
											New search
										</Button>
									</Popover>
								</Col>
								<Col>
									<DatePicker
										format={dateTimeFormat}
										style={{ display: 'flex' }}
										size='large'
									/>
								</Col>
							</Row>
							<Row>
								<Col>
									<Toolbar />
								</Col>
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
