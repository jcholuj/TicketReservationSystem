import { Col, Row } from 'antd';
import React from 'react';
import AddressCard from '../Data/AddressCard';
import GeneralCard from '../Data/GeneralCard';
import PersonalCard from '../Data/PersonalCard';
import SecurityCard from '../Data/SecurityCard';

const PersonalData = () => {
	return (
		<Row gutter={[30, { xs: 8, sm: 16, md: 24, lg: 32 }]}>
			<Col lg={10}>
				<GeneralCard avatarNum='1' />
			</Col>
			<Col lg={11}>
				<PersonalCard />
			</Col>
			<Col lg={10}>
				<AddressCard />
			</Col>
			<Col lg={11}>
				<SecurityCard />
			</Col>
		</Row>
	);
};

export default PersonalData;
