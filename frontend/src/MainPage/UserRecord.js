import React from "react";
import { Form, Input, InputNumber, Button, Radio, Table } from "antd";
import { Component } from "react";
// import axios from "axios";

const FormItem = Form.Item;

class UserRecord extends Component {
    constructor() {
        super();
        const title = () => "CRUD Application of User Records";
        const showHeader = true;
        const footer = () => "This is the footer of our Application";
        this.state = {
            formLayout: "horizontal",
            currentId: null,
            editing: false,
            newUser: {
                name: "",
                age: 0
            },
            userRecords: [],
            tableConfiguration: {
                bordered: true,
                loading: false,
                pagination: true,
                size: "small",
                title,
                showHeader,
                footer,
                scroll: undefined
            }
        };
        this.updateUser = this.updateUser.bind(this);
        this.saveNewUser = this.saveNewUser.bind(this);
        this.changeName = this.changeName.bind(this);
        this.changeAge = this.changeAge.bind(this);
        this.handleFormLayoutChange = this.handleFormLayoutChange.bind(this);
        this.handleUpdateUser = this.handleUpdateUser.bind(this);
        this.handleDeleteUser = this.handleDeleteUser.bind(this);
    }

    handleFormLayoutChange = e => {
        this.setState({
            formLayout: e.target.value
        });
    };

    fetchUser() {
        // axios
        //     .get("http://rest.learncode.academy/api/nenjotsu/users")
        //     .then(response => {
        //         console.log(response.data);
        //         this.setState({
        //             userRecords: response.data,
        //             tableConfiguration: { loading: false }
        //         });
        //     })
        //     .catch(err => {
        //         console.log("Network " + err);
        //     });
    }

    componentWillMount() {
        this.fetchUser();
    }

    createUserRecord(userRecord) {
        // axios
        //     .post("http://rest.learncode.academy/api/nenjotsu/users", userRecord)
        //     .then(response => {
        //         userRecord.id = response.data.id;
        //         this.fetchUser();
        //     })
        //     .catch(err => {
        //         debugger;
        //         console.log(err);
        //     });
    }

    updateUserRecord(userRecord) {
        const userName = userRecord.data.name;
        const userAge = userRecord.data.age;
        fetch("http://rest.learncode.academy/api/nenjotsu/users/" + userRecord.id, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ name: userName, age: userAge })
        }).then(response => {
            this.fetchUser();
            console.log("Update success!", response); //returns 200 ok
        });
    }

    deleteUser(id) {
        console.log(id);
        // axios
        //     .delete("http://rest.learncode.academy/api/nenjotsu/users/" + id)
        //     .then(response => {
        //         console.log(response);
        //         this.fetchUser();
        //     })
        //     .catch(err => {
        //         console.log(err);
        //     });
    }

    saveNewUser = e => {
        this.setState({ tableConfiguration: { loading: true } });
        const userRecord = {};
        userRecord.name = this.state.newUser.name;
        userRecord.age = this.state.newUser.age;
        this.createUserRecord(userRecord);
        this.fetchUser();
        this.setState({ editing: false, newUser: { name: "", age: 0 } });
        this.setState({ tableConfiguration: { loading: false } });
    };

    updateUser = e => {
        const userRecord = {};
        userRecord.id = this.state.currentId;
        userRecord.data = this.state.newUser;
        this.updateUserRecord(userRecord);
        this.setState({ editing: false, newUser: { name: "", age: 0 } });
    };

    changeName = e => {
        this.setState({
            newUser: { name: e.target.value, age: this.state.newUser.age }
        });
    };

    changeAge = e => {
        this.setState({
            newUser: { name: this.state.newUser.name, age: e }
        });
    };

    handleDeleteUser = e => {
        this.deleteUser(e.id);
    };

    handleUpdateUser = e => {
        this.setState({
            currentId: e.id,
            editing: true,
            newUser: {
                name: e.name,
                age: e.age
            }
        });
    };

    render() {
        const { formLayout } = this.state;
        const formItemLayout =
            formLayout === "horizontal"
                ? {
                    labelCol: { span: 4 },
                    wrapperCol: { span: 14 }
                }
                : null;
        const buttonItemLayout =
            formLayout === "horizontal"
                ? {
                    wrapperCol: { span: 4, offset: 4 }
                }
                : null;
        const layoutProps = { [formLayout]: "true" };

        const data = this.state.userRecords;
        let button = null;
        if (this.state.editing) {
            button = (
                <Button type="primary" size="default" onClick={this.updateUser}>
                    Save Changes
                </Button>
            );
        } else {
            button = (
                <Button type="primary" size="default" onClick={this.saveNewUser}>
                    Add User
                </Button>
            );
        }

        const columns = [
            {
                title: "Id",
                dataIndex: "id",
                key: "id"
            },
            {
                title: "Name",
                dataIndex: "name",
                key: "name",
                render: text => <strong>{text}</strong>
            },
            {
                title: "Age",
                dataIndex: "age",
                key: "age"
            },
            {
                title: "Action",
                key: "action",
                render: (text, record) => (
                    <span>
            <a onClick={() => this.handleUpdateUser(record)}>Edit</a>
            <span className="ant-divider" />
            <a onClick={() => this.handleDeleteUser(record)}>Delete</a>
          </span>
                )
            }
        ];
        return (
            <div>
                <Form {...layoutProps}>
                    <FormItem label="Form Layout" {...formLayout}>
                        <Radio.Group
                            defaultValue={"inline"}
                            onChange={this.handleFormLayoutChange}
                        >
                            <Radio.Button value="horizontal">Horizontal</Radio.Button>
                            <Radio.Button value="vertical">Vertical</Radio.Button>
                            <Radio.Button value="inline">Inline</Radio.Button>
                        </Radio.Group>
                    </FormItem>
                    <FormItem label="Username" {...formItemLayout}>
                        <Input
                            type="text"
                            value={this.state.newUser.name}
                            placeholder="Name"
                            onChange={this.changeName}
                        />
                    </FormItem>
                    <FormItem label="Age" {...formItemLayout}>
                        <InputNumber
                            min={1}
                            max={99}
                            value={this.state.newUser.age}
                            placeholder="Age"
                            onChange={this.changeAge}
                        />
                    </FormItem>
                    <FormItem {...buttonItemLayout}>{button}</FormItem>
                </Form>
                <Table
                    rowKey={record => record.id}
                    {...this.state.tableConfiguration}
                    columns={columns}
                    dataSource={data}
                />
            </div>
        );
    }
}

export default UserRecord;
