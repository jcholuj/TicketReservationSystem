import React from "react";
import {Form, Button, Tabs} from 'antd';
import AccountInputs from "./AccountInputs";

const {TabPane} = Tabs;

class AccountForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            accountTabsOption: '1',
            action: 'Log in'
        };
        this.formRef = React.createRef();
    }

    onFinish = (values) => {
        console.log(values);
    };
    onChange = (activeKey) => {
        this.setState({accountTabsOption: activeKey})
        switch (activeKey) {
            case '2':
                this.setState({action: 'Register'})
                this.formRef.current.resetFields(['pass'])
                break;
            case '3':
                this.setState({action: 'Reset'})
                break;
            default:
                this.formRef.current.resetFields(['pass'])
                this.setState({action: 'Log in'})
        }
        
    }

    render() {
        const option = this.state.accountTabsOption;
        const accountInputs = <AccountInputs option={option} />
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
            <Tabs onChange={this.onChange} defaultActiveKey="1" centered>
                <TabPane tab="Sign in" key="1">
                    {option === '1' && accountInputs}
                </TabPane>
                <TabPane tab="Register" key="2">
                    {option === '2' && accountInputs}
                </TabPane>
                <TabPane tab="Forgot password" key="3">
                    {option === '3' && accountInputs}
                </TabPane>
            </Tabs>
            <Form.Item noStyle>
                <Button htmlType="submit" className="login-form-button" block>
                    {this.state.action}
                </Button>
            </Form.Item>
        </Form>);
    }
}

export default AccountForm;
