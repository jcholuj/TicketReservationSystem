import React from "react";
import AppTopHeader from "../components/general/AppTopHeader";
import AppFooter from "../components/general/AppFooter";
import {Layout} from "antd";


const GenericPage = ({ children, ...props }) => {

    return (
        <Layout style={props.topLayoutStyle}>
            <AppTopHeader selectedKey={props.headerActiveTab} />
            {children}
            <AppFooter />
        </Layout>
    );
};

export default GenericPage;