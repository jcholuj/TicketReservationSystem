import React from "react";
import {AutoComplete, Button, Col, DatePicker, Form, Row} from 'antd';
import {SwapOutlined} from '@ant-design/icons';
import moment from 'moment';

const dateTimeFormat = "DD.MM.YYYY HH:mm"
const options = [
    { value: 'Warszawa Centralna' },
    { value: 'Wrocław Główny' },
    { value: 'Łódź Fabryczna' },
    { value: 'Gdynia Główna' },
    { value: 'Kraków Główny' },
];
const range = (min, max) => {
    return Array(max - min + 1)
        .fill(0)
        .map((_, i) => i + min);
}
const stationInputFilter = (inputValue, option) =>
    option.value.toUpperCase().indexOf(inputValue.toUpperCase()) !== -1;

class SearchInputs extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            connect_orig: '',
            connect_dest: '',
            switch_triggered: false
        }
        this.form = props.formRef;
    }

    handleAutocompleteChange = (field, data) => {
        const val = data === undefined ? '' : data;
        this.setState({ [field]: val, })
        this.form.current.setFieldsValue({ [field]: val, })
    }

    switchStations = () => {
        const {switch_triggered, ...vals} = this.state
        if (!Object.values(vals).every(x =>
            x === undefined || x === '')) {
            const switched = {
                connect_orig: vals.connect_dest,
                connect_dest: vals.connect_orig,
            }
            this.form.current.setFieldsValue(switched);
            this.setState({
                ...switched,
                switch_triggered: !switch_triggered,
            })
        }
    }

    getTimeAdjustNow() {
        let current = moment();
        let minBy15 = ~~(current.minute() / 15);
        current.minute(15 * minBy15);
        return current
    }

    disabledDateTime() {
        const allowedMin = [0, 15, 30, 45]
        return {
          disabledMinutes: () => range(0, 59)
            .filter(n => allowedMin.indexOf(n) === -1),
        };
    }

    render() {
        const checkOption1 = this.props.option === "1";
        return(
            <React.Fragment>
                <Form.Item name="connect_date"
                    initialValue={checkOption1 ? this.getTimeAdjustNow() : undefined}>
                    <DatePicker format={dateTimeFormat}
                        disabledTime={this.disabledDateTime}
                        showTime={{ format: 'HH:mm' }}
                    />
                </Form.Item>
                <Row justify="center">
                    <Col span={checkOption1 ? 10 : 15}>
                        <Form.Item name="connect_orig" noStyle>
                            <AutoComplete options={options}
                                value={this.state.connect_orig}
                                placeholder={checkOption1
                                    ? "Origin"
                                    : "Station"
                                }
                                filterOption={stationInputFilter}
                                className="stations-input"
                                onChange={(data) =>
                                    this.handleAutocompleteChange("connect_orig", data)
                                }
                                allowClear
                            />
                        </Form.Item>
                    </Col>
                    {checkOption1 &&
                        <Col span={4} className="stations-btn-col">
                            <Button type="primary"
                                shape="circle"
                                icon={
                                    <SwapOutlined rotate={
                                        this.state.switch_triggered ? 180 : 0
                                    }/>
                                }
                                size='large'
                                onClick={this.switchStations}
                            />
                        </Col>
                    }
                    {checkOption1 &&
                        <Col span={10}>
                            <Form.Item name="connect_dest" noStyle>
                                <AutoComplete options={options}
                                    value={this.state.connect_dest}
                                    placeholder="Destination"
                                    filterOption={stationInputFilter}
                                    className="stations-input"
                                    onChange={(data) =>
                                        this.handleAutocompleteChange("connect_dest", data)
                                    }
                                    allowClear
                                />
                            </Form.Item>
                        </Col>
                    }
                </Row>
            </React.Fragment>
        )
    }
}

export default SearchInputs;