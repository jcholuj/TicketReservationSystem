import { Divider, Form, Radio, Tag } from 'antd';
import React, { useState } from 'react';
import DefCard from './DefCard';

import avatar1 from '../../../static/avatar1.svg';
import avatar2 from '../../../static/avatar2.svg';
import avatar3 from '../../../static/avatar3.svg';

const avatars = {
	1: avatar1,
	2: avatar2,
	3: avatar3,
};

const GeneralCard = (props) => {
	const [generalForm] = Form.useForm();
	const [avatar, setAvatar] = useState(avatars[props.avatarNum]);

	const handleFormChange = (changed, _) => {
		setAvatar(avatars[changed[0].value]);
	};

	return (
		<DefCard title='Avatar & Account type'>
			<Form
				layout='vertical'
				name='general-form'
				form={generalForm}
				onFieldsChange={handleFormChange}
			>
				<img src={avatar} alt='chosen avatar' />
				<Form.Item label='Avatar selection' name='avatar'>
					<Radio.Group>
						<Radio.Button value='1'>
							<img src={avatar1} alt='avatar 1' />
						</Radio.Button>
						<Radio.Button value='2'>
							<img src={avatar2} alt='avatar 2' />
						</Radio.Button>
						<Radio.Button value='3'>
							<img src={avatar3} alt='avatar 3' />
						</Radio.Button>
					</Radio.Group>
				</Form.Item>
				<Divider />
				<Form.Item style={{ marginBottom: 0 }} label='Current account type'>
					<Tag color='blue'>Admin</Tag>
				</Form.Item>
			</Form>
		</DefCard>
	);
};

export default GeneralCard;
