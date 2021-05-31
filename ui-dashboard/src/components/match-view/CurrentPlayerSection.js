import React, { Component } from 'react'
import { Card, Badge, Avatar, Descriptions, Tag, Button, Row, Col, Space } from 'antd'
import { UserOutlined } from '@ant-design/icons';
const { Meta } = Card;
export default class CurrentPlayerSection extends Component {

    getCurrentBatsman(striker) {
        const playerName = (striker) ? this.props.innings.currentStriker : this.props.innings.currentNonStriker;
        //return 
    }
    render() {

        const { inning } = this.props
        if (!inning) return null;
        const currentBatsmans = inning.batsmanScores.filter((player) => player.name === inning.currentStriker || player.name === inning.currentNonStriker)
        const currentBowler = inning.bowlerScores.filter((player) => player.name === inning.currentBowler)[0]
        const responsiveCol = { xs: 24, sm: 24, md: 12, lg: 12, xl: 12, xxl: 12 }
        const timeline = ["1","4","Wd","W","2","B4","6","2"]
        return (
            <div>
                
                <Descriptions bordered className="player-description">
                    <Descriptions.Item label="Batsman" span={5} style={{ padding: "5px" }}>
                        <Row gutter={16}>
                            {currentBatsmans.map((item) => (
                                <Col {...responsiveCol} >
                                    <Card
                                        title={<div><Meta style={{ float: "Left" }} avatar={<Avatar style={{ backgroundColor: '#f56a00' }}>{item.name[0]}</Avatar>} title={item.name} /> {item.name == inning.currentStriker && <Tag style={{ float: "right" }} color="#2db7f5">Striker</Tag>}</div>}
                                        size="small">
                                        <span><strong>Run Scored: </strong>{item.runScored}</span><br />
                                        <span><strong>Pall Played: </strong>{item.ballPlayed}</span>
                                    </Card>
                                </Col>
                            ))}
                        </Row>
                    </Descriptions.Item>
                    <Descriptions.Item label="Bowler" span={5} style={{ padding: "5px" }}>
                        <Row gutter={16}>
                            <Col {...responsiveCol} >
                                <Card
                                    title={<Meta style={{ float: "Left" }} avatar={<Avatar style={{ backgroundColor: '#f56a00' }}>{currentBowler.name[0]}</Avatar>} title={currentBowler.name} />}
                                    size="small">
                                    <span><strong>Run Scored: </strong>{currentBowler.overBowled}</span><br />
                                    <span><strong>Pall Played: </strong>{currentBowler.wicket}</span>
                                </Card>
                            </Col>
                        </Row>
                    </Descriptions.Item>
                    <Descriptions.Item label="Timeline" span={5} style={{ padding: "5px" }}>
                        <Space size="small" wrap>
                            {timeline.map((item)=> (
                                <Button >{item}</Button>
                            ))}
                        </Space>
                    </Descriptions.Item>
                </Descriptions>
            </div >


        )
    }
}
