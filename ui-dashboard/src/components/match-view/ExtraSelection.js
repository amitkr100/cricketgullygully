import React from 'react'
import { Button, Space, Popover, Badge, Card, Checkbox, Divider, Radio } from 'antd'
import RunSelection from './RunSelection'
function getPopOverContent(wicketType) {

    const runsOption = ["0", "1", "2", "3", "4", "5", "6"]
    return (
        <Card size="small">
            <Radio.Group
                options={runsOption}
                optionType="button"
                defaultValue="0"
            />
            <Divider />
            <Checkbox >Strike Change</Checkbox>
            <div style={{ float: 'right' }}>
                <Button type="primary" >OK</Button>
            </div>
        </Card>
    )
}

export default function ExtraSelection() {
    const extraTypes = ["WD", "NB", "B", "LB", "PEN"]
    return (
        <div>
            <Space size="small">
                {
                    extraTypes.map((item) => (

                        <Popover placement="bottom" title={item.type} content={getPopOverContent()} trigger="click">
                            <Badge dot>
                                <Button onClick={() => console.log("Clicked: ", item)}>{item}</Button>
                            </Badge>
                        </Popover>

                    ))
                }
            </Space>

        </div >
    )
}
