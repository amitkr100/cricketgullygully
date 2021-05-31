import React, { Component } from 'react'
import { Card, Badge, Avatar, Descriptions, Tag, Button, Row, Col, Space } from 'antd'
import RunSelection from './RunSelection'
import ExtraSelection from './ExtraSelection'
import WicketSelection from './WicketSelection'

export default class MatchControllerSection extends Component {
    
    render() {
        const timeline = ["1","4","Wd","W","2","B4","6","2"]
        return (
            <div>
                <Descriptions bordered className="player-description">
                    <Descriptions.Item label="Runs" span={3} style={{ padding: "10px" }}>
                        <RunSelection/>
                    </Descriptions.Item>
                    <Descriptions.Item label="Extra" span={3} style={{ padding: "10px" }}>
                        <ExtraSelection/>
                    </Descriptions.Item>
                    <Descriptions.Item label="Wicket" span={1} style={{ padding: "10px" }}>
                        <WicketSelection/>
                    </Descriptions.Item>
                </Descriptions>
            </div>
        )
    }
}
