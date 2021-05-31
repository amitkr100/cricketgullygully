import { Button, Space } from 'antd'
import React from 'react'

export default function RunSelection() {
    const runs = [0,1, 2, 3, 4, 5, 6]
    return (
        <div>
            <Space size="small" wrap>
                {
                    runs.map((item) => (
                        <Button type="primary" onClick={()=>console.log("Clicked: ", item)}>{item}</Button>
                    ))
                }
            </Space>

        </div >
    )
}
