import { AutoComplete, Button, Form, Input } from 'antd';
import React from 'react';

const { Search } = Input;
const options = [
	{ value: 'Warszawa Centralna' },
	{ value: 'Wrocław Główny' },
	{ value: 'Łódź Fabryczna' },
	{ value: 'Gdynia Główna' },
	{ value: 'Kraków Główny' },
];

const NewSearchForm = () => {
	const [newSearchForm] = Form.useForm();

	const onSelect = () => {};
	const handleSearch = () => {};

	const stationInput = <Search placeholder='Enter station' allowClear />;

	return (
		<Form
			layout='vertical'
			form={newSearchForm}
			size='small'
			name='new-search'
			spellCheck='false'
		>
			<Form.Item label='Origin' name='origin'>
				<AutoComplete
					options={options}
					style={{
						width: 200,
					}}
					onSelect={onSelect}
					onSearch={handleSearch}
				>
					{stationInput}
				</AutoComplete>
			</Form.Item>
			<Form.Item label='Destination' name='destination'>
				<AutoComplete
					options={options}
					style={{
						width: 200,
					}}
					onSelect={onSelect}
					onSearch={handleSearch}
				>
					{stationInput}
				</AutoComplete>
			</Form.Item>
			<Form.Item noStyle>
				<Button type='primary' className='new-search-submit' block>
					Show connections
				</Button>
			</Form.Item>
		</Form>
	);
};

export default NewSearchForm;
