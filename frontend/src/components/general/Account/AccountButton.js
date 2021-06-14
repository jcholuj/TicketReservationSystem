import React from "react";
import { Popover, Button } from "antd";
import { UserOutlined } from "@ant-design/icons";
import AccountForm from "./AccountForm";

class AccountButton extends React.Component {
	render() {
		return (
			<Popover
				placement='bottomRight'
				content={<AccountForm />}
				title=''
				trigger='click'
			>
				<Button
					className='top-account-btn'
					type='primary'
					icon={<UserOutlined />}
				>
					My account
				</Button>
			</Popover>
		);
	}
}

export default AccountButton;
