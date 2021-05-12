import React from "react";
import {Form, Input, Checkbox} from 'antd';
import {UserOutlined, LockOutlined} from '@ant-design/icons';

class AccountInputs extends React.Component {
    constructor(props) {
        super(props);
        this.state = {type: props.type};
    }

    render() {
        const type = this.state.type.charAt(0)
        if (type === 'f') {
            return (
                <Form.Item
                    name="email"
                    label="E-mail"
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
            )
        } else {
            return (
            <React.Fragment>
                <Form.Item name="username"
                    rules={
                        [{
                            required: true,
                            message: 'Please input your Username!'
                        }]
                }>
                    <Input prefix={<UserOutlined/>}
                        placeholder="Username"/>
                </Form.Item>
                <Form.Item name="pass"
                    rules={
                        [{
                            required: true,
                            message: 'Please input your Password!'
                        }]
                }>
                    <Input prefix={<LockOutlined/>}
                        type="password"
                        placeholder="Password"/>
                </Form.Item>
                {type === 'r' &&
                    <Form.Item name="pass-repeat"
                        rules={
                            [{
                                required: true,
                                message: 'Please enter your Password again!'
                            }]
                    }>
                        <Input prefix={<LockOutlined/>}
                            type="password"
                            placeholder="Repeat password"/>
                    </Form.Item>
                }
                {type === 's' &&
                    <Form.Item name="remember" valuePropName="checked">
                        <Checkbox>Remember me</Checkbox>
                    </Form.Item>
                }
            </React.Fragment>
            )
        }
    }
}

export default AccountInputs;
