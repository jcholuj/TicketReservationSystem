import React from "react";
import {message, Button, Form, Modal, Row, Col, Tabs, Typography } from "antd";
import {CompassOutlined, EnvironmentOutlined} from '@ant-design/icons';
import SearchInputs from "./SearchInputs";
import moment from 'moment';

const { TabPane } = Tabs;
const { Title } = Typography;

class SearchWidget extends React.Component {
    constructor(props) {
        super(props);
        this.state = {searchTabOption: '1', visible: false};
        this.formRef = React.createRef();
    }
    
    handleSearchTabChange = (key) => {
        this.setState({
            searchTabOption: key,
        })
    }

    onFormSubmitted = (inputs) => {
        let noErrors = true;
        if (!inputs.connect_orig ||
            (!inputs.connect_dest && this.state.searchTabOption === '1')) {
            message.warning('Station selection is not complete!').then();
            noErrors = false
        }
        if (!inputs.connect_date) {
            message.warning('Date was not selected!').then();
            noErrors = false
        }
        if (noErrors) {
            // some useful logic should happen instead of this temporary
            const { connect_date, ...rest} = inputs
            const inputsLog = {
                ...rest, connect_date: moment(connect_date).format()
            }
            console.table(inputsLog)
            this.successModal()
            //TODO
        }
    }

    successModal() {
        Modal.info({
            title: 'Search query received',
            content: (
                <p>Specified parameters are logged in the console.</p>
            ),
            onOk() {},
        });
      }

    render() {
        const option = this.state.searchTabOption;
        const searchInputOpts = {
            option: option,
            formRef: this.formRef,
        }
        const searchInputs = <SearchInputs {...searchInputOpts}/>
        return (
            <Row>
                <Col flex="auto" />
                <Col flex="500px">
                    <Title className="widget-title">Browse timetable with ease.</Title>
                    <Form
                        name="search_options"
                        className="search-form"
                        layout="vertical"
                        ref={this.formRef}
                        size="large"
                        spellCheck="false"
                        onFinish={this.onFormSubmitted}
                    >
                        <Tabs className="search-tabs"
                            centered
                            defaultActiveKey="1"
                            onChange={this.handleSearchTabChange}
                        >
                            <TabPane
                                tab={
                                    <span>
                                    <CompassOutlined />
                                    Route
                                    </span>
                                }
                                key="1"
                            >
                                {option === "1" && searchInputs}
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
                                {option === "2" && searchInputs}
                            </TabPane>
                        </Tabs>
                        <Form.Item>
                            <Button type="primary" htmlType="submit">Show connections</Button>
                        </Form.Item>
                    </Form>
                </Col>
                <Col flex="auto" />
            </Row>
        )
    }
}

export default SearchWidget;