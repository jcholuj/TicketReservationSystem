import React from "react";
import "antd/dist/antd.css";
import "./App.css";
import {Layout, Menu, Breadcrumb, Button} from "antd";
import { DatePicker } from "antd";
import UserRecord from "./UserRecord";

const { Header, Content, Footer } = Layout;

function App() {
    return (
        <Layout className="layout">
            <Header>
                <div className="logo" />
                <Menu
                    theme="dark"
                    mode="horizontal"
                    defaultSelectedKeys={["2"]}
                    style={{ lineHeight: "64px" }}
                >
                    <Menu.Item key="1">Main Dashboard</Menu.Item>
                    <Menu.Item key="2">nav 2</Menu.Item>
                    <Menu.Item key="3">nav 3</Menu.Item>
                </Menu>
            </Header>
            <Content style={{ padding: "0 50px" }}>
                <Breadcrumb style={{ margin: "16px 0" }}>
                    <Breadcrumb.Item>Home</Breadcrumb.Item>
                    <Breadcrumb.Item>List</Breadcrumb.Item>
                    <Breadcrumb.Item>App</Breadcrumb.Item>
                </Breadcrumb>
                <div style={{ background: "#fff", padding: 24, minHeight: 280 }}>
                    {/* <img src={logo} className="App-logo" alt="logo" /> */}
                    <DatePicker />
                    <UserRecord />
                </div>
            </Content>

            <Footer style={{ textAlign: "center" }}>
                {/*Ant Design Â©2018 Created by Ant UED*/}
            </Footer>
        </Layout>
    );
}

export default App;
