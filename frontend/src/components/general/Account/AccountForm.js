import React from "react";
import {Form, Button, Tabs} from 'antd';
import AccountInputs from "./AccountInputs";

const {TabPane} = Tabs;

class AccountForm extends React.Component {
    formRef = React.createRef();
    onFinish = (values) => {
        console.log(values);
    };
    onReset = () => {
        this.formRef.current.resetFields();
    };

    render() {
        return (
        <Form ref={this.formRef}
            layout="vertical"
            name="account_actions"
            className="account-form"
            initialValues={
                {remember: true}
            }
            onFinish={
                this.onFinish
        }>
            <Tabs defaultActiveKey="1" centered>
                <TabPane tab="Sign in" key="1">
                    <AccountInputs type="signin" />
                </TabPane>
                <TabPane tab="Register" key="2">
                    <AccountInputs type="register" />
                </TabPane>
                <TabPane tab="Forgot password" key="3">
                    <AccountInputs type="forgot" />
                </TabPane>
            </Tabs>
            <Form.Item noStyle>
                <Button htmlType="submit" className="login-form-button" block>
                    Submit
                </Button>
            </Form.Item>
        </Form>);
    }
}

export default AccountForm;
