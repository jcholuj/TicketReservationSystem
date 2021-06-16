import { Button, List } from 'antd';
import React, { Component } from 'react';
import { CaretDownOutlined } from '@ant-design/icons';

import reqwest from 'reqwest';
import ConnectionEntry from './ConnectionEntry';

const count = 3;
const fakeDataUrl = `https://randomuser.me/api/?results=${count}&inc=name,gender,email,nat&noinfo`;

class ConnectionList extends Component {

	state = {
		initLoading: true,
		loading: false,
		data: [],
		list: [],
	};

	componentDidMount() {
		this.getData((res) => {
			this.setState({
				initLoading: false,
				data: res.results,
				list: res.results,
			});
		});
	}

	getData = (callback) => {
		reqwest({
			url: fakeDataUrl,
			type: 'json',
			method: 'get',
			contentType: 'application/json',
			success: (res) => {
				callback(res);
			},
		});
	};

	onLoadMore = () => {
		this.setState({
			loading: true,
			list: this.state.data.concat(
				[...new Array(count)].map(() => ({ loading: true, name: {} }))
			),
		});
		this.getData((res) => {
			const data = this.state.data.concat(res.results);
			this.setState(
				{
					data,
					list: data,
					loading: false,
				},
				() => {
					window.dispatchEvent(new Event('resize'));
				}
			);
		});
	};

	render() {
		const { initLoading, loading, list } = this.state;
		const loadMore =
			!initLoading && !loading ? (
				<div
					style={{
						textAlign: 'center',
						marginTop: 12,
						height: 32,
						lineHeight: '32px',
					}}
				>
					<Button onClick={this.onLoadMore} icon={<CaretDownOutlined />}>
						Load later
					</Button>
				</div>
			) : null;

		return (
			<List
				className='connection-list'
				loading={initLoading}
				itemLayout='horizontal'
				size='small'
				loadMore={loadMore}
				dataSource={list}
				style={{ padding: '0 50px' }}
				renderItem={(item) => <ConnectionEntry item={item} />}
			/>
		);
	}
}

export default ConnectionList;
