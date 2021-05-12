import React from "react";
import { Component } from "react";
import { Layout, Breadcrumb, Row, Col, Menu } from "antd";

const { Header, Content, Footer } = Layout;

class SearchPage extends Component {
    render() {
        return (
            <Layout>
                <Header style={{ position: "fixed", zIndex: 1, width: "100%" }}>
                    <Row>
                        <Col flex="100px">
                            <div className="logo" />
                        </Col>
                        <Col flex="auto">
                            <Menu mode="horizontal" defaultSelectedKeys={["2"]}>
                                <Menu.Item key="1">Search</Menu.Item>
                                <Menu.Item key="2">Info</Menu.Item>
                            </Menu>
                        </Col>
                    </Row>
                </Header>
                <Content
                    className="site-layout"
                    style={{ padding: "0 50px", marginTop: 64 }}
                >
                    <Breadcrumb style={{ margin: "16px 0" }}>
                        <Breadcrumb.Item>Home</Breadcrumb.Item>
                        <Breadcrumb.Item>List</Breadcrumb.Item>
                        <Breadcrumb.Item>App</Breadcrumb.Item>
                    </Breadcrumb>
                    <div
                        className="site-layout-background"
                        style={{ padding: 24, minHeight: 380 }}
                    >
                        Content
                    </div>
                </Content>
                <Footer style={{ textAlign: "center" }}>
                    Ant Design ©2018 Created by Ant UED
                </Footer>
            </Layout>
        );
    }
}

export default SearchPage;
