import { Card } from 'antd';
import React from 'react';

export const formItemLayout = {
	labelCol: {
		xs: { span: 24 },
		sm: { span: 6 },
	},
	wrapperCol: {
		xs: { span: 24 },
		sm: { span: 18 },
	},
};

const DefCard = (props) => {
	return (
		<Card size='small' title={props.title}>
			{props.children}
		</Card>
	);
};

export default DefCard;
