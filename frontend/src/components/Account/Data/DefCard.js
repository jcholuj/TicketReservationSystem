import { Card } from 'antd';
import React from 'react';

const HocCard = (props) => {
	return (
		<Card size='small' title={props.title}>
			{props.children}
		</Card>
	);
};

export default HocCard;
