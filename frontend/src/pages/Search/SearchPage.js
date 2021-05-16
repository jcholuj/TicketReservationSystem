import React from "react";
import { Layout } from "antd";
import AppTopHeader from "../../components/general/AppTopHeader"
import AppFooter from "../../components/general/AppFooter";
import SearchWidget from "../../components/Search/SearchWidget";
import "../../styles/Search/SearchPage.less";

const { Content } = Layout;

class SearchPage extends React.Component {
    render() {
        return (
            <Layout style={{height: "inherit"}}>
                <AppTopHeader />
                <Content className="app-content">
                    <div className="app-content__backdrop"></div>
                    <SearchWidget />
                </Content>
                <AppFooter />
            </Layout>
        );
    }
}

export default SearchPage;
