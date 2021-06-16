import React, { Component } from 'react';
import {
	Button,
	Layout,
	Row,
	Col,
	Popconfirm,
	Space,
	Tooltip,
	Typography,
	Divider,
} from 'antd';
import { PoweroffOutlined, QuestionCircleOutlined } from '@ant-design/icons';

import GenericPage from '../GenericPage';
import SideMenu from '../../components/Account/SideMenu';
import AppBreadcrumb from '../../components/general/AppBreadcrumb';

import '../../styles/Account/AccountPage.less';
import headerImg from '../../static/account_img.svg';
import ContentPane from '../../components/Account/ContentPane';

const { Header, Content, Sider } = Layout;
const { Title } = Typography;
const logOutConfirm = (
	<Popconfirm
		placement='bottomRight'
		title='Proceed with logging out?'
		okText='Ok'
		cancelText='Cancel'
		cancelButtonProps={{ type: 'text' }}
		okType='default'
		okButtonProps={{ danger: true }}
	>
		<Button type='primary' size='large' icon={<PoweroffOutlined />} danger>
			Log out
		</Button>
	</Popconfirm>
);
const titleStyle = { margin: '0', userSelect: 'none' };

class AccountPage extends Component {
	constructor(props) {
		super(props);
		this.state = {
			activeTitle: 'Your data',
			activeTooltip: 'Secured customer profile',
			activeMenuKey: '1',
		};
	}

	handleMenuSelect = (key, { title, tooltip }) => {
		this.setState({
			activeTitle: title,
			activeTooltip: tooltip,
			activeMenuKey: key,
		});
	};

	render() {
		return (
			<GenericPage title='Account' className='account-page'>
				<Layout className='app-content'>
					<Header className='account-header'>
						<Row align='middle'>
							<Col flex='300px'>
								<img src={headerImg} alt='account header' />
							</Col>
							<Col flex='auto'>
								<Title level={2} style={titleStyle}>
									Welcome, Artem Popelyshev!
								</Title>
							</Col>
							<Col flex='150px'>{logOutConfirm}</Col>
						</Row>
					</Header>
					<Content className='account-wrapper'>
						<AppBreadcrumb page={{ name: 'Account', link: '/account' }} />
						<Layout className='inner'>
							<Sider
								style={{ backgroundColor: '#fff' }}
								breakpoint='md'
								collapsedWidth='0'
								width={300}
							>
								<SideMenu selectHandler={this.handleMenuSelect} />
							</Sider>
							<Content className='inner-content'>
								<Space direction='vertical'>
									<Space>
										<Title level={3} style={titleStyle}>
											{this.state.activeTitle}
										</Title>
										<Tooltip placement='right' title={this.state.activeTooltip}>
											<QuestionCircleOutlined />
										</Tooltip>
									</Space>
									<Divider />
									<ContentPane paneKey={this.state.activeMenuKey} />
								</Space>
							</Content>
						</Layout>
					</Content>
				</Layout>
			</GenericPage>
		);
	}
}

export default AccountPage;
