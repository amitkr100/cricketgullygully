import React, { Component } from 'react'
import { Row, Col, Button, Select } from 'antd';
const { Option } = Select;
export default class SelectTeam extends Component {

    constructor(props) {
        super(props);
    }

    onChangeTeam1(value) {
        console.log(`selected ${value}`);
        this.props.onTeamSelected(0, value);
    }
    onChangeTeam2(value) {
        console.log(`selected ${value}`);
        this.props.onTeamSelected(1, value);
    }
    render() {
        const { teams, teamSelected} = this.props;
        return (
            <div>
                <Row>
                    <Col span={10} style={{ paddingLeft: "8px" }}>
                        <Select
                            showSearch
                            style={{ width: "100%" }}
                            size="large"
                            placeholder="Select Team 1"
                            optionFilterProp="children"
                            onChange={(val) => this.onChangeTeam1(val)}
                            filterOption={(input, option) =>
                                option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                            }
                        >
                            {
                                (teams && teams.map(item => (
                                    <Option key={item.shortName} value={item.shortName}>{item.name + "(" + item.shortName + ")"}</Option>
                                )))
                            }
                        </Select>
                    </Col>
                    <Col span={4} >
                        <Button type="primary" shape="circle" size="large" >
                            VS
                    </Button>
                    </Col>
                    <Col span={10} style={{ paddingRight: "8px" }}>
                        <Select
                            showSearch
                            style={{ width: "100%" }}
                            size="large"
                            placeholder="Select Team 2"
                            optionFilterProp="children"
                            onChange={(val) => this.onChangeTeam2(val)}
                            filterOption={(input, option) =>
                                option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                            }
                        >
                            {

                                (teams && teams.map(item => (
                                    <Option key={item.shortName} value={item.shortName}>{item.name + "(" + item.shortName + ")"}</Option>
                                )))
                            }

                        </Select>
                    </Col>
                </Row>
            </div>
        )
    }
}
