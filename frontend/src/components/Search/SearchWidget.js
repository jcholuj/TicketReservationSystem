import React from "react";
import {Tabs} from "antd";
import {CompassOutlined, EnvironmentOutlined} from '@ant-design/icons';
import SearchForm from "./SearchForm";

const { TabPane } = Tabs;

function SearchWidget() {
    return (
        <Tabs defaultActiveKey="2">
            <TabPane
                tab={
                    <span>
                        <CompassOutlined />
                        Route
                    </span>
                }
                key="1"
            >
                <SearchForm />
            </TabPane>
            <TabPane
                tab={
                    <span>
                        <EnvironmentOutlined />
                        Station
                    </span>
                }
                key="2"
            >
                <SearchForm />
            </TabPane>
        </Tabs>
    );
}

export default SearchWidget;
