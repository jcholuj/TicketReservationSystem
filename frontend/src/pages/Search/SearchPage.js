import React from "react";
import { Layout } from "antd";
import GenericPage from "../GenericPage";
import SearchWidget from "../../components/Search/SearchWidget";
import "../../styles/Search/SearchPage.less";

const { Content } = Layout;

class SearchPage extends React.Component {

    render() {
        return (
            <GenericPage topLayoutStyle={{height: "inherit"}} headerActiveTab="1">
                <Content className="app-content">
                    <div className="app-content__backdrop"></div>
                    <SearchWidget />
                </Content>
            </GenericPage>
        );
    }
}

export default SearchPage;
