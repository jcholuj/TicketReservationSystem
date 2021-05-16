import React from "react";
import {Form, Input, Checkbox} from 'antd';
import {UserOutlined, LockOutlined} from '@ant-design/icons';

class AccountInputs extends React.Component {

    render() {
        const option = this.props.option
        if (option === '3') {
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
                    normalize={(value) => value.replace(/ /g, "_")}
                    rules={[
                        {
                            required: true,
                            message: 'Please input your Username!'
                        },
                ]}>
                    <Input prefix={<UserOutlined/>}
                        placeholder="Username"/>
                </Form.Item>
                <Form.Item name="pass"
                    hasFeedback
                    rules={
                        [{
                            required: true,
                            message: 'Please input your Password!'
                        }]
                    }
                >
                    <Input.Password prefix={<LockOutlined/>}
                        placeholder="Password"/>
                </Form.Item>
                {option === '2' &&
                    <Form.Item
                        name="pass-repeat"
                        dependencies={['pass']}
                        hasFeedback
                        rules={[
                            {
                                required: true,
                                message: 'Please confirm your password!',
                            },
                            ({ getFieldValue }) => ({
                                validator(_, value) {
                                    if (!value || getFieldValue('pass') === value) {
                                        return Promise.resolve();
                                    }
                                    return Promise.reject(new Error('Entered passwords do not match!'));
                                },
                            }),
                        ]}
                    >
                        <Input.Password prefix={<LockOutlined/>}
                            placeholder="Repeat password"/>
                    </Form.Item>
                }
                {option === '1' &&
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
