import { Button, Form, Input } from 'antd';
import React, { useState } from 'react';
import DefCard from './DefCard';
import { EditOutlined, MinusCircleOutlined } from '@ant-design/icons';

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

const formItemLayoutWithOutLabel = {
	wrapperCol: {
		xs: { span: 24, offset: 0 },
		sm: { span: 18, offset: 6 },
	},
};

const SecurityCard = () => {
	const [securityForm] = Form.useForm();

	return (
		<DefCard title='Security'>
			<Form
				{...formItemLayout}
				form={securityForm}
				name='security-form'
				requiredMark={false}
				scrollToFirstError
			>
				<Form.Item name='username' label='Username'>
					<Input placeholder='user' style={{ width: '80%' }} />
				</Form.Item>
				<Form.List name='password'>
					{(fields, { add, remove }) => (
						<>
							{fields.map(({ key, name, fieldKey, ...restField }) => (
								<React.Fragment key={key}>
									<Form.Item label='New password' required={false}>
										<Form.Item
											{...restField}
											name={[name, 'main']}
											fieldKey={[fieldKey, 'main']}
											rules={[
												{
													required: true,
													message: 'Please input your password!',
												},
											]}
											noStyle
										>
											<Input.Password style={{ width: '80%' }} />
										</Form.Item>
										<MinusCircleOutlined
											className='dynamic-delete-button'
											onClick={() => remove(name)}
										/>
									</Form.Item>
									<Form.Item
										{...restField}
										name={[name, 'repeat']}
										fieldKey={[fieldKey, 'repeat']}
										label='Confirm'
										hasFeedback
										rules={[
											{
												required: true,
												message: 'Please confirm your password!',
											},
											({ getFieldValue }) => ({
												validator(_, value) {
													if (
														!value ||
														getFieldValue('password')[0].main === value
													) {
														return Promise.resolve();
													}

													return Promise.reject(
														new Error(
															'The two passwords that you entered do not match!'
														)
													);
												},
											}),
										]}
									>
										<Input.Password style={{ width: '80%' }} />
									</Form.Item>
								</React.Fragment>
							))}
							{fields.length === 0 && (
								<Form.Item {...formItemLayoutWithOutLabel}>
									<Button
										type='dashed'
										style={{ width: '80%' }}
										onClick={() => add()}
										icon={<EditOutlined />}
									>
										Change password
									</Button>
								</Form.Item>
							)}
						</>
					)}
				</Form.List>
			</Form>
		</DefCard>
	);
};

export default SecurityCard;
