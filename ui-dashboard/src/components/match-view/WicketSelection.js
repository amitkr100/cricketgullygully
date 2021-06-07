import { ClockCircleOutlined } from '@ant-design/icons';
import { Badge, Button, Popover, Space, Select, Checkbox, Row, Col, Card, Divider } from 'antd'
import React from 'react'
const { Option } = Select;
function getPopOverContent(wicketType) {
    return (
            <Card size="small">
                <Select
                    showSearch
                    style={{ width: 200 }}
                    placeholder="Select a person"
                    optionFilterProp="children"
                    onChange={console.log(this)}
                    filterOption={(input, option) =>
                        option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                    }
                >
                    <Option value="jack">Jack</Option>
                    <Option value="lucy">Lucy</Option>
                    <Option value="tom">Tom</Option>
                </Select>
                <Divider />
                <Checkbox >Strike Change</Checkbox>
                <div style={{ float: 'right' }}>
                    <Button type="primary" >OK</Button>
                </div>

            </Card>
    )
}
function getButton(item) {
    const button = (<Button key="index" type="secondary" onClick={() => console.log("Clicked: ", item)}>{item.type}</Button>);
    if (item.requireMoreInfo) {
        return (
            <Popover placement="bottom" title={item.type} content={getPopOverContent(item.type)} trigger="click">
                <Badge dot>
                    {button}
                </Badge>
            </Popover>
        )
    }
    return button

}
export default function WicketSelection() {
    const wicketTypes = [
        { type: "Bowled", requireMoreInfo: false },
        { type: "Caught", requireMoreInfo: true },
        { type: "LBW", requireMoreInfo: false },
        { type: "Run Out", requireMoreInfo: true },
        { type: "Stumped", requireMoreInfo: true },
        { type: "Hit Wicket", requireMoreInfo: false },
        { type: "Handled Ball", requireMoreInfo: false },
        { type: "Field Obs.", requireMoreInfo: false },
        { type: "Timed Out", requireMoreInfo: false },
        { type: "Retired Out", requireMoreInfo: false }
    ]

    return (
        <div>
            <Space size="small" wrap>
                {
                    wicketTypes.map((item, index) => getButton(item, index))
                }
            </Space>

        </div >
    )
}
