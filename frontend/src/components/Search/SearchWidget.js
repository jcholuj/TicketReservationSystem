import React from "react";
import {message, Button, Form, Modal, Row, Col, Tabs, Typography } from "antd";
import {CompassOutlined, EnvironmentOutlined} from '@ant-design/icons';
import SearchInputs from "./SearchInputs";
import vid from "../../static/success-1.mp4"

const { TabPane } = Tabs;
const { Title } = Typography;
const fun = "http://ksi.pwr.edu.pl/fcp/cGBUKOQtTKlQhbx08SlkTUgRLUWRuHQwFDBoIVURNWHVBG1gnBVcoFW8SBDRKHg/109/public/default/staff/rafal_kern.jpg"

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
            message.warning('Station selection is not complete!');
            noErrors = false
        }
        if (!inputs.connect_date) {
            message.warning('Date was not selected!');
            noErrors = false
        }
        if (noErrors) {
            this.successModal()
        }
    }

    successModal() {
        Modal.info({
          title: 'This feature will be implemented later 😊',
          content: (
            <video autoPlay loop className="modal-vid">
                <source src={vid} type="video/mp4" />
            </video>
          ),
          onOk() {
            window.open(fun, '_blank').focus();
          },
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
                <Col flex="auto"></Col>
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
                <Col flex="auto"></Col>
            </Row>
        )
    }
}

export default SearchWidget;