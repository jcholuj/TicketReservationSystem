import React from "react";
import {
    Layout,
    Row,
    Col,
    Menu
} from "antd";
import AccountButton from "./Account/AccountButton";

const {Header} = Layout;

class AppTopHeader extends React.Component {
    render() {
        return (
            <Header className="top-header">
                <Row align="middle">
                    <Col span={4}>
                        <div className="logo"/>
                    </Col>
                    <Col span={6}
                        offset={11}>
                        <Menu className="top-menu" mode="horizontal"
                            defaultSelectedKeys={
                                ["1"]
                        }>
                            <Menu.Item key="1">Search</Menu.Item>
                            <Menu.Item disabled key="2">Info</Menu.Item>
                        </Menu>
                    </Col>
                    <Col span={3}>
                        <AccountButton />
                    </Col>
                </Row>
            </Header>
        );
    }
}

export default AppTopHeader;
