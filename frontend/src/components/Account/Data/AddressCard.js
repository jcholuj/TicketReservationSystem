import { Form, Input, Select } from 'antd';
import React, { useState } from 'react';
import DefCard, { formItemLayout } from './DefCard';

import addressImg from '../../../static/address.svg';

const { Option } = Select;

const AddressCard = () => {
	const [addressForm] = Form.useForm();

	return (
		<DefCard title='Address details'>
			<Form
				{...formItemLayout}
				form={addressForm}
				name='address-form'
				requiredMark={false}
				scrollToFirstError
			>
				<img src={addressImg} alt='address thumbnail' />

				<Form.Item name={['address', 'line']} label='Address line'>
					<Input placeholder='Street, building..' />
				</Form.Item>

				<Form.Item label='Country / City'>
					<Input.Group compact>
						<Form.Item name={['address', 'country']} noStyle>
							<Select style={{ width: '50%' }} placeholder='Select country'>
								<Option value='PL'>Poland</Option>
								<Option value='RU'>Russia</Option>
							</Select>
						</Form.Item>
						<Form.Item name={['address', 'city']} noStyle>
							<Input
								style={{ width: '50%', marginLeft: '1px' }}
								placeholder='Input city'
							/>
						</Form.Item>
					</Input.Group>
				</Form.Item>
				<Form.Item name={['address', 'postal_code']} label='Postal code'>
					<Input placeholder='12345' style={{ width: '40%' }} />
				</Form.Item>
			</Form>
		</DefCard>
	);
};

export default AddressCard;
