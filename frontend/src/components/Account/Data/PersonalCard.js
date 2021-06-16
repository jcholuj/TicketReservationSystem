import { DatePicker, Form, Input, Radio, Select } from 'antd';
import React, { useState } from 'react';
import DefCard, { formItemLayout } from './DefCard';

const { Option } = Select;

const PersonalCard = () => {
	const [personalForm] = Form.useForm();

	return (
		<DefCard title='Personal info'>
			<Form
				{...formItemLayout}
				form={personalForm}
				name='personal-form'
				requiredMark={false}
				scrollToFirstError
			>
				<Form.Item
					name={['user', 'first_name']}
					label='First name'
					rules={[
						{
							required: true,
							message: 'Please input your first name!',
						},
					]}
				>
					<Input />
				</Form.Item>

				<Form.Item
					name={['user', 'second_name']}
					label='Second name'
					rules={[
						{
							required: true,
							message: 'Please input your second name!',
						},
					]}
				>
					<Input />
				</Form.Item>

				<Form.Item
					name={['user', 'email']}
					label='E-mail'
					rules={[
						{
							type: 'email',
							message: 'The input is not valid E-mail!',
						},
						{
							required: true,
							message: 'Please input your E-mail!',
						},
					]}
				>
					<Input />
				</Form.Item>

				<Form.Item
					name={['user', 'birthdate']}
					rules={[
						{
							required: true,
							message: 'Please input your birthdate!',
						},
					]}
					label='Birthdate'
				>
					<DatePicker />
				</Form.Item>

				<Form.Item name={['user', 'gender']} label='Gender'>
					<Radio.Group>
						<Radio value='m'>Male</Radio>
						<Radio value='f'>Female</Radio>
					</Radio.Group>
				</Form.Item>

				<Form.Item
					name={['user', 'nationality']}
					label='Nationality'
					hasFeedback
				>
					<Select placeholder='Please select a country'>
						<Option value='CN'>China</Option>
						<Option value='US'>U.S.A</Option>
					</Select>
				</Form.Item>
			</Form>
		</DefCard>
	);
};

export default PersonalCard;
